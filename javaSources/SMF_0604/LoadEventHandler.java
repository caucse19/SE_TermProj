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
	private int loadOption;
	
	public LoadEventHandler(JTextArea area, int loadOption) {
		this.textArea = area;
		this.loadOption = loadOption;
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) { // TODO Auto-generated method stub
		
		SimpleMergeController.leftLineNum = -1;
		SimpleMergeController.rightLineNum = -1;
		
		JFileChooser chooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		FileNameExtensionFilter filter = new FileNameExtensionFilter("TXT (*.txt)", "txt");
		chooser.addChoosableFileFilter(filter);
		chooser.setDialogTitle("Load File");
		int returnVal = chooser.showOpenDialog(chooser);
		if (returnVal == JFileChooser.APPROVE_OPTION) { // 열기를 클릭
			System.out.println(chooser.getSelectedFile().toString());
			File selectedFile = chooser.getSelectedFile();
			String filename = selectedFile.getAbsolutePath();
			
			if(loadOption == 1)
				SimpleMergeController.leftFileName = filename;
			else
				SimpleMergeController.rightFileName = filename;
			
			
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
