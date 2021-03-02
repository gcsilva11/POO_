package projecto;

import java.io.Serializable;


public class Admin extends Utilizador implements Serializable{
    
    Admin(){};
    Admin(String n,String u,String m,String em,String pass,int ni,int t){
        super(n,u,m,em,pass,ni,t);
    }
    
}
