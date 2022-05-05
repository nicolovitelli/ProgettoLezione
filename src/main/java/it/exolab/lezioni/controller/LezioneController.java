package it.exolab.lezioni.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.exolab.lezioni.exception.GeneralError;
import it.exolab.lezioni.exception.LunghezzaNonValida;
import it.exolab.lezioni.model.Lezione;
import it.exolab.lezioni.service.LezioneService;

public class LezioneController {

	private LezioneService lezioneService = new LezioneService();
	private final String elenco_lezioni = "elenco-lezioni.jsp";
	private final String lezione_form = "lezione-form.jsp";
	private final String elenco = "elenco";

	public void formCrea(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher(lezione_form);
		dispatcher.forward(request, response);

	}

	public void insert(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String data = request.getParameter("data");
		String argomento = request.getParameter("argomento");
		String descrizione = request.getParameter("descrizione");
		Lezione l = new Lezione(data, argomento, descrizione);
		try {
			lezioneService.insert(l);
		} catch (GeneralError e) {
			e.printStackTrace();
		} catch (LunghezzaNonValida e) {
			e.printStackTrace();
		}
		response.sendRedirect(elenco);

	}

	public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		lezioneService.delete(id);
		response.sendRedirect(elenco);

	}

	public void formModifica(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		Lezione l = lezioneService.findById(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher(lezione_form);
		request.setAttribute("lezione", l);
		dispatcher.forward(request, response);

	}

	public void update(HttpServletRequest request, HttpServletResponse response) throws IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		String data = request.getParameter("data");
		String argomento = request.getParameter("argomento");
		String descrizione = request.getParameter("descrizione");
		Lezione l = new Lezione(id, data, argomento, descrizione);
		try {
			lezioneService.update(l);
		} catch (GeneralError e) {
			e.printStackTrace();
		} catch (LunghezzaNonValida e) {
			e.printStackTrace();
		}
		response.sendRedirect(elenco);

	}

	public void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Lezione> lezioni = lezioneService.findAll();
		request.setAttribute("lezioni", lezioni);
		RequestDispatcher dispatcher = request.getRequestDispatcher(elenco_lezioni);
		dispatcher.forward(request, response);

	}

	public void findByArgomento(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String argomento = request.getParameter("argomento");
		List<Lezione> lezioni = lezioneService.findByArgomento(argomento);
		request.setAttribute("lezioni", lezioni);
		RequestDispatcher dispatcher = request.getRequestDispatcher(elenco_lezioni);
		dispatcher.forward(request, response);

	}

	public void findByData(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String data = request.getParameter("data");
		data = data.substring(8, 10) + "/" + data.substring(5, 7) + "/" + data.substring(0, 4);
		List<Lezione> lezioni = lezioneService.findByData(data);
		request.setAttribute("lezioni", lezioni);
		RequestDispatcher dispatcher = request.getRequestDispatcher(elenco_lezioni);
		dispatcher.forward(request, response);

	}

}
