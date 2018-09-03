/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleacademia.Controladores;

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
        telaLogin.exibir();
    }
	
	public void login() {
		ControladorMenu.getInstance().exibir();
	}
}
