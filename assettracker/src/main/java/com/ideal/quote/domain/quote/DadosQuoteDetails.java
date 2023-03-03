package com.ideal.quote.domain.quote;

import java.math.BigDecimal;

public
record DadosQuoteDetails(Long id, String symbol, BigDecimal price, Country country) {

    public DadosQuoteDetails(Quote quote) {
        this(quote.getId(), quote.getSymbol(),quote.getPrice(), quote.getCountry());
    }
}
