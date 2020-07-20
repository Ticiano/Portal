package br.com.vasconcelos.portal.main;

import org.hibernate.Session;

import br.com.vasconcelos.portal.util.hibernateUtil;

public class HibernateUtilTest {

	public static void main(String[] args) {
		Session sessao = hibernateUtil.getSessionfactory().openSession();
		sessao.close(); 
		hibernateUtil.getSessionfactory().close();
	}
	
}
