package com.asia.pay.repository;

import com.asia.pay.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by Dang Dim
 * Date     : 3/25/19, 1:24 PM
 * Email    : dangdim02@gmail.com
 */

@Service
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByUsername(String username);
}
