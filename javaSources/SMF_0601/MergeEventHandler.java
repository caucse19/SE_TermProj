package SimpleMerge;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.Highlighter.HighlightPainter;

public class MergeEventHandler implements ActionListener {

	private int mergeOption;
	private JTextArea lTextArea, rTextArea;
	HighlightPainter wrnpainter = // Highlight Color Yellow
			new DefaultHighlighter.DefaultHighlightPainter(Color.yellow);

	public MergeEventHandler(JTextArea leftTextArea, JTextArea rightTextArea, int mergeOption) {
		lTextArea = leftTextArea;
		rTextArea = rightTextArea;
		this.mergeOption = mergeOption;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String[] lText = null;
		String[] rText = null;
		lText = lTextArea.getText().split("\n"); // Make Array of Strings in lTextArea
		rText = rTextArea.getText().split("\n"); // Make Array of Strings in rTextArea
		int lLength = lText.length;
		int rLength = rText.length;

		int[] lhighlightedLine = new int[lLength];
		int[] rhighlightedLine = new int[rLength];
		int lhighlighted = 0;
		int rhighlighted = 0;

		int end = -1;
		int begin = -1;
		int zeroCount = 0;

		int[][] LCS = new int[lLength + 1][rLength + 1];
		// Array for Comparing Strings in LCS Algorithm
		String[][] Solution = new String[lLength + 1][rLength + 1];
		// Array for Checking Solutions in LCS Algorithm

		Highlighter lyhighlighter = lTextArea.getHighlighter();
		Highlighter ryhighlighter = rTextArea.getHighlighter();
		Highlighter ldhighlighter = lTextArea.getHighlighter();
		Highlighter rdhighlighter = rTextArea.getHighlighter();

		ldhighlighter.removeAllHighlights();
		rdhighlighter.removeAllHighlights();

		/* Use LCS Algorithm to find different lines */
		for (int i = 0; i < lLength; i++) {
			for (int j = 0; j < rLength; j++) {
				LCS[i][j] = 0;
				Solution[i][j] = null;
			}
		}

		for (int a = 1; a < lLength + 1; a++) {
			for (int b = 1; b < rLength + 1; b++) {
				if (lText[a - 1].equals(rText[b - 1])) {
					LCS[a][b] = LCS[a - 1][b - 1] + 1;
					Solution[a][b] = "Sol";
				} else {
					LCS[a][b] = Math.max(LCS[a][b - 1], LCS[a - 1][b]);

					if (LCS[a][b] == LCS[a - 1][b]) {
						Solution[a][b] = "top";
					} else {
						Solution[a][b] = "left";
					}
				}
			}
		}
		/* LCS Algorithm Finished */

		/* Save different line numbers in Array */
		while (Solution[lLength][rLength] != null) {
			if (Solution[lLength][rLength] == "Sol") {
				try {
					int lstart = lTextArea.getLineStartOffset(lLength - 1);
					int rstart = rTextArea.getLineStartOffset(rLength - 1);
				} catch (BadLocationException e1) {
					break;
				}
				lLength--;
				rLength--;
			} else if (Solution[lLength][rLength] == "top") {
				try {
					int lstart = lTextArea.getLineStartOffset(lLength - 1);
					int lend = lTextArea.getLineEndOffset(lLength - 1);
					lyhighlighter.addHighlight(lstart - 1, lend, wrnpainter);
					lhighlightedLine[lhighlighted] = lLength;
					lhighlighted++;
				} catch (BadLocationException e1) {
					break;
				}
				lLength--;
			} else if (Solution[lLength][rLength] == "left") {
				try {
					int rstart = rTextArea.getLineStartOffset(rLength - 1);
					int rend = rTextArea.getLineEndOffset(rLength - 1);
					ryhighlighter.addHighlight(rstart - 1, rend, wrnpainter);
					rhighlightedLine[rhighlighted] = rLength;
					rhighlighted++;
				} catch (BadLocationException e1) {
					break;
				}
				rLength--;
			}
		}

		while (lLength > 0) {
			try {
				int lstart = lTextArea.getLineStartOffset(lLength - 1);
				int lend = lTextArea.getLineEndOffset(lLength - 1);
				lyhighlighter.addHighlight(lstart, lend, wrnpainter);
				lhighlightedLine[lhighlighted] = lLength;
				lhighlighted++;
			} catch (BadLocationException e1) {
				break;
			}
			lLength--;
		}

		while (rLength > 0) {
			try {
				int rstart = rTextArea.getLineStartOffset(rLength - 1);
				int rend = rTextArea.getLineEndOffset(rLength - 1);
				ryhighlighter.addHighlight(rstart, rend, wrnpainter);
				rhighlightedLine[rhighlighted] = rLength;
				rhighlighted++;
			} catch (BadLocationException e1) {
				break;
			}
			rLength--;
		}
		
		for(int i = 0; i < lhighlightedLine.length; i++) {
			if(lhighlightedLine[i] == 0) {
				zeroCount++;
			}
		}
		
		for (int i = 0; i < lhighlightedLine.length - zeroCount; i++) {
			if ((SimpleMergeController.leftLineNum == lhighlightedLine[i])
					|| (SimpleMergeController.rightLineNum == lhighlightedLine[i])) {
				end = i;
				break;
			}
		}

		if(end == -1) {
			JOptionPane.showMessageDialog(new Frame(), "커서 위치가 올바르지 않습니다.");
			return;
		}

		while (end != 0) {
			if (lhighlightedLine[end - 1] - lhighlightedLine[end] == 1) {
				end--;
			} else {
				break;
			}
		}
		
		begin = end;
		while(begin != lhighlightedLine.length - zeroCount - 1) {
			if(lhighlightedLine[begin] - lhighlightedLine[begin + 1] == 1) {
				begin++;
			}
			else {
				break;
			}
		}
		
		
		if(mergeOption == 1) {
			rTextArea.replaceRange(lText[6], 6, 8);
		}
//			for(int i = lhighlightedLine[begin] - 1; i < lhighlightedLine[end]; i++) {
//				rTextArea.replaceRange(lText[i], i, i+1);
//			}
//		}
		else {
			for(int i = lhighlightedLine[begin] - 1; i < lhighlightedLine[end]; i++) {
				lTextArea.append(rText[i] + "\n");
			}
		}
		
	}
}