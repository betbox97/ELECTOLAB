package es.upm.dit.isst.electolab.dao;

import java.util.List;

import es.upm.dit.isst.electolab.model.Comunidad;

public interface ComunidadDAO {
	public Comunidad create(Comunidad comunidad);
	public Comunidad read(int comunidadID);
	public Comunidad update(Comunidad comunidad);
	public Comunidad delete(Comunidad comunidad);
	public List<Comunidad> readAll();
	public List<Comunidad> readAll(String user);

}
