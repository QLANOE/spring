package poe.spring.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import poe.spring.form.TrajetForm;
import poe.spring.model.Trajet;
import poe.spring.services.TrajetServices;

@Controller
@RequestMapping("/trajet")
public class TrajetPageController {

	@Autowired
	TrajetServices trajetService;

	@GetMapping
	public String accueilTrajet(Model model) {
		return "indexTrajet";
	}

	@GetMapping("/creationTrajet")
	public String listerUser(TrajetForm form, Model model) {
		return "creationTrajet";
	}

	@PostMapping("/sauvegardeTrajet")
	public String sauvegarderTrajet(@Valid TrajetForm form, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "creationTrajet";
		}

		Trajet trajet = form.trajetFormToTrajet();
		trajetService.ajout(trajet);

		return "redirect:/";
	}

}
