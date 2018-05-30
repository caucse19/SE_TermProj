package SimpleMerge;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
// SimpleMergeFrame�� Edit��ư�� �������� �� ����
public class EditEventHandler implements ActionListener{
	private JTextArea leftTextArea;
	private JTextArea rightTextArea;
	
	public EditEventHandler(JTextArea lta, JTextArea rta) {
		this.leftTextArea = lta;
		this.rightTextArea = rta;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (leftTextArea.isEditable()) { // if editable
			leftTextArea.setEditable(false);
			rightTextArea.setEditable(false);
		}
		else {	// if not editable
			leftTextArea.setEditable(true);
			rightTextArea.setEditable(true);
		}
	}
}
