package com.idivine.open.solr.analyzers.ka;

import java.io.IOException;
import org.apache.lucene.analysis.TokenFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.KeywordAttribute;
import org.apache.solr.analysis.BaseTokenFilterFactory;

/**
 * Class for normalizing the Bengali tokens
 * @author dsahi
 */
public class KannadaNormalizationFilterFactory extends BaseTokenFilterFactory {

	@Override
	public TokenStream create(TokenStream input) {
		return new BengaliNormalizationFilter(input);
	}
}

/**
 * @author dsahi
 */
final class BengaliNormalizationFilter extends TokenFilter {

  private final KannadaNormalizer normalizer = new KannadaNormalizer();
  private final CharTermAttribute termAtt = addAttribute(CharTermAttribute.class);
  private final KeywordAttribute keywordAtt = addAttribute(KeywordAttribute.class);

	protected BengaliNormalizationFilter(TokenStream input) {
		super(input);
	}

	@Override
	public boolean incrementToken() throws IOException {
    if (input.incrementToken()) {
      if (!keywordAtt.isKeyword())
        termAtt.setLength(normalizer.normalize(termAtt.buffer(),
                termAtt.length()));
      return true;
    }
	    return false;
	}
}

