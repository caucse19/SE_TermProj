package SimpleMerge;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.StringReader;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

public class SaveEventHandler implements ActionListener {

	private JTextArea textArea;
	private JTextArea leftTextArea;
	private JTextArea rightTextArea;

	public SaveEventHandler(JTextArea leftTextArea, JTextArea rightTextArea) {
		this.leftTextArea = leftTextArea;
		this.rightTextArea = rightTextArea;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		SimpleMergeController.leftLineNum = -1;
		SimpleMergeController.rightLineNum = -1;

		switch (SimpleMergeController.saveOption) {
		case 0:
		case 1:
			textArea = leftTextArea;
			break;
		case 2:
		case 3:
			textArea = rightTextArea;
		}

		File file = null;
		String fileName = null;

		/* push "left save" */
		if (SimpleMergeController.saveOption == 0 && SimpleMergeController.leftFileName != null) {
			file = new File(SimpleMergeController.leftFileName);
			fileName = file.toString();
		}

		/* push "right save" */
		else if (SimpleMergeController.saveOption == 2 && SimpleMergeController.rightFileName != null) {
			file = new File(SimpleMergeController.rightFileName);
			fileName = file.toString();
		}

		else {
			JFileChooser chooser = new JFileChooser();
			chooser.setAcceptAllFileFilterUsed(false);
			FileNameExtensionFilter filter = new FileNameExtensionFilter("TXT (*.txt)", "txt");
			chooser.addChoosableFileFilter(filter);
			chooser.setDialogTitle("Save File");
			int result = chooser.showSaveDialog(null);
			
			if (result == JFileChooser.APPROVE_OPTION) {
				file = chooser.getSelectedFile();
				fileName = file.toString();

				/* When not appending ".txt" and save  */
				if (!fileName.endsWith(".txt") && !fileName.endsWith(".TXT")) {
					fileName += ".txt";
				}

				/* When a file with the same name exists */
				file = new File(fileName);
				if (file.exists()) {
					int r = JOptionPane.showConfirmDialog(new Frame(), file.getName() + " is already exist. overwrite?", "Save",
							JOptionPane.YES_NO_OPTION);
					if (r == JOptionPane.NO_OPTION) {
						JOptionPane.showMessageDialog(new Frame(), "Cancel");
						return;
					}
				}

			}

			else {
				return;
			}

		}

		try {
			String line;
			StringReader content = new StringReader(textArea.getText());
			BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
			BufferedReader br = new BufferedReader(content);
			int check = -1;
			if(SimpleMergeController.compOption!=0) {
				while ((line = br.readLine()) != null) {
					check++;
					if((SimpleMergeController.saveOption == 0 || SimpleMergeController.saveOption == 1) && SimpleMergeController.lbl.contains(check))
						continue;
					else if((SimpleMergeController.saveOption == 2 || SimpleMergeController.saveOption == 3) &&SimpleMergeController.rbl.contains(check))
						continue;
					bw.write(line);
					bw.newLine();
				}
			}
			else {
				while ((line = br.readLine()) != null) {
					check++;
					bw.write(line);
					bw.newLine();
				}
			}
			bw.flush();
			bw.close();
			JOptionPane.showMessageDialog(new Frame(), "Save Complete");

		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
	}
}
