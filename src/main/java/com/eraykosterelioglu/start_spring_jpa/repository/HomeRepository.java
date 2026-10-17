package com.eraykosterelioglu.start_spring_jpa.repository;

import com.eraykosterelioglu.start_spring_jpa.entites.Home;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HomeRepository extends JpaRepository<Home,Long> {

}
