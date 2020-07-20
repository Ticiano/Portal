package br.com.vasconcelos.portal.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.vasconcelos.portal.domain.Usuario;

public class UsuarioDAOTest {

	@Test
	@Ignore
	public void salvar(){
		Usuario usuario = new Usuario();
		usuario.setNome("Ivan");
		usuario.setApelido("Ivan");
		usuario.setEmail("ivan@gmail.com");
		usuario.setSenha("123");
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		usuarioDAO.salvar(usuario); 
	}
	
	@Test
	@Ignore
	public void listar() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		List<Usuario> resultado = usuarioDAO.listar();
		
		for(Usuario usuario : resultado) {
			System.out.println(usuario.getNome() + " - " + usuario.getApelido() + " - " + usuario.getEmail() + " - " + usuario.getSenha());
		}	
	}
		
	@Test
	@Ignore
	public void buscar() {
		Long codigo = 1L;
		
		UsuarioDAO usuarioDAO =  new UsuarioDAO();
		List<Usuario> resultado = usuarioDAO.buscar(codigo);
		
		if(resultado.isEmpty()) {
			System.out.println("Nenhum usuário encontrado");
		}
		
		for(Usuario usuario : resultado) {
			System.out.println(usuario.getNome() + " - " + usuario.getApelido() + " - " + usuario.getEmail() + " - " + usuario.getSenha());
		}
	}
	
	@Test
	@Ignore
	public void excluir(){
		Long codigo = 2L;
		
		UsuarioDAO usuarioDAO =  new UsuarioDAO();
		List<Usuario> resultado = usuarioDAO.buscar(codigo);
		
		if(resultado.isEmpty()){
			System.out.println("Nenhum usuário encontrado");
		} else {	
			for(Usuario usuario : resultado) {
				usuarioDAO.excluir(usuario);
			}
		}	
	}
	
	@Test
	@Ignore
	public void editar() {
		Long codigo = 2L;
		
		UsuarioDAO usuarioDAO =  new UsuarioDAO();
		List<Usuario> resultado = usuarioDAO.buscar(codigo);
		
		if(resultado.isEmpty()) {
			System.out.println("Nenhum usuário encontrado");
		}
		
		for (Usuario usuario : resultado) {
			usuario.setSenha("1234");
			usuarioDAO.editar(usuario);
		}
		
	}
	
}
