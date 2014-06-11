/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import modelo.Aluno;
import util.JPAUtil;

/**
 *
 * @author Melkran
 */
public class NewClass {
    public static void main(String[] args) {
        Aluno a = new Aluno();
        AlunoJpaController dao = new AlunoJpaController(JPAUtil.EMF);
        a.setNome("Jaaday");
        a.setSenha("uyuy");
        a.setLogin("admin");
        try {
            dao.create(a);
        } catch (Exception e) {
        }
                
    }
}
