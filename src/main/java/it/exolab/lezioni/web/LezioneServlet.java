package it.exolab.lezioni.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.exolab.lezioni.controller.LezioneController;
import it.exolab.lezioni.exception.GeneralError;
import it.exolab.lezioni.exception.LunghezzaNonValida;

/**
 * Servlet implementation class LezioneServlet
 */
@WebServlet("/")
public class LezioneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LezioneController lezioneController;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LezioneServlet() {
        super();
        this.lezioneController = new LezioneController();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// ritorna l'URL della servlet
		String azione = request.getServletPath();
		
		switch(azione) {
		case "/nuovaLezione":
			lezioneController.formCrea(request, response);
			break;
		case "/inserisciLezione":
			lezioneController.insert(request, response);
			break;
		case "/eliminaLezione":
			lezioneController.delete(request, response);
			break;
		case "/modificaLezione":
			lezioneController.formModifica(request, response);
			break;
		case "/aggiornaLezione":
			lezioneController.update(request, response);
			break;
		case "/elenco":
			lezioneController.findAll(request, response);
			break;
		case "/cercaPerArgomento":
			lezioneController.findByArgomento(request, response);
			break;
		case "/cercaPerData":
			lezioneController.findByData(request, response);
			break;
		default:
			lezioneController.findAll(request, response);
			break;
		}
		
	}
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
