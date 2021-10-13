package jpa.persistencia;

import jpa.entidades.Editorial;

/**
 *
 * @author Walter Garcia 
 */
public class EditorialDao extends Dao {
      public void crear(Editorial editorial) throws Exception {
        try {
            lb.getTransaction().begin();
            lb.persist(editorial);
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

    public void modificar(Editorial editorial) throws Exception {
        try {
            lb.getTransaction().begin();
            lb.merge(editorial);
            lb.getTransaction().commit();
        } catch (Exception e) {
            throw new Exception("Error al modificar una persona");
        }
    }

    public void eliminar(Editorial editorial) throws Exception {
        try {
            lb.getTransaction().begin();
            lb.remove(editorial);
            lb.getTransaction().commit();
        } catch (Exception e) {
            throw new Exception("Error al eliminar una persona");
        }
    }

    public Editorial buscarPorId(Integer id) {
        return lb.find(Editorial.class, id);
    }

}
