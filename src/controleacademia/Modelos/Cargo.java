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
public class Cargo implements Serializable, ISerializavel {

	private static final long serialVersionUID = 1L;
	private UUID id;
    private String nome;
    private float salario;
    private boolean admin;

    public Cargo(String nome, float salario, boolean admin) {
		this.id = UUID.randomUUID();
        this.nome = nome;
        this.salario = salario;
        this.admin = admin;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

	@Override
	public UUID getId() {
		return this.id;
	}
}
