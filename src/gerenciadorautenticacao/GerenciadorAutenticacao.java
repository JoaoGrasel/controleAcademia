/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadorautenticacao;

import controleacademia.Excecoes.LoginInvalidoException;
import controleacademia.Modelos.Funcionario;
import gerenciadorpersistencia.GerenciadorPersistencia;

/**
 *
 * @author thiagobrezinski
 */
public class GerenciadorAutenticacao {
	
	private static GerenciadorAutenticacao gerenciadorAutenticacao;
	
	public static GerenciadorAutenticacao getInstance() {
        if (gerenciadorAutenticacao == null) {
            gerenciadorAutenticacao = new GerenciadorAutenticacao();
        }
        return gerenciadorAutenticacao;
    }
	
	public Funcionario autentica(String login, String senha) throws Exception {
		for(Funcionario funcionario : GerenciadorPersistencia.getInstance().getFuncionarios()) {
			if(funcionario.getLogin().equals(login) && funcionario.getSenha().equals(senha)) {
				return funcionario;
			}
		}
		throw new LoginInvalidoException();
	}
	
}
