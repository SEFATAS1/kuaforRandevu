package com.SefaTas.KuaforRandevu.Repository;

import com.SefaTas.KuaforRandevu.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
