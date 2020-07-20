package br.com.vasconcelos.portal.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.vasconcelos.portal.domain.Peladas;
import br.com.vasconcelos.portal.domain.Usuario;

public class PeladasDAOTest {
	
	@Test
	@Ignore
	public void salvar () throws ParseException {
		
		//Como ainda não tenho a tela, preciso pesquisar a FK antes
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		List<Usuario> resultado = usuarioDAO.buscar(3L);
		
		Peladas peladas = new Peladas(); 
		peladas.setNomeEvento("Baba dos Coroas");
		peladas.setData(new SimpleDateFormat("dd/MM/yyyy").parse("19/07/2020"));
		peladas.setHorario(new SimpleDateFormat("HH:mm").parse("08:00"));
		peladas.setLocal("Quadra de Colinas de Pituaçu");
		
		for(Usuario usuario : resultado) {
			peladas.setUsuario(usuario);
		}
		
		if(resultado.isEmpty()) {
			System.out.println("Nenhum usuário encontrado");
		}
		
		PeladasDAO peladasDAO = new PeladasDAO();
		peladasDAO.salvar(peladas);
		
	}
	
	@Test
	@Ignore
	public void listar() {
		PeladasDAO peladasDAO = new PeladasDAO();
		List<Peladas> resultado = peladasDAO.listar();
		
		for(Peladas peladas : resultado) {
			System.out.println(peladas.getNomeEvento() + " - " + peladas.getData() + " - " + peladas.getHorario() + " - " + peladas.getLocal() + " - " + peladas.getUsuario().getId());  
		}
	}
	
	@Test
	@Ignore
	public void buscar() {
		
		Long codigo = 7L;
		PeladasDAO peladasDAO = new PeladasDAO();
		List<Peladas> resultado = peladasDAO.buscar(codigo);
		
		if(resultado.isEmpty()) {
			System.out.println("Nenhuma pelada foi encontrada");
		}
		
		for(Peladas peladas : resultado) {
			System.out.println(peladas.getNomeEvento() + " - " + peladas.getData() + " - " + peladas.getHorario() + " - " + peladas.getLocal() + " - " + peladas.getUsuario().getId());  
		}
	}
	
	@Test
	@Ignore
	public void excluir(){
		
		Long codigo = 9L;
		PeladasDAO peladasDAO = new PeladasDAO();
		List<Peladas> resultado = peladasDAO.buscar(codigo);
		
		if(resultado.isEmpty()) {
			System.out.println("Nenhuma pelada foi encontrada");
		} else {
			for(Peladas peladas : resultado) {
				peladasDAO.excluir(peladas);
			}
		}
	}
	
	@Test
	public void editar() {		
		
		Long codigoPelada = 5L;
		Long codigoUsuario = 3L;
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		List<Usuario> resultadoUsuario = usuarioDAO.buscar(codigoUsuario);
		
		PeladasDAO peladasDAO = new PeladasDAO();
		List<Peladas> resultadoPeladas = peladasDAO.buscar(codigoPelada);
		
		if(resultadoPeladas.isEmpty()) {
			System.out.println("Nenhuma pelada foi encontrada");
		} else {
			for(Peladas peladas : resultadoPeladas) {
				peladas.setNomeEvento("Baba dos amigos");
					
				for(Usuario usuario : resultadoUsuario) {
					peladas.setUsuario(usuario);
				}
				peladasDAO.editar(peladas);
			}
		}	
	}
	
	
}
