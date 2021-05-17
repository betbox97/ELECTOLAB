package es.upm.dit.isst.electolab.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import es.upm.dit.isst.electolab.model.EscenarioComplejo;

public class EscenarioComplejoDAOImplementation implements EscenarioComplejoDAO {
	private static  EscenarioComplejoDAOImplementation instancia = null;
	private EscenarioComplejoDAOImplementation() {
	}
	public static EscenarioComplejoDAOImplementation getInstance() {
		if( null == instancia )
	      instancia = new EscenarioComplejoDAOImplementation();
	    return instancia;
	}

	@Override
	public EscenarioComplejo create(EscenarioComplejo escenarioComplejo) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		try {
		session.save(escenarioComplejo);
		} catch(Exception e) {
		escenarioComplejo = null;
		}
		session.getTransaction().commit();
		session.close();
		return escenarioComplejo;
	}

	@Override
	public EscenarioComplejo read(int escenarioComplejoID) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		EscenarioComplejo escenarioComplejo = session.get(EscenarioComplejo.class, escenarioComplejoID);
		session.getTransaction().commit();
		session.close();
		return escenarioComplejo;
	}

	@Override
	public EscenarioComplejo update(EscenarioComplejo escenarioComplejo) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.saveOrUpdate(escenarioComplejo);
		session.getTransaction().commit();
		session.close();
		return escenarioComplejo;
	}

	@Override
	public EscenarioComplejo delete(EscenarioComplejo escenarioComplejo) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.delete(escenarioComplejo);
		session.getTransaction().commit();
		session.close();
		return escenarioComplejo;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EscenarioComplejo> readAll() {
		List<EscenarioComplejo> escenariosComplejo = new ArrayList<EscenarioComplejo> ();
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		escenariosComplejo.addAll(session.createQuery("from EscenarioComplejo").list());
		session.getTransaction().commit();
		session.close();
		return escenariosComplejo;
	}
	
	@Override	//not sure
	public List<EscenarioComplejo> readAll(String user) {
		List <EscenarioComplejo> res = new ArrayList<EscenarioComplejo>();
		for (EscenarioComplejo escenarioComplejo : this.readAll())
			if (escenarioComplejo.getAuthor().equals(user))
				res.add(escenarioComplejo);
			return res;
	}

}
