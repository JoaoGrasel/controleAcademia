/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleacademia.Modelos;

import controleacademia.Interfaces.ISerializavel;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.UUID;

/**
 *
 * @author vladimir
 */
public class Treino implements Serializable, ISerializavel {

	private static final long serialVersionUID = 1L;
	private UUID id;
    private Collection<Exercicio> exercicios;

    public Treino() {
		this.id = UUID.randomUUID();
        this.exercicios = new HashSet<Exercicio>();
    }

    public Collection<Exercicio> getExercicios() {
        return exercicios;
    }

    public boolean add(Exercicio exercicio) {
        return this.exercicios.add(exercicio);
    }

    public boolean remove(Exercicio exercicio) {
        return this.exercicios.remove(exercicio);
    }

    public boolean estaVazio() {
        return this.exercicios.isEmpty();
    }

    public int tamanho() {
        return this.exercicios.size();
    }

	@Override
	public UUID getId() {
		return this.id;
	}

}
