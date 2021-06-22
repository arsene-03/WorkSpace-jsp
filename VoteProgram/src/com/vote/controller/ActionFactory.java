package com.vote.controller;

import com.vote.controller.action.Action;
import com.vote.controller.action.selectMember_Action;

public class ActionFactory {
	
	private ActionFactory () {};
	
	private static ActionFactory af = new ActionFactory();
	
	public static ActionFactory getInstance() {
		return af;
	}
	
	
	public Action getAction(String command) {
		Action action = null;
		if(command.equals("selecMember")) {
			action = new selectMember_Action();
		}
		return action;
	}
	
	
}
