package com.ideal.quote.domain.quote;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Table(name = "quotes")
@Entity(name = "Quote")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Quote {

    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private Long id;
    private String symbol;
    private BigDecimal price;

    @Enumerated (EnumType.STRING)
    private Country country;


    private Boolean active;

    public
    Quote ( DadosQuoteRegister dados ) {
        this.active = true;
        this.symbol = dados.symbol ();
        this.price = dados.price ();
        this.country = dados.country ();

    }

    public
    void updateInformation ( DadosQuoteUpdate dados ) {
        if (dados.symbol () != null) {
            this.symbol = dados.symbol ();

        }

    }

        public void delete() {this.active = false;}

}

