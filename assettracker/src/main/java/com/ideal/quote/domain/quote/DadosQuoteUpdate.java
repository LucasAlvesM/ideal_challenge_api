package com.ideal.quote.domain.quote;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record DadosQuoteUpdate(
        @NotNull
        Long id,
        String symbol,
        BigDecimal price,
        Country country) {
}
