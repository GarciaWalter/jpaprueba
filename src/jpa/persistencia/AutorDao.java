package jpa.persistencia;

import jpa.entidades.Autor;

/**
 *
 * @author Walter Garcia 
 */
public class AutorDao extends Dao {
      public void crear(Autor autor) throws Exception {
        try {
            lb.getTransaction().begin();
            lb.persist(autor);
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

    public void modificar(Autor autor) throws Exception {
        try {
            lb.getTransaction().begin();
            lb.merge(autor);
            lb.getTransaction().commit();
        } catch (Exception e) {
            throw new Exception("Error al modificar una persona");
        }
    }

    public void eliminar(Autor autor) throws Exception {
        try {
            lb.getTransaction().begin();
            lb.remove(autor);
            lb.getTransaction().commit();
        } catch (Exception e) {
            throw new Exception("Error al eliminar una persona");
        }
    }

    public Autor buscarPorId(Integer id) {
        return lb.find(Autor.class, id);
    }

}
