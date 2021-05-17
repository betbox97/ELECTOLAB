package es.upm.dit.isst.electolab.dao;

import java.util.List;

import es.upm.dit.isst.electolab.model.Usuario;

public interface UsuarioDAO {
	public Usuario create(Usuario usuario);
	public Usuario read(String email);
	public Usuario update(Usuario usuario);
	public Usuario delete(Usuario usuario);
	public List<Usuario> readAll();
	public List<Usuario> readAll(String user);

}
