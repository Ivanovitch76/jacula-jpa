package be.steformations.it.jacula.dao.beans;

import java.util.Date;

import javax.persistence.*;

import be.steformations.it.jacula.dto.beans.History;
import be.steformations.it.jacula.dto.beans.Job;

@Entity(name="History")
@Table(name="history")
@Access(AccessType.PROPERTY)
public class HistoryEntity extends History{

	private static final long serialVersionUID = 5044813008023847794L;
	
	
	
	public HistoryEntity() {
		super();
	}
	public HistoryEntity(JobEntity job, Date start, int status) {
		super();
		this.setJob(job);
		this.setStart(start);
		this.setStatus(status);
	}

	@Override
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return super.getId();
	}
	@Override
	@ManyToOne(targetEntity=JobEntity.class)
	@JoinColumn(name="job_id")
	public Job getJob() {
		return super.getJob();
	}
	@Override
	@Basic
	@Column(name="starttime")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getStart() {
		return super.getStart();
	}
	@Override
	@Basic
	@Column(name="status")
	public Integer getStatus() {
		return super.getStatus();
	}
	
	
	
}
