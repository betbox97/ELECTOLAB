package es.upm.dit.isst.electolab.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class EscenarioSimple implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private int escenarioSimpleID;
	private String tituloSimulacion;
	private Date fecha;
	private String author;
	private String[] partidosPoliticos;
	private int[] votos;
	private int[] escanos;
	@Lob
	private byte[] grafica;
	
	public EscenarioSimple () {}

	public int getEscenarioSimpleID() {
		return escenarioSimpleID;
	}

	public void setEscenarioSimpleID(int escenarioSimpleID) {
		this.escenarioSimpleID = escenarioSimpleID;
	}

	public String getTituloSimulacion() {
		return tituloSimulacion;
	}

	public void setTituloSimulacion(String tituloSimulacion) {
		this.tituloSimulacion = tituloSimulacion;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String[] getPartidosPoliticos() {
		return partidosPoliticos;
	}

	public void setPartidosPoliticos(String[] partidosPoliticos) {
		this.partidosPoliticos = partidosPoliticos;
	}

	public int[] getVotos() {
		return votos;
	}

	public void setVotos(int[] votos) {
		this.votos = votos;
	}

	public int[] getEscanos() {
		return escanos;
	}

	public void setEscanos(int[] escanos) {
		this.escanos = escanos;
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
		result = prime * result + escenarioSimpleID;
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
		EscenarioSimple other = (EscenarioSimple) obj;
		if (escenarioSimpleID != other.escenarioSimpleID)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EscenarioSimple [escenarioSimpleID=" + escenarioSimpleID + ", tituloSimulacion=" + tituloSimulacion
				+ ", fecha=" + fecha + ", author=" + author + ", partidosPoliticos="
				+ Arrays.toString(partidosPoliticos) + ", votos=" + Arrays.toString(votos) + ", escanos="
				+ Arrays.toString(escanos) + ", grafica=" + Arrays.toString(grafica) + "]";
	}

}