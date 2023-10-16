package com.digitar120.todoapp.mapper;

public interface IMapper <I, O>{
    // Interfaz genérica para todos los mapeadores.
    // I -> In, O-> Out

    public O map(I in);
}
