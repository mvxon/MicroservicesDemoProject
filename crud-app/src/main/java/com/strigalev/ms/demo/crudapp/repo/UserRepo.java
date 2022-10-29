package com.strigalev.ms.demo.crudapp.repo;

import com.strigalev.ms.demo.crudapp.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
