package br.com.vendetudo.marketplace.modules.user.Service;

import br.com.vendetudo.marketplace.modules.user.Entity.UserEntity;

import java.util.List;

public interface UserService {
    void create();
    void delete();
    void update();
    void findUserById();
    List<UserEntity> listarUsuarios();

}
