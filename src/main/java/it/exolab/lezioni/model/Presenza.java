package it.exolab.lezioni.model;

public class Presenza {

	private int id;
	private int id_studente;
	private int id_lezione;
	private int orario_ingresso;
	private int orario_uscita;
	
	public Presenza(int id, int id_studente, int id_lezione, int orario_ingresso, int orario_uscita) {
		super();
		this.id = id;
		this.id_studente = id_studente;
		this.id_lezione = id_lezione;
		this.orario_ingresso = orario_ingresso;
		this.orario_uscita = orario_uscita;
	}
	
	public Presenza () { }
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_studente() {
		return id_studente;
	}
	public void setId_studente(int id_studente) {
		this.id_studente = id_studente;
	}
	public int getId_lezione() {
		return id_lezione;
	}
	public void setId_lezione(int id_lezione) {
		this.id_lezione = id_lezione;
	}
	public int getOrario_ingresso() {
		return orario_ingresso;
	}
	public void setOrario_ingresso(int orario_ingresso) {
		this.orario_ingresso = orario_ingresso;
	}
	public int getOrario_uscita() {
		return orario_uscita;
	}
	public void setOrario_uscita(int orario_uscita) {
		this.orario_uscita = orario_uscita;
	}

	
}
