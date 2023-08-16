package unillanos.delegation;

import lombok.RequiredArgsConstructor;
import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;
import unillanos.dto.UserDTO;
import unillanos.service.IUserService;

@Component
@RequiredArgsConstructor
public class UserDelegate implements JavaDelegate {

    private final IUserService userService;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        String currentActivityId = execution.getCurrentActivityId();
        System.out.println("currentActivityId: " + currentActivityId);

        switch (currentActivityId){
            case "createAccountServiceTask" -> {
                UserDTO userDTO = new UserDTO();
                userDTO.setUsername(execution.getProcessInstance().getVariables().get("username").toString());
                userDTO.setFullname(execution.getProcessInstance().getVariables().get("fullname").toString());
                userDTO.setEmail(execution.getProcessInstance().getVariables().get("email").toString());
                userDTO.setPassword(execution.getProcessInstance().getVariables().get("password").toString());
                userService.save(userDTO);
            }
            case "validateCredentialsServiceTask" -> {
                String username = execution.getProcessInstance().getVariables().get("username").toString();
                String password = execution.getProcessInstance().getVariables().get("password").toString();
                boolean correctCredentials = userService.validateCredentials(username,password);
                execution.setVariable("correctCredentials",correctCredentials);
            }
            default -> throw new BpmnError("error_404");
        }
    }
}
