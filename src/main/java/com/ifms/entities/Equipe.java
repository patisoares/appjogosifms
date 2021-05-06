package com.ifms.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_equipe")
public class Equipe implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome_time")
	private String nomeTime;
	
	@ManyToOne
	@JoinColumn(name = "id_tecnico_fk")
	private Tecnico tecnico;
	
	@ManyToOne
	@JoinColumn(name = "escola_id")
	private Escola escola;
		
	
	@ManyToOne
	@JoinColumn(name = "modalidade_id")
	private Modalidade modalidade;
	
	@ManyToMany
	@JoinTable(name = "tb_equipe_atleta", 
		joinColumns = @JoinColumn(name= "equipe_id"),
		inverseJoinColumns = @JoinColumn(name= "atleta_id"))
	
	Set<Atleta> atletas = new HashSet<>(); 
	// Set - implementa o conceito de conjunto que não aceita repetições
	// Set - Interface(não tem implementação)
	// HashSet - implementa o Set
	//ATENÇÃ
	// ... não adicionar a lista no construtor
	// ... não adicionar o Setter, apenas o Getter para lista, pois queremos
	// ... manipular a lista e não trocar

}
