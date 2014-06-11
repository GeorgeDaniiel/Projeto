/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.ProfessorJpaController;
import dao.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import modelo.Professor;
import util.JPAUtil;

/**
 *
 * @author George
 */
@ManagedBean(name="professorBean")
@RequestScoped
public class ProfessorBean implements Serializable{
    
    private Professor professor = new Professor();
    ProfessorJpaController professorDAO = new ProfessorJpaController(JPAUtil.EMF);
    private String mensagem;

    public ProfessorBean() {
    }
    
    public void inserir(){
        FacesContext context = FacesContext.getCurrentInstance();
        try{
            
            professorDAO.create(professor);
            professor = new Professor();

        }catch(Exception ex){
            context.addMessage("formProfessor", new FacesMessage("Professor não pode ser inserido"));
           Logger.getLogger(ProfessorBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        context.addMessage("formProfessor", new FacesMessage("Professor foi inserido com sucesso!"));
    }
    
    public void alterar() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
   
            professorDAO.edit(professor);
            professor = new Professor();

        } catch (NonexistentEntityException ex) {
            context.addMessage("formProfessor", new FacesMessage("Professor não pode ser alterado"));
            Logger.getLogger(ProfessorBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            context.addMessage("formProfessor", new FacesMessage("Professor não pode ser alterado"));
            Logger.getLogger(ProfessorBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        context.addMessage("formProfessor", new FacesMessage("Professor foi alterado com sucesso!"));
    }
    
    public void excluir() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            professorDAO.destroy(professor.getId());
            professor = new Professor();
        } catch (Exception ex) {
            context.addMessage("formProfessor", new FacesMessage("Professor não pode ser excluido"));
            Logger.getLogger(ProfessorBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        context.addMessage("formProfessor", new FacesMessage("Professor foi excluido com sucesso!"));
    }

    /**
     * @return the professor
     */
    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    
    public List<Professor> getProfessors(){
        return professorDAO.findProfessorEntities();
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
