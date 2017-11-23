package be.steformations.it.jacula.dao.beans;

import javax.persistence.*;

import be.steformations.it.jacula.dto.beans.Fileset;
import be.steformations.it.jacula.dto.beans.Job;
import be.steformations.it.jacula.dto.beans.Schedule;

@Entity(name="Job")
@Table(name="job")
@NamedQueries({
	@NamedQuery(name="getJobById",
				query = "select j from Job j where j.id = :id")
})
@Access(AccessType.PROPERTY)
public class JobEntity extends Job{

	private static final long serialVersionUID = 3938417572483587454L;

	
	
	public JobEntity() {
		super();
	}
	public JobEntity(FilesetEntity fileset, String type, ScheduleEntity schedule) {
		super();
		this.setFileset(fileset);
		this.setType(type);
		this.setSchedule(schedule);
	}	
	
	@Override
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return super.getId();
	}
	@Override
	@ManyToOne(targetEntity=FilesetEntity.class)
	@JoinColumn(name="fileset_id")
	public Fileset getFileset() {
		return super.getFileset();
	}
	@Override
	@Basic
	@Column(name="job_type")
	public String getType() {
		return super.getType();
	}
	@Override
	@ManyToOne(targetEntity=ScheduleEntity.class)
	@JoinColumn(name="schedule_id")
	public Schedule getSchedule() {
		return super.getSchedule();
	}
	
}
