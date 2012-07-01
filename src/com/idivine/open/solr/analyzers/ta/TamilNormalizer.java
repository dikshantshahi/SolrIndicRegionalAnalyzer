package com.idivine.open.solr.analyzers.ta;

/**
 *
 * @author dsahi
 */
public class TamilNormalizer {
	public int normalize(char s[], int len) {
		for (int i = 0; i < len; i++) {
			switch (s[i]) {
		      // nukta deletions
					case '\u0B83':  
						len = delete(s, i, len);
				        i--;
				        break;
					case '\u0B88':
						s[i]='\u0B87';
						break;
					case '\u0B8A':
						s[i]='\u0B89';
						break;
					case '\u0B8F':
						s[i]='\u0B8E';
						break;
					case '\u0B93':
						s[i]='\u0B92';
						break;
					case '\u0BC0':
						s[i]='\u0BBF';
						break;
					case '\u0BC2':
						s[i]='\u0BC1';
						break;
					case '\u0BC7':
						s[i]='\u0BC6';
						break;
					case '\u0BCB':
						s[i]='\u0BCA';
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