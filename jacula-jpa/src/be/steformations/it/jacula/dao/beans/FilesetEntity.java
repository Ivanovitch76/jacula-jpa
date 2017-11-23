package be.steformations.it.jacula.dao.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import be.steformations.it.jacula.dto.beans.Client;
import be.steformations.it.jacula.dto.beans.File;
import be.steformations.it.jacula.dto.beans.Fileset;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity(name="Fileset")
@Table(name="fileset")
@Access(AccessType.PROPERTY)
public class FilesetEntity extends Fileset{

	private static final long serialVersionUID = 7334966690379822135L;

	
	public FilesetEntity() {
		super();
	}
	public FilesetEntity(String description, ClientEntity client, java.util.List<FileEntity> files) {
		super();
		this.setDescription(description);
		this.setClient(client);
		this.getFiles().addAll(files);
	}
	
	@Override
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return super.getId();
	}
	@Override
	@Basic
	@Column(name="description")
	public String getDescription() {
		return super.getDescription();
	}
	@Override
	@ManyToOne(targetEntity=ClientEntity.class)
	@JoinColumn(name="client_id")
	public Client getClient() {
		return super.getClient();
	}

	@SuppressWarnings("unchecked")
	@ManyToMany
	@JoinTable(name="files_in_fileset", joinColumns=@JoinColumn(name="fileset_id"), inverseJoinColumns=@JoinColumn(name="files_id"))
	public List<FileEntity> getFiles() {
		return (List<FileEntity>) super.getFiles();
	}
	
	

}
