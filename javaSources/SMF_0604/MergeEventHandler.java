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
		
		
		int minLength = lLength < rLength ? lLength : rLength;
		int maxLength = lLength > rLength ? lLength : rLength;
		
		int []highlightedLine = new int[maxLength];
		int highlighted = 0;
		int end = -1;
		int begin = -1;

		
		Highlighter lyhighlighter = lTextArea.getHighlighter();
		Highlighter ryhighlighter = rTextArea.getHighlighter();
		Highlighter ldhighlighter = lTextArea.getHighlighter();
		Highlighter rdhighlighter = rTextArea.getHighlighter();

		ldhighlighter.removeAllHighlights();
		rdhighlighter.removeAllHighlights();

		
		/* Check Different Lines */
		for(int i = 0; i < minLength; i++) {
			if(!(lText[i].equals(rText[i]))) {
				highlightedLine[highlighted] = i + 1;
				highlighted++;
			}
		}
		
		/* check Different Lines Ended */
		
		/* check Contiguous Different Lines */
		for (int i = 0; i < highlighted; i++) {
			if ((SimpleMergeController.leftLineNum == highlightedLine[i])
					|| (SimpleMergeController.rightLineNum == highlightedLine[i])) {
				
				begin = i;
				break;
			}
		}


		if(begin == -1) {
			JOptionPane.showMessageDialog(new Frame(), "Wrong Cursor Position");
			/* Highlight Different Lines */
			/* Exception for the Wrong Cursor Position */
			lText = lTextArea.getText().split("\n"); 
			rText = rTextArea.getText().split("\n"); 
			minLength = lText.length < rText.length ? lLength : rLength;
		    for(int i = 0; i < minLength; i++) {
			    if(!(lText[i].equals(rText[i]))) {
			 	   try {
			 			int lstart = lTextArea.getLineStartOffset(i);
						int lend = lTextArea.getLineEndOffset(i);
						int rstart = rTextArea.getLineStartOffset(i);
						int rend = rTextArea.getLineEndOffset(i);
						lyhighlighter.addHighlight(lstart, lend - 1, wrnpainter );
						ryhighlighter.addHighlight(rstart, rend - 1, wrnpainter);
					} catch (BadLocationException e) {
						break;
					}
			   }
		   }


		    /* Highlight Ended */
			return;
		}
		
		while(begin != 0) {
			if(highlightedLine[begin] - highlightedLine[begin - 1] == 1) {
				begin--;
			}
			else {
				break;
			}
		}
		
		end = begin;
		while(end != highlighted - 1) {
			if(highlightedLine[end + 1] - highlightedLine[end] == 1) {
				end++;
			}
			else {
				break;
			}
		}
		/* check Contiguous Different Lines Ended*/

		/* Copy to Right*/
		int cnt = 0;
		
		if(mergeOption == 1) {
			for(int i = 0; i < highlightedLine[begin] - 1; i++) {
				cnt += rText[i].length() + 1;	
			}
			
			for(int i = highlightedLine[begin] - 1; i < highlightedLine[end]; i++) {
				if(i >= rText.length - 1 ) {
					rTextArea.replaceRange(lText[lLength - 1] + "\n", cnt, cnt + rText[rLength-1].length());
				}
				else {
					rTextArea.replaceRange(lText[i] + "\n", cnt, cnt + rText[i].length()+1);
					if(SimpleMergeController.lbl.contains(i))	//add fake blank
						SimpleMergeController.rbl.add(i);		//add fake blank
					}
				
				cnt += lText[i].length() + 1;
			}
			
			
		}
		/* Copy to Right Ended */
	
		
		/* Copy to Left */
		else {
			
			for(int i = 0; i < highlightedLine[begin] - 1; i++) {
				cnt += lText[i].length() + 1;
			}
			for(int i = highlightedLine[begin] - 1; i < highlightedLine[end]; i++) {
				if(i >= lText.length - 1 ) {
					lTextArea.replaceRange(rText[rLength - 1] + "\n", cnt, cnt + lText[lLength-1].length());
				}
				else {
					lTextArea.replaceRange(rText[i] + "\n", cnt, cnt + lText[i].length()+1 );
					if(SimpleMergeController.rbl.contains(i)) 	// add fake blank
						SimpleMergeController.lbl.add(i);		// add fake blank
					
						
				}
				cnt += rText[i].length() + 1;
			}
		}
		
		
		/* Copy to Left Ended */
		
		
		/* Highlight Different Lines */
		lText = lTextArea.getText().split("\n"); // Make Array of Strings in lTextArea again
		rText = rTextArea.getText().split("\n"); // Make Array of Strings in rTextArea again
		minLength = lText.length < rText.length ? lLength : rLength;
	    for(int i = 0; i < minLength; i++) {
		    if(!(lText[i].equals(rText[i]))) {
		 	   try {
		 			int lstart = lTextArea.getLineStartOffset(i);
					int lend = lTextArea.getLineEndOffset(i);
					int rstart = rTextArea.getLineStartOffset(i);
					int rend = rTextArea.getLineEndOffset(i);
					if(i == 0) {
						lyhighlighter.addHighlight(lstart, lend - 1, wrnpainter );
						ryhighlighter.addHighlight(rstart, rend - 1, wrnpainter);
					}
					else {
						lyhighlighter.addHighlight(lstart - 1, lend , wrnpainter );
						ryhighlighter.addHighlight(rstart - 1, rend , wrnpainter);
					}
				} catch (BadLocationException e) {
					break;
				}
		   }
	   }

	    if(lText.length > rText.length) {
	    	for(int i = rText.length ; i < lText.length  ; i++) {
	    		int lstart;
	    		int lend;
				try {
					lstart = lTextArea.getLineStartOffset(i);
					lend = lTextArea.getLineEndOffset(i);
					lyhighlighter.addHighlight(lstart, lend, wrnpainter);
				} catch (BadLocationException e) {
					break;
				}	
				
	    	}
	    }
	    else if(rText.length > lText.length) {
	    	for(int i = lText.length; i < rText.length; i++) {
	    		try {
					int rstart = rTextArea.getLineStartOffset(i);
					int rend = rTextArea.getLineEndOffset(i);
					ryhighlighter.addHighlight(rstart, rend, wrnpainter);
				} catch (BadLocationException e) {
					break;
				}
	    	}
	    
	    }
	    /* Highlight Ended */
	    
	}
}