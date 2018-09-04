/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleacademia.Controladores;

import controleacademia.Telas.TelaCriarAluno;
import controleacademia.Telas.TelaCriarTreino;
import controleacademia.Telas.TelaEditarAluno;
import controleacademia.Telas.TelaEditarTreino;
import controleacademia.Telas.TelaGerenciadorAlunos;
import controleacademia.Telas.TelaGerenciadorTreinos;

/**
 *
 * @author thiagobrezinski
 */
public class ControladorAluno {

    public static ControladorAluno controladorAluno;
    private TelaGerenciadorAlunos telaGerenciadorAlunos;
    private TelaCriarAluno telaCriarAluno;
    private TelaEditarAluno telaEditarAluno;
    private TelaGerenciadorTreinos telaGerenciadorTreinos;
    private TelaCriarTreino telaCriarTreino;
    private TelaEditarTreino telaEditarTreino;
 

    private ControladorAluno() {
        this.telaGerenciadorAlunos = new TelaGerenciadorAlunos();
        this.telaCriarAluno = new TelaCriarAluno();
        this.telaGerenciadorTreinos = new TelaGerenciadorTreinos();
        this.telaCriarTreino = new TelaCriarTreino();
        this.telaEditarAluno = new TelaEditarAluno();
        this.telaEditarTreino = new TelaEditarTreino();
    }

    public static ControladorAluno getInstance() {
        if (controladorAluno == null) {
            controladorAluno = new ControladorAluno();
        }
        return controladorAluno;
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
    
    public void exibeEditarAluno(){
        this.telaEditarAluno.exibir();
    }

    public void exibirGerenciadorTreinos(){
        this.telaGerenciadorTreinos.exibir();
    }
    
    public void exibeCadastrarTreino(){
        this.telaCriarTreino.exibir();
    }
    
    public void exibeEditarTreino(){
        this.telaEditarTreino.exibir();
    }
    
    
}
