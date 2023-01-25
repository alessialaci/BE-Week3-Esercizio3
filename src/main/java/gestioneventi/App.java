package gestioneventi;

import java.time.LocalDate;

import dao.EventoDAO;
import dao.LocationDAO;
import dao.PartecipazioneDAO;
import dao.PersonaDAO;
import models.Evento;
import models.Location;
import models.Partecipazione;
import models.Persona;
import models.Sesso;
import models.Stato;
import models.TipoEvento;

public class App {

	public static void main(String[] args) {
		Location location = saveLocation();
		Evento evento = saveEvento(location);
		Persona persona = savePersona();
		Partecipazione partecipazione = savePartecipazione(evento, persona);
	}

	private static Location saveLocation() {
		Location location = new Location();
		location.setNome("Masseria Torrepietra");
		location.setCitta("Monopoli");
		
		LocationDAO locationDao = new LocationDAO();
		locationDao.save(location);
		return location;
	}
	
	private static Evento saveEvento(Location location) {
		Evento evento = new Evento();
		evento.setTitolo("Festa di fine corso");
		evento.setDataEvento(LocalDate.parse("2023-04-09"));
		evento.setDescrizione("Siete invitati alla mia festa di fine corso");
		evento.setTipoEvento(TipoEvento.PRIVATO);
		evento.setNumeroMassimoPartecipanti(40);
		evento.setLocation(location);
		
		EventoDAO eventoDao = new EventoDAO();
		eventoDao.save(evento);
		return evento;
	}
	
	private static Persona savePersona() {
		Persona persona = new Persona();
		persona.setNome("Alessia");
		persona.setCognome("Lacitignola");
		persona.setEmail("alessia@mail.com");
		persona.setDatadinascita(LocalDate.parse("1998-04-21"));
		persona.setSesso(Sesso.FEMMINA);
		
		PersonaDAO personaDao = new PersonaDAO();
		personaDao.save(persona);		
		return persona;
	}
	
	private static Partecipazione savePartecipazione(Evento evento, Persona persona) {
		Partecipazione partecipazione = new Partecipazione();
		partecipazione.setPersona(persona);
		partecipazione.setEvento(evento);
		partecipazione.setStato(Stato.CONFERMATA);
		
		PartecipazioneDAO partecipazioneDao = new PartecipazioneDAO();
		partecipazioneDao.save(partecipazione);
		return partecipazione;
	}

}
