package be.steformations.it.jacula.dto.beans;

import java.io.Serializable;


@javax.xml.bind.annotation.XmlRootElement
@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.PROPERTY)
public class Client implements Serializable{

	private static final long serialVersionUID = 5599402101601049826L;

	private Integer id;
	private String ipAdress;
	private String email;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getIpAdress() {
		return ipAdress;
	}
	public void setIpAdress(String ipAdress) {
		this.ipAdress = ipAdress;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((ipAdress == null) ? 0 : ipAdress.hashCode());
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
		Client other = (Client) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (ipAdress == null) {
			if (other.ipAdress != null)
				return false;
		} else if (!ipAdress.equals(other.ipAdress))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Client [id=" + id + ", ipAdress=" + ipAdress + ", email=" + email + "]";
	}
	
}
