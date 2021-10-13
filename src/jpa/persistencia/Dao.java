/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author Walter Garcia
 */
public class Dao {
    protected EntityManager lb = Persistence.createEntityManagerFactory("jpaaPU").createEntityManager();
     
}
