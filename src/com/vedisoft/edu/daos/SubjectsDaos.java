package com.vedisoft.edu.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;
import com.vedisoft.edu.pojos.Enrollments;
import com.vedisoft.edu.pojos.Study;
import com.vedisoft.edu.pojos.Subjects;
import com.vedisoft.edu.utilities.ConnectionPool;

public class SubjectsDaos {

	public static int create(Subjects subjects) {
		int id = -1;
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "insert into subjects (subname,courseid,objective) values(?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, subjects.getSubName());
			ps.setInt(2, subjects.getCourseId());
			ps.setString(3,subjects.getObjective());
			ps.executeUpdate();
			ResultSet generatedKeys = ps.getGeneratedKeys();
			if (generatedKeys.next()) {
				id = generatedKeys.getInt(1);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return id;
	}
	
	public static boolean edit(Subjects subjects) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "update subjects " + "set subname = ?, courseid = ? ,objective=? where subid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, subjects.getSubName());
			ps.setInt(2, subjects.getCourseId());
			ps.setString(3,subjects.getObjective());
			ps.setInt(4, subjects.getSubId());
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
			return false;
		} finally {
			pool.putConnection(conn);
		}
		return true;
	}
	
	public static boolean remove(int subId) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "delete from subjects where subid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, subId);
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
			return false;
		} finally {
			pool.putConnection(conn);
		}
		return true;
	}
	
	public static Subjects find(int subId) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		Subjects subjects = new Subjects();
		try {
			String sql = "select * from subjects where subid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, subId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				subjects.setSubId(subId);
				subjects.setSubName(rs.getString("subname"));
				subjects.setCourseId(rs.getInt("courseid"));
				subjects.setObjective(rs.getString("objective"));
				
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return subjects;
	}
	
	public static ArrayList<Subjects> findAll() {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ArrayList<Subjects> listSubjects = new ArrayList<Subjects>();
		try {
			String sql = "select * from subjects";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Subjects subjects = new Subjects();
				subjects.setSubId(rs.getInt("subid"));
				subjects.setSubName(rs.getString("subname"));
				subjects.setCourseId(rs.getInt("courseid"));
				subjects.setObjective(rs.getString("objective"));
				
				listSubjects.add(subjects);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row.");
		} finally {
			pool.putConnection(conn);
		}
		return listSubjects;
	}


	
	public static void main(String args[]) {
		Subjects sb=new Subjects("A22SD",9,"buhgsj");
		System.out.print(SubjectsDaos.create(sb));
		System.out.print(SubjectsDaos.find(3));
		ArrayList<Subjects> listSubjects=new ArrayList<Subjects>();
		listSubjects=SubjectsDaos.findAll();
		for(Subjects sb1:listSubjects)
			System.out.println(sb1);
		
	}

}
