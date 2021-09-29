package api.dto;



public class InformeDTO {

    private InformeIDDTO id;

    private int notaExercicis;

    private int notaAtencio;

    private int notaAssistencia;

    private int notaTreball;


    public InformeDTO() {
    }

    public InformeDTO(InformeIDDTO id, int notaAssistencia, int notaAtencio, int notaExercicis, int notaTreball){
        this.id = id;
        this.notaAssistencia = notaAssistencia;
        this.notaAtencio = notaAtencio;
        this.notaExercicis = notaExercicis;
        this.notaTreball = notaTreball;
    }

    public InformeDTO(InformeIDDTO id) {
        this.id = id;
    }

    public InformeIDDTO getId() {
        return id;
    }

    public void setId(InformeIDDTO id) {
        this.id = id;
    }

    public int getNotaExercicis() {
        return notaExercicis;
    }

    public void setNotaExercicis(int notaExercicis) {
        this.notaExercicis = notaExercicis;
    }

    public int getNotaAtencio() {
        return notaAtencio;
    }

    public void setNotaAtencio(int notaAtencio) {
        this.notaAtencio = notaAtencio;
    }

    public int getNotaAssistencia() {
        return notaAssistencia;
    }

    public void setNotaAssistencia(int notaAssistencia) {
        this.notaAssistencia = notaAssistencia;
    }

    public int getNotaTreball() {
        return notaTreball;
    }

    public void setNotaTreball(int notaTreball) {
        this.notaTreball = notaTreball;
    }
}

