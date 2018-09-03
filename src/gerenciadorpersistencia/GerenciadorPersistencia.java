/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadorpersistencia;

import controleacademia.Interfaces.ISerializavel;
import controleacademia.Modelos.Funcionario;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thiagobrezinski
 */
public class GerenciadorPersistencia {
	
	public static GerenciadorPersistencia gerenciadorPersistencia;
	private HashMap<UUID, ISerializavel> cache = new HashMap<>();
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
	
    public void put(ISerializavel object) {
		cache.put(object.getId(), object);
        persist();
    }
	
    public Object get(UUID id) {
        return cache.get(id);
    }

    public ArrayList<ISerializavel> getList() {
        return new ArrayList<ISerializavel>(cache.values());
    }

    public ArrayList<Funcionario> getFuncionarios() {
        ArrayList<ISerializavel> values = this.getList();
		ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
		for(Object value : values) {
			if(value instanceof Funcionario) funcionarios.add(((Funcionario) value));
		}
		return funcionarios;
    }
	
	public ArrayList<Object> getKeys() {
		return new ArrayList<>(this.cache.keySet());
	}
	
    public void remove(UUID id) {
		cache.remove(id);
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

            cache = (HashMap<UUID, ISerializavel>) oIS.readObject();

            oIS.close();
            fIS.close();

        } catch (FileNotFoundException ex) {
            persist();
        } catch (IOException ex) {
            Logger.getLogger(GerenciadorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
			Logger.getLogger(GerenciadorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
		}
    }
	
}