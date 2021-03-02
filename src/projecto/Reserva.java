package projecto;

import java.io.Serializable;

public class Reserva  implements Serializable{
    
    private Viagem viagem;
    private Autocarro autocarro;
    private int numLugar;
    private Double preco;
    private String estado;
    
    Reserva(){};
    Reserva(Viagem v, Autocarro a,int n,Double p,String e){
        viagem = v;
        autocarro = a;
        numLugar = n;
        preco = p;
        estado = e;
    }


    public Viagem getViagem() {
        return viagem;
    }

    public void setViagem(Viagem viagem) {
        this.viagem = viagem;
    }

    public Autocarro getAutocarro() {
        return autocarro;
    }

    public void setAutocarro(Autocarro autocarro) {
        this.autocarro = autocarro;
    }

    public int getNumLugar() {
        return numLugar;
    }

    public void setNumLugar(int numLugar) {
        this.numLugar = numLugar;
    }


    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "\nViagem\n" + viagem + "\nAutocarro: " + autocarro.getMatricula() + ", Lugar numero:" + numLugar + "\nPreco a pagar: " + preco;
    }
    

}
