package com.project.professor.allocation.entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import java.time.DayOfWeek;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Allocation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	private DayOfWeek day;
	private Date start;
	private Date end;
	
	@Column (name = "course_id", nullable = false)
	private Long courseId;
	
	@ManyToOne (optional = false)
	@JoinColumn (name = "course_id", nullable = false, insertable = false, updatable = false)
	private Course course;	
 
	public Allocation(Long id, DayOfWeek day, Date start, Date end) {
		super();
		this.id = id;
		this.day = day;
		this.start = start;
		this.end = end;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DayOfWeek getDay() {
		return day;
	}

	public void setDay(DayOfWeek day) {
		this.day = day;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	@Override
	public String toString() {
		
		return super.toString();
	}
	

}
