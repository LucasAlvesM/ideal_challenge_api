package com.ideal.quote.domain.quote;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record DadosQuoteRegister(
        @NotBlank
        String symbol,
        @NotNull
        BigDecimal price,
        @NotNull
        Country country
        ) {
}
