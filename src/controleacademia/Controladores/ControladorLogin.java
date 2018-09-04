/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleacademia.Controladores;

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
				"123456789",
				"987654321",
				"01/01/1981",
				"999092312",
				"Rua Sem Nome",
				"admin",
				"admin",
				cargoAdmin
		);
	
		Cargo cargoComum = new Cargo("Comum", 1000, false);
		Funcionario comum = new Funcionario(
				"João",
				"123456789",
				"987654321",
				"01/01/1981",
				"999092312",
				"Rua Sem Nome",
				"comum",
				"comum",
				cargoComum
		);
		
		GerenciadorPersistencia.getInstance().put(cargoAdmin);
		GerenciadorPersistencia.getInstance().put(admin);
		
		GerenciadorPersistencia.getInstance().put(cargoComum);
		GerenciadorPersistencia.getInstance().put(comum);
		
        telaLogin.exibir();
    }
	
	public void login(String login, String senha) {
		try {
			Funcionario funcionario = GerenciadorAutenticacao.getInstance().autentica(login, senha);
			telaLogin.ocultar();
			
			if(funcionario.getCargo().isAdmin()) {
				ControladorMenu.getInstance().exibirMenuAdmin();
			} else {
				ControladorMenu.getInstance().exibirMenuComum();
			}
		} catch(Exception ex) {
			telaLogin.exibeErroLogin();
		}
	}
}
