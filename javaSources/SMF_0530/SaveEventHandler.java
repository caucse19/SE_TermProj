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
			break;
		}

		File file = null;
		String fileName = null;

		if (SimpleMergeController.saveOption == 0 || SimpleMergeController.saveOption == 2) {
			// 파일위치 찾아서 파일 다시 저장 구현 해야됨@@
			// load 한거 없을때도 예외처리해야함@@
			file = new File("test.txt");
			fileName = file.toString();
		}
		else {
			JFileChooser chooser = new JFileChooser(); // ()안에 path 설정할수있음
			chooser.setAcceptAllFileFilterUsed(false); // 파일유형에 모든파일 항목 사용여부결정
			FileNameExtensionFilter filter = new FileNameExtensionFilter("TXT (*.txt)", "txt");
			chooser.addChoosableFileFilter(filter);
			chooser.setDialogTitle("Save File");
			int result = chooser.showSaveDialog(chooser);
			if (result == JFileChooser.APPROVE_OPTION) {
				file = chooser.getSelectedFile();
				fileName = file.toString();

				// .txt 안붙이고 저장했을때 대비하여서
				if (!fileName.endsWith(".txt") && !fileName.endsWith(".TXT")) {
					fileName += ".txt";
				}

				// 이미 존재하는 파일인 경우
				file = new File(fileName);
				if (file.exists()) {
					int r = JOptionPane.showConfirmDialog(new Frame(), file.getName() + "이(가) 이미 있습니다. 바꾸시겠습니까?", "취소",
							JOptionPane.YES_NO_OPTION);

					if (r == JOptionPane.NO_OPTION) {
						// 다시 save창 실행하는거 구현해야되려나?
						System.out.println("cancel");
						return;
					}
				}

			}
		}

		try {
			String line;
			StringReader content = new StringReader(textArea.getText());
			BufferedWriter fw = new BufferedWriter(new FileWriter(fileName));
			BufferedReader br = new BufferedReader(content);

			while ((line = br.readLine()) != null ){
				fw.write(line);
				fw.newLine();
			}

			fw.flush();
			fw.close();

		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
	}
}
