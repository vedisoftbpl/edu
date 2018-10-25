package com.vedisoft.edu.pojos;

import java.io.Serializable;
import java.util.Date;

public class AssignmentSubmission implements Serializable {
	protected int assignsubId;
	protected int studentId;
	protected int assignId;
	protected Date dateTime;
	protected int score;

	public int getAssignsubId() {
		return assignsubId;
	}

	public void setAssignsubId(int assignsubId) {
		this.assignsubId = assignsubId;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getAssignId() {
		return assignId;
	}

	public void setAssignId(int assignId) {
		this.assignId = assignId;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public AssignmentSubmission(int assignsubId, int studentId, int assignId, Date dateTime, int score) {
		super();
		this.assignsubId = assignsubId;
		this.studentId = studentId;
		this.assignId = assignId;
		this.dateTime = dateTime;
		this.score = score;
	}

	public AssignmentSubmission(int studentId, int assignId, Date dateTime, int score) {
		super();
		this.studentId = studentId;
		this.assignId = assignId;
		this.dateTime = dateTime;
		this.score = score;
	}

	public AssignmentSubmission() {
		super();
	}

	@Override
	public int hashCode() {
		return assignsubId;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AssignmentSubmission other = (AssignmentSubmission) obj;
		if (assignId != other.assignId)
			return false;
		if (assignsubId != other.assignsubId)
			return false;
		if (dateTime == null) {
			if (other.dateTime != null)
				return false;
		} else if (!dateTime.equals(other.dateTime))
			return false;
		if (score != other.score)
			return false;
		if (studentId != other.studentId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AssignmentSubmission [assignsubId=" + assignsubId + ", studentId=" + studentId + ", assignId="
				+ assignId + ", dateTime=" + dateTime + ", score=" + score + "]";
	}

}
