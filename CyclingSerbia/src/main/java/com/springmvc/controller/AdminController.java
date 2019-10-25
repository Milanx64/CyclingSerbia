package com.springmvc.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import com.springmvc.model.FileBucket;
import com.springmvc.model.Mountain;
import com.springmvc.model.Photo;
import com.springmvc.model.User;
import com.springmvc.model.UserProfile;
import com.springmvc.service.MountainService;
import com.springmvc.service.PhotoService;
import com.springmvc.service.UserProfileService;
import com.springmvc.service.UserService;
import com.springmvc.util.FileValidator;


@Controller
@RequestMapping("/admin")
@SessionAttributes("roles")
public class AdminController {
	
	@Autowired
	PhotoService photoService;
	
	@Autowired
	MountainService mountainService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserProfileService userProfileService;
	
	@Autowired
	PersistentTokenBasedRememberMeServices persistentTokenBaseRememberMeService;
	
	@Autowired
	AuthenticationTrustResolver authenticationTrustResolver;
	
	@Autowired
	FileValidator fileValidator;
	
	
	
	 @InitBinder("fileBucket")
	 protected void initBinder(WebDataBinder binder) {
	       binder.setValidator(fileValidator);
	 }
	 
	
	
	//method for admin panel
	@RequestMapping(value = "/panel", method = RequestMethod.GET)
	public String adminPanel(ModelMap model) {
		User user = userService.findUserByEmail(getPrincipal());
		model.addAttribute("loggedinuser", getPrincipal());
		model.addAttribute("user", user);
		return "admin";
	}
	
	//Method for crating  admin or dba account
	@RequestMapping(value = "/panel-create-new", method = RequestMethod.GET)
	public String createAccount(ModelMap model) {
		User admin = new User();
		model.addAttribute("user", admin);
		model.addAttribute("edit", false);
		model.addAttribute("loggedinuser", getPrincipal());
		return "registration";
	}
	//Method for handliing admin creatino
	@RequestMapping(value = "/panel-create-new", method = RequestMethod.POST)
	public String create(@Valid User user, @PathVariable int id, BindingResult result, ModelMap model) {
		if(result.hasErrors()) {
			System.out.println("Error creating admin");
			model.addAttribute("");
			return "registration";
		}
		
		userService.saveUser(user);
		model.addAttribute("user", user);
		model.addAttribute("success", "Admin :" + user.getFirstname() + user.getLastname() + "created successfully");
		model.addAttribute("loggedinuser", getPrincipal());
		return "registration";
	}
	//Method to edit admin account
	@RequestMapping(value = "/panel-edit-admin-{id}", method = RequestMethod.GET)
	public String editAdmin(@PathVariable int id, ModelMap model) {
		User admin = userService.findUserById(id);
		if(getPrincipal().equals(admin.getEmail())) {
			model.addAttribute("user", admin);
			model.addAttribute("edit", true);
			model.addAttribute("loggedinuser", getPrincipal());
			return "registration";
		} else {
			model.addAttribute("loggedinuser", getPrincipal());
			return "access-denied";
		}
		
	}
	
	
	
	//Method for listing all users
	@RequestMapping(value = "/panel-list-all-users", method = RequestMethod.GET)
	public String listAllUsers(ModelMap model) {
		List<User> users = userService.findAllUsers();
		model.addAttribute("users", users);
		return "user-list";
	}
	//Method for deleting user
	@RequestMapping(value = "/panel-delete-user-{id}", method = RequestMethod.GET)
	public String deleteUser(@PathVariable int id, ModelMap model) {
		User user = userService.findUserById(id);
		userService.deleteUser(user);
		return "user-list";
	}
	
	//Method for deleting admin account
	@RequestMapping(value = "/panel-delete-admin-{id}", method = RequestMethod.GET)
	public String deleteAdmin(@PathVariable int id, ModelMap model) {
		User admin = userService.findUserById(id);
		userService.deleteUser(admin);
		return "success";
	}
	
	
	//Access denied page
	@RequestMapping( value = "/access-denied", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model) {
		model.addAttribute("loggedinuser", getPrincipal());
		return "access-denied";
	}
	
	
	//Method that provides form for photo upload
	@RequestMapping(value = "/panel-add-photo-{id}", method = RequestMethod.GET)
	public String uploadPage(@PathVariable int id, ModelMap model) {
		System.out.println("adding photo");
		User admin = userService.findUserByEmail(getPrincipal());
		model.addAttribute("user", admin);
		
		FileBucket fileModel = new FileBucket();
        model.addAttribute("fileBucket", fileModel);
        model.addAttribute("loggedinuser", getPrincipal());
        System.out.println("username " + getPrincipal());
		return "photo-upload";
	}
	
	@RequestMapping(value = "/panel-add-photo-{id}", method = RequestMethod.POST)
	private String uploadPhoto(@Valid FileBucket fileBucket, BindingResult result, ModelMap model, @PathVariable int id) throws IOException {
		System.out.println("uploading photo");
		if(result.hasErrors()) {
			return "photo-upload";
		}
		User admin = userService.findUserByEmail(getPrincipal());
		Mountain mountain = mountainService.findById(id);
		
		savePhoto(fileBucket, admin, mountain);
		model.addAttribute("loggedinuser", getPrincipal());
		model.addAttribute("user", admin);
		model.addAttribute("filename", fileBucket.getFile().getName());
		return "success";
	
	}
	
	
	@RequestMapping(value = "/panel-show-all-photos", method = RequestMethod.GET)
	public String showAllPhotos(ModelMap model) throws IOException {
		List<Photo> photos = photoService.findAllPhotos();	
		model.addAttribute("photos", photos);
		model.addAttribute("loggedinuser", getPrincipal());
		return "photo-list";
	}
	
	
	@RequestMapping(value = "/panel-show-photo-{id}", method = RequestMethod.GET)
	public void showImage(@PathVariable int id, HttpServletResponse response,HttpServletRequest request) 
	          throws ServletException, IOException{


	    Photo photo = photoService.findById(id);        
	    response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
	    response.getOutputStream().write(photo.getContent());
	    response.getOutputStream().close();
	}
	
	@RequestMapping(value = "/panel-delete-photo-{id}", method = RequestMethod.GET)
	public String deletePhoto(@PathVariable int id, ModelMap model) {
		Photo p = photoService.findById(id);
		photoService.deletePhoto(p);
		model.addAttribute("success", "Photo deleted successfuly");
		model.addAttribute("loggedinuser", getPrincipal());
		return "success";
	}
	private void savePhoto(FileBucket fileBucket, User admin, Mountain mountain) throws IOException {
		Photo photo = new Photo();
		
	    MultipartFile multipartFile = fileBucket.getFile();
	    
		photo.setName(multipartFile.getOriginalFilename());
		photo.setDescription(fileBucket.getDescription());
		photo.setType(multipartFile.getContentType());
		photo.setContent(multipartFile.getBytes());
		photo.setUser(admin);
		photo.setMountain(mountain);
		
		photoService.savePhoto(photo);
	}
	
	
	
	//Return  a principal (email) of logged in user
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
	
	@SuppressWarnings("unused")
	private boolean isCurrentAuthenticationAnonymous() {
		final Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return authenticationTrustResolver.isAnonymous(auth);
	}
	
	@ModelAttribute("roles")
	private List<UserProfile> initializeProfiles(){
		return userProfileService.findAll();
	}
	

	
	
}
