package be.steformations.it.jacula.dao.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import be.steformations.it.jacula.dto.beans.File;

import javax.persistence.*;

@Entity(name="File")
@Table(name="files")
@Access(AccessType.PROPERTY)
public class FileEntity extends File{

	private static final long serialVersionUID = 2141598074467112113L;

	@Override
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return super.getId();
	}
	@Override
	@Basic
	@Column(name="path")
	public String getPath() {
		return super.getPath();
	}
	
	

	
}
