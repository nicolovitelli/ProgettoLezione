package it.exolab.lezioni.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.exolab.lezioni.exception.GeneralError;
import it.exolab.lezioni.exception.LunghezzaNonValida;
import it.exolab.lezioni.model.Lezione;

public class LezioneService extends ConnessioneDB {

	public void insert(Lezione l) throws GeneralError, LunghezzaNonValida {

		validaData(l.getData());
		validaArgomento(l.getArgomento());
		
		String sql = "INSERT INTO lezione (data, argomento, descrizione) VALUES (?, ?, ?)";

		try {
			PreparedStatement ps = connect().prepareStatement(sql);
			ps.setString(1, l.getData());
			ps.setString(2, l.getArgomento());
			ps.setString(3, l.getDescrizione());
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connect().close();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public boolean update(Lezione l) throws GeneralError, LunghezzaNonValida {

		validaData(l.getData());
		validaArgomento(l.getArgomento());
		
		boolean righeAggiornate = false;
		String sql = "UPDATE lezione SET data = ?, argomento = ?, descrizione = ? WHERE id = ?";

		try {
			PreparedStatement ps = connect().prepareStatement(sql);
			ps.setString(1, l.getData());
			ps.setString(2, l.getArgomento());
			ps.setString(3, l.getDescrizione());
			ps.setInt(4, l.getId());
			// se aggiorna almeno 1 riga, righeAggiornate vale true
			righeAggiornate = ps.executeUpdate() > 0;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} 

		return righeAggiornate;

	}

	public Lezione findById(int id) {

		Lezione l = null;
		String sql = "SELECT * FROM lezione WHERE id = ?";

		try {
			PreparedStatement ps = connect().prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				l = new Lezione(rs.getInt("id"), rs.getString("data"), rs.getString("argomento"),
						rs.getString("descrizione"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} 

		return l;

	}

	public List<Lezione> findAll() {

		List<Lezione> lezioni = new ArrayList<Lezione>();
		String sql = "SELECT * FROM lezione";

		try {
			Statement st = connect().createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				lezioni.add(new Lezione(rs.getInt("id"), rs.getString("data"), rs.getString("argomento"),
						rs.getString("descrizione")));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lezioni;

	}

	public List<Lezione> findByArgomento(String argomento) {

		try {
			validaArgomento(argomento);
		} catch (GeneralError e1) {
			e1.printStackTrace();
		}
		
		List<Lezione> lezioni = new ArrayList<Lezione>();
		String sql = "SELECT * FROM lezione WHERE argomento LIKE ?";

		try {
			PreparedStatement ps = connect().prepareStatement(sql);
			ps.setString(1, argomento);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				lezioni.add(new Lezione(rs.getInt("id"), rs.getString("data"), rs.getString("argomento"),
						rs.getString("descrizione")));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} 

		return lezioni;

	}

	public List<Lezione> findByData(String data) {

		try {
			validaData(data);
		} catch (LunghezzaNonValida e1) {
			e1.printStackTrace();
		}
		
		List<Lezione> lezioni = new ArrayList<Lezione>();
		String sql = "SELECT * FROM lezione WHERE data LIKE ?";

		try {
			PreparedStatement ps = connect().prepareStatement(sql);
			ps.setString(1, data);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				lezioni.add(new Lezione(rs.getInt("id"), rs.getString("data"), rs.getString("argomento"),
						rs.getString("descrizione")));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} 

		return lezioni;

	}

	public boolean delete(int id) {

		boolean righeEliminate = false;
		String sql = "DELETE FROM lezione WHERE ID = ?";

		try {
			PreparedStatement ps = connect().prepareStatement(sql);
			ps.setInt(1, id);
			// se elimina almeno 1 riga, righeEliminate vale true
			righeEliminate = ps.executeUpdate() > 0;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} 

		return righeEliminate;

	}

	private void validaData(String data) throws LunghezzaNonValida {

		if (data.length() != 10) {

			throw new LunghezzaNonValida("data");
		}
	}
	
	private void validaArgomento(String argomento) throws GeneralError {
		
		if (argomento == null || argomento.length() > 255) {
			
			throw new GeneralError();
			
		}
		
	}
	
	
}
