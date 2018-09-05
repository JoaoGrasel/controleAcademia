/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validadoratributos;

import controleacademia.Excecoes.CpfInvalidoException;
import controleacademia.Excecoes.DataNascimentoInvalidaException;
import controleacademia.Excecoes.EnderecoInvalidoException;
import controleacademia.Excecoes.LoginInvalidoException;
import controleacademia.Excecoes.NomeInvalidoException;
import controleacademia.Excecoes.RgInvalidoException;
import controleacademia.Excecoes.SenhaInvalidaException;
import controleacademia.Excecoes.TelefoneInvalidoException;

/**
 *
 * @author thiagobrezinski
 */
public class ValidadorAtributos {
	
	public static ValidadorAtributos validadorAtributos;
	
	public static ValidadorAtributos getInstance() {
        if (validadorAtributos == null) {
            validadorAtributos = new ValidadorAtributos();
        }
        return validadorAtributos;
    }
	
	public void validaNome(String nome) throws Exception {
		if (nome.length() > 2) {
            for (int i = 0; i < nome.length(); i++) {
                char letraAnalisada = nome.charAt(i);
                if (!Character.isLetter(letraAnalisada)) {
                    if (!Character.isSpace(letraAnalisada)) {
                        throw new NomeInvalidoException();
                    }
                }
            }
        } else {
            throw new NomeInvalidoException();
        }
	}
	
	public void validaCpf(String cpf) throws Exception {
		if (cpf.length() == 11) {
            for (int i = 0; i < cpf.length(); i++) {
                char charAnalisado = cpf.charAt(i);
                if (Character.isLetter(charAnalisado) || Character.isSpace(charAnalisado)) {
					throw new CpfInvalidoException();
                }
            }
        } else {
            throw new CpfInvalidoException();
        }
	}
	
	public void validaRg(String rg) throws Exception {
		if (rg.length() == 7) {
            for (int i = 0; i < rg.length(); i++) {
                char charAnalisado = rg.charAt(i);
                if (Character.isLetter(charAnalisado) || Character.isSpace(charAnalisado)) {
					throw new RgInvalidoException();
                }
            }
        } else {
            throw new RgInvalidoException();
        }
	}
	
	public void validaDataNascimento(String dataNascimento) throws Exception {
		if (dataNascimento.length() == 8) {
            for (int i = 0; i < dataNascimento.length(); i++) {
                char charAnalisado = dataNascimento.charAt(i);
                if (Character.isLetter(charAnalisado) || Character.isSpace(charAnalisado)) {
					throw new DataNascimentoInvalidaException();
                }
            }
        } else {
            throw new DataNascimentoInvalidaException();
        }
	}
	
	public void validaTelefone(String telefone) throws Exception {
		if (telefone.length() == 8 || telefone.length() == 9) {
            for (int i = 0; i < telefone.length(); i++) {
                char charAnalisado = telefone.charAt(i);
                if (Character.isLetter(charAnalisado) || Character.isSpace(charAnalisado)) {
					throw new TelefoneInvalidoException();
                }
            }
        } else {
            throw new TelefoneInvalidoException();
        }
	}	
	
	public void validaEndereco(String endereco) throws Exception {
		if(endereco.length() < 3) throw new EnderecoInvalidoException();
	}
	
	public void validaLogin(String login) throws Exception {
		if(login.length() < 3) throw new LoginInvalidoException();
	}
	
	public void validaSenha(String senha) throws Exception {
		if(senha.length() < 3) throw new SenhaInvalidaException();
	}
	
}
