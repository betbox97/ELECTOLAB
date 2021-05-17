package es.upm.dit.isst.electolab.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import es.upm.dit.isst.electolab.model.Comunidad;

public class ComunidadDAOImplementation implements ComunidadDAO {
	private static  ComunidadDAOImplementation instancia = null;
	private ComunidadDAOImplementation() {
	}
	public static ComunidadDAOImplementation getInstance() {
		if( null == instancia )
	      instancia = new ComunidadDAOImplementation();
	    return instancia;
	}

	@Override
	public Comunidad create(Comunidad comunidad) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		try {
		session.save(comunidad);
		} catch(Exception e) {
		comunidad = null;
		}
		session.getTransaction().commit();
		session.close();
		return comunidad;
	}

	@Override
	public Comunidad read(int comunidadID) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Comunidad comunidad = session.get(Comunidad.class, comunidadID);
		session.getTransaction().commit();
		session.close();
		return comunidad;
	}

	@Override
	public Comunidad update(Comunidad comunidad) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.saveOrUpdate(comunidad);
		session.getTransaction().commit();
		session.close();
		return comunidad;
	}

	@Override
	public Comunidad delete(Comunidad comunidad) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.delete(comunidad);
		session.getTransaction().commit();
		session.close();
		return comunidad;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Comunidad> readAll() {
		List<Comunidad> comunidades = new ArrayList<Comunidad> ();
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		comunidades.addAll(session.createQuery("from Comunidad").list());
		session.getTransaction().commit();
		session.close();
		return comunidades;
	}
	
	@Override	//not sure
	public List<Comunidad> readAll(String user) {
		List <Comunidad> res = new ArrayList<Comunidad>();
		for (Comunidad comunidad : this.readAll())
			if (comunidad.getUserName().equals(user))
				res.add(comunidad);
			return res;
	}

}
