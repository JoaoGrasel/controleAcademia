/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleacademia.Controladores;

import controleacademia.Telas.TelaMenu;

/**
 *
 * @author thiagobrezinski
 */
public class ControladorMenu {
	
	public static ControladorMenu controladorMenu;
	public TelaMenu telaMenu;
	
	private ControladorMenu() {
		this.telaMenu = new TelaMenu();
	}
	
	public static ControladorMenu getInstance() {
        if (controladorMenu == null) {
            controladorMenu = new ControladorMenu();
        }
        return controladorMenu;
    }
	
	public void exibir() {
		this.telaMenu.exibir();
	}
	
}
