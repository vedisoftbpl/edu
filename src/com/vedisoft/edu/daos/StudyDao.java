package com.vedisoft.edu.daos;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;
import com.vedisoft.edu.pojos.Study;
import com.vedisoft.edu.utilities.ConnectionPool;



public class StudyDao {
	public static int create(Study studyId) {
		int id = -1;
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "insert into study (studentid, sessionid, topicid,completed) values(?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, studyId.getstudentId());
			ps.setInt(2, studyId.getsessionId());
			ps.setInt(3, studyId.gettopicId());
			ps.setString(4, studyId.getCompleted());
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

	public static boolean edit(Study study) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "update study " + "set studentid = ?, sessionid = ? ,topicid=?,completed=? where studyid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, study.getstudentId());
			ps.setInt(2, study.getsessionId());
			ps.setInt(3, study.gettopicId());
			ps.setString(4, study.getCompleted());
			ps.setInt(5, study.getstudyId());
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
			return false;
		} finally {
			pool.putConnection(conn);
		}
		return true;
	}
	
	public static boolean remove(int studyId) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "delete from study where studyId = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, studyId);
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
			return false;
		} finally {
			pool.putConnection(conn);
		}
		return true;
	}
	
	public static Study find(int studyId) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		Study study = new Study();
		try {
			String sql = "select * from study where studyId = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, studyId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				study.setstudyId(studyId);
				study.setstudentId(rs.getInt("studentId"));
				study.setsessionId(rs.getInt("sessionId"));
				study.settopicId(rs.getInt("topicId"));
				study.setCompleted(rs.getString("completed"));
				
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return study;
	}
	
	public static ArrayList<Study> findAll() {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ArrayList<Study> listCourses = new ArrayList<Study>();
		try {
			String sql = "select * from study";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Study course = new Study();
				course.setstudyId(rs.getInt("studyId"));
				course.setstudentId(rs.getInt("studentId"));
				course.setsessionId(rs.getInt("sessionId"));
				course.settopicId(rs.getInt("topicId"));
				course.setCompleted(rs.getString("completed"));
				
				listCourses.add(course);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row.");
		} finally {
			pool.putConnection(conn);
		}
		return listCourses;
	}



	public static void main(String args[]) {
		// Study st = new Study(3, 2, 1, 1, "Yes");
		// StudyDao.create(st);

//		Study st = new Study(1, 2, 344, 5, "No");
//		StudyDao.edit(st);
		
		
		//StudyDao.remove(2);
		
		
		//System.out.println(StudyDao.find(3));
		
		System.out.println(StudyDao.findAll()); 
		

	}
}
