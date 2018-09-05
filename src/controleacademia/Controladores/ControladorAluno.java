/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleacademia.Controladores;

import controleacademia.Modelos.Aluno;
import controleacademia.Modelos.Exercicio;
import controleacademia.Modelos.Treino;
import gerenciadorcadastro.GerenciadorCadastro;
import gerenciadorpersistencia.GerenciadorPersistencia;
import controleacademia.Telas.TelaCriarAluno;
import controleacademia.Telas.TelaCriarTreino;
import controleacademia.Telas.TelaGerenciadorAlunos;
import controleacademia.Telas.TelaSelecionarTreino;
import java.util.ArrayList;

/**
 *
 * @author thiagobrezinski
 */
public class ControladorAluno {

    public static ControladorAluno controladorAluno;
    private TelaGerenciadorAlunos telaGerenciadorAlunos;
    private TelaCriarAluno telaCriarAluno;
    private TelaCriarTreino telaCriarTreino;
    private TelaSelecionarTreino telaSelecionarTreino;
 
    private ControladorAluno() {
        this.telaGerenciadorAlunos = new TelaGerenciadorAlunos();
        this.telaCriarAluno = new TelaCriarAluno();
        this.telaCriarTreino = new TelaCriarTreino();
        this.telaSelecionarTreino = new TelaSelecionarTreino();
    }

    public static ControladorAluno getInstance() {
        if (controladorAluno == null) {
            controladorAluno = new ControladorAluno();
        }
        return controladorAluno;
    }

	public ArrayList<Aluno> getAlunos() {
		return GerenciadorPersistencia.getInstance().getAlunos();
	}

	public ArrayList<Treino> getTreinos() {
		return GerenciadorPersistencia.getInstance().getTreinos();
	}
	
	public ArrayList<Exercicio> getExercicios() {
		return GerenciadorPersistencia.getInstance().getExercicios();
	}	
	
	public void cadastrarAluno(
			String nome,
			String cpf,
			String rg,
			String dataNascimento,
			String telefone,
			String endereco
	) {
		try {
			GerenciadorCadastro.getInstance().cadastraAluno(
					nome,
					cpf,
					rg,
					dataNascimento,
					telefone,
					endereco
			);	
		} catch(Exception ex) {
			telaCriarAluno.exibeErro(ex.getMessage());
		}
	}
	
	public void cadastrarTreino(String nome, ArrayList<Exercicio> exercicios) {
		try {
			GerenciadorCadastro.getInstance().cadastraTreino(nome, exercicios);
		} catch(Exception ex) {
			this.telaCriarTreino.exibeErro(ex.getMessage());
		}
	}
	
	public void updateAlunosTableData() {
		this.telaGerenciadorAlunos.updateData();
	}
//	
//	public void updateTreinosTableData() {
//		this.telaGerenciadorTreinos.updateData();
//	}
//	
        
    public void defineTreino(Aluno aluno, Treino treino) {
        aluno.setTreino(treino);
        GerenciadorPersistencia.getInstance().put(aluno);
        this.telaGerenciadorAlunos.updateData();
    }
        
    public void exibirMenu() {
        this.telaGerenciadorAlunos.exibir();
    }

    public void voltarMenuPrincipal() {
        this.telaGerenciadorAlunos.voltar();
    }

    public void voltarMenuAluno() {
        this.telaCriarAluno.voltar();
    }

    public void exibirCriarAluno() {
        this.telaCriarAluno.exibir();
    }
        
    public void exibeCadastrarTreino(){
        this.telaCriarTreino.exibir();
    }
    
    public void exibeSelecionarTreino(Aluno aluno){
        this.telaSelecionarTreino.exibir(aluno);
    }
}
