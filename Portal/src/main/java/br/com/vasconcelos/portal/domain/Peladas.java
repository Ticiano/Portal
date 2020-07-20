package br.com.vasconcelos.portal.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
public class Peladas implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idPelada;
	
	@Column(length = 200, nullable = false)
	private String nomeEvento; 
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date data;
	
	@Column(nullable = false)
	@Temporal(TemporalType.TIME)
	private Date horario;
	
	@Column(length = 200, nullable = false)
	private String local;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Usuario usuario;

	public Long getIdPelada() {
		return idPelada;
	}

	public void setIdPelada(Long idPelada) {
		this.idPelada = idPelada;
	}

	public String getNomeEvento() {
		return nomeEvento;
	}

	public void setNomeEvento(String nomeEvento) {
		this.nomeEvento = nomeEvento;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Date getHorario() {
		return horario;
	}

	public void setHorario(Date horario) {
		this.horario = horario;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
