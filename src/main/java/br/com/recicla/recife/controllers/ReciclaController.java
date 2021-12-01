package br.com.recicla.recife.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.recicla.recife.entities.Recicla;
import br.com.recicla.recife.repository.ReciclaRepository;

@Controller
public class ReciclaController {

	@Autowired
	private ReciclaRepository repository;

	@GetMapping("/inserirDenuncia")
	public ModelAndView InsertDenuncia(Recicla recicla) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Denuncia/form");
		mv.addObject("recicla", new Recicla());
		return mv;
	}

	@PostMapping("InsertDenuncia")
	public ModelAndView inserirDenuncia(@Validated Recicla recicla, BindingResult br) {
		ModelAndView mv = new ModelAndView();
		if (br.hasErrors()) {
			mv.setViewName("Denuncia/form");
				mv.addObject("recicla");
		} else {
			mv.setViewName("redirect:ultimas_denuncias");
			repository.save(recicla);
		}

		return mv;
	}

	@GetMapping("ultimas_denuncias")
	public ModelAndView listAllDenuncia() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Denuncia/listDenuncia");
		mv.addObject("lista_denuncias", repository.findAll());
		return mv;
	}

	@GetMapping("/alterar/{id}")
	public ModelAndView alterar(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Denuncia/alterar");
		Recicla recicla = repository.getOne(id);
		mv.addObject("recicla", recicla);
		return mv;
	}

	@PostMapping("/alterar")
	public ModelAndView alterar(Recicla recicla) {
		ModelAndView mv = new ModelAndView();
		repository.save(recicla);
		mv.setViewName("redirect:ultimas_denuncias");
		return mv;

	}

	@GetMapping("/excluir/{id}")
	public String excluirDenuncia(@PathVariable("id") Long id) {
		repository.deleteById(id);
		return "redirect:ultimas_denuncias";
	}

}
