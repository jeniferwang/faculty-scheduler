package edu.csupomona.cs461.data.provider;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.csupomona.cs461.data.Faculty;
import edu.csupomona.cs461.data.UserMap;
import edu.csupomona.cs461.util.ResourceResolver;

/**
 * The implementation of {@link UserManager} interface
 * using file system.
 * <p>
 * This class demonstrates how you can use the file system
 * as a database to store your data.
 *
 */
public class FSUserManager implements UserManager {

	/**
	 * We persist all the user related objects as JSON.
	 * <p>
	 * For more information about JSON and ObjectMapper, please see:
	 * http://www.journaldev.com/2324/jackson-json-processing-api-in-java-example-tutorial
	 *
	 * or Google tons of tutorials
	 *
	 */
	private static final ObjectMapper JSON = new ObjectMapper();

	/**
	 * Load the user map from the local file.
	 *
	 * @return
	 */
	private UserMap getUserMap() {
		UserMap userMap = null;
		File userFile = ResourceResolver.getUserFile();
        if (userFile.exists()) {
        	// read the file and convert the JSON content
        	// to the UserMap object
            try {
				userMap = JSON.readValue(userFile, UserMap.class);
			} catch (IOException e) {
				e.printStackTrace();
			}
        } else {
        	userMap = new UserMap();
        }
        return userMap;
	}

	/**
	 * Save and persist the user map in the local file.
	 *
	 * @param userMap
	 */
	private void persistUserMap(UserMap userMap) {
		try {
			// convert the user object to JSON format
            JSON.writeValue(ResourceResolver.getUserFile(), userMap);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	@Override
	public Faculty getUser(String userId) {
		UserMap userMap = getUserMap();
        return userMap.get(userId);
	}

	@Override
	public void updateUser(Faculty user) {
		UserMap userMap = getUserMap();
		userMap.put(user.getId(), user);
		persistUserMap(userMap);
	}

	@Override
	public void deleteUser(String userId) {
		UserMap userMap = getUserMap();
		userMap.remove(userId);
		persistUserMap(userMap);
	}

	@Override
	public List<Faculty> listAllUsers() {
		UserMap userMap = getUserMap();
		List<Faculty> facultyList = new ArrayList<Faculty>(userMap.values());
		Collections.sort(facultyList, new Comparator<Faculty>(){
			public int compare(Faculty user1, Faculty user2) {
				return user1.getName().compareToIgnoreCase(user2.getName());
			}
		});
		return facultyList;
	}

}
