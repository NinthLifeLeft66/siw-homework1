package it.uniroma3.siw.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Corso {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	   
	private String nome;
	private LocalDate inizio;
	private int durata;
	/*
	 * Lazy, non per forza se accediamo a un corso vogliamo conoscere anche il relativo docente.
	 * Nessuna modalità di cascade, altrimenti le operazioni svolte sui corsi si ripercuoterebbero anche sui docenti.
	 * 
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	private Docente docente;
	
	/*
	 * Lazy, non per forza se accediamo a un corso vogliamo conoscere anche i relativi allievi.
	 * Nessuna modalità di cascade, altrimenti le operazioni svolte sugli corsi si ripercuoterebbero anche sugli allievi.
	 */
	@ManyToMany(mappedBy = "corsi")
	private List<Allievo> allievi;
	
	public Corso(String nome, LocalDate inizio, Integer durataInMesi, List<Allievo> allievi, Docente docente, int durata) {
		this.nome = nome;
		this.inizio = inizio;
		this.durata = durata;
		this.allievi = allievi;
		this.docente = docente;
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
	public LocalDate getInizio() {
		return inizio;
	}
	public void setInizio(LocalDate inizio) {
		this.inizio = inizio;
	}
	public int getDurata() {
		return durata;
	}
	public void setDurata(int durata) {
		this.durata = durata;
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
		Corso other = (Corso) obj;
		return Objects.equals(id, other.id);
	}

}
