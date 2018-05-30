package SimpleMerge;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

public class LoadEventHandler implements ActionListener {
	private JTextArea textArea;
	
	public LoadEventHandler(JTextArea area) {
		this.textArea = area;
	}

	@Override
	public void actionPerformed(ActionEvent e) { // TODO Auto-generated method stub
		JFileChooser chooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		FileNameExtensionFilter filter = new FileNameExtensionFilter("TXT (*.txt)", "txt");
		chooser.addChoosableFileFilter(filter);
		chooser.setDialogTitle("Load File");
		int returnVal = chooser.showOpenDialog(chooser);
		if (returnVal == JFileChooser.APPROVE_OPTION) { // 열기를 클릭
			System.out.println(chooser.getSelectedFile().toString());
			File selectedFile = chooser.getSelectedFile();
			String filename = selectedFile.getAbsolutePath();
			try {
				String str;
				FileReader reader = new FileReader(filename);
				BufferedReader br = new BufferedReader(reader);
				textArea.setText("");
				//textArea.setEditable(false);
				while ((str = br.readLine()) != null) { // while loop begins here
					textArea.append(str + "\n");
				} // end while
				br.close();

			} catch (Exception e1) {
				System.out.println("File Load Error!!!");
			}
		} else if (returnVal == JFileChooser.CANCEL_OPTION) { // 취소를 클릭
			System.out.println("cancel");
		}

	}

}
