package com.board.controller;

import com.board.controller.action.Action;
import com.board.controller.action.Board_del_action;
import com.board.controller.action.Board_info_action;
import com.board.controller.action.Board_list_action;
import com.board.controller.action.Board_update_action;
import com.board.controller.action.Board_update_form_action;
import com.board.controller.action.Board_write_action;
import com.board.controller.action.Board_write_form_action;
import com.board.controller.action.Comment_del_action;
import com.board.controller.action.Comment_write_action;

public class ActionFactory {
	
	private ActionFactory(){}
	
	private static ActionFactory af = new ActionFactory();
	
	public static ActionFactory getInstance() {
		return af;
	}
	
	public Action getAction(String command) {
		Action action = null;
		
		if(command.equals("board_list")) {
			action = new Board_list_action();
		}else if(command.equals("board_info")) {
			action = new Board_info_action();
		}else if(command.equals("comment_Delete")) {
			action = new Comment_del_action();
		}else if(command.equals("comment_write")) {
			action = new Comment_write_action();
		}else if(command.equals("board_update_form")) {
			action = new Board_update_form_action();
		}else if(command.equals("board_update")) {
			action = new Board_update_action();
		}else if(command.equals("board_delete")) {
			action = new Board_del_action();
		}else if(command.equals("board_write_form")) {
			action = new Board_write_form_action();
		}else if(command.equals("board_write")) {
			action = new Board_write_action();
		}
		return action;
	}
	
	
	
	
}
