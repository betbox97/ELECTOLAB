package es.upm.dit.isst.electolab.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String email;
	private String password;
	private String userName;
	private int numeroSimulacionesUsuario;
	private boolean inCommunity;
	private String community;
	private int comunidadID;
	private int status;
	
	public Usuario() {}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getNumeroSimulacionesUsuario() {
		return numeroSimulacionesUsuario;
	}

	public void setNumeroSimulacionesUsuario(int numeroSimulacionesUsuario) {
		this.numeroSimulacionesUsuario = numeroSimulacionesUsuario;
	}

	public boolean isInCommunity() {
		return inCommunity;
	}

	public void setInCommunity(boolean inCommunity) {
		this.inCommunity = inCommunity;
	}

	public String getCommunity() {
		return community;
	}

	public void setCommunity(String community) {
		this.community = community;
	}

	public int getComunidadID() {
		return comunidadID;
	}

	public void setComunidadID(int comunidadID) {
		this.comunidadID = comunidadID;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
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
		Usuario other = (Usuario) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Usuario [email=" + email + ", password=" + password + ", userName=" + userName
				+ ", numeroSimulacionesUsuario=" + numeroSimulacionesUsuario + ", inCommunity=" + inCommunity
				+ ", community=" + community + ", comunidadID=" + comunidadID + ", status=" + status + "]";
	}

}
