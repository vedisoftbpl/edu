package com.vedisoft.edu.pojos;

public class Subjects {
	protected int subId;
	protected String subName;
	protected int courseId;
	protected String objective;
	public Subjects() {
		super();
	}
	public Subjects(String subName, int courseId, String objective) {
		super();
		this.subName = subName;
		this.courseId = courseId;
		this.objective = objective;
	}
	public Subjects(int subId, String subName, int courseId, String objective) {
		super();
		this.subId = subId;
		this.subName = subName;
		this.courseId = courseId;
		this.objective = objective;
	}
	public int getSubId() {
		return subId;
	}
	public void setSubId(int subId) {
		this.subId = subId;
	}
	public String getSubName() {
		return subName;
	}
	public void setSubName(String subName) {
		this.subName = subName;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getObjective() {
		return objective;
	}
	public void setObjective(String objective) {
		this.objective = objective;
	}
	@Override
	public int hashCode() {
		return subId;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Subjects other = (Subjects) obj;
		if (courseId != other.courseId)
			return false;
		if (objective == null) {
			if (other.objective != null)
				return false;
		} else if (!objective.equals(other.objective))
			return false;
		if (subId != other.subId)
			return false;
		if (subName == null) {
			if (other.subName != null)
				return false;
		} else if (!subName.equals(other.subName))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Subjects [subId=" + subId + ", subName=" + subName + ", courseId=" + courseId + ", objective="
				+ objective + "]";
	}
	
	

}
