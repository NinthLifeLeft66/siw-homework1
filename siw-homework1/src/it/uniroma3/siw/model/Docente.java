package it.uniroma3.siw.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Docente {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	   
	private String nome;
	private String cognome;
	private LocalDate dataNascita;
	private String partitaIVA;
	
	/*
	 * Lazy, non per forza se accediamo a un docente vogliamo conoscere anche i relativi corsi.
	 * Nessuna modalità di cascade, altrimenti le operazioni svolte sui docenti si ripercuoterebbero anche sui corsi.
	 */
	@OneToMany
	private List<Corso> corsi;
	
	public Docente(String nome, String cognome, LocalDate dataNascita, String partitaIVA, List<Corso> corsi) {
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.partitaIVA = partitaIVA;
		this.corsi = corsi;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public LocalDate getDataNascita() {
		return dataNascita;
	}
	public void setDataNascita(LocalDate dataNascita) {
		this.dataNascita = dataNascita;
	}
	public String getPartitaIVA() {
		return partitaIVA;
	}
	public void setPartitaIVA(String partitaIVA) {
		this.partitaIVA = partitaIVA;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(partitaIVA);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Docente other = (Docente) obj;
		return Objects.equals(partitaIVA, other.partitaIVA);
	}
	   
}
