package es.upm.dit.isst.electolab.dao;

import java.util.List;

import es.upm.dit.isst.electolab.model.EscenarioComplejo;

public interface EscenarioComplejoDAO {
	public EscenarioComplejo create(EscenarioComplejo escenarioComplejo);
	public EscenarioComplejo read(int escenarioComplejoID);
	public EscenarioComplejo update(EscenarioComplejo escenarioComplejo);
	public EscenarioComplejo delete(EscenarioComplejo escenarioComplejo);
	public List<EscenarioComplejo> readAll();
	public List<EscenarioComplejo> readAll(String user);

}
