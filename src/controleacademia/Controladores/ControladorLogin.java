/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleacademia.Controladores;

import controleacademia.Modelos.Cargo;
import controleacademia.Modelos.Exercicio;
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
		persisteFixtures();
        telaLogin.exibir();
    }
	
	private void persisteFixtures() {
		Cargo cargoAdmin = new Cargo("Administrador", 10000, true);
                Cargo cargoRecepcionista = new Cargo("Recepcionista", 2500, false);
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
                Funcionario comum = new Funcionario(
				"Joao",
				"123456789",
				"987654321",
				"01/01/1981",
				"999092312",
				"Rua Sem Nome",
				"comum",
				"comum",
				cargoAdmin
		);
		
		Exercicio exercicio1 = new Exercicio("Remada Alta");
		Exercicio exercicio2 = new Exercicio("Remada Baixa");
		Exercicio exercicio3 = new Exercicio("Supino");
		Exercicio exercicio4 = new Exercicio("Rosca Direta");
		Exercicio exercicio5 = new Exercicio("Rosca Invertida");
		Exercicio exercicio6 = new Exercicio("Tríceps Polia");
		Exercicio exercicio7 = new Exercicio("Tríceps Banco");
		Exercicio exercicio8 = new Exercicio("Rosca Polia");
		Exercicio exercicio9 = new Exercicio("Encolhimento");
		Exercicio exercicio10 = new Exercicio("Crucifixo");
		
		GerenciadorPersistencia.getInstance().put(cargoAdmin);
		GerenciadorPersistencia.getInstance().put(admin);
                GerenciadorPersistencia.getInstance().put(cargoRecepcionista);
                GerenciadorPersistencia.getInstance().put(comum);
		GerenciadorPersistencia.getInstance().put(exercicio1);
		GerenciadorPersistencia.getInstance().put(exercicio2);
		GerenciadorPersistencia.getInstance().put(exercicio3);
		GerenciadorPersistencia.getInstance().put(exercicio4);
		GerenciadorPersistencia.getInstance().put(exercicio5);
		GerenciadorPersistencia.getInstance().put(exercicio6);
		GerenciadorPersistencia.getInstance().put(exercicio7);
		GerenciadorPersistencia.getInstance().put(exercicio8);
		GerenciadorPersistencia.getInstance().put(exercicio9);
		GerenciadorPersistencia.getInstance().put(exercicio10);
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
