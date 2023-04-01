package com.example.repasoclase35.service;

import com.example.repasoclase35.domain.Domicilio;
import com.example.repasoclase35.domain.Paciente;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class PacienteServiceTest {
    @Autowired
    private PacienteService pacienteService;
    @Test
    @Order(1)
    public void  guardarPacienteTest(){
        Domicilio domicilio1 = new Domicilio("calle a", "23","salta","prov salta");
        Paciente pacienteAGuardar = new Paciente("Baspineiro", "Rodo", "12233",
                LocalDate.of(2023,03,29), domicilio1, "rodo@gmail.com");
        Paciente pacienteGuardado =pacienteService.guardarPaciente(pacienteAGuardar);

        //sin usar el constructor y solo con setters
        Paciente paciente2 = new Paciente();
        paciente2.setApellido("Rodriguez");
        paciente2.setNombre("Carlos");
        paciente2.setDocumento("123334");
        paciente2.setFechaIngreso(LocalDate.of(2023,03,31));
        paciente2.setDomicilio(domicilio1);
        paciente2.setEmail("rodo@hotmail.com");

        assertEquals(1L, pacienteGuardado.getId());
    }
    @Test
    @Order(2)
    public void buscarPacientePorID(){
        Long id1= 1L;
        Optional<Paciente> pacienteBuscado = pacienteService.buscarPaciente(id1);
        assertNotNull(pacienteBuscado.get());
    }

}