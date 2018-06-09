/**
 * 
 */
package com.Ex.JUNIT;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LCSTEST {

	@Before 
	public void tes() {
		
		
	}
	@Test
	public void case1() {
	      String[] lText= {"a","b","c"};
	      String[] rText= {"a","b","c"};
	      int lLength = lText.length;
	      int rLength = rText.length;
	      
	      int [][]t = {{0,0,0,0},{0,1,1,1},{0,1,2,2},{0,1,2,3}};
	      int [][]LCS = new int [lLength+1][rLength+1];
	      
	      
	      for(int i = 0; i < lLength; i++) {
	         for(int j = 0; j < rLength; j++) {
	            LCS[i][j] = 0;
	           
	         }
	      }
	      // && lText[a-1].length()!=0
	      for(int a = 1; a < lLength+1; a++) {
	         for(int b = 1; b < rLength+1; b++) {
	            if(lText[a-1].equals(rText[b-1])) {
	               LCS[a][b] = LCS[a-1][b-1] + 1;
	            }
	            else {
	               LCS[a][b] = Math.max(LCS[a][b-1], LCS[a-1][b]);
	            }
	         }
	      }
	   Assert.assertArrayEquals(t,LCS);
	      
	   }
	@Test
	public void case2() {
	      String[] lText= {"a","b","c"};
	      String[] rText= {"d","b","c"};
	      int lLength = lText.length;
	      int rLength = rText.length;
	      
	      int [][]t = {{0,0,0,0},{0,0,0,0},{0,0,1,1},{0,0,1,2}};
	      int [][]LCS = new int [lLength+1][rLength+1];
	      
	      
	      for(int i = 0; i < lLength; i++) {
	         for(int j = 0; j < rLength; j++) {
	            LCS[i][j] = 0;
	           
	         }
	      }
	      // && lText[a-1].length()!=0
	      for(int a = 1; a < lLength+1; a++) {
	         for(int b = 1; b < rLength+1; b++) {
	            if(lText[a-1].equals(rText[b-1])) {
	               LCS[a][b] = LCS[a-1][b-1] + 1;
	            }
	            else {
	               LCS[a][b] = Math.max(LCS[a][b-1], LCS[a-1][b]);
	            }
	         }
	      }
	   Assert.assertArrayEquals(t,LCS);
	      
	   }
	@Test
	public void case3() {
	      String[] lText= {"a","b","c"};
	      String[] rText= {"a","d","c"};
	      int lLength = lText.length;
	      int rLength = rText.length;
	      
	      int [][]t = {{0,0,0,0},{0,1,1,1},{0,1,1,1},{0,1,1,2}};
	      int [][]LCS = new int [lLength+1][rLength+1];
	      
	      
	      for(int i = 0; i < lLength; i++) {
	         for(int j = 0; j < rLength; j++) {
	            LCS[i][j] = 0;
	           
	         }
	      }
	      // && lText[a-1].length()!=0
	      for(int a = 1; a < lLength+1; a++) {
	         for(int b = 1; b < rLength+1; b++) {
	            if(lText[a-1].equals(rText[b-1])) {
	               LCS[a][b] = LCS[a-1][b-1] + 1;
	            }
	            else {
	               LCS[a][b] = Math.max(LCS[a][b-1], LCS[a-1][b]);
	            }
	         }
	      }
	   Assert.assertArrayEquals(t,LCS);
	      
	   }
	@Test
	public void case4() {
	      String[] lText= {"a","b","c"};
	      String[] rText= {"a","b","d"};
	      int lLength = lText.length;
	      int rLength = rText.length;
	      
	      int [][]t = {{0,0,0,0},{0,1,1,1},{0,1,2,2},{0,1,2,2}};
	      int [][]LCS = new int [lLength+1][rLength+1];
	      
	      
	      for(int i = 0; i < lLength; i++) {
	         for(int j = 0; j < rLength; j++) {
	            LCS[i][j] = 0;
	           
	         }
	      }
	      
	      // && lText[a-1].length()!=0
	      for(int a = 1; a < lLength+1; a++) {
	         for(int b = 1; b < rLength+1; b++) {
	            if(lText[a-1].equals(rText[b-1])) {
	               LCS[a][b] = LCS[a-1][b-1] + 1;
	            }
	            else {
	               LCS[a][b] = Math.max(LCS[a][b-1], LCS[a-1][b]);
	            }
	         }
	      }
	   Assert.assertArrayEquals(t,LCS);
	      
	   }
	@Test
	public void case5() {
	      String[] lText= {"a","b","c"};
	      String[] rText= {"\n","b","c"};
	      int lLength = lText.length;
	      int rLength = rText.length;
	      
	      int [][]t = {{0,0,0,0},{0,0,0,0},{0,0,1,1},{0,0,1,2}};
	      int [][]LCS = new int [lLength+1][rLength+1];
	      
	      
	      for(int i = 0; i < lLength; i++) {
	         for(int j = 0; j < rLength; j++) {
	            LCS[i][j] = 0;
	           
	         }
	      }
	      // && lText[a-1].length()!=0
	      for(int a = 1; a < lLength+1; a++) {
	         for(int b = 1; b < rLength+1; b++) {
	            if(lText[a-1].equals(rText[b-1])) {
	               LCS[a][b] = LCS[a-1][b-1] + 1;
	            }
	            else {
	               LCS[a][b] = Math.max(LCS[a][b-1], LCS[a-1][b]);
	            }
	         }
	      }
	   Assert.assertArrayEquals(t,LCS);
	      
	   }
	@Test
	public void case6() {
	      String[] lText= {"a","b","c"};
	      String[] rText= {"a","\n","c"};
	      int lLength = lText.length;
	      int rLength = rText.length;
	      
	      int [][]t = {{0,0,0,0},{0,1,1,1},{0,1,1,1},{0,1,1,2}};
	      int [][]LCS = new int [lLength+1][rLength+1];
	      
	      
	      for(int i = 0; i < lLength; i++) {
	         for(int j = 0; j < rLength; j++) {
	            LCS[i][j] = 0;
	           
	         }
	      }
	      // && lText[a-1].length()!=0
	      for(int a = 1; a < lLength+1; a++) {
	         for(int b = 1; b < rLength+1; b++) {
	            if(lText[a-1].equals(rText[b-1])) {
	               LCS[a][b] = LCS[a-1][b-1] + 1;
	            }
	            else {
	               LCS[a][b] = Math.max(LCS[a][b-1], LCS[a-1][b]);
	            }
	         }
	      }
	   Assert.assertArrayEquals(t,LCS);
	      
	   }
	@Test
	public void case7() {
	      String[] lText= {"a","b","c"};
	      String[] rText= {"a","b","\n"};
	      int lLength = lText.length;
	      int rLength = rText.length;
	      
	      int [][]t = {{0,0,0,0},{0,1,1,1},{0,1,2,2},{0,1,2,2}};
	      int [][]LCS = new int [lLength+1][rLength+1];
	      
	      
	      for(int i = 0; i < lLength; i++) {
	         for(int j = 0; j < rLength; j++) {
	            LCS[i][j] = 0;
	           
	         }
	      }
	      // && lText[a-1].length()!=0
	      for(int a = 1; a < lLength+1; a++) {
	         for(int b = 1; b < rLength+1; b++) {
	            if(lText[a-1].equals(rText[b-1])) {
	               LCS[a][b] = LCS[a-1][b-1] + 1;
	            }
	            else {
	               LCS[a][b] = Math.max(LCS[a][b-1], LCS[a-1][b]);
	            }
	         }
	      }
	   Assert.assertArrayEquals(t,LCS);
	      
	   }
	@Test
	public void case8() {
	      String[] lText= {"a","b","c"};
	      String[] rText= {"d","\n","c"};
	      int lLength = lText.length;
	      int rLength = rText.length;
	      
	      int [][]t = {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,1}};
	      int [][]LCS = new int [lLength+1][rLength+1];
	      
	      
	      for(int i = 0; i < lLength; i++) {
	         for(int j = 0; j < rLength; j++) {
	            LCS[i][j] = 0;
	           
	         }
	      }
	      // && lText[a-1].length()!=0
	      for(int a = 1; a < lLength+1; a++) {
	         for(int b = 1; b < rLength+1; b++) {
	            if(lText[a-1].equals(rText[b-1])) {
	               LCS[a][b] = LCS[a-1][b-1] + 1;
	            }
	            else {
	               LCS[a][b] = Math.max(LCS[a][b-1], LCS[a-1][b]);
	            }
	         }
	      }
	   Assert.assertArrayEquals(t,LCS);
	      
	   }
	@Test
	public void case9() {
	      String[] lText= {"a","b","c"};
	      String[] rText= {"d","b","\n"};
	      int lLength = lText.length;
	      int rLength = rText.length;
	      
	      int [][]t = {{0,0,0,0},{0,0,0,0},{0,0,1,1},{0,0,1,1}};
	      int [][]LCS = new int [lLength+1][rLength+1];
	      
	      
	      for(int i = 0; i < lLength; i++) {
	         for(int j = 0; j < rLength; j++) {
	            LCS[i][j] = 0;
	           
	         }
	      }
	      // && lText[a-1].length()!=0
	      for(int a = 1; a < lLength+1; a++) {
	         for(int b = 1; b < rLength+1; b++) {
	            if(lText[a-1].equals(rText[b-1])) {
	               LCS[a][b] = LCS[a-1][b-1] + 1;
	            }
	            else {
	               LCS[a][b] = Math.max(LCS[a][b-1], LCS[a-1][b]);
	            }
	         }
	      }
	   Assert.assertArrayEquals(t,LCS);
	      
	   }
	@Test
	public void case10() {
	      String[] lText= {"a","b","c"};
	      String[] rText= {"a","d","\n"};
	      int lLength = lText.length;
	      int rLength = rText.length;
	      
	      int [][]t = {{0,0,0,0},{0,1,1,1},{0,1,1,1},{0,1,1,1}};
	      int [][]LCS = new int [lLength+1][rLength+1];
	      
	      
	      for(int i = 0; i < lLength; i++) {
	         for(int j = 0; j < rLength; j++) {
	            LCS[i][j] = 0;
	           
	         }
	      }
	      // && lText[a-1].length()!=0
	      for(int a = 1; a < lLength+1; a++) {
	         for(int b = 1; b < rLength+1; b++) {
	            if(lText[a-1].equals(rText[b-1])) {
	               LCS[a][b] = LCS[a-1][b-1] + 1;
	            }
	            else {
	               LCS[a][b] = Math.max(LCS[a][b-1], LCS[a-1][b]);
	            }
	         }
	      }
	   Assert.assertArrayEquals(t,LCS);
	      
	   }
	@Test
	public void case11() {
	      String[] lText= {"a","b","c"};
	      String[] rText= {"\n","d","c"};
	      int lLength = lText.length;
	      int rLength = rText.length;
	      
	      int [][]t = {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,1}};
	      int [][]LCS = new int [lLength+1][rLength+1];
	      
	      
	      for(int i = 0; i < lLength; i++) {
	         for(int j = 0; j < rLength; j++) {
	            LCS[i][j] = 0;
	           
	         }
	      }
	      // && lText[a-1].length()!=0
	      for(int a = 1; a < lLength+1; a++) {
	         for(int b = 1; b < rLength+1; b++) {
	            if(lText[a-1].equals(rText[b-1])) {
	               LCS[a][b] = LCS[a-1][b-1] + 1;
	            }
	            else {
	               LCS[a][b] = Math.max(LCS[a][b-1], LCS[a-1][b]);
	            }
	         }
	      }
	   Assert.assertArrayEquals(t,LCS);
	      
	   }
	@Test
	public void case12() {
	      String[] lText= {"a","b","c"};
	      String[] rText= {"\n","b","d"};
	      int lLength = lText.length;
	      int rLength = rText.length;
	      
	      int [][]t = {{0,0,0,0},{0,0,0,0},{0,0,1,1},{0,0,1,1}};
	      int [][]LCS = new int [lLength+1][rLength+1];
	      
	      
	      for(int i = 0; i < lLength; i++) {
	         for(int j = 0; j < rLength; j++) {
	            LCS[i][j] = 0;
	           
	         }
	      }
	      // && lText[a-1].length()!=0
	      for(int a = 1; a < lLength+1; a++) {
	         for(int b = 1; b < rLength+1; b++) {
	            if(lText[a-1].equals(rText[b-1])) {
	               LCS[a][b] = LCS[a-1][b-1] + 1;
	            }
	            else {
	               LCS[a][b] = Math.max(LCS[a][b-1], LCS[a-1][b]);
	            }
	         }
	      }
	   Assert.assertArrayEquals(t,LCS);
	      
	   }
	@Test
	public void case13() {
	      String[] lText= {"a","b","c"};
	      String[] rText= {"a","\n","d"};
	      int lLength = lText.length;
	      int rLength = rText.length;
	      
	      int [][]t = {{0,0,0,0},{0,1,1,1},{0,1,1,1},{0,1,1,1}};
	      int [][]LCS = new int [lLength+1][rLength+1];
	      
	      
	      for(int i = 0; i < lLength; i++) {
	         for(int j = 0; j < rLength; j++) {
	            LCS[i][j] = 0;
	           
	         }
	      }
	      // && lText[a-1].length()!=0
	      for(int a = 1; a < lLength+1; a++) {
	         for(int b = 1; b < rLength+1; b++) {
	            if(lText[a-1].equals(rText[b-1])) {
	               LCS[a][b] = LCS[a-1][b-1] + 1;
	            }
	            else {
	               LCS[a][b] = Math.max(LCS[a][b-1], LCS[a-1][b]);
	            }
	         }
	      }
	   Assert.assertArrayEquals(t,LCS);
	      
	   }
	@Test
	public void case14() {
	      String[] lText= {"a","b","c"};
	      String[] rText= {"d","e","f"};
	      int lLength = lText.length;
	      int rLength = rText.length;
	      
	      int [][]t = {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
	      int [][]LCS = new int [lLength+1][rLength+1];
	      
	      
	      for(int i = 0; i < lLength; i++) {
	         for(int j = 0; j < rLength; j++) {
	            LCS[i][j] = 0;
	           
	         }
	      }
	      // && lText[a-1].length()!=0
	      for(int a = 1; a < lLength+1; a++) {
	         for(int b = 1; b < rLength+1; b++) {
	            if(lText[a-1].equals(rText[b-1])) {
	               LCS[a][b] = LCS[a-1][b-1] + 1;
	            }
	            else {
	               LCS[a][b] = Math.max(LCS[a][b-1], LCS[a-1][b]);
	            }
	         }
	      }
	   Assert.assertArrayEquals(t,LCS);
	      
	   }
	@Test
	public void case15() {
	      String[] lText= {"a","b","c"};
	      String[] rText= {"a","d","f"};
	      int lLength = lText.length;
	      int rLength = rText.length;
	      
	      int [][]t = {{0,0,0,0},{0,1,1,1},{0,1,1,1},{0,1,1,1}};
	      int [][]LCS = new int [lLength+1][rLength+1];
	      
	      
	      for(int i = 0; i < lLength; i++) {
	         for(int j = 0; j < rLength; j++) {
	            LCS[i][j] = 0;
	           
	         }
	      }
	      // && lText[a-1].length()!=0
	      for(int a = 1; a < lLength+1; a++) {
	         for(int b = 1; b < rLength+1; b++) {
	            if(lText[a-1].equals(rText[b-1])) {
	               LCS[a][b] = LCS[a-1][b-1] + 1;
	            }
	            else {
	               LCS[a][b] = Math.max(LCS[a][b-1], LCS[a-1][b]);
	            }
	         }
	      }
	   Assert.assertArrayEquals(t,LCS);
	      
	   }
	@Test
	public void case16() {
	      String[] lText= {"a","b","c"};
	      String[] rText= {"d","b","f"};
	      int lLength = lText.length;
	      int rLength = rText.length;
	      
	      int [][]t = {{0,0,0,0},{0,0,0,0},{0,0,1,1},{0,0,1,1}};
	      int [][]LCS = new int [lLength+1][rLength+1];
	      
	      
	      for(int i = 0; i < lLength; i++) {
	         for(int j = 0; j < rLength; j++) {
	            LCS[i][j] = 0;
	           
	         }
	      }
	      // && lText[a-1].length()!=0
	      for(int a = 1; a < lLength+1; a++) {
	         for(int b = 1; b < rLength+1; b++) {
	            if(lText[a-1].equals(rText[b-1])) {
	               LCS[a][b] = LCS[a-1][b-1] + 1;
	            }
	            else {
	               LCS[a][b] = Math.max(LCS[a][b-1], LCS[a-1][b]);
	            }
	         }
	      }
	   Assert.assertArrayEquals(t,LCS);
	      
	   }
	@Test
	public void case17() {
	      String[] lText= {"a","b","c"};
	      String[] rText= {"d","f","c"};
	      int lLength = lText.length;
	      int rLength = rText.length;
	      
	      int [][]t = {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,1}};
	      int [][]LCS = new int [lLength+1][rLength+1];
	      
	      
	      for(int i = 0; i < lLength; i++) {
	         for(int j = 0; j < rLength; j++) {
	            LCS[i][j] = 0;
	           
	         }
	      }
	      // && lText[a-1].length()!=0
	      for(int a = 1; a < lLength+1; a++) {
	         for(int b = 1; b < rLength+1; b++) {
	            if(lText[a-1].equals(rText[b-1])) {
	               LCS[a][b] = LCS[a-1][b-1] + 1;
	            }
	            else {
	               LCS[a][b] = Math.max(LCS[a][b-1], LCS[a-1][b]);
	            }
	         }
	      }
	   Assert.assertArrayEquals(t,LCS);
	      
	   }
	@Test
	public void case18() {
	      String[] lText= {"a","b","c"};
	      String[] rText= {"d","f","\n"};
	      int lLength = lText.length;
	      int rLength = rText.length;
	      
	      int [][]t = {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
	      int [][]LCS = new int [lLength+1][rLength+1];
	      
	      
	      for(int i = 0; i < lLength; i++) {
	         for(int j = 0; j < rLength; j++) {
	            LCS[i][j] = 0;
	           
	         }
	      }
	      // && lText[a-1].length()!=0
	      for(int a = 1; a < lLength+1; a++) {
	         for(int b = 1; b < rLength+1; b++) {
	            if(lText[a-1].equals(rText[b-1])) {
	               LCS[a][b] = LCS[a-1][b-1] + 1;
	            }
	            else {
	               LCS[a][b] = Math.max(LCS[a][b-1], LCS[a-1][b]);
	            }
	         }
	      }
	   Assert.assertArrayEquals(t,LCS);
	      
	   }
	@Test
	public void case19() {
	      String[] lText= {"a","b","c"};
	      String[] rText= {"d","\n","f"};
	      int lLength = lText.length;
	      int rLength = rText.length;
	      
	      int [][]t = {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
	      int [][]LCS = new int [lLength+1][rLength+1];
	      
	      
	      for(int i = 0; i < lLength; i++) {
	         for(int j = 0; j < rLength; j++) {
	            LCS[i][j] = 0;
	           
	         }
	      }
	      // && lText[a-1].length()!=0
	      for(int a = 1; a < lLength+1; a++) {
	         for(int b = 1; b < rLength+1; b++) {
	            if(lText[a-1].equals(rText[b-1])) {
	               LCS[a][b] = LCS[a-1][b-1] + 1;
	            }
	            else {
	               LCS[a][b] = Math.max(LCS[a][b-1], LCS[a-1][b]);
	            }
	         }
	      }
	   Assert.assertArrayEquals(t,LCS);
	      
	   }
	@Test
	public void case20() {
	      String[] lText= {"a","b","c"};
	      String[] rText= {"\n","d","f"};
	      int lLength = lText.length;
	      int rLength = rText.length;
	      
	      int [][]t = {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
	      int [][]LCS = new int [lLength+1][rLength+1];
	      
	      
	      for(int i = 0; i < lLength; i++) {
	         for(int j = 0; j < rLength; j++) {
	            LCS[i][j] = 0;
	           
	         }
	      }
	      // && lText[a-1].length()!=0
	      for(int a = 1; a < lLength+1; a++) {
	         for(int b = 1; b < rLength+1; b++) {
	            if(lText[a-1].equals(rText[b-1])) {
	               LCS[a][b] = LCS[a-1][b-1] + 1;
	            }
	            else {
	               LCS[a][b] = Math.max(LCS[a][b-1], LCS[a-1][b]);
	            }
	         }
	      }
	   Assert.assertArrayEquals(t,LCS);
	      
	   }
	

}
