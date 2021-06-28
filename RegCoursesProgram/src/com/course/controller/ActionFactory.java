package com.course.controller;

import com.course.controller.action.Action;
import com.course.controller.action.Course_delete_action;
import com.course.controller.action.Course_list_action;
import com.course.controller.action.Course_update_action;
import com.course.controller.action.Course_update_form_action;
import com.course.controller.action.Course_write_action;
import com.course.controller.action.Course_write_form_action;

public class ActionFactory {
	private ActionFactory () {};
	private static ActionFactory af = new ActionFactory();
	public static ActionFactory getInsetance() {
		return af;
	}
	
	public Action getAction(String command) {
		Action action = null;
		
		if(command.equals("course_list")) {
			action = new Course_list_action();
		}else if(command.equals("course_write_form")) {
			action = new Course_write_form_action();
		}else if(command.equals("course_write")) {
			action = new Course_write_action();
		}else if(command.equals("course_del")) {
			action = new Course_delete_action();
		}else if(command.equals("course_update_form")) {
			action = new Course_update_form_action();
		}else if(command.equals("course_update")) {
			action = new Course_update_action();
		}
		
		return action;
	}
}


