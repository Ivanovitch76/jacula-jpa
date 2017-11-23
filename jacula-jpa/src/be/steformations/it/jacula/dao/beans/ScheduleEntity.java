package be.steformations.it.jacula.dao.beans;

import java.util.Date;

import javax.persistence.*;

import be.steformations.it.jacula.dto.beans.Schedule;

@Entity(name="Schedule")
@Table(name="schedule")
@Access(AccessType.PROPERTY)
public class ScheduleEntity extends Schedule{

	private static final long serialVersionUID = 3999511985223475184L;

	@Override
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return super.getId();
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
	@Column(name="repeat")
	public Integer getRepeat() {
		return super.getRepeat();
	}
	
	

	
}
