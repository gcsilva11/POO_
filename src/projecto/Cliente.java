package projecto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;


public class Cliente extends Utilizador implements Serializable{
    
    private ArrayList <Reserva> reservas = new ArrayList();
    
    Cliente(){};
    Cliente(String n,String u,String m,String em,String pass,int ni,int t,ArrayList <Reserva> r){
        super(n,u,m,em,pass,ni,t);
        reservas = r;
    }    

    public void consultaReservas(Manager manager) throws InterruptedException{
        
        if(reservas.isEmpty()){
            System.out.println("\nNao fez nenhuma reserva!\n\n");Thread.sleep(2000);
        }
        for(Reserva reserva: reservas){
            System.out.println("A apresentar reservas feitas: \n");
            System.out.println("\n"+reserva.toString());
            System.out.println("\n");
        }
    }
    
    public void fazerReserva(Manager manager,Cliente cliente) throws InterruptedException{
        
        int codigo,verificaAutocarros=0;
        Double precoFinal;
        Double preco;
        Reserva novaReserva = new Reserva();
        Scanner sc = new Scanner(System.in);
        Scanner lde = new Scanner (System.in);
        String escolha;
        
        
        if(manager.viagens.isEmpty()){
            System.out.println("Não existem viagens disponiveis, por favor tente mais tarde.\n");Thread.sleep(2000);
            return;
        }
        
        System.out.print("Que viagem pertende reservar? (Insira o codigo da viagem): ");
        codigo = sc.nextInt();
        for(int i=0;i<manager.viagens.size();i++){
            if(codigo == manager.viagens.get(i).getCodigo()){
                if(!manager.viagensRealizadas.contains(manager.viagens.get(i))){
                    novaReserva.setViagem(manager.viagens.get(i));
                    for(int j=0;j<manager.viagens.get(i).getAutocarros().size();j++){
                        for(int k=0;k< manager.viagens.get(i).getAutocarros().get(j).getLugares().length;k++){
                            if(manager.viagens.get(i).getAutocarros().get(j).getLugares()[k]==0){
                                verificaAutocarros = 1;
                                manager.viagens.get(i).getAutocarros().get(j).getLugares()[k]  = 1;
                                novaReserva.setAutocarro(manager.viagens.get(i).getAutocarros().get(j));
                                novaReserva.setNumLugar(k);
                                manager.viagens.get(i).setNumReservas(manager.viagens.get(i).getNumReservas()+1);
                                break;
                            }
                        }
                        if(verificaAutocarros == 1){
                            break;
                        }
                    }
                    if(verificaAutocarros != 1){
                        menu:
                        System.out.print("\nNao ha lugares disponiveis, quer ir para a lista de espera?(s/n)");
                        escolha = lde.nextLine();
                        switch(escolha){
                                case "s":{
                                    System.out.print("\nFoi posto em lista de espera, aguarde notificações.\n");Thread.sleep(2000);
                                    manager.listaDeEspera.add(cliente);
                                    novaReserva.setEstado("Em espera");
                                    cliente.getReservas().add(novaReserva);
                                    return;
                                }
                                case "n":{
                                    System.out.print("\nNão foi posto em lista de espera, a voltar ao menu cliente....\n");Thread.sleep(2000);
                                    return;
                                }
                                default:System.out.print("\nEssa opcao não e valida,tente de novo");Thread.sleep(2000);menu:break;
                        }
                        
                    }
                    preco = manager.viagens.get(i).getPreco();
                    precoFinal = cliente.precoPorCliente(manager,cliente,preco);
                    novaReserva.setPreco(precoFinal);
                    novaReserva.setEstado("Activa");
                    reservas.add(novaReserva);   
                }
                else{
                    System.out.println("\nErro, essa viagem ja foi realizada...");Thread.sleep(2000);
                    return;
                }
            }
                
            else{
                System.out.println("\nErro: viagem nao encontrada");Thread.sleep(2000);
                return;
            }
        
        }
        
        System.out.println("\nReserva efectuada com sucesso! :)\n");Thread.sleep(2000);
        
    
    }
        
    public void cancelaReserva(Manager manager,Cliente cliente) throws InterruptedException{
        
        String dado;
        int numero,loop;
        Double preco;
        Data dataViagem = new Data();
        
        if(cliente.getReservas().isEmpty()){
            System.out.println("\nAinda nao fez nenhuma reserva!");
            Thread.sleep(2000);
            return;
        }
        
        System.out.println("\n\n\t\t------CANCELAR RESERVAS------\n\n");
        System.out.println("Escolha Uma Reserva:\n");
        do{
            loop=0;
            for (int i=0;i<cliente.reservas.size();i++){
                System.out.println("\nReserva nº" +i +reservas.get(i).toString());
            }
            dado= Projecto.perguntaGeral("\nEscolha(Nº Reserva): ","inteiro",null);
            numero=Integer.parseInt(dado); //neste caso dadoInt e o numero da viagem no array.
            if(numero>=cliente.reservas.size() || numero < 0){
                System.out.println("\nPor Favor, Introduza Uma Reserva Listada!\n");
                Thread.sleep(1500);
                loop=1;
            }
        }while(loop==1);
        
        preco = cliente.getReservas().get(numero).getPreco();
        dataViagem = cliente.getReservas().get(numero).getViagem().getData();
        cliente.getReservas().get(numero).setPreco(cliente.precoCancelamento(manager,cliente,preco,dataViagem));
        cliente.getReservas().get(numero).setEstado("cancelada");
        manager.reservasCanceladas.add(cliente.getReservas().get(numero));
        cliente.reservas.remove(numero);
        System.out.println("\nSuccess: Reserva cancelada! :)");
        Thread.sleep(3000);
        
    }
   
    public Double precoPorCliente(Manager manager,Cliente cliente,Double preco) throws InterruptedException{
        return preco;
    }
    
    public Double precoCancelamento(Manager manager,Cliente cliente,Double preco,Data dataViagem) throws InterruptedException{
        return 0.0;
    }
    
    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(ArrayList<Reserva> reservas) {
        this.reservas = reservas;
    }
    
    @Override
    public String toString() {
        return "Nome:"+nome+"\nNIF:"+nif+"\nMorada:"+morada+"\nTelefone:"+telefone+"\nEmail:"+email+"\nUsername:"+username+"\nPassword:"+password+"\nReservas:\n";
    }
}
