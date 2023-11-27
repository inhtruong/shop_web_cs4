package com.example.shop_web.service.role;

import com.example.shop_web.domain.Role;
import com.example.shop_web.repository.RoleRepository;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RoleServiceImpl implements IRoleService{

    @Autowired
    private RoleRepository roleRepository;


    @Override
    public List<Role> findAll() {
        return null;
    }

    @Override
    public Optional<Role> findById(Long id) {
        return roleRepository.findById(id);
    }

    @Override
    public Role save(Role role) {
        return null;
    }

    @Override
    public void update(Role role) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
