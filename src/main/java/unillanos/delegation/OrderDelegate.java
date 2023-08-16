package unillanos.delegation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;
import unillanos.dto.OrderDTO;
import unillanos.service.IOrderService;

import java.util.Date;


@Component
@RequiredArgsConstructor
public class OrderDelegate implements JavaDelegate {
    private final IOrderService orderService;
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        String currentActivityId = execution.getCurrentActivityId();
        System.out.println("currentActivityId: " + currentActivityId);
        switch (currentActivityId){
            case "createOrderServiceTask" -> {
                OrderDTO orderDTO = new OrderDTO();
                orderDTO.setPedidoAsadero(execution.getProcessInstance().getVariables().get("pedidoAsadero").toString());
                orderDTO.setCantPedidoAsadero(Integer.parseInt(execution.getProcessInstance().getVariables().get("cantPedidoAsadero").toString()));
                orderDTO.setPedidoCocina(execution.getProcessInstance().getVariables().get("pedidoCocina").toString());
                orderDTO.setCantPedidoCocina(Integer.parseInt(execution.getProcessInstance().getVariables().get("cantPedidoCocina").toString()));
                orderDTO.setPedidoBar(execution.getProcessInstance().getVariables().get("pedidoBar").toString());
                orderDTO.setCantPedidoBar(Integer.parseInt(execution.getProcessInstance().getVariables().get("cantPedidoBar").toString()));
                orderDTO.setFechaActual(new Date());
                orderService.save(orderDTO);
            }
        }
    }
}
