package unillanos.service;

import unillanos.dto.UserDTO;

public interface IUserService {
    public UserDTO save(UserDTO userDTO);
    public boolean validateCredentials(String username, String password);
}
