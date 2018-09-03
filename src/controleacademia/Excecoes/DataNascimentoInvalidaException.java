/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleacademia.Excecoes;

/**
 *
 * @author thiagobrezinski
 */
public class DataNascimentoInvalidaException extends Exception {
	
	public DataNascimentoInvalidaException() {
		super("Data de nascimento inválida!");
	}
	
}
