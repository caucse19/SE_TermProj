package ict.controller;

import java.awt.event.ActionEvent;

import ict.view.ViewFrame;

public class SimpleMergeFrame {
	
	public static void main(String[] args) {
		
		ViewFrame SMView = new ViewFrame();
		SMView.show();
			
	}
	
	
	EventHandler EHandler = new EventHandler();
	
	public SimpleMergeFrame() {
		// TODO Auto-generated constructor stub
	}
	
	public void controllEvent(ActionEvent event) {
		
		this.EHandler.activeEvent(event);	
	}
	
	

}
