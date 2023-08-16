package unillanos.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unillanos.dto.OrderDTO;
import unillanos.service.ImpOrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private ImpOrderService orderService;
    @GetMapping("/hellow")
    public String hellow(){
        return "Hola mundo!";
    }
    @PostMapping("/create")
    public ResponseEntity<OrderDTO> createOrder(@RequestBody OrderDTO orderDTO){
        OrderDTO createdOrder = orderService.save(orderDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrder);
    }
}

