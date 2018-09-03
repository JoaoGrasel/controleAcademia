/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleacademia.Controladores;

import controleacademia.Excecoes.LoginInexistenteException;
import controleacademia.Modelos.Cargo;
import controleacademia.Modelos.Funcionario;
import gerenciadorautenticacao.GerenciadorAutenticacao;
import gerenciadorpersistencia.GerenciadorPersistencia;
import controleacademia.Telas.TelaLogin;

/**
 *
 * @author thiagobrezinski
 */
public class ControladorLogin {
	
	public static ControladorLogin controladorLogin;
	public TelaLogin telaLogin;
	
	private ControladorLogin() {
		this.telaLogin = new TelaLogin();
	}
	
	public static ControladorLogin getInstance() {
        if (controladorLogin == null) {
            controladorLogin = new ControladorLogin();
        }
        return controladorLogin;
    }
	
	public void inicia() {
		Cargo cargoAdmin = new Cargo("Administrador", 10000, true);
		Funcionario admin = new Funcionario(
				"Thiago",
				123456789,
				987654321,
				"01/01/1981",
				"999092312",
				"Rua Sem Nome",
				"admin",
				"admin",
				cargoAdmin
		);
	
		GerenciadorPersistencia.getInstance().put(cargoAdmin);
		GerenciadorPersistencia.getInstance().put(admin);
		
        telaLogin.exibir();
    }
	
	public void login(String login, String senha) {
		if(GerenciadorAutenticacao.getInstance().autentica(login, senha)) {
			ControladorMenu.getInstance().exibir();
		} else {
			System.out.println("Login ou senha incorretos!");
			//EXIBIR MODAL DE SENHA LOGIN OU SENHA INCORRETOS ERRADA
		}
	}
}
