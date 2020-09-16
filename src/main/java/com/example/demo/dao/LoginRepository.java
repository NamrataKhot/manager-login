package com.example.demo.dao;

import com.example.demo.entity.secutiry.JwtUser;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface LoginRepository extends CrudRepository<JwtUser, Object>{

    public Optional<JwtUser> findByUserName(String userName);

}
