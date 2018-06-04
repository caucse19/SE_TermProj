package SimpleMerge;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.Highlighter.HighlightPainter;
import java.awt.Color;

public class CompEventHandler implements ActionListener {
	private JTextArea lTextArea;
	private JTextArea rTextArea;
	
	HighlightPainter wrnpainter = 	//Highlight Color Yellow
            new DefaultHighlighter.DefaultHighlightPainter(Color.yellow);
	public CompEventHandler(JTextArea area1, JTextArea area2) {
		this.lTextArea = area1;
		this.rTextArea = area2;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) { 
		
		SimpleMergeController.leftLineNum = -1;
		SimpleMergeController.rightLineNum = -1;
		
		String []lText= null;
		String []rText= null;
		lText = lTextArea.getText().split("\n"); // Make Array of Strings in lTextArea
		rText = rTextArea.getText().split("\n"); // Make Array of Strings in rTextArea
		int lLength = lText.length;
		int rLength = rText.length;
		
		int [] lfixarr = new int[lLength];	//Line index of Solution Line
		int [] rfixarr = new int[rLength];	//Line index of Solution Line
		int fix = 0;						//for new line that will be inserted
		int leftNewLine = 0;				//New Lines(Fake blank)
		int rightNewLine = 0;				//New Lines(Fake blank)
		
		int [][]LCS = new int [lLength+1][rLength+1]; 				
		//Array for Comparing Strings in LCS Algorithm
		String [][]Solution = new String [lLength+1][rLength+1];	
		//Array for Checking Solutions in LCS Algorithm
		
		Highlighter lyhighlighter = lTextArea.getHighlighter();
		Highlighter ryhighlighter = rTextArea.getHighlighter();
		Highlighter ldhighlighter = lTextArea.getHighlighter();
		Highlighter rdhighlighter = rTextArea.getHighlighter();
		
		ldhighlighter.removeAllHighlights();
		rdhighlighter.removeAllHighlights();
		
		/*   LCS Algorithm   */
		for(int i = 0; i < lLength; i++) {
			for(int j = 0; j < rLength; j++) {
				LCS[i][j] = 0;
				Solution[i][j] = null;
			}
		}
		// && lText[a-1].length()!=0
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
		/* LCS Algorithm Finished */
		
		while(Solution[lLength][rLength] != null) {
			if(Solution[lLength][rLength] == "Sol") {
				try {
					int lstart = lTextArea.getLineStartOffset(lLength-1);
				//	int lend = lTextArea.getLineEndOffset(lLength-1);
					int rstart = rTextArea.getLineStartOffset(rLength-1);
				//	int rend = rTextArea.getLineEndOffset(rLength-1);
					
					
					rfixarr[fix] = rTextArea.getLineOfOffset(rstart);
					lfixarr[fix] = lTextArea.getLineOfOffset(lstart);
;
					fix++;
					
				} catch (BadLocationException e1) {
					break;
				}
				lLength--;
				rLength--;
			}
			else if(Solution[lLength][rLength] == "top") {
				try {
					int lstart = lTextArea.getLineStartOffset(lLength-1);
					int lend = lTextArea.getLineEndOffset(lLength-1);
					//System.out.println("top");
					lyhighlighter.addHighlight(lstart - 1, lend, wrnpainter );
				} catch (BadLocationException e1) {
					break;
				}
				lLength--;
			}
			else if(Solution[lLength][rLength] == "left") {
				try {
					int rstart = rTextArea.getLineStartOffset(rLength-1);
					int rend = rTextArea.getLineEndOffset(rLength-1);
					//System.out.println("left");
					ryhighlighter.addHighlight(rstart - 1, rend, wrnpainter );
				} catch (BadLocationException e1) {
					break;
				}
				rLength--;
			}
		}
		
		while(lLength > 0) {
			try {
				int lstart = lTextArea.getLineStartOffset(lLength-1);
				int lend = lTextArea.getLineEndOffset(lLength-1);
				lyhighlighter.addHighlight(lstart, lend, wrnpainter );
			} catch (BadLocationException e1) {
				break;
			}
			//System.out.println("top");
			lLength--;	
		}
		
		while(rLength > 0) {
			try {
				int rstart = rTextArea.getLineStartOffset(rLength-1);
				int rend = rTextArea.getLineEndOffset(rLength-1);
				ryhighlighter.addHighlight(rstart, rend, wrnpainter );
			} catch (BadLocationException e1) {
				break;
			}
			//System.out.println("left");
			rLength--;
		}
	      SimpleMergeController.lbl = new ArrayList<Integer>();
	      SimpleMergeController.rbl = new ArrayList<Integer>();

	      /* Insert New Lines in lTextArea and rTextArea */
	      // Then Check New line Numbers in lbl and rbl(fake blank)
	      for(int i = fix - 1; i >-1; i--) {
	         if(lfixarr[i] + leftNewLine > rfixarr[i] + rightNewLine) {
	            int temp = 0;
	            while(lfixarr[i] + leftNewLine - rfixarr[i] - rightNewLine > 0 ) {
	               try {
	                  rTextArea.insert("\n", rTextArea.getLineStartOffset(rfixarr[i] + rightNewLine));
	                  
	                  //First line value is 0
	                  if (SimpleMergeController.rbl.contains(rfixarr[i] + rightNewLine))
	                     SimpleMergeController.rbl.add(rfixarr[i] + rightNewLine + temp++);
	                  else
	                     temp = 0;
	                  SimpleMergeController.rbl.add(rfixarr[i] + rightNewLine);
	               } catch (BadLocationException e1) {
	                  break;
	               }
	               rightNewLine++;   
	            }
	         }
	         
	         else if(lfixarr[i] + leftNewLine < rfixarr[i] + rightNewLine) {
	            int temp = 0;
	            while(rfixarr[i] + rightNewLine - lfixarr[i] - leftNewLine > 0 ) {
	               try {
	                  lTextArea.insert("\n", lTextArea.getLineStartOffset(lfixarr[i] + leftNewLine));
	                  
	                  //First line value is 0
	                  if (SimpleMergeController.lbl.contains(lfixarr[i] + leftNewLine))
	                     SimpleMergeController.lbl.add(lfixarr[i] + leftNewLine + temp++);
	                  else
	                     temp = 0;
	                  SimpleMergeController.lbl.add(lfixarr[i] + leftNewLine);
	               } catch (BadLocationException e1) {
	                  break;
	               }
	               leftNewLine++;
	            }
	         }

	      }
	      
	      lText = lTextArea.getText().split("\n"); 
	      rText = rTextArea.getText().split("\n"); 
	      if(lText.length> rText.length) {
	    	  int temp = 0;
	    	  for(int i = 0; i < lText.length - rText.length; i++) {
	    		  rTextArea.append("\n\0");
	    	  }
	      }
	      else if (lText.length < rText.length) {
	    	  int temp = 0;
	    	  for(int i = 0; i < rText.length - lText.length; i++) {
	    		  lTextArea.append("\n\0");
	    	  }
	      }
	      /* New Line Inserting Ended */
	}
}
