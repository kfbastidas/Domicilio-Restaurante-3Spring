package co.mycompany.usuario;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import co.mycompany.usuario.domain.entity.Usuario;
import co.mycompany.usuario.domain.service.IUsuarioService;

@SpringBootTest
class ServicioUsuarioApplicationTests {
	@Autowired
	IUsuarioService usuarioservice;
	
	@Test
	void findUsuarioExistente() {
		String idUser = "admin";
		String clave = "123456";
		String nombre = "juan";
		String direccion = "calle 45#10";
		String telefono = "3134253526";
		String tipo = "A";
		
		Usuario user =null;
		try {
			user = usuarioservice.findById(idUser);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		assertEquals(user.getId(), idUser);
		assertEquals(user.getNombre(), nombre);
		assertEquals(user.getClave(), clave);
		assertEquals(user.getTelefono(),telefono);
		assertEquals(user.getDireccion(),direccion);
		assertEquals(user.getTipo(),tipo);
	}

	@Test
	void createUsuarioNoExistente() {
		String idUser = "admin13";
		String clave = "123456";
		String nombre = "juan";
		String direccion = "calle 45#10";
		String telefono = "3134253526";
		String tipo = "A";
		
		Usuario userCreate = new Usuario(idUser, clave, nombre, direccion, telefono, tipo);
		Usuario user = null;
		try {
			user = usuarioservice.create(userCreate);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		assertEquals(user.getId(), idUser);
		assertEquals(user.getNombre(), nombre);
		assertEquals(user.getClave(), clave);
		assertEquals(user.getTelefono(),telefono);
		assertEquals(user.getDireccion(),direccion);
		assertEquals(user.getTipo(),tipo);
		
		try {
			usuarioservice.deleteById(idUser);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	@Test
	void createUsuarioExistente() {
		String idUser = "admin";
		String clave = "123456";
		String nombre = "juan";
		String direccion = "calle 45#10";
		String telefono = "3134253526";
		String tipo = "A";
		
		Usuario userCreate = new Usuario(idUser, clave, nombre, direccion, telefono, tipo);
		Usuario user = null;
		try {
			user = usuarioservice.create(userCreate);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		assertEquals(user, null);
	}
	
	@Test
	void updateUsuarioExistente() {
		String idUser = "admin";
		String clave = "12345689";
		String nombre = "juan234";
		String direccion = "calle 45#1056";
		String telefono = "313425352236";
		String tipo = "C";
		
		Usuario user = new Usuario(idUser, clave, nombre, direccion, telefono, tipo);
		Usuario userExiste = null;
		Usuario userUpdate = null;
		try {
			userExiste = this.usuarioservice.findById(idUser);
			userUpdate = this.usuarioservice.update(idUser, user);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		assertEquals(user.getId(), userUpdate.getId());
		assertEquals(user.getNombre(), userUpdate.getNombre());
		assertEquals(user.getClave(), userUpdate.getClave());
		assertEquals(user.getTelefono(),userUpdate.getTelefono());
		assertEquals(user.getDireccion(),userUpdate.getDireccion());
		assertEquals(user.getTipo(),userUpdate.getTipo());
		
		if (userExiste!=null) {
			try {
				this.usuarioservice.update(idUser, userExiste);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	@Test
	void deleteUsuarioExistente() {
		String idUser = "admin";
		
		Usuario userDelete = null;
		Usuario user = null;
		try {
			userDelete = this.usuarioservice.findById(idUser);
			usuarioservice.deleteById(idUser);
			user = this.usuarioservice.findById(idUser);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		assertEquals(user, null);
		
		if (userDelete!=null) {
			try {
				this.usuarioservice.create(userDelete);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
}
