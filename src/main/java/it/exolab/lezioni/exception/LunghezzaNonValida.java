package it.exolab.lezioni.exception;

public class LunghezzaNonValida extends Exception {
	String campo;

	public LunghezzaNonValida(String campo) {
		this.campo = campo;
	}

	@Override
	public String getMessage() {
		return "Il campo " + campo + " ha una lunghezza non valida";
	}
}