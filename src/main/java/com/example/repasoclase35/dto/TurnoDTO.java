package com.example.repasoclase35.dto;

import java.time.LocalDate;

public class TurnoDTO {
    private Long id;
    private Long odontologo_id;
    private Long paciente_id;
    private LocalDate fecha;
    private String nombre_odontologo;
    private String nombre_paciente;

    public TurnoDTO(Long id, Long odontologo_id, Long paciente_id, LocalDate fecha, String nombre_odontologo, String nombre_paciente) {
        this.id = id;
        this.odontologo_id = odontologo_id;
        this.paciente_id = paciente_id;
        this.fecha = fecha;
        this.nombre_odontologo = nombre_odontologo;
        this.nombre_paciente = nombre_paciente;
    }

    public TurnoDTO(Long odontologo_id, Long paciente_id, LocalDate fecha, String nombre_odontologo, String nombre_paciente) {
        this.odontologo_id = odontologo_id;
        this.paciente_id = paciente_id;
        this.fecha = fecha;
        this.nombre_odontologo = nombre_odontologo;
        this.nombre_paciente = nombre_paciente;
    }

    public TurnoDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOdontologo_id() {
        return odontologo_id;
    }

    public void setOdontologo_id(Long odontologo_id) {
        this.odontologo_id = odontologo_id;
    }

    public Long getPaciente_id() {
        return paciente_id;
    }

    public void setPaciente_id(Long paciente_id) {
        this.paciente_id = paciente_id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getNombre_odontologo() {
        return nombre_odontologo;
    }

    public void setNombre_odontologo(String nombre_odontologo) {
        this.nombre_odontologo = nombre_odontologo;
    }

    public String getNombre_paciente() {
        return nombre_paciente;
    }

    public void setNombre_paciente(String nombre_paciente) {
        this.nombre_paciente = nombre_paciente;
    }
}
