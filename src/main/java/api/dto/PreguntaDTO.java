package api.dto;


public class PreguntaDTO {

    private String text;

    private String respuestaCorrecta;

    private String respuestaIncorrecta1;

    private String respuestaIncorrecta2;

    private String respuestaIncorrecta3;

    public PreguntaDTO() {
    }

    public PreguntaDTO(String text, String respuestaCorrecta, String respuestaIncorrecta1, String respuestaIncorrecta2,
                       String respuestaIncorrecta3) {
        this.text = text;
        this.respuestaCorrecta = respuestaCorrecta;
        this.respuestaIncorrecta1 = respuestaIncorrecta1;
        this.respuestaIncorrecta2 = respuestaIncorrecta2;
        this.respuestaIncorrecta3 = respuestaIncorrecta3;
    }

    public String getRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    public void setRespuestaCorrecta(String respuestaCorrecta) {
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public String getRespuestaIncorrecta1() {
        return respuestaIncorrecta1;
    }

    public void setRespuestaIncorrecta1(String respuestaIncorrecta1) {
        this.respuestaIncorrecta1 = respuestaIncorrecta1;
    }

    public String getRespuestaIncorrecta2() {
        return respuestaIncorrecta2;
    }

    public void setRespuestaIncorrecta2(String respuestaIncorrecta2) {
        this.respuestaIncorrecta2 = respuestaIncorrecta2;
    }

    public String getRespuestaIncorrecta3() {
        return respuestaIncorrecta3;
    }

    public void setRespuestaIncorrecta3(String respuestaIncorrecta3) {
        this.respuestaIncorrecta3 = respuestaIncorrecta3;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

