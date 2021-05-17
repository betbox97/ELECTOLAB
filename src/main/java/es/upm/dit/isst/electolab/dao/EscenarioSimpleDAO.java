package es.upm.dit.isst.electolab.dao;

import java.util.List;

import es.upm.dit.isst.electolab.model.EscenarioSimple;

public interface EscenarioSimpleDAO {
	public EscenarioSimple create(EscenarioSimple escenarioSimple);
	public EscenarioSimple read(int escenarioSimpleID);
	public EscenarioSimple update(EscenarioSimple escenarioSimple);
	public EscenarioSimple delete(EscenarioSimple escenarioSimple);
	public List<EscenarioSimple> readAll();
	public List<EscenarioSimple> readAll(String user);

}
