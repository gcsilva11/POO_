package projecto;

import java.io.Serializable;




public class Autocarro  implements Serializable{
    
    private String matricula;
    private int capacidade;
    private int[] lugares;
    
    Autocarro(){};
    Autocarro(String m, int c){
        matricula = m;
        capacidade = c;
    }

    public String getMatricula() {
        return matricula;
    }

    
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
        lugares = new int[capacidade];
    }

    public int[] getLugares() {
        return lugares;
    }

    public void setLugares(int[] lugares) {
        this.lugares = lugares;
    }
    
    
}
