/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author George
 */
public class JPAUtil {
    public static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("Projeto_simuladoPU");
}
