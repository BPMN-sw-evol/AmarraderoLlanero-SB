package unillanos.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "Orders")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "fechaActual")
    private Date fechaActual;
    @Column(name = "pedidoAsadero")
    private String pedidoAsadero;
    @Column(name = "cantPedidoAsadero")
    private int cantPedidoAsadero;
    @Column(name = "pedidoCocina")
    private String pedidoCocina;
    @Column(name = "cantPedidoCocina")
    private int cantPedidoCocina;
    @Column(name = "pedidoBar")
    private String pedidoBar;
    @Column(name = "cantPedidoBar")
    private int cantPedidoBar;
}
