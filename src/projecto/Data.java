
package projecto;

import java.io.Serializable;

public class Data  implements Serializable{
    
    private int dia,mes,ano;
    
    Data(){};
    Data(int d,int m,int a){
        dia = d;
        mes = m;
        ano = a;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
    
}
