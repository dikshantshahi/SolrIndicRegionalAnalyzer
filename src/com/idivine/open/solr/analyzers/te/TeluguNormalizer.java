package com.idivine.open.solr.analyzers.te;

/**
 * 
 * @author dsahi
 */
public class TeluguNormalizer {
	public int normalize(char s[], int len) {
		for (int i = 0; i < len; i++) {
			switch (s[i]) {
		      // nukta deletions
					case '\u0C01':
					case '\u0C03':
					case '\u0C3D':
						len = delete(s, i, len);
				        i--;
				        break;
					case '\u0C08':
						s[i]='\u0C07';
						break;
					case '\u0C0A':
						s[i]='\u0C09';
						break;
					case '\u0C0F':
						s[i]='\u0C0E';
						break;
					case '\u0C13':
						s[i]='\u0C12';
						break;
					case '\u0C40':
						s[i]='\u0C3F';
						break;
					case '\u0C42':
						s[i]='\u0C41';
						break;
					case '\u0C44':
						s[i]='\u0C43';
						break;
					case '\u0C47':
						s[i]='\u0C46';
						break;
					case '\u0C4B':
						s[i]='\u0C4A';
						break;
					case '\u0C63':
						s[i]='\u0C62';
						break;
					case '\u0C60':
						s[i]='\u0C0B';
						break;
					case '\u0C61':
						s[i]='\u0C0C';
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
