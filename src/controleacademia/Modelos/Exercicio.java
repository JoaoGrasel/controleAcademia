/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleacademia.Modelos;

import controleacademia.Interfaces.ISerializavel;
import java.io.Serializable;
import java.util.UUID;

/**
 *
 * @author vladimir
 */
public class Exercicio implements Serializable, ISerializavel {

	private static final long serialVersionUID = 1L;
	private UUID id;
    private String nome;

    public Exercicio(String nome) {
		this.id = UUID.randomUUID();
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

	@Override
	public UUID getId() {
		return this.id;
	}

}
