package com.vedisoft.edu.pojos;

import java.io.Serializable;

public class Study implements Serializable {
	protected int studyId;
	protected int studentId;
	protected int sessionId;
	protected int topicId;
	protected String completed;

	public int getstudyId() {
		return studyId;
	}

	public void setstudyId(int studyId) {
		this.studyId = studyId;
	}

	public int getstudentId() {
		return studentId;
	}

	public void setstudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getsessionId() {
		return sessionId;
	}

	public void setsessionId(int sessionId) {
		this.sessionId = sessionId;
	}

	public int gettopicId() {
		return topicId;
	}

	public void settopicId(int topicId) {
		this.topicId = topicId;
	}

	public String getCompleted() {
		return completed;
	}

	public void setCompleted(String completed) {
		this.completed = completed;
	}

	@Override
	public String toString() {
		return "Study [studyId=" + studyId + ", studentId=" + studentId + ", sessionId=" + sessionId + ", topicId="
				+ topicId + ", completed=" + completed + "]";
	}

	public Study(int studyId, int studentId, int sessionId, int topicId, String completed) {
		this.studyId = studyId;
		this.studentId = studentId;
		this.sessionId = sessionId;
		this.topicId = topicId;
		this.completed = completed;
	}

	public Study() {

		completed = new String();
	}

	@Override
	public int hashCode() {

		return studyId;
	}

	public Study(int studentId, int sessionId, int topicId, String completed) {
		super();
		this.studentId = studentId;
		this.sessionId = sessionId;
		this.topicId = topicId;
		this.completed = completed;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Study other = (Study) obj;
		if (completed == null) {
			if (other.completed != null)
				return false;
		} else if (!completed.equals(other.completed))
			return false;
		if (sessionId != other.sessionId)
			return false;
		if (studentId != other.studentId)
			return false;
		if (studyId != other.studyId)
			return false;
		if (topicId != other.topicId)
			return false;
		return true;
	}

}
