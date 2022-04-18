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
public class Allievo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long numMatricola;
	   
	private String nome;
	private String cognome;
	private LocalDate dataNascita;
	private String luogoNascita;
	private String email;
	
	/*
	 * Lazy, non per forza se accediamo a uno studente vogliamo conoscere anche la relativa società.
	 * Nessuna modalità di cascade, altrimenti le operazioni svolte sugli allievi si ripercuoterebbero anche s
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	private Societa societa;
	
	/*
	 *Lazy, non per forza se accediamo a uno studente vogliamo conoscere anche i relativi corsi.
	 * Nessuna modalità di cascade, altrimenti le operazioni svolte sugli allievi si ripercuoterebbero anche sui corsi.
	 * */
	@ManyToMany
	private List<Corso> corsi;
	
	public Allievo (String nome, String cognome, LocalDate dataNascita, String luogoNascita, String email,
			Societa societa, List<Corso> corsi){
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.luogoNascita = luogoNascita;
		this.email = email;
		this.societa = societa;
		this.corsi = corsi;
	}
	public Long getNumMatricola() {
		return numMatricola;
	}
	public void setNumMatricola(Long numMatricola) {
		this.numMatricola = numMatricola;
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
	public LocalDate getData() {
		return dataNascita;
	}
	public void setData(LocalDate dataNascita) {
		this.dataNascita = dataNascita;
	}
	public String getLuogoNascita() {
		return luogoNascita;
	}
	public void setLuogoNascita(String luogoNascita) {
		this.luogoNascita = luogoNascita;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(numMatricola);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Allievo other = (Allievo) obj;
		
		return Objects.equals(numMatricola, other.numMatricola);
	}

}
