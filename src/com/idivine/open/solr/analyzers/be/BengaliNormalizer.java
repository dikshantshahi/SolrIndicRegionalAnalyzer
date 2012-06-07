package com.idivine.open.solr.analyzers.be;

/**
 * Class for normalizing the Bengali unicode characters
 * @author dsahi
 */
public class BengaliNormalizer {
	public int normalize(char s[], int len) {
		for (int i = 0; i < len; i++) {
			switch (s[i]) {
				case '\u0981':
				case '\u0982':
				case '\u0983':
				case '\u09BC':
				case '\u09BD':
				case '\u09CE':
				case '\u098D':
				case '\u098E':
				case '\u0991':
				case '\u0992':
				case '\u0984':
				case '\u09E4':
				case '\u09E5':
          len = delete(s, i, len);
          i--;
          break;
				case '\u09C0':
          s[i] = '\u09BF';
          break;
				case '\u09C2':
          s[i] = '\u09C1';
          break;
				case '\u09C4':
          s[i] = '\u09B3';
          break;
				case '\u098A':
          s[i] = '\u0989';
          break;
				case '\u0946':
          s[i] = '\u0945';
          break;
				case '\u0988':
          s[i] = '\u0987';
          break;
				case '\u09E3':
          s[i] = '\u09E1';
          break;
				case '\u09F1':
          s[i] = '\u09F0';
          break;
        default:
          break;
			  }
	    }
		return len;
	}
	
	private int delete(char s[], int pos, int len) {
    if (pos < len) 
      System.arraycopy(s, pos + 1, s, pos, len - pos - 1);
    return len - 1;
	}
}
