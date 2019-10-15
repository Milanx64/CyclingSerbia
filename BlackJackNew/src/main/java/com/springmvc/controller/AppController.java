package com.springmvc.controller;



import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.springmvc.model.Cards;
import com.springmvc.model.Game;
import com.springmvc.model.House;
import com.springmvc.model.Player;
import com.springmvc.util.PlayerLogic;

@Controller
@RequestMapping("/")

public class AppController {
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String indexPage(ModelMap model, HttpSession session) {
		
		Player player = new Player();
		model.addAttribute("player", player);
		model.addAttribute("edit", false);
		
		return "index";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String startGame(@Valid Player p, BindingResult result, ModelMap model, HttpSession session) {
		if(result.hasErrors()) {
			return "index";
		}
		Player player = p;
		House house = new House(); 
		Cards cards = new Cards();
		Game game = new Game();
		
		game.setCards(cards);
		game.setHouse(house);
		game.setPlayer(player);
		
		model.addAttribute("palyer", player);
		model.addAttribute("cards", cards);
		model.addAttribute("house", house);	
		
		session.setAttribute("game", game);
		
		return "play";
	}
	
	@RequestMapping(value = "/play", method = RequestMethod.POST)
	public String playGame( ModelMap model, HttpSession session) {
		
		Game game = (Game)session.getAttribute("game");
		Game newGame = PlayerLogic.startGame(game);
		Player player = newGame.getPlayer();
		Cards cards = newGame.getCards();
		House house = newGame.getHouse();
		model.addAttribute("palyer", player);
		model.addAttribute("cards", cards);
		model.addAttribute("house", house);	
		//model.addAttribute("game", newGame);
		session.setAttribute("game", newGame);
		session.setAttribute("test", "TEst");
		return "play";
	}
	
}
