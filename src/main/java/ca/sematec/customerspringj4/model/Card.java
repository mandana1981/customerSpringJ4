package ca.sematec.customerspringj4.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(value = "card")
public class Card extends Payment {
    @Column(name = "cardNumber")
    int cardNumber;
    @Column(name = "cardType")
    String cardType;
}
