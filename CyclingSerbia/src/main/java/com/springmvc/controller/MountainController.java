package com.springmvc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springmvc.model.Mountain;
import com.springmvc.model.Track;
import com.springmvc.service.MountainService;
import com.springmvc.service.TrackService;

@Controller
@RequestMapping("/mountain")
@SessionAttributes("role")
public class MountainController {
	
	@Autowired
	MountainService mountainService;
	
	@Autowired
	TrackService trackService;
	
	@RequestMapping(value = "/show-all-mountains", method = RequestMethod.GET)
	public String showAllMountains(ModelMap model) {
		List<Mountain> mountains = mountainService.findAll();
		model.addAttribute("mountains", mountains);
		model.addAttribute("loggedinuser", getPrincipal());
		return "mountain-list";
	}
	
	//Method to add mountain
	@RequestMapping(value = "/new-mountain", method = RequestMethod.GET)
	public String createMountain(ModelMap model) {
		Mountain mountain = new Mountain();
		model.addAttribute("mountain", mountain);
		model.addAttribute("edit", false);
		model.addAttribute("loggedinuser", getPrincipal());
		return "mountain-reg";
			
	}
	
	@RequestMapping(value= "/show-mountain-{id}", method = RequestMethod.GET)
	public String showMountain(@PathVariable int id, ModelMap model) {
		Mountain mountain = mountainService.findById(id);
		List<Track> tracks = trackService.findAllTracksOnMountain(mountain);
		mountain.setTracks(tracks);
		model.addAttribute("mountain", mountain);
		model.addAttribute("loggedinuser", getPrincipal());
		return "mountain";
		
	}
	
	@RequestMapping(value = "/new-mountain", method = RequestMethod.POST)
	public String editAdmin(@Valid Mountain mountain, BindingResult result, ModelMap model) {
		if(result.hasErrors()) {
			return "mountain-reg";
		}
		
		mountainService.save(mountain);
		model.addAttribute("mountain", mountain);
		model.addAttribute("success", "Mountain " + mountain.getName() + " created successfuly");
		model.addAttribute("loggedinuser", getPrincipal());
		return "success";
	}
	
	//Metod to edit mountain
	@RequestMapping(value = "/edit-mountain-{id}", method = RequestMethod.GET)
	public String updateMountain(@PathVariable int id, ModelMap model) {
		Mountain m = mountainService.findById(id);
		model.addAttribute("mountain", m);
		model.addAttribute("edit", true);
		model.addAttribute("loggedinuser", getPrincipal());
		return "mountain-reg";
	}
	
	@RequestMapping(value = "/edit-mountain-{id}", method = RequestMethod.POST)
	public String updateMountain(@Valid Mountain mountain, BindingResult result, ModelMap model) {
		if(result.hasErrors()) {
			return"mountain-reg";
		}
		
		
		return "success";
		
	}
	
	@RequestMapping(value = "/add-track-{id}", method = RequestMethod.GET)
	public String addTracks(@PathVariable int id, ModelMap model) {
		Track track = new Track();
		model.addAttribute("track", track);
		model.addAttribute("edit", false);
		model.addAttribute("loggedinuser", getPrincipal());
		return "track-reg";
		
	}
	
	@RequestMapping(value = "/add-track-{id}", method = RequestMethod.POST)
	public String createTrack(@Valid Track track, BindingResult result, ModelMap model, @PathVariable int id) {
		if(result.hasErrors()) {
			return "track-reg";
		}
		Mountain mountain = mountainService.findById(id);
		track.setMountain(mountain);
		trackService.saveTrack(track);
		model.addAttribute("success", "Track succesffuly saved");
		model.addAttribute("loggedinuser", getPrincipal());
		return "success";
		
	}
	
	public String updateTrack() {
		return null;
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
