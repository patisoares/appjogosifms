package com.ifms.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_tecnico")
public class Tecnico extends Pessoa<Long> {
private static final long serialVersionUID = 1L;
	
	private boolean arbitro;
	
	@OneToMany(mappedBy = "tecnico")
	private List<Equipe> equipes;

	public boolean isArbitro() {
		return arbitro;
	}

	public void setArbitro(boolean arbitro) {
		this.arbitro = arbitro;
	}
	
}
