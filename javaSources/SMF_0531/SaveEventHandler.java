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

	private JTextArea textArea, leftTextArea, rightTextArea;

	public SaveEventHandler(JTextArea leftTextArea, JTextArea rightTextArea) {

		this.leftTextArea = leftTextArea;
		this.rightTextArea = rightTextArea;

	}

	@Override
	public void actionPerformed(ActionEvent e) {

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

		// load�ȴ����� left save ��������, ���ο� �޸��� ����
		if (SimpleMergeController.saveOption == 0 && LoadEventHandler.leftFileName != null) {

			file = new File(LoadEventHandler.leftFileName);
			fileName = file.toString();
		}

		// load�ȴ����� right save ��������, ���ο� �޸��� ����
		else if (SimpleMergeController.saveOption == 2 && LoadEventHandler.rightFileName != null) {

			file = new File(LoadEventHandler.rightFileName);
			fileName = file.toString();
		}

		else {

			JFileChooser chooser = new JFileChooser(); // ()�ȿ� path �����Ҽ�����
			chooser.setAcceptAllFileFilterUsed(false); // ���������� ������� �׸� ��뿩�ΰ���
			FileNameExtensionFilter filter = new FileNameExtensionFilter("TXT (*.txt)", "txt");
			chooser.addChoosableFileFilter(filter);
			chooser.setDialogTitle("Save File");
			int result = chooser.showSaveDialog(null);
			if (result == JFileChooser.APPROVE_OPTION) {
				file = chooser.getSelectedFile();
				fileName = file.toString();

				// .txt �Ⱥ��̰� ���������� ����Ͽ���
				if (!fileName.endsWith(".txt") && !fileName.endsWith(".TXT")) {
					fileName += ".txt";
				}

				// �̹� �����ϴ� ������ ���
				file = new File(fileName);
				if (file.exists()) {
					int r = JOptionPane.showConfirmDialog(new Frame(), file.getName() + "��(��) �̹� �ֽ��ϴ�. �ٲٽðڽ��ϱ�?", "����",
							JOptionPane.YES_NO_OPTION);

					if (r == JOptionPane.NO_OPTION) {
						JOptionPane.showMessageDialog(new Frame(), "���");
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

			while ((line = br.readLine()) != null) {
				bw.write(line);
				bw.newLine();
			}

			bw.flush();
			bw.close();

			JOptionPane.showMessageDialog(new Frame(), "���� �Ϸ�");

		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
	}
}
