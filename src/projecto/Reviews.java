package projecto;

import java.io.Serializable;
import java.util.ArrayList;

public class Reviews  implements Serializable{
    
    private ArrayList <String> comentarios = new ArrayList();
    private int mediaPontuacao = 0;
    
    Reviews(){};
    Reviews(int mp,ArrayList <String> c){
        mediaPontuacao = mp;
        comentarios = c;
    }

    public ArrayList<String> getComentarios() {
        return comentarios;
    }

    public void setComentarios(ArrayList<String> comentarios) {
        this.comentarios = comentarios;
    }

    public int getMediaPontuacao() {
        return mediaPontuacao;
    }

    public void setMediaPontuacao(int mp) {
        mediaPontuacao = mp;
    }
    
}
