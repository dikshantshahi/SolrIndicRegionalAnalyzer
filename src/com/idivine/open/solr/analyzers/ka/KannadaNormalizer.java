package com.idivine.open.solr.analyzers.ka;

/**
 *
 * @author dsahi
 */
public class KannadaNormalizer {
	public int normalize(char s[], int len) {
		for (int i = 0; i < len; i++) {
			switch (s[i]) {
		      // nukta deletions
			 // case '\u0C82':is imp dont remove 'anusvara'
				case '\u0C83':
				case '\u0CBC':
				case '\u0CBD':
			//	case '\u0CCD': 'virama'
					len = delete(s, i, len);
			        i--;
			        break;
				case '\u0C88':
					s[i] = '\u0C87';
					break;
				case '\u0C8A':
					s[i] = '\u0C89';
					break;
				case '\u0C8F':
					s[i] = '\u0C8E';
					break;
				case '\u0C93':
					s[i] = '\u0C92';
					break;
				case '\u0CC0':
					s[i] = '\u0CBF';
					break;
				case '\u0CC2':
					s[i] = '\u0CC1';
					break;
				case '\u0CC4':
					s[i] = '\u0CC3';
					break;
				case '\u0CC7':
					s[i] = '\u0CC6';
					break;
				case '\u0CCB':
					s[i] = '\u0CCA';
					break;
				case '\u0CE3':
					s[i] = '\u0CE2';
					break;
				case '\u0CB1':
					s[i] = '\u0CB0';
					break;
				case '\u0CE0':
					s[i]='\u0C8B';
				case '\u0CE1':
					s[i]='\u0C8C';
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
