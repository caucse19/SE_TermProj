package SimpleMerge;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;

public class CopyEventHandler implements ActionListener {
	
	private JTextArea leftTextArea;
	private JTextArea rightTextArea;
	private int copyOption;

	public CopyEventHandler(JTextArea leftTextArea, JTextArea rightTextArea, int copyOption) {
		this.leftTextArea = leftTextArea;
		this.rightTextArea = rightTextArea;
		this.copyOption = copyOption;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		SimpleMergeController.leftLineNum = -1;
		SimpleMergeController.rightLineNum = -1;
		
		if(copyOption == 1) {
			rightTextArea.setText("");
			rightTextArea.append(leftTextArea.getText());
		}
		else {
			leftTextArea.setText("");
			leftTextArea.append(rightTextArea.getText());
		}
	}
}
