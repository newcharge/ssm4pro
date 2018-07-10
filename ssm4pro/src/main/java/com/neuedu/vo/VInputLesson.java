package com.neuedu.vo;

import java.util.List;
import java.util.stream.Collectors;

import com.neuedu.po.Lesson;

public class VInputLesson 
{
	private Lesson lesson;
	private List<Integer> branches;
	
	@Override
	public String toString() {
		return lesson.toString() + "_" + String.join(", ", branches.stream()
				.map(num -> num.toString())
				.collect(Collectors.toList())
				);
	}
	
	public Lesson getLesson() {
		return lesson;
	}
	public void setLesson(Lesson lesson) {
		this.lesson = lesson;
	}
	public List<Integer> getBranches() {
		return branches;
	}
	public void setBranches(List<Integer> branches) {
		this.branches = branches;
	}
}
