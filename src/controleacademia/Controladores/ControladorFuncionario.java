/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleacademia.Controladores;

import controleacademia.Modelos.Cargo;
import controleacademia.Telas.TelaCriarFuncionario;
import controleacademia.Telas.TelaEditarFuncionario;
import controleacademia.Telas.TelaGerenciadorFuncionarios;

/**
 *
 * @author thiagobrezinski
 */
public class ControladorFuncionario {

    public static ControladorFuncionario controladorFuncionario;
    private TelaGerenciadorFuncionarios telaGerenciadorFuncionarios;
    private TelaCriarFuncionario telaCriarFuncionario;
    private TelaEditarFuncionario telaEditarFuncionario;

    private ControladorFuncionario() {
        this.telaGerenciadorFuncionarios = new TelaGerenciadorFuncionarios();
        this.telaCriarFuncionario = new TelaCriarFuncionario();
        this.telaEditarFuncionario = new TelaEditarFuncionario();
    }

    public static ControladorFuncionario getInstance() {
        if (controladorFuncionario == null) {
            controladorFuncionario = new ControladorFuncionario();
        }
        return controladorFuncionario;
    }

    public void exibirMenu() {
        this.telaGerenciadorFuncionarios.exibir();
    }

    public void voltarMenuPrincipal() {
        this.telaGerenciadorFuncionarios.voltar();
        ControladorMenu.getInstance().exibir();
    }

     public void voltarMenuFuncionario() {
        this.telaCriarFuncionario.voltar();
    }

    public void exibirCriarFuncionario() {
        this.telaCriarFuncionario.exibir();
    }
    
    public void exibirEditarFuncionario(){
        this.telaEditarFuncionario.exibir();
    }
}
