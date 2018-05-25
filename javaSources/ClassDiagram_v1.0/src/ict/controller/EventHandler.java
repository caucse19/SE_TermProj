package ict.controller;

import java.awt.event.ActionEvent;

import ict.model.LoadModel;

public class EventHandler {
	LoadModel loadM;
	
	public EventHandler() {
		// TODO Auto-generated constructor stub
		loadM = new LoadModel();
	}
	
	public void activeEvent(ActionEvent event) {
		// switch each model 
		// case load event
		loadM.active();
		// case  save copy compare
		// ...
	}
}
