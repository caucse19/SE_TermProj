package SimpleMerge;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.Highlighter.HighlightPainter;
import java.awt.Color;

public class CompEventHandler implements ActionListener {
	private JTextArea lTextArea;
	private JTextArea rTextArea;
	
	HighlightPainter corpainter = 
            new DefaultHighlighter.DefaultHighlightPainter(Color.white);
	HighlightPainter wrnpainter = 
            new DefaultHighlighter.DefaultHighlightPainter(Color.yellow);
	public CompEventHandler(JTextArea area1, JTextArea area2) {
		this.lTextArea = area1;
		this.rTextArea = area2;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) { // TODO Auto-generated method stub
		
		
		String []lText= null;
		String []rText= null;
		lText = lTextArea.getText().split("\n");
		rText = rTextArea.getText().split("\n");
		int lLength = lText.length;
		int rLength = rText.length;
		int [] lfixarr = new int[lLength];
		int [] rfixarr = new int[rLength];
		int lfix = 0;
		int rfix = 0;
		int [][]LCS = new int [lLength+1][rLength+1]; 
		String [][]Solution = new String [lLength+1][rLength+1];
		//Highlighter lwhighlighter = lTextArea.getHighlighter();
		Highlighter lyhighlighter = lTextArea.getHighlighter();
		//Highlighter rwhighlighter = rTextArea.getHighlighter();
		Highlighter ryhighlighter = rTextArea.getHighlighter();

		for(int i = 0; i < lLength; i++) {
			for(int j = 0; j < rLength; j++) {
				LCS[i][j] = 0;
				Solution[i][j] = null;
			}
		}
		
		
		for(int a = 1; a < lLength+1; a++) {
			for(int b = 1; b < rLength+1; b++) {
				if(lText[a-1].equals(rText[b-1])) {
					LCS[a][b] = LCS[a-1][b-1] + 1;
					Solution[a][b] = "Sol";
				}
				else {
					LCS[a][b] = Math.max(LCS[a][b-1], LCS[a-1][b]);
					
					if(LCS[a][b] == LCS[a-1][b]) {
						Solution[a][b] = "top";
					}
					else {
						Solution[a][b] = "left";
					}
					
				}
			}
		}
		
		
		while(Solution[lLength][rLength] != null) {
			if(Solution[lLength][rLength] == "Sol") {
				try {
					int lstart = lTextArea.getLineStartOffset(lLength-1);
					int lend = lTextArea.getLineEndOffset(lLength-1);
					int rstart = rTextArea.getLineStartOffset(rLength-1);
					int rend = rTextArea.getLineEndOffset(rLength-1);
					//lwhighlighter.addHighlight(lstart, lend, corpainter );
					//rwhighlighter.addHighlight(rstart, rend, corpainter );
					if(lLength > rLength) {
						rfixarr[rfix] = rstart;
						rfix++;
					}
					else if(lLength < rLength) {
						lfixarr[lfix] = lstart;
						lfix++;
					}
				} catch (BadLocationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				lLength--;
				rLength--;
			}
			else if(Solution[lLength][rLength] == "top") {
				try {
					int lstart = lTextArea.getLineStartOffset(lLength-1);
					int lend = lTextArea.getLineEndOffset(lLength-1);
					lyhighlighter.addHighlight(lstart, lend, wrnpainter );
				} catch (BadLocationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println("top");
				lLength--;
			}
			else if(Solution[lLength][rLength] == "left") {
				try {
					int rstart = rTextArea.getLineStartOffset(rLength-1);
					int rend = rTextArea.getLineEndOffset(rLength-1);
					ryhighlighter.addHighlight(rstart, rend, wrnpainter );
				} catch (BadLocationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println("left");
				rLength--;
			}
		}
		while(lLength > 0) {
			try {
				int lstart = lTextArea.getLineStartOffset(lLength-1);
				int lend = lTextArea.getLineEndOffset(lLength-1);
				lyhighlighter.addHighlight(lstart, lend, wrnpainter );
			} catch (BadLocationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("top");
			lLength--;	
		}
		
		while(rLength > 0) {
			try {
				int rstart = rTextArea.getLineStartOffset(rLength-1);
				int rend = rTextArea.getLineEndOffset(rLength-1);
				ryhighlighter.addHighlight(rstart, rend, wrnpainter );
			} catch (BadLocationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("left");
			rLength--;
		}
		
		
		for(int i = 0; i < lfix; i++)
			lTextArea.insert("\n", lfixarr[i]);
		for(int j = 0; j < rfix; j++)
			rTextArea.insert("\n", rfixarr[j]);
		
	}

}