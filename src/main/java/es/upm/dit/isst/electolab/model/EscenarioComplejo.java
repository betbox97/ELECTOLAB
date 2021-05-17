package es.upm.dit.isst.electolab.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class EscenarioComplejo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private int escenarioComplejoID;
	private String tituloSimulacion;
	private Date fecha;
	private String author;
	private String[] partidosPoliticos;
	private int[] circunscripciones;
	private int[] votos;
	private int[] escanos;
	private boolean alianzas;
	@Lob
	private byte[] grafica;

	public EscenarioComplejo () {}

	public int getEscenarioComplejoID() {
		return escenarioComplejoID;
	}

	public void setEscenarioComplejoID(int escenarioComplejoID) {
		this.escenarioComplejoID = escenarioComplejoID;
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

	public int[] getCircunscripciones() {
		return circunscripciones;
	}

	public void setCircunscripciones(int[] circunscripciones) {
		this.circunscripciones = circunscripciones;
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

	public boolean isAlianzas() {
		return alianzas;
	}

	public void setAlianzas(boolean alianzas) {
		this.alianzas = alianzas;
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
		result = prime * result + escenarioComplejoID;
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
		EscenarioComplejo other = (EscenarioComplejo) obj;
		if (escenarioComplejoID != other.escenarioComplejoID)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EscenarioComplejo [escenarioComplejoID=" + escenarioComplejoID + ", tituloSimulacion="
				+ tituloSimulacion + ", fecha=" + fecha + ", author=" + author + ", partidoPoliticoss="
				+ Arrays.toString(partidosPoliticos) + ", circunscripciones=" + Arrays.toString(circunscripciones)
				+ ", votos=" + Arrays.toString(votos) + ", escanos=" + Arrays.toString(escanos) + ", alianzas="
				+ alianzas + ", grafica=" + Arrays.toString(grafica) + "]";
	}

}