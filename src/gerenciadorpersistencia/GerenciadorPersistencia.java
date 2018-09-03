/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadorpersistencia;

import controleacademia.Modelos.Treino;
import controleacademia.Modelos.Usuario;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thiagobrezinski
 */
public class GerenciadorPersistencia {
	
	public static GerenciadorPersistencia gerenciadorPersistencia;
	private HashMap<Object, Object> cache = new HashMap<>();
    private final String fileName = "cache.batman";
	
    public GerenciadorPersistencia() {
        load();
    }

	public static GerenciadorPersistencia getInstance() {
        if (gerenciadorPersistencia == null) {
            gerenciadorPersistencia = new GerenciadorPersistencia();
        }
        return gerenciadorPersistencia;
    }
	
    public void put(Object object) {
		if(object instanceof Usuario) {
			cache.put(((Usuario) object).getCpf(), object);
		} else {
			cache.put(((Treino) object).getId(), object);	
		}
        persist();
    }
	
    public Object get(Object key) {
        return cache.get(key);
    }

    public ArrayList<Object> getList() {
        return new ArrayList<Object>(cache.values());
    }

	public ArrayList<Object> getKeys() {
		return new ArrayList<>(this.cache.keySet());
	}
	
    public void remove(Object object) {
        if(object instanceof Usuario) {
			cache.remove(((Usuario) object).getCpf());
		} else {
			cache.remove(((Treino) object).getId());	
		}
        persist();
    }

    private void persist() {
        try {
            FileOutputStream fOS = new FileOutputStream(fileName);
            ObjectOutputStream oOS = new ObjectOutputStream(fOS);

            oOS.writeObject(cache);

            oOS.flush();
            fOS.flush();

            oOS.close();
            fOS.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(GerenciadorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GerenciadorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void load() {
        try {
            FileInputStream fIS = new FileInputStream(fileName);
            ObjectInputStream oIS = new ObjectInputStream(fIS);

            cache = (HashMap<Object, Object>) oIS.readObject();

            oIS.close();
            fIS.close();

        } catch (FileNotFoundException ex) {
            persist();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(GerenciadorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
	
}