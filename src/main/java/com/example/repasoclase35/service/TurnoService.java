package com.example.repasoclase35.service;

import com.example.repasoclase35.domain.Paciente;
import com.example.repasoclase35.domain.Turno;
import com.example.repasoclase35.repository.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurnoService {
    private TurnoRepository turnoRepository;
    @Autowired
    public TurnoService(TurnoRepository turnoRepository) {
        this.turnoRepository = turnoRepository;
    }

    public Turno guardarTurno (Turno turno){
        return turnoRepository.save(turno);
    }
    public Turno actualizarTurno(Turno turno){
        return turnoRepository.save(turno);
    }
    public List<Turno> buscarTodosTurnos(){
        return turnoRepository.findAll();
    }
    public Optional<Turno> buscarTurno (Long id){
        return turnoRepository.findById(id);
    }
    public void eliminarTurno (Long id){
        turnoRepository.deleteById(id);
    }

}
