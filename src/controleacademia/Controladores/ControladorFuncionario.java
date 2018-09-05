/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleacademia.Controladores;

import controleacademia.Modelos.Cargo;
import gerenciadorpersistencia.GerenciadorPersistencia;
import gerenciadorcadastro.GerenciadorCadastro;
import controleacademia.Modelos.Funcionario;
import controleacademia.Telas.TelaCriarFuncionario;
import controleacademia.Telas.TelaGerenciadorFuncionarios;
import java.util.ArrayList;

/**
 *
 * @author thiagobrezinski
 */
public class ControladorFuncionario {

    public static ControladorFuncionario controladorFuncionario;
    private TelaGerenciadorFuncionarios telaGerenciadorFuncionarios;
    private TelaCriarFuncionario telaCriarFuncionario;
    
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

	public ArrayList<Funcionario> getFuncionarios() {
		return GerenciadorPersistencia.getInstance().getFuncionarios();
	}
	
	public ArrayList<Cargo> getCargos() {
		return GerenciadorPersistencia.getInstance().getCargos();
	}	
	
	public void cadastrarFuncionario(
			String nome,
			String cpf,
			String rg,
			String dataNascimento,
			String telefone,
			String endereco,
			String login,
			String senha,
			Cargo cargo
	) {
		try {
			GerenciadorCadastro.getInstance().cadastraFuncionario(
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
		} catch(Exception ex) {
			telaCriarFuncionario.exibeErro(ex.getMessage());
		}
	}
	
	public void removeFuncionario(int index) {
		if(index != -1) {
//			getFuncionarios()
		} else {
			//TODO CHAMAR MODAL ERRO
		}
	}
	
	public void updateTableData() {
		this.telaGerenciadorFuncionarios.updateData();
	}
	
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
}
