package com.example.repasoclase35.controller;

import com.example.repasoclase35.domain.Odontologo;
import com.example.repasoclase35.domain.Paciente;
import com.example.repasoclase35.dto.TurnoDTO;
import com.example.repasoclase35.service.OdontologoService;
import com.example.repasoclase35.service.PacienteService;
import com.example.repasoclase35.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/turnos")
public class TurnoController {
    private TurnoService turnoService;
    private OdontologoService odontologoService;
    private PacienteService pacienteService;

    @Autowired
    public TurnoController(TurnoService turnoService, OdontologoService odontologoService, PacienteService pacienteService) {
        this.turnoService = turnoService;
        this.odontologoService = odontologoService;
        this.pacienteService = pacienteService;
    }

    @PostMapping
    public ResponseEntity<TurnoDTO> registrarTurno(@RequestBody TurnoDTO turno){
        ResponseEntity<TurnoDTO> respuesta;
        Optional<Paciente> pacienteBuscado = pacienteService.buscarPaciente(turno.getPaciente_id());
        Optional<Odontologo> odontologoBuscado = odontologoService.buscarOdontologo(turno.getOdontologo_id());
        if (pacienteBuscado.isPresent() && odontologoBuscado.isPresent()){
            respuesta= ResponseEntity.ok(turnoService.guardarTurno(turno));
        }
        else{
            respuesta = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return respuesta;
    }
    @GetMapping("/{id}")
    public ResponseEntity<TurnoDTO> buscarTurno (@PathVariable Long id){
        Optional<TurnoDTO> turnoBuscado = turnoService.buscarTurno(id);
        if (turnoBuscado.isPresent()){
            return ResponseEntity.ok(turnoBuscado.get());
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<String> eliminarTurno(@PathVariable Long id){
        Optional<TurnoDTO> turnoBuscado = turnoService.buscarTurno(id);
        if (turnoBuscado.isPresent()){
            turnoService.eliminarTurno(id);
            return ResponseEntity.ok("Se elimino el turno con id: "+ id);
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se logró " +
                    "eliminar" +"el turno con id: "+ id + "dado que el mismo no " +
                    "existe en la base de datos");
        }
    }
}
