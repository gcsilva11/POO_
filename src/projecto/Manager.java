package projecto;

import java.io.Serializable;
import java.util.ArrayList;

public class Manager  implements Serializable{
    
    ArrayList <Cliente> clientes = new ArrayList();
    ArrayList <Admin> administradores = new ArrayList();
    ArrayList <Reserva> reservas = new ArrayList();
    ArrayList <Viagem> viagens = new ArrayList();
    ArrayList <Autocarro> autocarros = new ArrayList();
    ArrayList <Cliente> listaDeEspera = new ArrayList();
    ArrayList <Reserva> reservasCanceladas = new ArrayList();
    ArrayList <Viagem> viagensRealizadas = new ArrayList();
    
    Manager(){};
    Manager(ArrayList <Cliente> c,ArrayList <Admin> a,ArrayList <Reserva> r,
            ArrayList <Viagem> v,ArrayList <Autocarro> au,ArrayList <Cliente> le,ArrayList <Reserva> rc, ArrayList <Viagem> vr){
        clientes = c;
        administradores = a;
        reservas = r;
        viagens = v;
        autocarros = au;
        listaDeEspera = le;
        reservasCanceladas = rc;
        viagensRealizadas = vr;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public ArrayList<Admin> getAdministradores() {
        return administradores;
    }

    public void setAdministradores(ArrayList<Admin> administradores) {
        this.administradores = administradores;
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(ArrayList<Reserva> reservas) {
        this.reservas = reservas;
    }

    public ArrayList<Viagem> getViagens() {
        return viagens;
    }

    public void setViagens(ArrayList<Viagem> viagens) {
        this.viagens = viagens;
    }

    public ArrayList<Viagem> getViagensRealizadas() {
        return viagensRealizadas;
    }

    public void setViagensRealizadas(ArrayList<Viagem> viagensRealizadas) {
        this.viagensRealizadas = viagensRealizadas;
    }

    public ArrayList<Autocarro> getAutocarros() {
        return autocarros;
    }

    public void setAutocarros(ArrayList<Autocarro> autocarros) {
        this.autocarros = autocarros;
    }

    public ArrayList<Cliente> getListaDeEspera() {
        return listaDeEspera;
    }

    public void setListaDeEspera(ArrayList<Cliente> listaDeEspera) {
        this.listaDeEspera = listaDeEspera;
    }

    public ArrayList<Reserva> getReservasCanceladas() {
        return reservasCanceladas;
    }

    public void setReservasCanceladas(ArrayList<Reserva> reservasCanceladas) {
        this.reservasCanceladas = reservasCanceladas;
    }

}
