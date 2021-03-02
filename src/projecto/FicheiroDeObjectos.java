package projecto;
import java.io.*;

public class FicheiroDeObjectos{
    
    private ObjectInputStream iS;
    private ObjectOutputStream oS;
   
    //Método para abrir um ficheiro para leitura
    public boolean abreLeitura(String nomeDoFicheiro) {
        try{
            iS = new ObjectInputStream(new FileInputStream(nomeDoFicheiro));
            return true;
        }catch (IOException e){
            return false;
        }
    }
   
    //Método para abrir um ficheiro para escrita
    //Recebe o nome do ficheiro
    public void abreEscrita(String nomeDoFicheiro) throws IOException {
        oS = new ObjectOutputStream(new FileOutputStream(new File(nomeDoFicheiro)));
    }
   
    //Método para ler um objecto do ficheiro
    //Devolve o objecto lido
    public Object leObjecto() throws IOException,ClassNotFoundException {
        return iS.readObject();
    }
   
    //Método para escrever um objecto no ficheiro
    //Recebe o objecto a escrever
    public void escreveObjecto(Object o) throws IOException {
        oS.writeObject(o);
    }
   
    //Método para fechar um ficheiro aberto em modo leitura
    public void fechaLeitura() throws IOException {
        iS.close();
    }
   
    //Método para fechar um ficheiro aberto em modo escrita
    public void fechaEscrita() throws IOException {
        oS.close();
    }    
}
