package ict.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ict.controller.EventHandler;
import ict.controller.SimpleMergeFrame;
import javafx.scene.control.TextArea;

// view main Class

public class ViewFrame implements ActionListener {
	
	private boolean toggleRightPanel;
	private boolean toggleLeftPanel;
	
	CustomTextArea RightTextArea = new CustomTextArea();
	CustomTextArea LeftTextArea  = new CustomTextArea();
	SimpleMergeFrame Controller = new SimpleMergeFrame();
	
	public ViewFrame() {
		// TODO Auto-generated constructor stub
		
	}
	
	public void show() {
		
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		this.Controller.controllEvent(event);
		
	}
	
	

	
}
