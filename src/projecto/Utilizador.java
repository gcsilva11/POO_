package projecto;

import java.io.Serializable;


public class Utilizador implements Serializable{
    
    protected String nome,username,morada,email,password;
    protected int nif,telefone,verificaOnline = 0;
    
    Utilizador(){}
    Utilizador(String n,String u,String m,String em,String pass,int ni,int t){
        nome = n;
        username = u;
        morada = m;
        email = em;
        password = pass;
        nif = ni;
        telefone = t;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getNif() {
        return nif;
    }

    public void setNif(int nif) {
        this.nif = nif;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public int getVerificaOnline() {
        return verificaOnline;
    }

    public void setVerificaOnline(int verificaOnline) {
        this.verificaOnline = verificaOnline;
    }
    
    
}
