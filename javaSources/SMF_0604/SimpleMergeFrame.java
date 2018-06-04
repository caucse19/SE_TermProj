package SimpleMerge;

import java.awt.*;
import javax.swing.*;

public class SimpleMergeFrame {
	private JFrame frm;
	private JPanel mainPanel;
	private JPanel winPanel;
	private JPanel textPanel;
	private JPanel editPanel;
	private JPanel mergePanel;
	private JPanel compPanel;
	private JButton leftLoadBtn;
	private JButton rightLoadBtn;
	private JButton editBtn;
	private JComboBox<String> saveCBox;
	private JButton saveBtn;
	private JButton cpyToRightBtn;
	private JButton cpyToLeftBtn;
	private JButton allCpyToRightBtn;
	private JButton allCpyToLeftBtn;
	private JButton compBtn;
	private JTextArea leftTextArea;
	private JScrollPane leftScroll;
	private JTextArea rightTextArea;
	private JScrollPane rightScroll;
	
	final private String[] saveList = {"left", "left As", "right", "right As"};
	
	static SimpleMergeFrame inst = null;
	public static SimpleMergeFrame createFrame()
	{
		if(inst == null)
			inst = new SimpleMergeFrame();
		
		return inst;
	}

	// Constructor
	private SimpleMergeFrame() {
		createSimpleMerge();
	}

	private void createSimpleMerge() {// MainFrame, MainPanel, WinPanel, TextPanel
		frm = new JFrame("SimpleMerge");
		mainPanel = new JPanel(new BorderLayout());
		winPanel = new JPanel(new FlowLayout());
		textPanel = new JPanel(new GridLayout(1, 2));

		frm.setBounds(500, 200, 1300, 500);

		// WinPanel
		editPanel = new JPanel(new FlowLayout());
		mergePanel = new JPanel(new FlowLayout());
		compPanel = new JPanel(new FlowLayout());
		leftTextArea = new JTextArea(200, 200);
		rightTextArea = new JTextArea(200, 200);
		leftLoadBtn = new JButton("Left Load");
		rightLoadBtn = new JButton("Right Load");
		editBtn = new JButton("Edit");
		saveCBox = new JComboBox<String>(saveList);
		saveBtn = new JButton("Save");
		cpyToRightBtn = new JButton("Copy to Right");
		cpyToLeftBtn = new JButton("Copy to Left");
		allCpyToRightBtn = new JButton("All copy to Right");
		allCpyToLeftBtn = new JButton("All copy to Left");
		compBtn = new JButton("Compare");
		
		editPanel.add(leftLoadBtn);
		editPanel.add(rightLoadBtn);
		editPanel.add(editBtn);
		editPanel.add(saveCBox);
		editPanel.add(saveBtn);
		mergePanel.add(cpyToRightBtn);
		mergePanel.add(cpyToLeftBtn);
		mergePanel.add(allCpyToRightBtn);
		mergePanel.add(allCpyToLeftBtn);
		compPanel.add(compBtn);

		winPanel.add(editPanel);
		winPanel.add(mergePanel);
		winPanel.add(compPanel);

		// TextPanel
		leftScroll = new JScrollPane(leftTextArea);
		rightScroll = new JScrollPane(rightTextArea);

		textPanel.add(leftScroll);
		textPanel.add(rightScroll);

		mainPanel.add(winPanel, BorderLayout.NORTH);
		mainPanel.add(textPanel, BorderLayout.CENTER);
		frm.add(mainPanel);
		frm.setVisible(true);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/* create SimpleMerge window */
	}
	
	/* Gets */
	public JButton getLeftLoadBtn() {
		return this.leftLoadBtn;
	}
	public JButton getRightLoadBtn() {
		return this.rightLoadBtn;
	}
	public JButton getEditBtn() {
		return this.editBtn;
	}
	public JComboBox<String> getsaveCBox() {
		return this.saveCBox;
	}
	public JButton getSaveBtn() {
		return this.saveBtn;
	}
	public JButton getCpyToRightBtn() {
		return this.cpyToRightBtn;
	}
	public JButton getAllCpyToLeftBtn() {
		return this.allCpyToLeftBtn;
	}
	public JButton getAllCpyToRightBtn() {
		return this.allCpyToRightBtn;
	}
	public JButton getCpyToLeftBtn() {
		return this.cpyToLeftBtn;
	}
	public JButton getCompBtn() {
		return this.compBtn;
	}
	public JTextArea getLeftTextArea() {
		return this.leftTextArea;
	}
	public JTextArea getRightTextArea() {
		return this.rightTextArea;
	}
	
}
