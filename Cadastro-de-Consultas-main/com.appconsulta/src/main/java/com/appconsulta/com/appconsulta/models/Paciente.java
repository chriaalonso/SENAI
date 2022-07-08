package com.appconsulta.com.appconsulta.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

@Entity
public class Paciente implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idPaciente;

	@NotEmpty
	private String nomePaciente;

	@NotEmpty
	private String rgPaciente;

	@NotEmpty
	private String dataNascimentoPaciente;

	@NotEmpty
	private String telefonePaciente;

	@NotEmpty
	private String emailPaciente;

	@NotEmpty
	private String enderecoPaciente;
	
	@OneToMany(mappedBy = "paciente", cascade = CascadeType.REMOVE)
	private List<Consulta>consultas;

	public long getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(long idPaciente) {
		this.idPaciente = idPaciente;
	}

	public String getNomePaciente() {
		return nomePaciente;
	}

	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}

	public String getRgPaciente() {
		return rgPaciente;
	}

	public void setRgPaciente(String rgPaciente) {
		this.rgPaciente = rgPaciente;
	}

	public String getDataNascimentoPaciente() {
		return dataNascimentoPaciente;
	}

	public void setDataNascimentoPaciente(String dataNascimentoPaciente) {
		this.dataNascimentoPaciente = dataNascimentoPaciente;
	}

	public String getTelefonePaciente() {
		return telefonePaciente;
	}

	public void setTelefonePaciente(String telefonePaciente) {
		this.telefonePaciente = telefonePaciente;
	}

	public String getEmailPaciente() {
		return emailPaciente;
	}

	public void setEmailPaciente(String emailPaciente) {
		this.emailPaciente = emailPaciente;
	}

	public String getEnderecoPaciente() {
		return enderecoPaciente;
	}

	public void setEnderecoPaciente(String enderecoPaciente) {
		this.enderecoPaciente = enderecoPaciente;
	}

	public List<Consulta> getConsultas() {
		return consultas;
	}

	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
	}
}
