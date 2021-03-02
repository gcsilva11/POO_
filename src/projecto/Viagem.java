package projecto;

import java.io.Serializable;
import java.util.ArrayList;

public class Viagem  implements Serializable{
    
    private int codigo,duracao,numReservasMax,numReservas=0,realizada=0;
    private Data data;
    private ArrayList <Autocarro> autocarros = new ArrayList();
    private String origem,destino;
    private Double preco;
    private Reviews reviews = new Reviews();
    
    Viagem(){};
    Viagem(int c,int dura,int nr,Data d,ArrayList <Autocarro> a,String o,String dest,
            Double p,Reviews r){
        
        codigo = c;
        duracao = dura;
        numReservas = nr;
        data = d;
        autocarros = a;
        origem = o;
        destino = dest;
        preco = p;
        reviews = r;
        
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public int getNumReservasMax() {
        return numReservasMax;
    }

    public void setNumReservasMax(int numReservasMax) {
        this.numReservasMax = numReservasMax;
    }
    
    public void alterarNumReservasMax(int antigaReserva,int reservaNova){
        numReservasMax -= antigaReserva;
        numReservasMax += reservaNova;
    }
    
    public int getNumReservas() {
        return numReservas;
    }

    public void setNumReservas(int numReservas) {
        this.numReservas = numReservas;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public ArrayList<Autocarro> getAutocarros() {
        return autocarros;
    }

    public void setAutocarros(Autocarro autocarros) {
        this.autocarros.add(autocarros);
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Reviews getReviews() {
        return reviews;
    }

    public void setReviews(Reviews reviews) {
        this.reviews = reviews;
    }

    public int getRealizada() {
        return realizada;
    }

    public void setRealizada(int realizada) {
        this.realizada = realizada;
    }

    @Override
    
    public String toString() {
        return "Codigo: " + codigo + "\nData: " + data.getDia() + "/" + data.getMes() + "/" +data.getAno() + "\nOrigem: " + origem 
                + "  Destino:" + destino +"\nDuracao:" +duracao +"\nNumero de reservas: " +numReservas +"\nPreco inicial: " + preco;
    }
        
}
