package com.kudanai.thaanadroid;

/**
 * utility class to aid conversion of characters
 * @author kudanai
 */
public class ThaanaUtils {

	/**
	 * transposes a string of characters to the thaana equivalent
	 * 
	 * @param s String to transpose
	 * @return
	 */
	public String transposeChars(String s){
		String newStr=s;
		for(int i=0;i<s.length();i++){
			char toSub=s.charAt(i);
			newStr=newStr.replace(toSub, getTransposeForChar(toSub));
		}
		return newStr;
	}
	
	/**
	 * will convert CharSequence to a String and perform the 
	 * transpose operation.
	 * 
	 * @param s is a CharSequence.. 
	 * @return String..oops
	 */
	public String transposeChars(CharSequence s){
		return transposeChars(s.toString());
	}
	
	
	/**
	 * Returns the corrosponding Thaana character to a char
	 * based on the Phonetic keyboard
	 * 
	 * @param c
	 * @return the transposed char
	 */
	public char getTransposeForChar(char c){
		//TODO: use unicode escapes to be safer
		switch(c){
			case 'q': return 'ް';
			case 'w': return 'އ';
			case 'e': return 'ެ';
			case 'r': return 'ރ';
			case 't': return 'ތ';
			case 'y': return 'ޔ';
			case 'u': return 'ު';
			case 'i': return 'ި';
			case 'o': return 'ޮ';
			case 'p': return 'ޕ';
			case 'a': return 'ަ';
			case 's': return 'ސ';
			case 'd': return 'ދ';
			case 'f': return 'ފ';
			case 'g': return 'ގ';
			case 'h': return 'ހ';
			case 'j': return 'ޖ';
			case 'k': return 'ކ';
			case 'l': return 'ލ';
			case 'z': return 'ޒ';
			case 'x': return '×';
			case 'c': return 'ޗ';
			case 'v': return 'ވ';
			case 'b': return 'ބ';
			case 'n': return 'ނ';
			case 'm': return 'މ';
			case 'Q': return 'ޤ';
			case 'W': return 'ޢ';
			case 'E': return 'ޭ';
			case 'R': return 'ޜ';
			case 'T': return 'ޓ';
			case 'Y': return 'ޠ';
			case 'U': return 'ޫ';
			case 'I': return 'ީ';
			case 'O': return 'ޯ';
			case 'P': return '÷';
			case 'A': return 'ާ';
			case 'S': return 'ށ';
			case 'D': return 'ޑ';
			case 'F': return 'ﷲ';
			case 'G': return 'ޣ';
			case 'H': return 'ޙ';
			case 'J': return 'ޛ';
			case 'K': return 'ޚ';
			case 'L': return 'ޅ';
			case 'Z': return 'ޡ';
			case 'X': return 'ޘ';
			case 'C': return 'ޝ';
			case 'V': return 'ޥ';
			case 'B': return 'ޞ';
			case 'N': return 'ޏ';
			case 'M': return 'ޟ';
			default: return c;
		}
	} //getTransposeForChar
}
