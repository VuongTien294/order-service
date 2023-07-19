package tien.baseproject.orderservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "t_orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order extends BaseEntity{

    @Column(name = "order_number")
    private String orderNumber;

//    @OneToMany(cascade = CascadeType.ALL)
//    private List<OrderLineItems> orderLineItemsList;

}
