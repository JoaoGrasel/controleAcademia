/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleacademia.Controladores;

import controleacademia.Telas.TelaCriarAluno;
import controleacademia.Telas.TelaGerenciadorAlunos;

/**
 *
 * @author thiagobrezinski
 */
public class ControladorAluno {

    public static ControladorAluno controladorAluno;
    public TelaGerenciadorAlunos telaGerenciadorAlunos;
    public TelaCriarAluno telaCriarAluno;

    private ControladorAluno() {
        this.telaGerenciadorAlunos = new TelaGerenciadorAlunos();
        this.telaCriarAluno = new TelaCriarAluno();
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

}
