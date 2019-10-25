package com.springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springmvc.model.Mountain;
import com.springmvc.model.Photo;
import com.springmvc.model.User;
import com.springmvc.service.MountainService;
import com.springmvc.service.PhotoService;
import com.springmvc.service.UserService;


@Controller
@RequestMapping("/")
@SessionAttributes("role")
public class AppController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	PhotoService photoService;
	
	@Autowired
	MountainService mountainService;
	
	@Autowired
	PersistentTokenBasedRememberMeServices persistentTokenBaseRememberMeService;
	
	@Autowired
	AuthenticationTrustResolver authenticationTrustResolver;
	
	@Autowired
	MessageSource messageSource;
	
	/*@Autowired
	FileValidator fileValidator;*/
	
	@InitBinder("fileBucket")
	protected void initBinder(WebDataBinder binder) {}
	
	//To handle request for home page
	@RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
	public String homePage(ModelMap model) {
		List<Photo> photos = photoService.find4Photos();
		model.addAttribute("photos", photos);
		model.addAttribute("loggedinuser", getPrincipal());
		return "index";
	}
	
	//To handle request for all mountains
	@RequestMapping(value = "/all-mountains", method = RequestMethod.GET)
	public String findAllMountains(ModelMap model) {
		return "allMountains";
	}
	
	//To handle request for a specific mountain
	@RequestMapping(value = "/mountain-{id}", method = RequestMethod.GET)
	public String mountainById(@PathVariable String id, ModelMap model) {
		
		return "mountain";
	}
	
	//TO handle request for a specific track
	@RequestMapping(value = "/track-{id}", method = RequestMethod.GET)
	public String trackById(@PathVariable String id, ModelMap model) {
		return "track";
	}
	
	//To handle request showing all tracks
	@RequestMapping(value = "/all-tracks", method = RequestMethod.GET)
	public String alltracks(ModelMap model) {
		return "allTracks";
	}
	
	//To handle request made by admin or dba for listing all users
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String listAllUsers(ModelMap model) {
		return "allUsers";
	}
	
	//To handle request for creating an user
	@RequestMapping(value = "/newuser", method = RequestMethod.GET)
	public String createUser(ModelMap model) {
		User user = new User();
		model.addAttribute("user", user);
		model.addAttribute("edit", false);
		model.addAttribute("loggedinuser", getPrincipal());
		return "registration";
	}
	
	//To handle post request for creating user
	@RequestMapping(value = "/newuser", method = RequestMethod.POST)
	public String saveUser(@Valid User user, BindingResult result, ModelMap model) {
		if(result.hasErrors()) {
			System.out.println("Error creating user");
			return "registration";
		}
		//make shore that user has unique email
		/*
		 * if(isEmailUnique(user.getEmail()){
		 * 		userService.saveUser(user);
		 * 		return "registrationsuccess";
		 * }
		 * 
		 */
		userService.saveUser(user);
		model.addAttribute("success", "User " + user.getFirstname()+ " " + user.getLastname() + "created successfully");
		model.addAttribute("loggedinuser", getPrincipal());
		return "registrationsuccess";
	}
	
	//To handle request by any user for creating accaunt
	@RequestMapping(value = "/user-create-account", method = RequestMethod.GET)
	public String createAcount(ModelMap model) {
		return "regUser";
	}
	
	//To handle users post request for creating acount
	@RequestMapping(value = "/user-create-account", method = RequestMethod.POST)
	public String userCreatAcount(@Valid User user, BindingResult result, ModelMap model) {
		return "success";
	}
	
	//Access denied redirect
	@RequestMapping(value = "/access-denied", method = RequestMethod.POST)
	public String accessDeniedUserPage(ModelMap model) {
		model.addAttribute("loggedinuser", getPrincipal());
		return "access-denied";
	}
	
	//If user is logged in
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String userLoginPage() {
		if(isCurrentAuthenticationAnonymous()) {
			return "login";
		} else {
			return "redirect:/home";
		}
	}
	
	//Logout request
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String userLogoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		if(auth != null) {
			persistentTokenBaseRememberMeService.logout(request, response, auth);
			SecurityContextHolder.getContext().setAuthentication(null);
		}
		
		return "redirect:/login?logout";
	}

	private boolean isCurrentAuthenticationAnonymous() {
		// TODO Auto-generated method stub
		final Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		return authenticationTrustResolver.isAnonymous(auth);
	}

	private String getPrincipal() {
		String username = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		
		if(principal instanceof UserDetails) {
			username = ((UserDetails)principal).getUsername();
		} else {
			username = principal.toString();
		}
		return username;
	}
	
	
}
