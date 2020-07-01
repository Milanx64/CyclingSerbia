package com.springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
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
import com.springmvc.model.Photo;
import com.springmvc.model.Region;
import com.springmvc.model.Track;
import com.springmvc.service.MountainService;
import com.springmvc.service.PhotoService;
import com.springmvc.service.RegionService;
import com.springmvc.service.TrackService;

@Controller
@RequestMapping("/mountain")
@SessionAttributes("role")
public class MountainController {
	
	@Autowired
	MountainService mountainService;
	
	@Autowired
	TrackService trackService;
	
	@Autowired
	PhotoService photoService;
	
	@Autowired
	RegionService regionService;
	
	@RequestMapping(value = "/show-for-", method = RequestMethod.GET)
	public String showAllMountainsForRegion(@Valid Mountain mountain, BindingResult result, ModelMap model, HttpServletRequest request) {
		String regionToSearch = request.getParameter("region");
		if(regionToSearch.equalsIgnoreCase("all")) {
			List<Mountain> mountains = mountainService.findAll();
			model.addAttribute("mountains", mountains);
		}
		else {
			Region region = regionService.findByName(regionToSearch);
			List<Mountain> mountains = mountainService.findByRegion(region);
			if(mountains.isEmpty()) {
				model.addAttribute("msg", "No results for " + regionToSearch );
				model.addAttribute("form", "true");
			}
			else {
				model.addAttribute("msg", "All mountains in " + region.getName());
			}
			model.addAttribute("mountains", mountains);
		}
		
		List<Region> regions = regionService.findAll();
		model.addAttribute("regions", regions);
		model.addAttribute("loggedinuser", getPrincipal());
		if(getPrincipal() != null) {
			model.addAttribute("loggedin", true);
		}
		return "region-mountain-list";
	}
	
	//Method to add mountain
	@RequestMapping(value = "/new-mountain", method = RequestMethod.GET)
	public String createMountain(ModelMap model) {
		Mountain mountain = new Mountain();
		model.addAttribute("mountain", mountain);
		model.addAttribute("edit", false);
		model.addAttribute("msg", "Add New Mountain");
		model.addAttribute("loggedinuser", getPrincipal());
		if(getPrincipal() != null) {
			model.addAttribute("loggedin", true);
		}
		return "mountain-reg";
			
	}
	
	@RequestMapping(value= "/show-mountain-{id}", method = RequestMethod.GET)
	public String showMountain(@PathVariable int id, ModelMap model) {
		Mountain mountain = mountainService.findById(id);
		List<Track> tracks = trackService.findAllTracksOnMountain(mountain);
		List<Photo> photos = photoService.findPhotoOfMountain(mountain);
		mountain.setTracks(tracks);
		model.addAttribute("mountain", mountain);
		model.addAttribute("photos", photos);
		model.addAttribute("loggedinuser", getPrincipal());
		if(getPrincipal() != null) {
			model.addAttribute("loggedin", true);
		}
		return "mountain";
		
	}
	
	//Method to show all mountains
	@RequestMapping(value = "/show-all-mountains", method= RequestMethod.GET)
	public String showAllMountains(ModelMap model) {
		List<Mountain> mountains = mountainService.findAll();
		model.addAttribute("loggedinuser", getPrincipal());
		model.addAttribute("mountains", mountains);
		if(getPrincipal() != null) {
			model.addAttribute("loggedin", true);
		}
		return "mountain-list";
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
		if(getPrincipal() != null) {
			model.addAttribute("loggedin", true);
		}
		return showAllMountains(model);
		//return "mountain-list";
	}
	
	//Metod to edit mountain
	@RequestMapping(value = "/edit-mountain-{id}", method = RequestMethod.GET)
	public String updateMountain(@PathVariable int id, ModelMap model) {
		Mountain m = mountainService.findById(id);
		List<Track> t = trackService.findAllTracksOnMountain(m);
		m.setTracks(t);
		model.addAttribute("mountain", m);
		model.addAttribute("track", t);
		model.addAttribute("edit", true);
		model.addAttribute("msg", "Edit Mountain Data");
		model.addAttribute("loggedinuser", getPrincipal());
		if(getPrincipal() != null) {
			model.addAttribute("loggedin", true);
		}
		return "mountain-reg";
	}
	
	@RequestMapping(value = "/edit-mountain-{id}", method = RequestMethod.POST)
	public String updateMountain(@Valid Mountain mountain, BindingResult result, ModelMap model) {
		if(result.hasErrors()) {
			return"mountain-reg";
		}
		mountainService.updateMountain(mountain);
		if(getPrincipal() != null) {
			model.addAttribute("loggedin", true);
		}
		return "mountain-list";
		
	}
	
	@RequestMapping(value = "/add-track-{id}", method = RequestMethod.GET)
	public String addTracks(@PathVariable int id, ModelMap model) {
		Track track = new Track();
		model.addAttribute("track", track);
		model.addAttribute("edit", false);
		model.addAttribute("loggedinuser", getPrincipal());
		if(getPrincipal() != null) {
			model.addAttribute("loggedin", true);
		}
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
		if(getPrincipal() != null) {
			model.addAttribute("loggedin", true);
		}
		return showAllTracks(model);
		
	}
	
	@RequestMapping(value = "/show-all-tracks", method = RequestMethod.GET)
	public String showAllTracks(ModelMap model) {
		List<Track> tracks = trackService.findAllTracks();
		model.addAttribute("tracks", tracks);
		model.addAttribute("loggedinuser", getPrincipal());
		if(getPrincipal() != null) {
			model.addAttribute("loggedin", true);
		}
		return "track-list";
		
	}
	
	//id in this method refrds to mountain id
	@RequestMapping(value = "/show-track-{id}", method = RequestMethod.GET)
	public String showTrack(@PathVariable int id, ModelMap model) {
		Mountain mountain = mountainService.findById(id);
		List<Track> tracks = trackService.findAllTracksOnMountain(mountain);
		model.addAttribute("tracks", tracks);
		model.addAttribute("loggedinuser", getPrincipal());
		if(getPrincipal() != null) {
			model.addAttribute("loggedin", true);
		}
		return "track-list";
	}
	
	@RequestMapping(value = "/edit-track-{id}", method = RequestMethod.GET)
	public String editTrack(@PathVariable int id, ModelMap model) {
		Track track = trackService.findById(id);
		model.addAttribute("track", track);
		model.addAttribute("edit", true);
		model.addAttribute("loggedinuser".concat(getPrincipal()));
		if(getPrincipal() != null) {
			model.addAttribute("loggedin", true);
		}
		return "track-reg";
		
	}
	
	@RequestMapping(value = "/edit-track-{id}", method = RequestMethod.POST)
	public String updateTrack(@Valid Track track, BindingResult result, ModelMap model) {
		if(result.hasErrors()) {
			return "track-reg";
		}
		trackService.updateTrack(track);
		return "success";
	}
	
	@RequestMapping(value="/delete-mountain-{id}", method = RequestMethod.GET)
	public String deleteMountain(@PathVariable int id) {
		System.out.println("ID to delete is: " + id);
		Mountain mountain = mountainService.findById(id);
		if(mountain == null) {
			System.out.println("No moutain found");
		} else {
			mountainService.delete(mountain);
			for(Photo p : mountain.getPhotos())
			photoService.deletePhoto(p);
		}
		
		return "success";
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
