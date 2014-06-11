/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.AlunoJpaController;
import dao.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import modelo.Aluno;
import util.JPAUtil;

/**
 *
 * @author George
 */
@ManagedBean(name="alunoBean")
@RequestScoped
public class AlunoBean implements Serializable{
    
    private Aluno aluno = new Aluno();
    AlunoJpaController alunoDAO = new AlunoJpaController(JPAUtil.EMF);
    private String mensagem;

    public AlunoBean() {
    }
    
    public void inserir(){
        FacesContext context = FacesContext.getCurrentInstance();
        try{
            
            alunoDAO.create(aluno);
            aluno = new Aluno();

        }catch(Exception ex){
            context.addMessage("formAluno", new FacesMessage("Aluno não pode ser inserido"));
           Logger.getLogger(AlunoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        context.addMessage("formAluno", new FacesMessage("Aluno foi inserido com sucesso!"));
    }
    
    public void alterar() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
   
            alunoDAO.edit(aluno);
            aluno = new Aluno();

        } catch (NonexistentEntityException ex) {
            context.addMessage("formAluno", new FacesMessage("Aluno não pode ser alterado"));
            Logger.getLogger(AlunoBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            context.addMessage("formAluno", new FacesMessage("Aluno não pode ser alterado"));
            Logger.getLogger(AlunoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        context.addMessage("formAluno", new FacesMessage("Aluno foi alterado com sucesso!"));
    }
    
    public void excluir() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            alunoDAO.destroy(aluno.getId());
            aluno = new Aluno();
        } catch (Exception ex) {
            context.addMessage("formAluno", new FacesMessage("Aluno não pode ser excluido"));
            Logger.getLogger(AlunoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        context.addMessage("formAluno", new FacesMessage("Aluno foi excluido com sucesso!"));
    }

    /**
     * @return the aluno
     */
    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    
    public List<Aluno> getAlunos(){
        return alunoDAO.findAlunoEntities();
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
