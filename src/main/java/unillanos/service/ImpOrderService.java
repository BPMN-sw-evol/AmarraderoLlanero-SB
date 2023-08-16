package unillanos.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unillanos.dto.OrderDTO;
import unillanos.model.Order;
import unillanos.repository.IOrderRepository;
@Service
public class ImpOrderService implements IOrderService {
    @Autowired
    private IOrderRepository orderRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public OrderDTO save(OrderDTO orderDTO) {
        Order order = modelMapper.map(orderDTO,Order.class);
        System.out.println("Order have been created.");
        return modelMapper.map(orderRepository.save(order), OrderDTO.class);
    }
}
