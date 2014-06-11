/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.QuestoesJpaController;
import dao.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import modelo.Questoes;
import util.JPAUtil;

/**
 *
 * @author George
 */
@ManagedBean(name = "questoesBean")
@RequestScoped
public class QuestoesBean implements Serializable {

    private Questoes questoes = new Questoes();
    private Integer alternativaCorreta;
    private List<Questoes> questoeses = new ArrayList();
    private QuestoesJpaController questoesDAO = new QuestoesJpaController(JPAUtil.EMF);
    private String mensagem;

    public QuestoesBean() {
        questoeses = questoesDAO.findQuestoesEntities();
    }
    
    public void verificarResposta(){
        FacesContext context = FacesContext.getCurrentInstance();
        
        if(Objects.equals(alternativaCorreta, questoes.getAlternativaCorreta()))
        {
            context.addMessage("formQuestoes", new FacesMessage("Acertouuuu :D!"));
        }
        else
        {
            context.addMessage("formQuestoes", new FacesMessage("Errouuuuuu D:!"));
        }
    }

    public void inserir() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {

            getQuestoesDAO().create(questoes);
            questoes = new Questoes();

        } catch (Exception ex) {
            context.addMessage("formQuestoes", new FacesMessage("Questoes não pode ser inserido"));
            Logger.getLogger(QuestoesBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        context.addMessage("formQuestoes", new FacesMessage("Questoes foi inserido com sucesso!"));
    }

    public void alterar() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {

            getQuestoesDAO().edit(questoes);
            questoes = new Questoes();

        } catch (NonexistentEntityException ex) {
            context.addMessage("formQuestoes", new FacesMessage("Questoes não pode ser alterado"));
            Logger.getLogger(QuestoesBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            context.addMessage("formQuestoes", new FacesMessage("Questoes não pode ser alterado"));
            Logger.getLogger(QuestoesBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        context.addMessage("formQuestoes", new FacesMessage("Questoes foi alterado com sucesso!"));
    }

    public void excluir() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            getQuestoesDAO().destroy(questoes.getId());
            questoes = new Questoes();
        } catch (Exception ex) {
            context.addMessage("formQuestoes", new FacesMessage("Questoes não pode ser excluido"));
            Logger.getLogger(QuestoesBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        context.addMessage("formQuestoes", new FacesMessage("Questoes foi excluido com sucesso!"));
    }

    /**
     * @return the questoes
     */
    public Questoes getQuestoes() {
        return questoes;
    }

    public void setQuestoes(Questoes questoes) {
        this.questoes = questoes;
    }

    public List<Questoes> getQuestoeses() {
            return questoeses;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    /**
     * @return the questoesDAO
     */
    public QuestoesJpaController getQuestoesDAO() {
        return questoesDAO;
    }

    /**
     * @param questoesDAO the questoesDAO to set
     */
    public void setQuestoesDAO(QuestoesJpaController questoesDAO) {
        this.questoesDAO = questoesDAO;
    }

    public Integer getAlternativaCorreta() {
        return alternativaCorreta;
    }

    public void setAlternativaCorreta(Integer alternativaCorreta) {
        this.alternativaCorreta = alternativaCorreta;
    }

}


/*
	
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
	public void inserirQuestao(){
		try {
			questao.addAlternativa(a);
			questao.addAlternativa(b);
			questao.addAlternativa(c);
			questao.addAlternativa(d);
			
			dao.create(questao);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void removerUsuario(Questao q) throws NonexistentEntityException{
		dao.delete(q.getId());
	}
	
	
*/
