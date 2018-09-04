/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadorcadastro;

import controleacademia.Modelos.Aluno;
import gerenciadorpersistencia.GerenciadorPersistencia;
import validadoratributos.ValidadorAtributos;
import controleacademia.Modelos.Cargo;
import controleacademia.Modelos.Exercicio;
import controleacademia.Modelos.Funcionario;
import controleacademia.Modelos.Treino;
import java.util.ArrayList;

/**
 *
 * @author thiagobrezinski
 */
public class GerenciadorCadastro {
	
	public static GerenciadorCadastro gerenciadorCadastro;
	
	public static GerenciadorCadastro getInstance() {
        if (gerenciadorCadastro == null) {
            gerenciadorCadastro = new GerenciadorCadastro();
        }
        return gerenciadorCadastro;
    }
	
	public Funcionario cadastraFuncionario(
		String nome,
		String cpf,
		String rg,
		String dataNascimento,
		String telefone,
		String endereco,
		String login,
		String senha,
		Cargo cargo
	) throws Exception {
		ValidadorAtributos.getInstance().validaNome(nome);
		ValidadorAtributos.getInstance().validaCpf(cpf);
		ValidadorAtributos.getInstance().validaRg(rg);
		ValidadorAtributos.getInstance().validaDataNascimento(dataNascimento);
		ValidadorAtributos.getInstance().validaTelefone(telefone);
		ValidadorAtributos.getInstance().validaEndereco(endereco);
		ValidadorAtributos.getInstance().validaLogin(login);
		ValidadorAtributos.getInstance().validaSenha(senha);
		
		Funcionario funcionario = new Funcionario(
				nome,
				cpf,
				rg,
				dataNascimento,
				telefone,
				endereco,
				login,
				senha,
				cargo
		);
		
		GerenciadorPersistencia.getInstance().put(funcionario);
		return funcionario;
	}
	
//	public Funcionario editaFuncionario(int index) {
//		if(index != -1) {
//			
//		} else {
//			//TODO CHAMAR MODAL ERRO
//		}
//	}
	
	public void removeFuncionario(int index) {
		if(index != -1) {
			
		} else {
			//TODO CHAMAR MODAL ERRO
		}
	}
	
	public Aluno cadastraAluno(
		String nome,
		String cpf,
		String rg,
		String dataNascimento,
		String telefone,
		String endereco,
		Treino treino
	) throws Exception {
		ValidadorAtributos.getInstance().validaNome(nome);
		ValidadorAtributos.getInstance().validaCpf(cpf);
		ValidadorAtributos.getInstance().validaRg(rg);
		ValidadorAtributos.getInstance().validaDataNascimento(dataNascimento);
		ValidadorAtributos.getInstance().validaTelefone(telefone);
		ValidadorAtributos.getInstance().validaEndereco(endereco);
		
		Aluno aluno = new Aluno(
				nome,
				cpf,
				rg,
				dataNascimento,
				telefone,
				endereco,
				treino
		);
		
		GerenciadorPersistencia.getInstance().put(aluno);
		return aluno;	
	}
	
//	public Aluno editaAluno(int index) {
//		if(index != -1) {
//			
//		} else {
//			//TODO CHAMAR MODAL ERRO
//		}
//	}
	
	public void removeAluno(int index) {
		if(index != -1) {
			
		} else {
			//TODO CHAMAR MODAL ERRO
		}
	}
	
	public Treino cadastraTreino(ArrayList<Exercicio> exercicios) {
		Treino treino = new Treino(exercicios);
		return treino;
	};
	
//	public Treino editaTreino(int index) {
//		if(index != -1) {
//			
//		} else {
////			TODO CHAMAR MODAL ERRO
//		}
//	}
	
	public void removeTreino(int index) {
		if(index != -1) {
			
		} else {
//			TODO CHAMAR MODAL ERRO
		}
	}
	
}
