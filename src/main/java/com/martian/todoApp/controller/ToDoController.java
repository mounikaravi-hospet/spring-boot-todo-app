package com.martian.todoApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.martian.todoApp.model.ToDo;
import com.martian.todoApp.service.ToDoService;

@Controller
public class ToDoController {
	
	@Autowired
	private ToDoService service;
	
	@GetMapping({"/", "/viewToDoList"})
	public String viewAllToDoItems(Model model, @ModelAttribute("message") String message) {
		model.addAttribute("list", service.getAllToDoItems());
		model.addAttribute("message", message);
		
		return "ViewToDoList";
	}
	
	@GetMapping("/updateStatus/{id}")
	public String updateToDoStatus(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
		if(service.updateStatus(id)) {
			redirectAttributes.addFlashAttribute("message", "Update Success");
			return "redirect:/viewToDoList";
		}
		redirectAttributes.addFlashAttribute("message", "Update Failed");
		return "redirect:/viewToDoList";
	}
	
	@GetMapping("/addTodoItem")
	public String addToDoItem(Model model) {
		model.addAttribute("todo", new ToDo());
		return "AddTodoItem";
	}
	
	@PostMapping("/saveTodoItem")
	public String saveTodoItem(ToDo todo, RedirectAttributes redirectAttributes) {
		if(service.saveOrUpdateToDoItem(todo)) {
			redirectAttributes.addFlashAttribute("message", "Item Saved");
			return "redirect:/viewToDoList"; //we are returning this so that the user can see the newly added item in the list
		}
		redirectAttributes.addFlashAttribute("message", "Save Fail");
		return "redirect:/addToDoItem";
	}
	
	@GetMapping("/editTodoItem/{id}")
	public String editToDoItem(@PathVariable Integer id, Model model) {
		//we first need to get the item that we want to edit. Hence this is a get mapping
		model.addAttribute("todo", service.getToDoItemById(id));
		return "EditToDoItem";
	}
	
	@PostMapping("/saveEditedTodoItem")
	public String saveEditedTodoItem(ToDo todo, RedirectAttributes redirectAttributes) {
		if(service.saveOrUpdateToDoItem(todo)) {
			redirectAttributes.addFlashAttribute("message", "Item Edited");
			return "redirect:/viewToDoList"; //we are returning this so that the user can see the newly added item in the list
		}
		redirectAttributes.addFlashAttribute("message", "Edit Fail");
		return "redirect:/editTodoItem/" + todo.getId();
	}
	
	@GetMapping("/deleteTodoItem/{id}")
	public String deteleToDoItem(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
		if(service.deleteToDoItem(id)){
			redirectAttributes.addFlashAttribute("message", "Item Deleted");
			return "redirect:/viewToDoList";
		}
			redirectAttributes.addFlashAttribute("message", "Delete Fail");
			return "redirect:/viewToDoList";
	}
	
}
