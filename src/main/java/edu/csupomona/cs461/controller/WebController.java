package edu.csupomona.cs461.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import edu.csupomona.cs461.data.Faculty;
import edu.csupomona.cs461.data.provider.UserManager;


@RestController
public class WebController {

    @Autowired
    private UserManager userManager;

    @RequestMapping(value = "/cs461/user/{userId}", method = RequestMethod.GET)
    Faculty getUser(@PathVariable("userId") String userId) {
    	Faculty user = userManager.getUser(userId);
        return user;
    }

    @RequestMapping(value = "/cs461/user/{userId}", method = RequestMethod.POST)
    Faculty updateUser(
    		@PathVariable("userId") String id,
    		@RequestParam("name") String name,
    		@RequestParam("email") String email,
    		@RequestParam("department") String department,
    		@RequestParam("office") String office,
    		@RequestParam("officeHours") String officeHours) {
    	Faculty user = new Faculty();
    	user.setId(id);
    	user.setDepartment(department);
    	user.setEmail(email);
    	user.setName(name);
    	user.setOffice(office);
    	user.setOfficeHours(officeHours);
    	user.setUpdateTime();
    	userManager.updateUser(user);
    	return user;
    }


    @RequestMapping(value = "/cs461/user/{userId}", method = RequestMethod.DELETE)
    void deleteUser(
    		@PathVariable("userId") String userId) {
    	userManager.deleteUser(userId);
    }


    @RequestMapping(value = "/cs461/users/list", method = RequestMethod.GET)
    List<Faculty> listAllUsers() {
    	return userManager.listAllUsers();
    }

    @RequestMapping(value = "/cs461/home", method = RequestMethod.GET)
    ModelAndView getUserHomepage() {
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("users", listAllUsers());
        return modelAndView;
    }
    
    @RequestMapping(value = "/cs461/student", method = RequestMethod.GET)
    ModelAndView getStudentPage() {
        ModelAndView modelAndView = new ModelAndView("student");
        modelAndView.addObject("users", listAllUsers());
        return modelAndView;
    }

}