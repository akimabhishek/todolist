package com.techprimers.security.securitydbexample.model;

public class TaskList {
	
	String taskname;
	int id;
	boolean flag;
	int user_id;
	
	public TaskList(String taskname,int id,boolean flag,int user_id) {
		this.taskname = taskname;
		this.id = id;
		this.flag = flag;
		this.user_id = user_id;
	}
	
	public int getUser_id() {
		return user_id;
	}


	public String getTaskname() {
		return taskname;
	}
	
	public int getId() {
		return id;
	}

	
	public boolean isFlag() {
		return flag;
	}

	@Override
	public String toString() {
		return "TaskList [taskname=" + taskname + ", id=" + id + ", flag=" + flag + ", user_id=" + user_id + "]";
	}
	
}
