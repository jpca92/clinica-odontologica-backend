package com.example.repasoclase35.service;

import com.example.repasoclase35.domain.Odontologo;
import com.example.repasoclase35.domain.Paciente;
import com.example.repasoclase35.domain.Turno;
import com.example.repasoclase35.dto.TurnoDTO;
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

    public TurnoDTO guardarTurno (TurnoDTO turno){
        return convertirTurnoaTurnoDTO(
                turnoRepository.save(convertirTurnoDTOaTurno(turno)));
    }
    public TurnoDTO actualizarTurno(TurnoDTO turno){
        return convertirTurnoaTurnoDTO(
                turnoRepository.save(convertirTurnoDTOaTurno(turno)));
    }
    public List<Turno> buscarTodosTurnos(){
        return turnoRepository.findAll();
    }
    public Optional<TurnoDTO> buscarTurno (Long id){
        Optional<Turno> turnoBuscado = turnoRepository.findById(id);
        if(turnoBuscado.isPresent()){
            return Optional.of(convertirTurnoaTurnoDTO(turnoBuscado.get()));
        }
        else{
            return Optional.empty();
        }
    }
    public void eliminarTurno (Long id){
        turnoRepository.deleteById(id);
    }

    private Turno convertirTurnoDTOaTurno(TurnoDTO turnoDTO){
        Turno turno = new Turno();
        Paciente paciente = new Paciente();
        Odontologo odontologo = new Odontologo();
        turno.setId(turnoDTO.getId());
        turno.setFecha(turnoDTO.getFecha());
        paciente.setId(turnoDTO.getPaciente_id());
        paciente.setNombre(turnoDTO.getNombre_paciente());
        odontologo.setId(turnoDTO.getId());
        odontologo.setNombre(turnoDTO.getNombre_odontologo());
        //vincular los objetos
        turno.setOdontologo(odontologo);
        turno.setPaciente(paciente);
        //el turno estaria listo
        return turno;
    }

    private TurnoDTO convertirTurnoaTurnoDTO(Turno turno){
        TurnoDTO turnoDTO = new TurnoDTO();
        turnoDTO.setId(turno.getId());
        turnoDTO.setOdontologo_id(turno.getOdontologo().getId());
        turnoDTO.setPaciente_id(turno.getPaciente().getId());
        turnoDTO.setFecha(turno.getFecha());
        turnoDTO.setNombre_odontologo(turno.getOdontologo().getNombre());
        turnoDTO.setNombre_paciente(turno.getPaciente().getNombre());

        return turnoDTO;
    }

}
