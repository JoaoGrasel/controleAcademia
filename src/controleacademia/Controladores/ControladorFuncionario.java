/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleacademia.Controladores;

import controleacademia.Modelos.Cargo;
import controleacademia.Telas.TelaCriarFuncionario;
import controleacademia.Telas.TelaGerenciadorFuncionarios;

/**
 *
 * @author thiagobrezinski
 */
public class ControladorFuncionario {

    public static ControladorFuncionario controladorFuncionario;
    public TelaGerenciadorFuncionarios telaGerenciadorFuncionarios;
    public TelaCriarFuncionario telaCriarFuncionario;

    private ControladorFuncionario() {
        this.telaGerenciadorFuncionarios = new TelaGerenciadorFuncionarios();
        this.telaCriarFuncionario = new TelaCriarFuncionario();
    }

    public static ControladorFuncionario getInstance() {
        if (controladorFuncionario == null) {
            controladorFuncionario = new ControladorFuncionario();
        }
        return controladorFuncionario;
    }

    // ============= EXIBICAO DE TELAS =============
    public void exibirMenu() {
        this.telaGerenciadorFuncionarios.exibir();
    }

    public void voltarMenuPrincipal() {
        this.telaGerenciadorFuncionarios.voltar();
    }

    public void voltarMenuFuncionario() {
        this.telaCriarFuncionario.voltar();
    }

    public void exibirCriarFuncionario() {
        this.telaCriarFuncionario.exibir();
    }
    // ============= CADASTRO =============

    public boolean cadastraFuncionario(String nome, int cpf, int rg, String dataNascimento, String telefone, String endereco, String login, String senha,
            Cargo cargo) {
        //if cpfEhValido(cpf);
        //if rgEhValido(rg);
        return true;

    }
}
