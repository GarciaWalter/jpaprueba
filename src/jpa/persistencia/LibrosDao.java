/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.persistencia;

import jpa.entidades.Libros;

/**
 *
 * @author Walter Garcia
 */
public class LibrosDao extends Dao {

    public void crear(Libros libro) throws Exception {
        try {
            lb.getTransaction().begin();
            lb.persist(libro);
            lb.getTransaction().commit();
        } catch (Exception e) {
            try {
                lb.getTransaction().rollback();

            } catch (Exception ex) {
                throw new Exception("Error haciendo un Rollback");
            }
            throw new Exception("Error al persitir una persona");
        }

    }

    public void modificar(Libros libro) throws Exception {
        try {
            lb.getTransaction().begin();
            lb.merge(libro);
            lb.getTransaction().commit();
        } catch (Exception e) {
            throw new Exception("Error al modificar una persona");
        }
    }

    public void eliminar(Libros libro) throws Exception {
        try {
            lb.getTransaction().begin();
            lb.remove(libro);
            lb.getTransaction().commit();
        } catch (Exception e) {
            throw new Exception("Error al eliminar una persona");
        }
    }

    public Libros buscarPorId(Integer id) {
        return lb.find(Libros.class, id);
    }

}
