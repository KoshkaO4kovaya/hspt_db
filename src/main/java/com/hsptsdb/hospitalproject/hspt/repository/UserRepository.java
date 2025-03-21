package com.hsptsdb.hospitalproject.hspt.repository;

import com.hsptsdb.hospitalproject.hspt.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends GenericRepository<User> {
    User findUserByEmail(String email);
}
