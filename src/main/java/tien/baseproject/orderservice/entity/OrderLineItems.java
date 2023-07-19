package tien.baseproject.orderservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "t_order_line_items")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderLineItems extends BaseEntity{

    @Column(name = "sku_code")
    private String skuCode;

    private BigDecimal price;

    private Integer quantity;

    @ToString.Exclude
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "order_id")
    private Order order;
}
