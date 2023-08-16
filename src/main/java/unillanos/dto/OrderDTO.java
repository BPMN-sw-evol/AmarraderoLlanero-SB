package unillanos.dto;

import lombok.Data;

import java.util.Date;
@Data
public class OrderDTO {
    private Long id;
    private Date fechaActual;
    private String pedidoAsadero;
    private int cantPedidoAsadero;
    private String pedidoCocina;
    private int cantPedidoCocina;
    private String pedidoBar;
    private int cantPedidoBar;
}
