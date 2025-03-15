package br.com.vendetudo.marketplace.modules.user.Controller;
import br.com.vendetudo.marketplace.modules.user.DTO.UpdateUserDto;
import br.com.vendetudo.marketplace.modules.user.DTO.UserDTO;
import br.com.vendetudo.marketplace.modules.user.Mapper.UserMapper;
import br.com.vendetudo.marketplace.modules.user.Service.UserServiceImplement;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class UserController {
    private final UserServiceImplement userServiceImplement;

    @Autowired
    public UserController(UserServiceImplement userServiceImplement, UserMapper userMapper) {
        this.userServiceImplement = userServiceImplement;
    }

    @PostMapping("/register")
    public ResponseEntity<UserDTO> registerUser(@RequestBody UserDTO userDTO) {
        userServiceImplement.create(userDTO);
        return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UpdateUserDto> updateUserData(@RequestBody UpdateUserDto user, @PathVariable Long id) {
        try {
            userServiceImplement.update(id, user);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e ) {
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/listarusuarios")
    public List<UserDTO> listUsers() {
        return userServiceImplement.listarUsuarios();
    }

    @GetMapping("{id}")
    public ResponseEntity<UserDTO> findUser(@PathVariable Long id) {
        try {
            UserDTO userDTO =   userServiceImplement.findUserById(id);
            return ResponseEntity.ok(userDTO);
        }catch (RuntimeException e){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userServiceImplement.delete(id);
        return ResponseEntity.noContent().build();
    }


}
