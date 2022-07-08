package com.appconsulta.com.appconsulta.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.appconsulta.com.appconsulta.repository.PacienteRepository;
import com.appconsulta.com.appconsulta.repository.ConsultaRepository;

@Controller
public class BuscaController {
	
	@Autowired
	private PacienteRepository pr;
	
	@Autowired
	private ConsultaRepository cr;
	
	//GET
	@RequestMapping("/")
	public ModelAndView abrirIndex() {
		ModelAndView mv = new ModelAndView("index");
		return mv;
	}
	
	//POST
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ModelAndView buscarIndex(@RequestParam("buscar") String buscar, @RequestParam("nome") String nome) {
		
		ModelAndView mv = new ModelAndView("index");
		String mensagem = "Resultados da busca por " + buscar;
		
		if(nome.equals("nomepaciente")) {
			mv.addObject("pacientes", pr.findByNomesPacientes(buscar));
			
		}else if(nome.equals("especialidadeconsulta")) {
			mv.addObject("consultass", cr.findByEspecialidadesConsultas(buscar));

		}else {
			mv.addObject("funcionarios", pr.findByNomesPacientes(buscar));
			mv.addObject("candidatos", cr.findByEspecialidadesConsultas(buscar));
		}
		
		mv.addObject("mensagem", mensagem);
		
		return mv;
	}

}
