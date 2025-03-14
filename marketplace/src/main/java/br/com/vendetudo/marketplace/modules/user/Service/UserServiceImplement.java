package br.com.vendetudo.marketplace.modules.user.Service;

import br.com.vendetudo.marketplace.modules.user.Entity.UserEntity;
import br.com.vendetudo.marketplace.modules.user.Mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImplement implements UserService {


    private final UserMapper userMapper;

    @Autowired
    public UserServiceImplement(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public void create() {

    }

    @Override
    public void delete() {

    }

    @Override
    public void update() {

    }

    @Override
    public void findUserById() {

    }

    @Override
    public List<UserEntity> listarUsuarios() {
        return List.of();
    }



}
