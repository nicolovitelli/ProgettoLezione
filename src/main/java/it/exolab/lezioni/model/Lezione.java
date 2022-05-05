package it.exolab.lezioni.model;

public class Lezione {

	private int id;
	private String data;
	private String argomento;
	private String descrizione;
	
	public Lezione(int id, String data, String argomento, String descrizione) {
		super();
		this.id = id;
		this.data = data;
		this.argomento = argomento;
		this.descrizione = descrizione;
	}
	
	public Lezione(String data, String argomento, String descrizione) {
		super();
		this.data = data;
		this.argomento = argomento;
		this.descrizione = descrizione;
	}
	
	public Lezione() { }
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getArgomento() {
		return argomento;
	}
	public void setArgomento(String argomento) {
		this.argomento = argomento;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
}
