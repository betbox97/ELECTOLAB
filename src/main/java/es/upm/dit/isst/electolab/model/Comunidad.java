package es.upm.dit.isst.electolab.model;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Comunidad implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private int comunidadID;
	private String nombreComunidad;
	private String userName;
	private int numeroSimulacionesComunidad;
	private int miembros;
	private int escenarioSimpleID;
	private int escenarioComplejoID;
	@Lob
	private byte[] grafica;
	
	public Comunidad() {}

	public int getComunidadID() {
		return comunidadID;
	}

	public void setComunidadID(int comunidadID) {
		this.comunidadID = comunidadID;
	}

	public String getNombreComunidad() {
		return nombreComunidad;
	}

	public void setNombreComunidad(String nombreComunidad) {
		this.nombreComunidad = nombreComunidad;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getNumeroSimulacionesComunidad() {
		return numeroSimulacionesComunidad;
	}

	public void setNumeroSimulacionesComunidad(int numeroSimulacionesComunidad) {
		this.numeroSimulacionesComunidad = numeroSimulacionesComunidad;
	}

	public int getMiembros() {
		return miembros;
	}

	public void setMiembros(int miembros) {
		this.miembros = miembros;
	}

	public int getEscenarioSimpleID() {
		return escenarioSimpleID;
	}

	public void setEscenarioSimpleID(int escenarioSimpleID) {
		this.escenarioSimpleID = escenarioSimpleID;
	}

	public int getEscenarioComplejoID() {
		return escenarioComplejoID;
	}

	public void setEscenarioComplejoID(int escenarioComplejoID) {
		this.escenarioComplejoID = escenarioComplejoID;
	}
	public byte[] getGrafica() {
		return grafica;
	}

	public void setGrafica(byte[] grafica) {
		this.grafica = grafica;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + comunidadID;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comunidad other = (Comunidad) obj;
		if (comunidadID != other.comunidadID)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Comunidad [comunidadID=" + comunidadID + ", nombreComunidad=" + nombreComunidad + ", userName="
				+ userName + ", numeroSimulacionesComunidad=" + numeroSimulacionesComunidad + ", miembros=" + miembros
				+ ", escenarioSimpleID=" + escenarioSimpleID + ", escenarioComplejoID=" + escenarioComplejoID
				+ ", grafica=" + Arrays.toString(grafica) + "]";
	}

}