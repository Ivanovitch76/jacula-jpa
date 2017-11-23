package be.steformations.it.jacula.dto.beans;

import java.io.Serializable;

@javax.xml.bind.annotation.XmlRootElement
@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.PROPERTY)
public class Schedule implements Serializable{

	private static final long serialVersionUID = 3999511985223475184L;

	private Integer id;
	private java.util.Date start; 
	private Integer repeat;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public java.util.Date getStart() {
		return start;
	}
	public void setStart(java.util.Date start) {
		this.start = start;
	}
	public Integer getRepeat() {
		return repeat;
	}
	public void setRepeat(Integer repeat) {
		this.repeat = repeat;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((repeat == null) ? 0 : repeat.hashCode());
		result = prime * result + ((start == null) ? 0 : start.hashCode());
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
		Schedule other = (Schedule) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (repeat == null) {
			if (other.repeat != null)
				return false;
		} else if (!repeat.equals(other.repeat))
			return false;
		if (start == null) {
			if (other.start != null)
				return false;
		} else if (!start.equals(other.start))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Schedule [id=" + id + ", start=" + start + ", repeat=" + repeat + "]";
	}
	
	
}
