package com.example.tsl.model.contractors.carrier;

import com.example.tsl.model.contractors.baseEntity.Contractor;
import com.example.tsl.model.orders.forwarderOrder.ForwardingOrder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Carrier extends Contractor {
    @OneToMany(mappedBy = "carrier")
    private List<ForwardingOrder> orders = new ArrayList<>();
    private LocalDate insuranceExpirationDate;
    private LocalDate licenceExpirationDate;
}
