package com.vedisoft.edu.pojos;

import java.io.Serializable;

public class AssignmentFiles implements Serializable {
	protected int assignFileId;
	protected int assignsubId;
	protected int questionId;
	protected String solution;

	public int getassignFileId() {
		return assignFileId;
	}

	public void setassignFileId(int assignFileId) {
		this.assignFileId = assignFileId;
	}

	public int getAssignsubId() {
		return assignsubId;
	}

	public void setAssignsubId(int assignsubId) {
		this.assignsubId = assignsubId;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getSolution() {
		return solution;
	}

	public void setSolution(String solution) {
		this.solution = solution;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	protected String remarks;

	public AssignmentFiles(int assignFileId, int assignsubId, int questionId, String solution, String remarks) {
		super();
		this.assignFileId = assignFileId;
		this.assignsubId = assignsubId;
		this.questionId = questionId;
		this.solution = solution;
		this.remarks = remarks;
	}

	public AssignmentFiles(int assignsubId, int questionId, String solution, String remarks) {
		super();
		this.assignsubId = assignsubId;
		this.questionId = questionId;
		this.solution = solution;
		this.remarks = remarks;
	}

	public AssignmentFiles() {
		solution = new String();
		remarks = new String();
	}

	@Override
	public String toString() {
		return "AssignmentFiles [assignFileId=" + assignFileId + ", assignsubId=" + assignsubId + ", questionId="
				+ questionId + ", solution=" + solution + ", remarks=" + remarks + "]";
	}

	@Override
	public int hashCode() {

		return assignFileId;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AssignmentFiles other = (AssignmentFiles) obj;
		if (assignFileId != other.assignFileId)
			return false;
		if (assignsubId != other.assignsubId)
			return false;
		if (questionId != other.questionId)
			return false;
		if (remarks == null) {
			if (other.remarks != null)
				return false;
		} else if (!remarks.equals(other.remarks))
			return false;
		if (solution == null) {
			if (other.solution != null)
				return false;
		} else if (!solution.equals(other.solution))
			return false;
		return true;
	}

}
