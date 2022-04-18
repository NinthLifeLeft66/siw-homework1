package it.uniroma3.siw.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Societa {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	   
	private String ragioneSociale;
	private String indirizzoCompleto;
	private String numeroTel;
	
	public Societa(String ragioneSociale, String indirizzoCompleto, String numeroTel) {
		this.ragioneSociale = ragioneSociale;
		this.indirizzoCompleto = indirizzoCompleto;
		this.numeroTel = numeroTel;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRagioneSociale() {
		return ragioneSociale;
	}
	public void setRagioneSociale(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
	}
	public String getIndirizzoCompleto() {
		return indirizzoCompleto;
	}
	public void setIndirizzoCompleto(String indirizzoCompleto) {
		this.indirizzoCompleto = indirizzoCompleto;
	}
	public String getNumeroTel() {
		return numeroTel;
	}
	public void setNumeroTel(String numeroTel) {
		this.numeroTel = numeroTel;
	}
	   
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Societa other = (Societa) obj;
		return Objects.equals(id, other.id);
	}
}
