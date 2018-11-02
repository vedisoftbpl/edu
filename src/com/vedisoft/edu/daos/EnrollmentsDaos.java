package com.vedisoft.edu.daos;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;
import com.vedisoft.edu.pojos.Enrollments;
import com.vedisoft.edu.pojos.Study;
import com.vedisoft.edu.utilities.ConnectionPool;
import com.vedisoft.edu.utilities.DateUtils;

public class EnrollmentsDaos {

	public static int create(Enrollments enrollments) {
		int id = -1;
			ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "insert into enrollments (studentid, courseid, dateofenroll) values(?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, enrollments.getStudentId());
			ps.setInt(2, enrollments.getCourseId());
			java.sql.Date dt = new java.sql.Date(enrollments.getDateOfEnroll().getTime());
			ps.setDate(3, dt);
			ps.executeUpdate();
			ResultSet generatedKeys = ps.getGeneratedKeys();
			if (generatedKeys.next()) {
				id = generatedKeys.getInt(1);
		} 
		}catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return id;
	}

	public static boolean edit(Enrollments enrollments) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "update enrollments set studentid = ? , courseid = ? , dateofenroll = ? where enrollid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, enrollments.getStudentId());
			ps.setInt(2, enrollments.getCourseId());
			java.sql.Date dt = new java.sql.Date(enrollments.getDateOfEnroll().getTime());
			ps.setDate(3, dt);
			ps.setInt(4, enrollments.getEnrollId());
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
			return false;
		} finally {
			pool.putConnection(conn);
		}
		return true;
	}

	public static boolean remove(int enrollId) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "delete from enrollments where enrollid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, enrollId);
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		return false;
		} finally {
			pool.putConnection(conn);
		}
		return true;
	}

	public static Enrollments find(int enrollId) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		Enrollments enrollments = new Enrollments();
		try {
			String sql = "select * from enrollments where enrollid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, enrollId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				enrollments.setEnrollId(enrollId);
				enrollments.setStudentId(rs.getInt("studentid"));
				enrollments.setCourseId(rs.getInt("courseid"));
				java.sql.Date dt = rs.getDate("dateofenroll");
				enrollments.setDateOfEnroll(new java.util.Date(dt.getTime()));
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return enrollments;
	}

	public static ArrayList<Enrollments> findAll() {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ArrayList<Enrollments> listEnrollments = new ArrayList<Enrollments>();
		try {
			String sql = "select * from enrollments";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Enrollments enrollments = new Enrollments();
				enrollments.setEnrollId(rs.getInt("enrollid"));
				enrollments.setStudentId(rs.getInt("studentid"));
				enrollments.setCourseId(rs.getInt("courseid"));
				java.sql.Date dt = rs.getDate("dateofenroll");
				enrollments.setDateOfEnroll(new java.util.Date(dt.getTime()));
				listEnrollments.add(enrollments);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return listEnrollments;
	}

	public static void main(String args[]) {
		java.util.Date dt = DateUtils.convertDate("1-6-1999");
		Enrollments enrollments=new Enrollments(1,2,4,dt);
		System.out.print(EnrollmentsDaos.find(1));
		System.out.println(EnrollmentsDaos.find(4));
		ArrayList<Enrollments> listEnrollments=new ArrayList<Enrollments>();
		listEnrollments=EnrollmentsDaos.findAll();
		for(Enrollments enrollments1:listEnrollments)
			System.out.println(enrollments);
		
		

}
}
