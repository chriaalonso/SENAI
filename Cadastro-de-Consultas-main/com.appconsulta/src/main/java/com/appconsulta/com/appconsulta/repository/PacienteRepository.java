package com.appconsulta.com.appconsulta.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.appconsulta.com.appconsulta.models.Paciente;

public interface PacienteRepository extends CrudRepository<Paciente, Long>{
	
	Paciente findById(long id);
	Paciente findByNomePaciente(String nomePaciente);
	
	// Query para a busca
	@Query(value = "select u from Paciente u where u.nomePaciente like %?1%")
	List<Paciente>findByNomesPacientes(String nomePaciente);

}
