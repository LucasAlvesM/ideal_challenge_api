package com.ideal.quote.domain.quote;

import java.math.BigDecimal;

public record DadosWatchlist(Long id, String symbol, BigDecimal price, Country country) {

    public DadosWatchlist(Quote quote) {
        this(quote.getId(), quote.getSymbol(),quote.getPrice(), quote.getCountry());
    }

}
