package com.example.repasoclase35.service;

import com.example.repasoclase35.domain.Paciente;
import com.example.repasoclase35.exceptions.ResourceNotFoundException;
import com.example.repasoclase35.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {
    private PacienteRepository pacienteRepository;

    @Autowired
    public PacienteService(PacienteRepository pacienteRepository) {

        this.pacienteRepository = pacienteRepository;
    }
    public  Paciente guardarPaciente (Paciente paciente){
        return pacienteRepository.save(paciente);
    }
    public Paciente actualizarPaciente(Paciente paciente){
        return pacienteRepository.save(paciente);
    }
    public List<Paciente> buscarTodosPaciente(){
        return pacienteRepository.findAll();
    }
    public Optional<Paciente> buscarPaciente(Long id){
        return pacienteRepository.findById(id);
    }
    public void eliminarPaciente (Long id) throws ResourceNotFoundException {
        Optional<Paciente> pacienteBuscado = pacienteRepository.findById(id);
        if (pacienteBuscado.isPresent()){
            pacienteRepository.deleteById(id);
        }
        else{
            throw new ResourceNotFoundException("Error. No existe el paciente con id: "+id);
        }
    }

    public Optional<Paciente> buscarXEmail (String email){
        return pacienteRepository.findByEmail(email);
    }


}
