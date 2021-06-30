package com.score.controller;

import com.score.controller.action.Action;
import com.score.controller.action.login_action;
import com.score.controller.action.login_form_action;
import com.score.controller.action.signup_action;
import com.score.controller.action.signup_form_action;

public class ActionFactory {
	private ActionFactory() {};
	private static ActionFactory af = new ActionFactory();
	public static ActionFactory getInsetance() {
		return af;
	}
	
	
	public Action getAction(String command) {
		Action action = null;
		
		if(command.equals("login_form_action")) {
			action = new login_form_action();
		}else if(command.equals("signup_form_action")) {
			action = new signup_form_action();
		}else if(command.equals("signup_action")) {
			action = new signup_action();
		}else if(command.equals("login_action")) {
			action = new login_action();
		}
		return action;
	}
	
	
	
	
	
}
