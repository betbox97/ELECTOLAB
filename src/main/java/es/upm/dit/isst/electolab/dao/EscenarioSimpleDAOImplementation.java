package es.upm.dit.isst.electolab.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import es.upm.dit.isst.electolab.model.EscenarioSimple;

public class EscenarioSimpleDAOImplementation implements EscenarioSimpleDAO {
	private static  EscenarioSimpleDAOImplementation instancia = null;
	private EscenarioSimpleDAOImplementation() {
	}
	public static EscenarioSimpleDAOImplementation getInstance() {
		if( null == instancia )
	      instancia = new EscenarioSimpleDAOImplementation();
	    return instancia;
	}

	@Override
	public EscenarioSimple create(EscenarioSimple escenarioSimple) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		try {
		session.save(escenarioSimple);
		} catch(Exception e) {
		escenarioSimple = null;
		}
		session.getTransaction().commit();
		session.close();
		return escenarioSimple;
	}

	@Override
	public EscenarioSimple read(int escenarioSimpleID) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		EscenarioSimple escenarioSimple = session.get(EscenarioSimple.class, escenarioSimpleID);
		session.getTransaction().commit();
		session.close();
		return escenarioSimple;
	}

	@Override
	public EscenarioSimple update(EscenarioSimple escenarioSimple) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.saveOrUpdate(escenarioSimple);
		session.getTransaction().commit();
		session.close();
		return escenarioSimple;
	}

	@Override
	public EscenarioSimple delete(EscenarioSimple escenarioSimple) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.delete(escenarioSimple);
		session.getTransaction().commit();
		session.close();
		return escenarioSimple;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EscenarioSimple> readAll() {
		List<EscenarioSimple> escenariosSimple = new ArrayList<EscenarioSimple> ();
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		escenariosSimple.addAll(session.createQuery("from EscenarioSimple").list());
		session.getTransaction().commit();
		session.close();
		return escenariosSimple;
	}
	
	@Override	//not sure
	public List<EscenarioSimple> readAll(String user) {
		List <EscenarioSimple> res = new ArrayList<EscenarioSimple>();
		for (EscenarioSimple escenarioSimple : this.readAll())
			if (escenarioSimple.getAuthor().equals(user))
				res.add(escenarioSimple);
			return res;
	}

}
