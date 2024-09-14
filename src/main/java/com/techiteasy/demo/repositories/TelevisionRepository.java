package com.techiteasy.demo.repositories;

import com.techiteasy.demo.models.Television;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelevisionRepository extends JpaRepository<Television, Long> {
}
