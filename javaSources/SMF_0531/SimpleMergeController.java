package SimpleMerge;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

public class SimpleMergeController {
	private SimpleMergeFrame frm;
	private JButton leftLoadBtn;
	private JButton rightLoadBtn;
	private JButton editBtn;
	private JComboBox<String> saveCBox;
	private JButton saveBtn;
	private JButton cpyToRightBtn;
	private JButton cpyToLeftBtn;
	private JButton compBtn;
	private JTextArea leftTextArea;
	private JTextArea rightTextArea;
	public static int saveOption = 0;
	
	/* Constructor */
	public SimpleMergeController() {
		/* Show View */
		this.frm = SimpleMergeFrame.createFrame();
		/* Link Model */
		this.leftTextArea = this.frm.getLeftTextArea();
		this.rightTextArea = this.frm.getRightTextArea();
		
		/* addEventHandler to JButtons */
		this.leftLoadBtn = this.frm.getLeftLoadBtn();
		this.leftLoadBtn.addActionListener(new LoadEventHandler(leftTextArea, 1));
		this.rightLoadBtn = this.frm.getRightLoadBtn();
		this.rightLoadBtn.addActionListener(new LoadEventHandler(rightTextArea, 2));
		this.editBtn = this.frm.getEditBtn();
		this.editBtn.addActionListener(new EditEventHandler(leftTextArea, rightTextArea));
		this.saveCBox = this.frm.getsaveCBox();
		this.saveCBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				saveOption = saveCBox.getSelectedIndex();
			}
		});
		this.saveBtn = this.frm.getSaveBtn();
		this.saveBtn.addActionListener(new SaveEventHandler(leftTextArea, rightTextArea));
		this.cpyToRightBtn = this.frm.getCpyToRightBtn();
		this.cpyToLeftBtn = this.frm.getCpyToLeftBtn();
		this.compBtn = this.frm.getCompBtn();
		this.compBtn.addActionListener(new CompEventHandler(leftTextArea, rightTextArea));
	}
}
