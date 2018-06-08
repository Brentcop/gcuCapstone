package com.gcu.security;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gcu.entity.Users;

public interface UsersRepository extends JpaRepository<Users,Integer>{
	//made optional in case user does not exist
	Optional<Users> findByName(String username);
	
	Optional<Users> findByEmail(String email);
	
	Optional<Users> findByLastName(String lastname);

}
