package com.nusacamp.app.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nusacamp.app.model.Items;
import com.nusacamp.app.service.ItemsService;

@Controller
public class ItemsController {
	
	@Autowired
	private ItemsService service;
	
	@RequestMapping(value = {"/items"})
	public String viewHomepage(Model model) {
		List<Items> listItems = service.listAll();
		model.addAttribute("listItems", listItems);
		return "indexItems";	
	}
	@RequestMapping("/new")
	public String showNewItemsPage(Model model) {
		
		Items items = new Items();
		model.addAttribute("items", items);
		
		return "newItems";
	}
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String saveItems(@ModelAttribute("items")Items items) {
		service.save(items);
		
		return "redirect:/";
	}
	@RequestMapping("/editItems/{id}")
	public ModelAndView showEditItemsPage(@PathVariable(name="id")int id) {
		ModelAndView mav = new ModelAndView("editItems");
		Items items = new Items();
		mav.addObject("items", items);
		return mav;
	}
	@RequestMapping("/deleteItems/{id}")
	public String deleteItems(@PathVariable(name = "id")int id) {
		service.delete(id);
		return "redirect:/";
	}
	public ResponseEntity<Items> get(@PathVariable Integer id){
		try {
			Items items = service.get(id);
			return new ResponseEntity<Items>(items, HttpStatus.OK);
		}catch(NoSuchElementException e){
			return new ResponseEntity<Items>(HttpStatus.NOT_FOUND);
		}
	}
	

}
