package com.example.repasoclase35.service;

import com.example.repasoclase35.domain.Domicilio;
import com.example.repasoclase35.domain.Odontologo;
import com.example.repasoclase35.domain.Paciente;
import com.example.repasoclase35.dto.TurnoDTO;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class TurnoServiceTest {
    @Autowired
    private TurnoService turnoService;
    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private OdontologoService odontologoService;
/*     private Long id;
    private Long odontologo_id;
    private Long paciente_id;
    private LocalDate fecha;
    private String nombre_odontologo;
    private String nombre_paciente;*/
    @Test
    @Order(1)
    public void guardarTurnoDTO_Test(){
        Domicilio domicilio1 = new Domicilio("calle a", "23","salta","prov salta");
        Paciente pacienteAGuardar = new Paciente("Baspineiro", "Rodo", "12233",
                LocalDate.of(2023,03,29), domicilio1, "rodo@gmail.com");
        Paciente pacienteGuardado =pacienteService.guardarPaciente(pacienteAGuardar);

        Odontologo odontologo1 = new Odontologo("juan","pedro", "225500");

        TurnoDTO turnoDTO_1 = new TurnoDTO(1L,1L,LocalDate.of(2023,03,31),
                "Pedro", "Lucas");
        TurnoDTO turnoGuardado = turnoService.guardarTurno(turnoDTO_1);

        assertEquals(1L, turnoGuardado.getId());

    }

}