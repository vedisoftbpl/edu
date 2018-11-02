package com.vedisoft.edu.pojos;

import java.util.Date;

public class Enrollments {
	protected int enrollId;
	protected int studentId;
	protected int courseId;
	protected Date dateOfEnroll;

	public Enrollments() {
		super();
		dateOfEnroll = new Date();
	}

	public Enrollments(int studentId, int courseId, Date dateOfEnroll) {
		super();
		this.studentId = studentId;
		this.courseId = courseId;
		this.dateOfEnroll = dateOfEnroll;
	}

	public Enrollments(int enrollId, int studentId, int courseId, Date dateOfEnroll) {
		super();
		this.enrollId = enrollId;
		this.studentId = studentId;
		this.courseId = courseId;
		this.dateOfEnroll = dateOfEnroll;
	}

	public int getEnrollId() {
		return enrollId;
	}

	public void setEnrollId(int enrollId) {
		this.enrollId = enrollId;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public Date getDateOfEnroll() {
		return dateOfEnroll;
	}

	public void setDateOfEnroll(Date dateOfEnroll) {
		this.dateOfEnroll = dateOfEnroll;
	}

	@Override
	public int hashCode() {
		return enrollId;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Enrollments other = (Enrollments) obj;
		if (courseId != other.courseId)
			return false;
		if (dateOfEnroll == null) {
			if (other.dateOfEnroll != null)
				return false;
		} else if (!dateOfEnroll.equals(other.dateOfEnroll))
			return false;
		if (enrollId != other.enrollId)
			return false;
		if (studentId != other.studentId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Enrollments [enrollId=" + enrollId + ", studentId=" + studentId + ", courseId=" + courseId
				+ ", dateOfEnroll=" + dateOfEnroll + "]";
	}

}
