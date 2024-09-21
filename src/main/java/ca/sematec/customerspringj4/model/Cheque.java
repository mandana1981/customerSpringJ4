package ca.sematec.customerspringj4.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
@DiscriminatorValue(value = "cheque")
public class Cheque extends Payment{

     @Column(name = "chequeNumber")
    int chequeNumber;
     @Column(name = "chequeType")
    String chequeType;
}
