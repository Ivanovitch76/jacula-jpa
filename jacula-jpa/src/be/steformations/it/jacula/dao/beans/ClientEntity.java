package be.steformations.it.jacula.dao.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import be.steformations.it.jacula.dto.beans.Client;

import javax.persistence.*;

@Entity(name="Client")
@Table(name="client")
@Access(AccessType.PROPERTY)
public class ClientEntity extends Client{

	private static final long serialVersionUID = 7031819825962255629L;

	@Override
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return super.getId();
	}

	@Override
	@Basic
	@Column(name="adresse_ip")	
	public String getIpAdress() {
		return super.getIpAdress();
	}

	@Override
	@Basic
	@Column(name="email")
	public String getEmail() {
		return super.getEmail();
	}
	
	
	
}
