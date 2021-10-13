/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.servicios;

import jpa.entidades.Autor;
import jpa.persistencia.AutorDao;

/**
 *
 * @author nancy
 */
public class AutorService {
    AutorDao aut = new AutorDao();
    public Autor crearAutor (Autor a) throws Exception{
        if (a.getId()==null || a.getId()<=0){
            throw new Exception ("Ingresaste un id incorrecto o vacio");
        }
        if (a.getNombre()==null || a.getNombre().isEmpty()){
            throw new Exception( "El nombre ingresado es incorreto o noseencuentra");
        }
        aut.crear(a);
        return null;
    }
    public Autor buscarAutor(Integer id){
        return aut.buscarPorId(id);
    }
    public Autor eliminar(Autor autor){
        return aut.eliminar(autor);
        
    }
    
}
