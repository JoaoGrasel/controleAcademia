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
public class SenhaMuitoPequenaException extends Exception {
	
	public SenhaMuitoPequenaException() {
		super("Senha muito pequena!");
	}
	
}
