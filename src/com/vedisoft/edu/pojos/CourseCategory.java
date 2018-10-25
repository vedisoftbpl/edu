package com.vedisoft.edu.pojos;
import java.io.Serializable;
public class CourseCategory implements Serializable {
int	ccid;
String ccname;
public int getCcid() {
	return ccid;
}
public void setCcid(int ccid) {
	this.ccid = ccid;
}
public String getCcname() {
	return ccname;
}
public void setCcname(String ccname) {
	this.ccname = ccname;
}
@Override
public String toString() {
	return "coursecategory [ccid=" + ccid + ", ccname=" + ccname + "]";
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ccid;
	result = prime * result + ((ccname == null) ? 0 : ccname.hashCode());
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
	CourseCategory other = (CourseCategory) obj;
	if (ccid != other.ccid)
		return false;
	if (ccname == null) {
		if (other.ccname != null)
			return false;
	} else if (!ccname.equals(other.ccname))
		return false;
	return true;
}
public CourseCategory(int ccid, String ccname) {
	super();
	this.ccid = ccid;
	this.ccname = ccname;
}
public CourseCategory() {
	super();
}


}
