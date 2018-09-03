/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadorcadastro;

import controleacademia.Modelos.Funcionario;

/**
 *
 * @author thiagobrezinski
 */
public class GerenciadorCadastro {
	
	public static GerenciadorCadastro gerenciadorCadastro;
	
	public static GerenciadorCadastro getInstance() {
        if (gerenciadorCadastro == null) {
            gerenciadorCadastro = new GerenciadorCadastro();
        }
        return gerenciadorCadastro;
    }
	
//	public Funcionario cadastra(Object object) {
//		
//	}
	
}
