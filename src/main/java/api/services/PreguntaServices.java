package api.services;

import entities.Pregunta;

import java.util.List;

public interface PreguntaServices {
    boolean altaPregunta(Pregunta pregunta);
    boolean deletePregunta(Pregunta pregunta);
    List<Pregunta> findAllPregunta();
    Pregunta findById(int id);
}
