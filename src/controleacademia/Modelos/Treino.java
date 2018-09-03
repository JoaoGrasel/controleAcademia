/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleacademia.Modelos;

import java.util.Collection;
import java.util.HashSet;

/**
 *
 * @author vladimir
 */
public class Treino {

    private Collection<Exercicio> exercicios;

    public Treino() {
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

}