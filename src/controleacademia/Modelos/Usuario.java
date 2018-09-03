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
public abstract class Usuario implements Serializable, ISerializavel {

	private static final long serialVersionUID = 1L;
	private UUID id;
    private String nome;
    private int cpf;
    private int rg;
    private String dataNascimento;
    private String telefone;
    private String endereco;

    public Usuario(String nome, int cpf, int rg, String dataNascimento, String telefone, String endereco) {
		this.id = UUID.randomUUID();
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public String getNome() {
        return this.nome;
    }

    public int getCpf() {
        return this.cpf;
    }

    public int getRg() {
        return this.rg;
    }

    public String getDataNascimento() {
        return this.dataNascimento;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public void setRg(int rg) {
        this.rg = rg;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

	@Override
	public UUID getId() {
		return this.id;
	}

}
