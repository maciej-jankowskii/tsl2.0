package com.example.tsl.model.contractors.customer;

import com.example.tsl.enums.PaymentsRating;
import com.example.tsl.model.cargos.Cargo;
import com.example.tsl.model.contractors.baseEntity.Contractor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Customer extends Contractor {
    @OneToMany(mappedBy = "customer")
    private List<Cargo> cargos = new ArrayList<>();
    @Enumerated(EnumType.STRING)
    private PaymentsRating paymentsRating;
}
