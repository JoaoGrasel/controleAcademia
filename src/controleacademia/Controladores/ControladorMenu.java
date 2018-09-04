/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleacademia.Controladores;

import controleacademia.Telas.TelaMenuAdmin;
import controleacademia.Telas.TelaMenuComum;

/**
 *
 * @author thiagobrezinski
 */
public class ControladorMenu {
	
	public static ControladorMenu controladorMenu;
	private TelaMenuAdmin telaMenuAdmin;
	private TelaMenuComum telaMenuComum;
	
	private ControladorMenu() {
		this.telaMenuAdmin = new TelaMenuAdmin();
		this.telaMenuComum = new TelaMenuComum();
	}
	
	public static ControladorMenu getInstance() {
        if (controladorMenu == null) {
            controladorMenu = new ControladorMenu();
        }
        return controladorMenu;
    }
	
	public void exibirMenuComum() {
		this.telaMenuComum.exibir();
	}
	
	public void exibirMenuAdmin() {
		this.telaMenuAdmin.exibir();
	}
	
}
