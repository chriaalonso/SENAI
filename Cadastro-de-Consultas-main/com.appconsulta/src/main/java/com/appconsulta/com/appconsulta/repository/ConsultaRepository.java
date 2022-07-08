package com.appconsulta.com.appconsulta.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.appconsulta.com.appconsulta.models.Consulta;
import com.appconsulta.com.appconsulta.models.Paciente;

public interface ConsultaRepository extends CrudRepository<Consulta, Long> {

	Iterable<Consulta> findByPaciente(Paciente paciente);

	// para o método delete por data e hora
	Consulta findByDataHorarioConsulta(String dataHorarioConsulta);
	
	Consulta findByCodigoConsulta(long codigoConsulta);
	List<Consulta> findByEspecialidadeConsulta(String EspecialidadeConsulta);

	// Query para a busca
	@Query(value = "select u from Consulta u where u.especialidadeConsulta like %?1%")
	List<Consulta> findByEspecialidadesConsultas(String especialidadeConsulta);

}
