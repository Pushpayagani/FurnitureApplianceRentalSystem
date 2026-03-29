package com.rentease.repository;

import com.rentease.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>
{

    UserEntity findByUserIdAndPassword(String userId, String password);
    //UserEntity findByEmailAndPassword(String userId, String password);


}
