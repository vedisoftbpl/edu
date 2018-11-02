package com.vedisoft.edu.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;
import com.vedisoft.edu.pojos.AssignmentFiles;
import com.vedisoft.edu.pojos.Subjects;
import com.vedisoft.edu.utilities.ConnectionPool;

public class AssignmentFilesDaos {

	public static int create(AssignmentFiles assignmentFiles) {
		int id = -1;
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "insert into assignmentfiles (assignsubid,questionid,solution,remarks) values(?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, assignmentFiles.getAssignsubId());
			ps.setInt(2, assignmentFiles.getQuestionId());
			ps.setString(3,assignmentFiles.getSolution());
			ps.setString(4,assignmentFiles.getSolution());
			ps.executeUpdate();
			ResultSet generatedKeys = ps.getGeneratedKeys();
			if (generatedKeys.next()) {
				id = generatedKeys.getInt(1);
		}} catch (SQLException sq) {
		
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return id;
	}
	
	public static boolean edit(AssignmentFiles assignmentFiles) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "update assignmentfiles " + "set assignsubid = ?, questionid = ?,solution=? ,remarks=? where assignfileid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, assignmentFiles.getAssignsubId());
			ps.setInt(2, assignmentFiles.getQuestionId());
			ps.setString(3,assignmentFiles.getSolution());
			ps.setString(4,assignmentFiles.getSolution());
			ps.setInt(5,assignmentFiles.getassignFileId());
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
			return false;
		} finally {
			pool.putConnection(conn);
		}
		return true;
	}
	
	public static boolean remove(int assignFieldId) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "delete from assignmentfiles where assignfileid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, assignFieldId);
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
			return false;
		} finally {
			pool.putConnection(conn);
		}
		return true;
	}
	
	public static AssignmentFiles find(int assignFieldId) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		AssignmentFiles assignmentFiles = new AssignmentFiles();
		try {
			String sql = "select * from assignmentfiles where assignfileid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, assignFieldId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				assignmentFiles.setassignFileId(assignFieldId);
				assignmentFiles.setAssignsubId(rs.getInt("assignsubid"));
				assignmentFiles.setQuestionId(rs.getInt("questionid"));
				assignmentFiles.setSolution(rs.getString("solution"));
				assignmentFiles.setRemarks(rs.getString("remarks"));	
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return assignmentFiles;
	}
	
	public static ArrayList<AssignmentFiles> findAll() {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ArrayList<AssignmentFiles> listAssignmentFiles = new ArrayList<AssignmentFiles>();
		try {
			String sql = "select * from assignmentfiles";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				AssignmentFiles assignmentFiles = new AssignmentFiles();
				assignmentFiles.setassignFileId(rs.getInt("assignfileid"));
				assignmentFiles.setAssignsubId(rs.getInt("assignsubid"));
				assignmentFiles.setQuestionId(rs.getInt("questionid"));
				assignmentFiles.setSolution(rs.getString("solution"));
				assignmentFiles.setRemarks(rs.getString("remarks"));	
				listAssignmentFiles.add(assignmentFiles);
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row.");
		} finally {
			pool.putConnection(conn);
		}
		return listAssignmentFiles;
	}
	
	public static void main(String args[]) {
		AssignmentFiles assignmentFiles = new AssignmentFiles(2,22,22,"adsd","add");
		System.out.println(AssignmentFilesDaos.create(assignmentFiles));
		ArrayList<AssignmentFiles> listAssignmentFiles=new ArrayList<AssignmentFiles>();
		listAssignmentFiles=AssignmentFilesDaos.findAll();
		for(AssignmentFiles assignment:listAssignmentFiles)
			System.out.println(assignment);
		
	}



}
