package ca.sematec.customerspringj4.model;

import jakarta.persistence.*;

@Entity
@Table(name = "PAYMENT")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "paymentMode", discriminatorType = DiscriminatorType.STRING)
public class Payment {
    @Id
    @Column(name = "payId")
    int id;
    @Column(name = "amount")
    int amount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
