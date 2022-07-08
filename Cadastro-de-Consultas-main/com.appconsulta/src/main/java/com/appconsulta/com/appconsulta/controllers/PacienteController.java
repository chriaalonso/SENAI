package com.appconsulta.com.appconsulta.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.appconsulta.com.appconsulta.repository.PacienteRepository;
import com.appconsulta.com.appconsulta.repository.ConsultaRepository;
import com.appconsulta.com.appconsulta.models.Consulta;
import com.appconsulta.com.appconsulta.models.Paciente;

@Controller
public class PacienteController {

	@Autowired
	private PacienteRepository pr;

	@Autowired
	private ConsultaRepository cr;

	// GET que chama o form para cadastrar pacientes
	@RequestMapping("/cadastrarPaciente")
	public String form() {
		return "paciente/form-paciente";
	}

	// POST que cadastra pacientes
	@RequestMapping(value = "/cadastrarPaciente", method = RequestMethod.POST)
	public String form(@Valid Paciente paciente, BindingResult result, RedirectAttributes attributes) {

		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos");
			return "redirect:/cadastrarPaciente";
		}

		pr.save(paciente);
		attributes.addFlashAttribute("mensagem", "Paciente cadastrado com sucesso!");
		return "redirect:/cadastrarPaciente";
	}

	// GET que lista pacientes
	@RequestMapping("/pacientes")
	public ModelAndView listaPacientes() {
		ModelAndView mv = new ModelAndView("paciente/lista-paciente");
		Iterable<Paciente> pacientes = pr.findAll();
		mv.addObject("pacientes", pacientes);
		return mv;
	}

	// GET que lista consulta e detalhes dos paciente
	@RequestMapping("/detalhes-paciente/{id}")
	public ModelAndView detalhesPaciente(@PathVariable("id") long id) {
		Paciente paciente = pr.findById(id);
		ModelAndView mv = new ModelAndView("paciente/detalhes-paciente");
		mv.addObject("pacientes", paciente);

		// lista de dependentes baseada no id do paciente
		Iterable<Consulta> consultas = cr.findByPaciente(paciente);
		mv.addObject("consultas", consultas);

		return mv;

	}

	// POST que adiciona consulta
	@RequestMapping(value="/detalhes-paciente/{id}", method = RequestMethod.POST)
	public String detalhesPacientePost(@PathVariable("id") long id, Consulta consultas, BindingResult result,
			RedirectAttributes attributes) {
		
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos!");
			return "redirect:/detalhes-paciente/{id}";
		}
		
		if(cr.findByDataHorarioConsulta(consultas.getDataHorarioConsulta()) != null) {
			attributes.addFlashAttribute("mensagem_erro", "Data e Horário duplicado");
			return "redirect:/detalhes-paciente/{id}";
		}

		Paciente paciente = pr.findById(id);
		consultas.setPaciente(paciente);
		cr.save(consultas);
		attributes.addFlashAttribute("mensagem", "Consulta agendada com sucesso");
		return "redirect:/detalhes-paciente/{id}";
		
	}
	
	//GET que deleta paciente
	@RequestMapping("/deletarPaciente")
	public String deletarPaciente(long id) {
		Paciente paciente = pr.findById(id);
		pr.delete(paciente);
		return "redirect:/pacientes";
		
	}
	
	// Métodos que atualizam paciente

	// GET que chama o FORM de edição do paciente
	@RequestMapping("/editar-paciente")
	public ModelAndView editarPaciente(long id) {
		Paciente paciente = pr.findById(id);
		ModelAndView mv = new ModelAndView("paciente/atualizar-paciente");
		mv.addObject("paciente", paciente);
		return mv;
	}
	
	// POST que atualiza o paciente
	@RequestMapping(value = "/editar-paciente", method = RequestMethod.POST)
	public String atualizaPaciente(@Valid Paciente paciente,  BindingResult result, RedirectAttributes attributes){
		
		pr.save(paciente);
		attributes.addFlashAttribute("successs", "Paciente atualizado com sucesso!");
		
		long idLong = paciente.getIdPaciente();
		String id = "" + idLong;
		return "redirect:/detalhes-paciente/" + id;
		
	}
	
	// GET que deleta consulta
	@RequestMapping("/deletarConsulta")
	public String deletarConsulta(Long codigoConsulta) {
		Consulta consulta = cr.findByCodigoConsulta(codigoConsulta);

		Paciente paciente = consulta.getPaciente();
		String codigo = "" + paciente.getIdPaciente();
		
		cr.delete(consulta);
		return "redirect:/detalhes-paciente/" + codigo;
	
	}
}
