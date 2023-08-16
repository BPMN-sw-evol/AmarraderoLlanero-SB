package unillanos.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unillanos.dto.UserDTO;
import unillanos.model.User;
import unillanos.repository.IUserRepository;
@Service
public class ImpUserService implements IUserService{
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public UserDTO save(UserDTO userDTO) {
        User user = modelMapper.map(userDTO,User.class);
        System.out.println("User have been created.");
        return modelMapper.map(userRepository.save(user),UserDTO.class);
    }

    @Override
    public boolean validateCredentials(String username, String password) {
        User user = userRepository.findByUsername(username);
        if(user!= null){
            System.out.println("Registered user");
            return true;
        }
        System.out.println("Unregistered user");
        return false;

    }
}
