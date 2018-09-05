/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleacademia.Modelos;

import controleacademia.Interfaces.ISerializavel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

/**
 *
 * @author vladimir
 */
public class Treino implements Serializable, ISerializavel {

	private static final long serialVersionUID = 1L;
	private UUID id;
	private String nome;
    private ArrayList<Exercicio> exercicios;

    public Treino(String nome, ArrayList<Exercicio> exercicios) {
		this.id = UUID.randomUUID();
		this.nome = nome;
        this.exercicios = new ArrayList<Exercicio>(exercicios);
    }

    public ArrayList<Exercicio> getExercicios() {
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
