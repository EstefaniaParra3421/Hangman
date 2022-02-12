package myProject;

public class ControlHangman {
    private Diccionario frases;
    private String frase, clave, errores;
    private int conteoErrores;
    private boolean fallo, ganar;

    public ControlHangman(){
        frases = new Diccionario();
    }

    public String pintaClaveFrase(){
        //inicializacion de las variables de control de la ronda
        clave = "";
        errores="Letras Erroneas: ";
        conteoErrores=0;

        //obtener la frase
        frase= frases.getfrase();
       // clave = frase;
        //crear clave
        for(int i = 0;i<frase.length();i++){
            if(frase.charAt(i) == ' '){
                clave+=frase.charAt(i);
            }else{
                clave+="-";
               // clave+=frase.charAt(i);
            }
        }
    return clave;
    }

    public String validarLetra(char letra){
        fallo=false;
        int index =frase.indexOf(letra);
        if(index!=-1){
            while(index>-1) {
                reemplazarLetra(index, letra);
                index = frase.indexOf(index+1,letra);
            }
        }else{
            fallo = true;
            conteoErrores++;
            errores+=letra+" ";
        }

        return clave;
    }

    private void reemplazarLetra(int index, char letra) {
        char[] arrayClave = clave.toCharArray();
        arrayClave[index]=letra;
        clave = String.copyValueOf(arrayClave);
    }

    public boolean isGanador(){
        /*if(clave.indexOf('-')==-1){
            ganar=true;
        }else{
            ganar=false;
        }*/
        //operador terciario
        ganar = (clave.indexOf('-')==-1)?true:false;
        return ganar;
    }

    public String getClave() {
        return clave;
    }

    public String getErrores() {
        return errores;
    }

    public int getConteoErrores() {
        return conteoErrores;
    }

    public boolean isFallo() {
        return fallo;
    }

    public String getFrase() {
        return frase;
    }
}
