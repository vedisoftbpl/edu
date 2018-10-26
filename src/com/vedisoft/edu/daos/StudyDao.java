package com.vedisoft.edu.daos;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

	public static void main(String args[]) {
		Study st = new Study(2, 1, 1, 1, "Yes");
		System.out.println(StudyDao.create(st));

	}
}
