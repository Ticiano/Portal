package br.com.vasconcelos.portal.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class hibernateUtil {
	private static SessionFactory sessionFactory = buildSessionFactory();
			
	//Chamar a sessionFactory
    public static SessionFactory getSessionfactory() {
		return sessionFactory;
	}
    
    private static SessionFactory buildSessionFactory() {
    	try{
    		//Carregar todas as propriedades do arquivo hibernate.cfg.xml
    		Configuration configuracao = new Configuration().configure();
    		
    		//Registro o serviço 
    		ServiceRegistry registro = new StandardServiceRegistryBuilder().applySettings(configuracao.getProperties()).build();
    		
    		//Construo a fábrica de sessão
    		SessionFactory fabrica = configuracao.buildSessionFactory(registro); 
    		
    		return fabrica; 
    		
    	} catch (Throwable ex){
			System.out.println("A fábrica de sessões não foi criada: " + ex);
			throw new ExceptionInInitializerError(ex); 
			
		}
    }   
}
