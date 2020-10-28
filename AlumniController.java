package net.javaguides.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import net.javaguides.springboot.model.Alumni;

import net.javaguides.springboot.service.UserService;

@Controller
public class AlumniController {
	@Autowired
	private UserService us;
	
	@GetMapping("/")
	public String showRegistration(Model model) {
		Alumni alumni = new Alumni();
		model.addAttribute("alumni", alumni);
		return "registration";
	}
	
	@PostMapping("/registration")
	public String saveAlumni(@ModelAttribute("alumni") @Validated Alumni alumni, BindingResult bindingResult) {
		
		Alumni existing = us.findByEmail(alumni.getEmail());
        if (existing != null) {
        	bindingResult.rejectValue("email", null, "There is already an account registered with that email");
        }
		
		if (bindingResult.hasErrors()) {
	         return "registration";
	      }
		us.saveAlumni(alumni);
		return "redirect:/?success";
	}
	
	
	@PostMapping("/updateAlumni")
	public String updateAlumni(@ModelAttribute("alumni") @Validated Alumni alumni, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
	         return "update_alumni";
	      }
		us.saveAlumni(alumni);
		return "redirect:/index";
	}
	
	@GetMapping("/index")
	public String showAlumni(Model model) {
		model.addAttribute("listOfAlumni",us.getAllAlumni());
		return "index";
	}
	
	@GetMapping("/showFormForUpdate/{id}" )
	public String showFormForUpdate(@PathVariable(value="id") long id, Model model) {
		Alumni alumni = us.getAlumniById(id);
		model.addAttribute("alumni", alumni);
		return "update_alumni";
	}
	
	@GetMapping("/deleteAlumni/{id}")
	public String deleteAlumni(@PathVariable(value="id")long id) {
		Alumni alumni = us.getAlumniById(id);
		us.deleteAlumni(alumni);
		return "redirect:/index";
	}

}
