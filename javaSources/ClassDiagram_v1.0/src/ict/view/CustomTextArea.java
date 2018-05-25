package ict.view;

import javax.swing.JTextArea;

public class CustomTextArea extends JTextArea{
	private boolean editLock;
	
	public CustomTextArea() {
		// TODO Auto-generated constructor stub
		editLock = true;
	}
	
	public void setEditLock(boolean bool) {
		this.editLock = bool;
	}
	
	public boolean getEditLock() {
		return this.editLock;
	}


}
