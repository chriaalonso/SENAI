package com.appconsulta.com.appconsulta.models;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;


@Entity
public class Consulta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long codigoConsulta;

	@NotEmpty
	private String especialidadeConsulta;
	
	@NotEmpty
	private String dataHorarioConsulta;

	@NotEmpty
	private String detalheConsulta;
	
	@ManyToOne
	private Paciente paciente;

	public long getCodigoConsulta() {
		return codigoConsulta;
	}

	public void setCodigoConsulta(long codigoConsulta) {
		this.codigoConsulta = codigoConsulta;
	}

	public String getEspecialidadeConsulta() {
		return especialidadeConsulta;
	}

	public void setEspecialidadeConsulta(String especialidadeConsulta) {
		this.especialidadeConsulta = especialidadeConsulta;
	}

	public String getDataHorarioConsulta() {
		return dataHorarioConsulta;
	}

	public void setDataHorarioConsulta(String dataHorarioConsulta) {
		this.dataHorarioConsulta = dataHorarioConsulta;
	}

	public String getDetalheConsulta() {
		return detalheConsulta;
	}

	public void setDetalheConsulta(String detalheConsulta) {
		this.detalheConsulta = detalheConsulta;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
}
