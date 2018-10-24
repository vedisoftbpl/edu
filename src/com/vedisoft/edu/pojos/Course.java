package com.vedisoft.edu.pojos;
import java.io.Serializable;
import java.util.Date;

public class Course implements Serializable {
	 int courseid;
	 int ccid;
	String coursename;
	String coursedetails;
	String prereq;
	 Date duration;
	public int getCourseid() {
		return courseid;
	}
	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}
	public int getCcid() {
		return ccid;
	}
	public void setCcid(int ccid) {
		this.ccid = ccid;
	}
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	public String getCoursedetails() {
		return coursedetails;
	}
	public void setCoursedetails(String coursedetails) {
		this.coursedetails = coursedetails;
	}
	public String getPrereq() {
		return prereq;
	}
	public void setPrereq(String prereq) {
		this.prereq = prereq;
	}
	public Date getDuration() {
		return duration;
	}
	public void setDuration(Date duration) {
		this.duration = duration;
	}
	@Override
	public String toString() {
		return "Course [courseid=" + courseid + ", ccid=" + ccid + ", coursename=" + coursename + ", coursedetails="
				+ coursedetails + ", prereq=" + prereq + ", duration=" + duration + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ccid;
		result = prime * result + ((coursedetails == null) ? 0 : coursedetails.hashCode());
		result = prime * result + courseid;
		result = prime * result + ((coursename == null) ? 0 : coursename.hashCode());
		result = prime * result + ((duration == null) ? 0 : duration.hashCode());
		result = prime * result + ((prereq == null) ? 0 : prereq.hashCode());
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
		Course other = (Course) obj;
		if (ccid != other.ccid)
			return false;
		if (coursedetails == null) {
			if (other.coursedetails != null)
				return false;
		} else if (!coursedetails.equals(other.coursedetails))
			return false;
		if (courseid != other.courseid)
			return false;
		if (coursename == null) {
			if (other.coursename != null)
				return false;
		} else if (!coursename.equals(other.coursename))
			return false;
		if (duration == null) {
			if (other.duration != null)
				return false;
		} else if (!duration.equals(other.duration))
			return false;
		if (prereq == null) {
			if (other.prereq != null)
				return false;
		} else if (!prereq.equals(other.prereq))
			return false;
		return true;
	}
}
