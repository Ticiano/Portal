package br.com.vasconcelos.portal.util;

import org.hibernate.Session;
import org.junit.Test;

public class HibernateUtilTest {
	
	@Test
	public void conectar() {
		Session sessao = hibernateUtil.getSessionfactory().openSession();
		sessao.close(); 
		hibernateUtil.getSessionfactory().close();
	}
}
