package com.example.repasoclase35.service;

import com.example.repasoclase35.domain.Odontologo;
import com.example.repasoclase35.domain.Paciente;
import com.example.repasoclase35.exceptions.ResourceNotFoundException;
import com.example.repasoclase35.repository.OdontologoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OdontologoService {
    private OdontologoRepository odontologoRepository;
    @Autowired
    public OdontologoService(OdontologoRepository odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }

    public Odontologo guardarOdontologo(Odontologo odontologo){
        return odontologoRepository.save(odontologo);
    }
    public Odontologo actualizarOdontologo(Odontologo odontologo){
        return odontologoRepository.save(odontologo);
    }
    public List<Odontologo> buscarTodosOdontologos(){
        return odontologoRepository.findAll();
    }
    public Optional<Odontologo> buscarOdontologo(Long id){
        return odontologoRepository.findById(id);
    }
    public void borrarOdontologo(Long id) throws ResourceNotFoundException{
        Optional<Odontologo> odontologoBuscado = odontologoRepository.findById(id);
        if (odontologoBuscado.isPresent()){
            odontologoRepository.deleteById(id);
        }
        else{
            throw new ResourceNotFoundException("Error. No existe el odontologo con id: "+id);
        }
    }
}
