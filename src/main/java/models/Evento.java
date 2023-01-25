package models;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name = "eventi")
@Getter
@Setter
@ToString
public class Evento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String titolo;
	private LocalDate dataEvento;
	private String descrizione;
	
	@Enumerated(EnumType.STRING)
	private TipoEvento tipoEvento;
	
	private int numeroMassimoPartecipanti;
	
	@OneToMany(mappedBy = "evento")
	private Set<Partecipazione> setPartecipazioni;
	
	@ManyToOne
	private Location location;
	
}
