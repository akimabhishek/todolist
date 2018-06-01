package com.techprimers.security.securitydbexample.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.techprimers.security.securitydbexample.model.TaskList;

public class MySQLConnect {

	public ArrayList<TaskList> getTask(String email) {
		ArrayList<TaskList> tasks = new ArrayList<TaskList>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/buddytodo?useSSL=true", "root",
					"root");
			String Query1 = "select id from user where email=?";
			PreparedStatement ps = con.prepareStatement(Query1);
			ps.setString(1, email);
			ResultSet result = ps.executeQuery();
			int user_id=0;
			if (result.next()) {
				user_id = result.getInt(1);
			}
			System.out.println(user_id);
			String Query2 = "select id,task,flag from tasktodo where user_id=?";
			PreparedStatement ps1 = con.prepareStatement(Query2);
			ps1.setInt(1, user_id);
			ResultSet result2 = ps1.executeQuery();
			while (result2.next()) {
				String task = result2.getString(2);
				int id = result2.getInt(1);
				boolean flag = result2.getBoolean(3);
				System.out.println(flag);
				// int user_id = result2.getInt(4);
				TaskList taskList = new TaskList(task, id, flag, user_id);
				tasks.add(taskList);
			}
			for (TaskList t : tasks) {
				System.out.println(t.getTaskname() + " " + t.getId() + " " + t.getUser_id() + " " + t.isFlag());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return tasks;
	}

	public void deletetask(int id) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/buddytodo?useSSL=true", "root",
					"root");
			String Query = "delete from tasktodo where id=?";
			PreparedStatement ps = con.prepareStatement(Query);
			ps.setInt(1, id);
			int resultset = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public TaskList getTaskbyId(int id) {
		String task = null;
		int user_id = 0;
		boolean flag = false;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/buddytodo?useSSL=true", "root",
					"root");
			String Query = "select task,flag,user_id from tasktodo where id=?";
			PreparedStatement ps = con.prepareStatement(Query);
			ps.setInt(1, id);
			ResultSet resultSet = ps.executeQuery();
			if (resultSet.next()) {
				task = resultSet.getString(1);
				user_id = resultSet.getInt(3);
				flag = resultSet.getBoolean(2);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		TaskList taskList = new TaskList(task, id, flag, user_id);
		return taskList;
	}

	public void NewTask(String taskname, int id, int user_id) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/buddytodo?useSSL=true", "root",
					"root");
			String Query = "insert into tasktodo (id,task,flag,user_id) values (?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(Query);
			ps.setInt(1, id);
			ps.setString(2, taskname);
			ps.setBoolean(3, true);
			ps.setInt(4, user_id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}