package com.example.repasoclase35.repository;

import com.example.repasoclase35.domain.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurnoRepository extends JpaRepository <Turno,Long> {

}
