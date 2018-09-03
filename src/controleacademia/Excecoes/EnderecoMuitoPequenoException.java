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
public class EnderecoMuitoPequenoException extends Exception {
	
	public EnderecoMuitoPequenoException() {
		super("Endereco muito pequeno!");
	}
	
}
