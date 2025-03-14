package br.com.vendetudo.marketplace.modules.user.Controller;
import br.com.vendetudo.marketplace.modules.user.DTO.UserDTO;
import br.com.vendetudo.marketplace.modules.user.Mapper.UserMapper;
import br.com.vendetudo.marketplace.modules.user.Service.UserServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserServiceImplement userServiceImplement;
    private final UserMapper userMapper;

    @Autowired
    public UserController(UserServiceImplement userServiceImplement, UserMapper userMapper) {
        this.userServiceImplement = userServiceImplement;
        this.userMapper = userMapper;
    }

    @PostMapping("/register")
    public ResponseEntity<UserDTO> registerUser(@RequestBody UserDTO userDTO){
            userServiceImplement.create(userDTO);
            return new ResponseEntity<>(userDTO,HttpStatus.CREATED);

    }





}
