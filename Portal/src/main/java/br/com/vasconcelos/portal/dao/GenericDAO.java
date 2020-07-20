package br.com.vasconcelos.portal.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.vasconcelos.portal.util.hibernateUtil;

public class GenericDAO<Entidade> {
	
	//Para pegar a classe da entidade para poder realizar um listar genérico utilizando o API reflection do java
	private Class<Entidade> classe; //Toda vez que instanciar o GenericDAO , esse classe irá descobrir o class da Entidade
	
	@SuppressWarnings("unchecked")
	public GenericDAO() {
		this.classe = (Class<Entidade>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}
	
	public void salvar(Entidade entidade){		
		Session sessao = hibernateUtil.getSessionfactory().openSession();
		Transaction transacao = null; 
		
		try{
			transacao = sessao.beginTransaction();
			sessao.save(entidade);		
			transacao.commit();
		} catch(RuntimeException ex) {
			if(transacao != null){
				transacao.rollback();
			}
			throw ex;
		} finally {
			sessao.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Entidade> listar() {
		Session sessao = hibernateUtil.getSessionfactory().openSession();
		
		try{
			Criteria consulta = sessao.createCriteria(classe);
			List<Entidade> resultado = consulta.list();	
			return resultado; 
		} catch(RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List <Entidade> buscar(Long codigo) {
		Session sessao = hibernateUtil.getSessionfactory().openSession();
		
		try{
			Criteria consulta = sessao.createCriteria(classe);
			consulta.add(Restrictions.idEq(codigo));
			List<Entidade> resultado = consulta.list();	
			return resultado; 
		} catch(RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();
		}
	}
	
	public void excluir(Entidade entidade){		
		Session sessao = hibernateUtil.getSessionfactory().openSession();
		Transaction transacao = null; 
		
		try{
			transacao = sessao.beginTransaction();
			sessao.delete(entidade);		
			transacao.commit();
		} catch(RuntimeException ex) {
			if(transacao != null){
				transacao.rollback();
			}
			throw ex;
		} finally {
			sessao.close();
		}
	}
	
	public void editar(Entidade entidade){		
		Session sessao = hibernateUtil.getSessionfactory().openSession();
		Transaction transacao = null; 
		
		try{
			transacao = sessao.beginTransaction();
			sessao.update(entidade);		
			transacao.commit();
		} catch(RuntimeException ex) {
			if(transacao != null){
				transacao.rollback();
			}
			throw ex;
		} finally {
			sessao.close();
		}
	}
	
}
