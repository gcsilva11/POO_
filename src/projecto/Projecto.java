package projecto;
 
import java.util.Locale;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
 
/**
* A Classe Projecto é onde nos usamos os metodos todos para a realização
* do projecto.
*
* @author  Serafim Barroca nº2014213964 , Guilherme Silva nº2014226354
* @version 1.0
*/
public class Projecto implements Serializable{
   
    public static void main(String[] args) throws InterruptedException, IOException{
     
        Manager manager = new Manager();    
        File f1 = new File("FicheiroManager.txt");
            if(f1.exists()){
            System.out.println("Ficheiro encontrado!");
            manager=leFicheiros(manager);
    }
        
        Admin base = new Admin("Admin","Administrador",
            "Fim do Universo, Porta Cosmica 4, 3º Esquerdo",
            "soudeusesou87@aleluia.com","420",0000000001,
            111000111);                                 /*Administrador criado no inicio para gerir o programa */
        manager.administradores.add(base);                  /*Adiciona-se o administrador ao manager */
        loginInicial(manager);                              /*Funçao para fazer login */
  
    }
    /** loginInicial - Funcao que serve para admin ou cliente fazerem login atravez do parametro manager.
     * @param manager - Classe Manager Com todos Os Arraylists de Informacao do Programa.
     * @throws InterruptedException - Thread.Sleep() causa esta excepcao.
     * @throws java.io.IOException */
    public static void loginInicial(Manager manager) throws InterruptedException, IOException{
       
        String escolha;
        Scanner scan= new Scanner(System.in);        
       
        while(true){
            System.out.println("\n\n1.Fazer Login\n\n0.Sair");
            System.out.print("\nEscolha: ");
            escolha = scan.nextLine();
            
            
            switch(escolha){   /*Escolha de fazer login ou sair do programa */
                
                case "1":
                    
                    String username,comparadorUser,password;
                    Admin comparaAdmin = new Admin();
                    Cliente comparaCliente = new Cliente();
       
                    System.out.print("\nUsername:");
                    username = scan.nextLine();
                   
                    for (int i=0;i<manager.administradores.size();i++) {
                        
                        comparadorUser = manager.getAdministradores().get(i).getUsername();
                       
                        if (comparadorUser.equals(username)) {
                            comparaAdmin = manager.getAdministradores().get(i);
                            System.out.print("\nAdministrador encontrado!\n\nPassword:");
                            password = scan.nextLine();
                            if(password.equals(comparaAdmin.password)){
                                comparaAdmin.setVerificaOnline(1);
                                manager.getAdministradores().set(i, comparaAdmin);
                                System.out.println("\nAdministrador autorizado! A ir para o menu administrador...");
                                Thread.sleep(2000);
                                menuAdmin(manager);
                            }
                            else{
                                System.out.println("Password errada, tente novamente....");
                                loginInicial(manager);
                            }
                        }          
                    }
       
                    for (int i=0;i<manager.clientes.size();i++) {
                        
                        comparadorUser = manager.clientes.get(i).getUsername();
                                       
                        if (comparadorUser.equals(username)) {
                            comparaCliente = manager.clientes.get(i);
                            System.out.print("\nCliente encontrado!\n\nPassword:");
                            password = scan.nextLine();
                            if(password.equals(comparaCliente.password)){
                                comparaCliente.setVerificaOnline(1);
                                manager.clientes.set(i, comparaCliente);
                                System.out.println("Utilizador autorizado! A ir para o menu cliente...\n\n");
                                Thread.sleep(2000);
                                menuCliente(manager);
                            }
                            else{
                                System.out.println("Password errada, tente novamente....");
                                loginInicial(manager);
                            }
                        }
                    }        
                    System.out.println("Login falhou: não foi encontrado username\n Tentando de novo...");
                    loginInicial(manager);
                case "0":System.exit(0);
                default:System.out.println("\nEssa Opção Não é valida");Thread.sleep(2000);
            }
        }
    }
    /** MenuAdmin- Funcao onde estao todas os metodos chamados pela classe admin.
     * @param manager - Classe Manager Com todos Os Arraylists de Informacao do Programa.
     * @throws InterruptedException - Thread.Sleep() causa esta excepcao.
     * @throws java.io.IOException*/
    public static void menuAdmin(Manager manager) throws InterruptedException, IOException{
 
        String escolha;
        Scanner sc = new Scanner(System.in);
       
        while(true){
 
            System.out.println("\nVIAGENS\n\n1.Criar Viagem\n2.Alterar Viagem\n"
                + "3.Mostrar Viagens\n4.Eliminar Viagem\n\nCLIENTES\n\n5.Criar Cliente\n"
                + "6.Alterar Cliente\n7.Mostrar Cliente\n"
                + "8.Eliminar Cliente\n\nAUTOCARROS\n\n9.Criar Autocarro\n"
                + "10.Alterar Autocarros\n11.Mostrar Autocarros\n12.Eliminar Autocarros\n\n"
                + "OUTRAS\n\n13.Viagem Mais Vendida\n14.Cliente Com Mais Viagens\n"
                + "15.Viagens Sem Reserva\n16.Viagens Com Reservas\n17.Reservas Canceladas\n"
                + "18.Lista De Espera Para Clientes\n19.Melhor Viagem\n20.Estatistica Vendas\n21.Criar Admin\n\n-1. Realizar Viagem\n0.Logout");
       
            System.out.print("\nEscolha: ");
            escolha=sc.nextLine();
           
            switch(escolha){
                case "1":criarViagem(manager);escreveFicheiros(manager);break;
                case "2":alterarViagem(manager);escreveFicheiros(manager);break;
                case "3":mostrarViagem(manager);break;
                case "4":removerViagem(manager);escreveFicheiros(manager);break;
                case "5":criarCliente(manager);escreveFicheiros(manager);break;
                case "6":alterarCliente(manager);escreveFicheiros(manager);break;
                case "7":mostrarCliente(manager);break;
                case "8":removerCliente(manager);escreveFicheiros(manager);break;
                case "9":criarAutocarro(manager);escreveFicheiros(manager);break;
                case "10":alterarAutocarro(manager);escreveFicheiros(manager);break;
                case "11":mostrarAutocarro(manager);break;
                case "12":removerAutocarro(manager);escreveFicheiros(manager);break;
                case "13":viagemMaisVendida(manager);break;
                case "14":clienteMaisViagens(manager);break;
                case "15":viagemSemReservas(manager);break;
                case "16":viagemComReservas(manager);break;
                case "17":reservasCanceladas(manager);break;
                case "18":listaDeEspera(manager);break;
                case "19":melhorViagem(manager);break;
                case "20":estatisticaVendas(manager);break;
                case "21":criarAdmin(manager);break;
                case "-1":realizarViagem(manager);escreveFicheiros(manager);break;
                case "0":loginInicial(manager);escreveFicheiros(manager);
                    for(int i=0;i<manager.administradores.size();i++){
                        if(manager.administradores.get(i).getVerificaOnline()==1){
                            manager.administradores.get(i).setVerificaOnline(0);
                        }
                    }
                default:System.out.println("\nEssa Opção Não é valida");Thread.sleep(2000);
            }
        }
    }
    /** MenuCliente- Funcao onde estao todas os metodos chamados pela classe Cliente.
     * @param manager - Classe Manager Com todos Os Arraylists de Informacao do Programa.
     * @throws InterruptedException - Thread.Sleep() causa esta excepcao.
     * @throws java.io.IOException*/
    public static void menuCliente(Manager manager) throws InterruptedException, IOException{
       
        String escolha;
        Scanner sc = new Scanner(System.in);
        Cliente online = new Cliente();
        int verificaEspera=0;
        
        for(Cliente cliente:manager.clientes){
            if(cliente.getVerificaOnline()==1){
                online = cliente;
            }
        }
        
        for(Reserva reserva:online.getReservas()){
            if(reserva.getEstado().equals("Em espera")){
                for(int i=0; i < reserva.getViagem().getAutocarros().size();i++){
                    for(int k=0; k < reserva.getViagem().getAutocarros().get(i).getLugares().length;k++){
                        if(reserva.getViagem().getAutocarros().get(i).getLugares()[k]==0){
                            verificaEspera = 1;
                            System.out.println("\nA viagem para qual se encontrava em espera ja se encontra disponivel!\nFoi-lhe atribuido um lugar!\n");
                            reserva.setEstado("Activa");
                            reserva.setAutocarro(reserva.getViagem().getAutocarros().get(i));
                            reserva.setNumLugar(k);
                            break;
                        }
                    }
                    if(verificaEspera == 1){
                        break;
                    }
                }
            }
        }
        
        while(true){
           
            System.out.println("1.Consultar viagens disponíveis\n2.Reservar viagens\n"
                + "3.Consultar reservas\n4.Cancelar Reservas\n5.Ver menu de reviews de viagens"
                + "\n\n0.Logout");
            System.out.print("\nEscolha: ");
            escolha=sc.nextLine();
           
            switch(escolha){
                case "1":mostrarViagem(manager);break;
                case "2":online.fazerReserva(manager,online);;break;
                case "3":online.consultaReservas(manager);break;
                case "4":online.cancelaReserva(manager,online);break;
                case "5":menuReviews(manager);break;
                case "0":{
                    for(int i=0;i<manager.clientes.size();i++){
                        if(manager.clientes.get(i).getVerificaOnline()==1){
                            online.setVerificaOnline(0);
                            manager.clientes.set(i, online);
                            return;
                        }
                    }
                    break;
                }
                default:System.out.println("\nEssa Opção Não é valida");Thread.sleep(2000);
            }
        }      
    }
    /** criarViagem - Funcao que serve para criar uma classe Viagem e guardar no ArrayList do manager.
     * @param manager - Classe Manager Com todos Os Arraylists de Informacao do Programa.
     * @throws InterruptedException - Thread.Sleep() causa esta excepcao.*/
    public static void criarViagem(Manager manager) throws InterruptedException{
       
        Viagem novaViagem = new Viagem();
        int dadoInt,loop;
        Double dadoDouble;
        String dado;
        Scanner sc= new Scanner(System.in);
        if(manager.autocarros.isEmpty()){
            System.out.println("\nErro! Não Existem Autocarros.\n");
            Thread.sleep(3000);
            return;
        }
        System.out.println("\n\n\t\t------ CRIAR VIAGEM------\n\n");
       
        do{
            loop=0;
            dado=perguntaGeral("Codigo: ","inteiro",null);
            dadoInt=Integer.parseInt(dado); // converte String para inteiro
            for (Viagem viagem : manager.viagens) {
                if (dadoInt == viagem.getCodigo()) {
                    System.out.println("Este Código Já Esta A Ser Usado!");
                    loop=1;
                }
            }
        }while(loop==1);
        novaViagem.setCodigo(dadoInt);
       
        dado=perguntaGeral("Duração(minutos): ","inteiro",null);
        dadoInt=Integer.parseInt(dado);
        novaViagem.setDuracao(dadoInt);
       
        dado=perguntaGeral("Preço: ","double",null);
        dadoDouble=Double.valueOf(dado);
        novaViagem.setPreco(dadoDouble);
 
        dado=perguntaGeral("Origem: ","string",null);
        novaViagem.setOrigem(dado);
       
        dado=perguntaGeral("Destino: ","string",null);
        novaViagem.setDestino(dado);
       
        //DATA + Protecoes
        Data novadata= new Data();
        System.out.println("Data Da Viagem:");
        //Ano
        dadoInt=Integer.parseInt(perguntaGeral("","data","ano"));
        novadata.setAno(dadoInt);
        //MES
        dadoInt=Integer.parseInt(perguntaGeral("","data","mes"));
        novadata.setMes(dadoInt);
        //DIA
        do{
            loop=0;
            dado=perguntaGeral("Dia: ","inteiro",null);
            dadoInt=Integer.parseInt(dado);
            if (dadoInt >=32 || dadoInt<=0 || (dadoInt==31 && (novadata.getMes()==2 || novadata.getMes()==4 || novadata.getMes()==6 || novadata.getMes()==9 || novadata.getMes()==11) ) || (dadoInt >= 29 && novadata.getMes()==2)){
                System.out.println("Este Dia Não é Válido!");
                loop=1;
            }
        }while(loop==1);
        novadata.setDia(dadoInt);
        novaViagem.setData(novadata);
       
        //AUTOCARROS + Protecoes
        System.out.print("\nAutocarros Disponiveis: \n\n");
       
        do{
            loop=1;
            for(int i=0;i<manager.autocarros.size();i++){
                System.out.println("Autocarro nº"+i+". Matricula:"+manager.autocarros.get(i).getMatricula()+" | Lugares:"+manager.autocarros.get(i).getCapacidade());
            }
            dado=perguntaGeral("\n-1.Acabar Seleção de Autocarros!!!\n\nEscolha(Nº Autocarro): ","inteiro",null);
            dadoInt=Integer.parseInt(dado);
            if(dadoInt>=manager.autocarros.size() || dadoInt < -1){
                System.out.println("\nPor Favor, Introduza Um Autocarro Listado!\n");
                Thread.sleep(1500);
            }
            if(dadoInt == -1){
                if(novaViagem.getAutocarros().isEmpty()){
                    System.out.println("\nA Viagem Precisa De Pelo Menos 1 Autocarro\n");
                    Thread.sleep(1500);
                }
                else{
                    break;
                }
            }
            else{
                loop=0;
                for(int i=0;i<novaViagem.getAutocarros().size();i++){
                    if (manager.autocarros.get(dadoInt).getMatricula().equals(novaViagem.getAutocarros().get(i).getMatricula())){
                        System.out.println("\nEste Autocarro Já Se Encontra Na Viagem!\n");
                        Thread.sleep(1500);
                        loop=1;
                    }
                }
                if(loop==0){
                        novaViagem.setAutocarros(manager.autocarros.get(dadoInt));
                        System.out.println("\nAutocarro Adicionado!\n");
                        Thread.sleep(1500);
                        loop=1;
                }
            }
        }while(loop==1);
       
        manager.viagens.add(novaViagem);
        System.out.println("\nSuccess: Viagem Criada! :)");
        Thread.sleep(3000);
    }
    /** alterarViagem - Funcao usada para alterar uma viagem.
     * @param manager - Classe Manager Com todos Os Arraylists de Informacao do Programa.
     * @throws java.lang.InterruptedException - Thread.Sleep() causa esta excepcao.
     */
    public static void alterarViagem(Manager manager) throws InterruptedException{
        String dado;
        Double dadoDouble;
        int dadoInt,loop,numero;
        if(manager.viagens.isEmpty()){
            System.out.println("\nErro! Não Existem Viagens.\n");
            Thread.sleep(3000);
            return;
        }
       
        System.out.println("\n\n\t\t------ALTERAR VIAGEM------\n\n");
       
        System.out.println("Escolha Uma Viagem:\n");
        do{
            loop=0;
            for (int i=0;i<manager.viagens.size();i++){
                System.out.println("Viagem nº"+i+". Codigo:"+manager.viagens.get(i).getCodigo()+" | Origem:"+manager.viagens.get(i).getOrigem()+" | Destino:"+manager.viagens.get(i).getDestino());
            }
            dado=perguntaGeral("\nEscolha(Nº Viagem): ","inteiro",null);
            numero=Integer.parseInt(dado); //neste caso dadoInt e o numero da viagem no array.
            if(numero>=manager.viagens.size() || numero < 0){
                System.out.println("\nPor Favor, Introduza Uma Viagem Listada!\n");
                Thread.sleep(1500);
                loop=1;
            }
        }while(loop==1);
       
        System.out.println("1.Codigo:"+manager.viagens.get(numero).getCodigo()
                +"\n2.Origem:"+manager.viagens.get(numero).getOrigem()
                +"\n3.Destino:"+manager.viagens.get(numero).getDestino()
                +"\n4.Data:"+manager.viagens.get(numero).getData().getDia()+"/"+manager.viagens.get(numero).getData().getMes()+"/"+manager.viagens.get(numero).getData().getAno()
                +"\n5.Duração:"+manager.viagens.get(numero).getDuracao()
                +"\n6.Preço:"+manager.viagens.get(numero).getPreco()+" Euros"
                +"\n8.Autocarros"
                + "\n0.Voltar.");
       
        do{
            loop=0;
            dado=perguntaGeral("\nAlterar: ","inteiro",null);
            dadoInt=Integer.parseInt(dado); //neste caso dadoInt e a opcao.
            if(dadoInt>8 || dadoInt < 0){
                System.out.println("\nPor Favor, Introduza Uma Opção Válida!\n");
                loop=1;
            }
        }while(loop==1);
            do{
                switch(dadoInt){
                case 1:dado=perguntaGeral("Codigo: ","inteiro",null);
                       dadoInt=Integer.parseInt(dado);
                       manager.viagens.get(numero).setCodigo(dadoInt);break;
       
                case 5:dado=perguntaGeral("Duração(minutos): ","inteiro",null);
                      dadoInt=Integer.parseInt(dado);
                      manager.viagens.get(numero).setDuracao(dadoInt);break;
       
                case 6:dado=perguntaGeral("Preço: ","double",null);
                      dadoDouble=Double.valueOf(dado);
                      manager.viagens.get(numero).setPreco(dadoDouble);break;
 
                case 2:dado=perguntaGeral("Origem: ","string",null);
                      manager.viagens.get(numero).setOrigem(dado);break;
       
                case 3:dado=perguntaGeral("Destino: ","string",null);
                      manager.viagens.get(numero).setDestino(dado);break;
       
                case 4: Data novadata= new Data();
                      System.out.println("Data Da Viagem:");
                   
                        dadoInt=Integer.parseInt(perguntaGeral("","data","ano"));
                        novadata.setAno(dadoInt);
       
                        dadoInt=Integer.parseInt(perguntaGeral("","data","mes"));
                        novadata.setMes(dadoInt);
                   
                        do{
                            loop=0;
                            dado=perguntaGeral("Dia: ","inteiro",null);
                            dadoInt=Integer.parseInt(dado);
                            if (dadoInt >=32 || dadoInt<=0 || (dadoInt==31 && (novadata.getMes()==2 || novadata.getMes()==4 || novadata.getMes()==6 || novadata.getMes()==9 || novadata.getMes()==11) ) || (dadoInt >= 29 && novadata.getMes()==2)){
                                System.out.println("Este Dia Não é Válido!");
                                loop=1;
                            }
                        }while(loop==1);
                        novadata.setDia(dadoInt);
                        manager.viagens.get(numero).setData(novadata);
                        break;
                case 7:
                    System.out.print("\n\n1.Adicionar\n2.Remover: \n\n");
                    do{
                        loop=0;
                        dado=perguntaGeral("\nEscolha: ","inteiro",null);
                        dadoInt=Integer.parseInt(dado); //neste caso dadoInt e o numero da viagem no array.
                        if(dadoInt>=3 || dadoInt <= 0){
                            System.out.println("\nPor Favor, Introduza Uma Opção Listada!\n");
                            Thread.sleep(1500);
                            loop=1;
                        }
                    }while(loop==1);
                    if (dadoInt==1){
                        do{
                            loop=1;
 
                            System.out.print("\nAutocarros Na Viagem: \n\n");
                            for(int i=0;i<manager.viagens.get(numero).getAutocarros().size();i++){
                                System.out.println("Autocarro nº"+i+". Matricula:"+manager.viagens.get(numero).getAutocarros().get(i).getMatricula()+" | Lugares:"+manager.viagens.get(numero).getAutocarros().get(i).getCapacidade());
                            }
                   
                            System.out.print("\nAutocarros Disponiveis: \n\n");
                            for(int i=0;i<manager.autocarros.size();i++){
                                System.out.println("Autocarro nº"+i+". Matricula:"+manager.autocarros.get(i).getMatricula()+" | Lugares:"+manager.autocarros.get(i).getCapacidade());
                            }
                   
                            dado=perguntaGeral("\n-1.Acabar Seleção de Autocarros!!!\n\nEscolha(Nº Autocarro): ","inteiro",null);
                            dadoInt=Integer.parseInt(dado);
                            if(dadoInt>=manager.viagens.get(numero).getAutocarros().size() || dadoInt < -1){
                                System.out.println("\nPor Favor, Introduza Um Autocarro Listado!\n");
                                Thread.sleep(1500);
                            }
                            if(dadoInt == -1){
                                if(manager.viagens.get(numero).getAutocarros().isEmpty()){
                                    System.out.println("\nA Viagem Precisa De Pelo Menos 1 Autocarro\n");
                                    Thread.sleep(1500);
                                }
                                else{
                                    break;
                                }
                            }
                            else{
                                loop=0;
                                for(int i=0;i<manager.viagens.get(numero).getAutocarros().size();i++){
                                    if (manager.autocarros.get(dadoInt).getMatricula().equals(manager.viagens.get(numero).getAutocarros().get(i).getMatricula())){
                                        System.out.println("\nEste Autocarro Já Se Encontra Na Viagem!\n");
                                        Thread.sleep(1500);
                                        loop=1;
                                    }
                                }
                                if(loop==0){
                                    manager.viagens.get(numero).setAutocarros(manager.autocarros.get(dadoInt));
                                    System.out.println("\nAutocarro Adicionado!\n");
                                    Thread.sleep(1500);
                                    loop=1;
                                }
                            }
                        }while(loop==1);
                        break;
                    }
                    else{
                        do{
                            loop=1;
                            System.out.print("\nAutocarros Na Viagem: \n\n");
                            for(int i=0;i<manager.viagens.get(numero).getAutocarros().size();i++){
                                System.out.println("Autocarro nº"+i+". Matricula:"+manager.viagens.get(numero).getAutocarros().get(i).getMatricula()+" | Lugares:"+manager.viagens.get(numero).getAutocarros().get(i).getCapacidade());
                            }
                       
                            dado=perguntaGeral("\n-1.Acabar Seleção de Autocarros!!!\n\nEscolha(Nº Autocarro): ","inteiro",null);
                            dadoInt=Integer.parseInt(dado);
                            if(dadoInt == -1){
                                break;
                            }
                            if(dadoInt>=manager.viagens.get(numero).getAutocarros().size() || dadoInt < -1){
                                System.out.println("\nPor Favor, Introduza Um Autocarro Listado!\n");
                                Thread.sleep(1500);
                            }
                            else{
                                manager.viagens.get(numero).getAutocarros().remove(dadoInt);
                                System.out.println("\nAutocarro Removido!");
                                Thread.sleep(1500);
                            }
                        }while(loop==1);
                        break;
                    }
            }
            if(manager.viagens.get(numero).getAutocarros().isEmpty()){
                System.out.println("\nAntes de Sair, Por favor , Adicione um Autocarro!\n");
                Thread.sleep(3000);
                dadoInt=8;
            }
        }while(manager.viagens.get(numero).getAutocarros().isEmpty());
        System.out.println("\nSuccess: Viagem Alterada! :)");
        Thread.sleep(3000);
    }
    /** mostrarViagem - Funcao usada para visualizar Viagens nao realizadas.
     * @param manager - Classe Manager Com todos Os Arraylists de Informacao do Programa.
     * @throws InterruptedException - Thread.Sleep() causa esta excepcao.
     */
    public static void mostrarViagem(Manager manager) throws InterruptedException{
        String dado;
        int numero,loop,dadoInt;
        if(manager.viagens.isEmpty()){
            System.out.println("\nErro! Não Existem Viagens.\n");
            Thread.sleep(3000);
            return;
        }
        System.out.println("\n\n\t\t------MOSTRAR VIAGENS------\n\n");
        //Mostrar Todas as Viagens
        System.out.println("Escolha Uma Viagem:\n");
        do{
            loop=0;
            for (int i=0;i<manager.viagens.size();i++){
                System.out.println("Viagem nº"+i+". Codigo:"+manager.viagens.get(i).getCodigo()+" | Origem:"+manager.viagens.get(i).getOrigem()+" | Destino:"+manager.viagens.get(i).getDestino());
            }
            dado=perguntaGeral("\nEscolha(Nº Viagem): ","inteiro",null);
            numero=Integer.parseInt(dado); //neste caso dadoInt e o numero da viagem no array.
            if(numero>=manager.viagens.size() || numero < 0){
                System.out.println("\nPor Favor, Introduza Uma Viagem Listada!\n");
                Thread.sleep(1500);
                loop=1;
            }
        }while(loop==1);
       
        System.out.println(""+manager.viagens.get(numero).toString());
        for (int i=0;i<manager.viagens.get(numero).getAutocarros().size();i++){
                System.out.println("Autocarro nº"+i+": Matricula:"+manager.viagens.get(numero).getAutocarros().get(i).getMatricula()+"| Capacidade:"+manager.viagens.get(numero).getAutocarros().get(i).getCapacidade());
        }
        System.out.println("\n0.Voltar");
       
        do{
            loop=0;
            dado=perguntaGeral("\nEscolha: ","inteiro",null);
            dadoInt=Integer.parseInt(dado);
            if(dadoInt!=0){
                System.out.println("ERRO! Não Existe Essa Opção!");
                loop=1;
            }
        }while(loop==1);
        System.out.println("\nSuccess: Voltando Para O Menu! :)");
        Thread.sleep(3000);
    }
    /** removerViagem - Funcao usada para remover Viagens nao realizadas.
     * @param manager - Classe Manager Com todos Os Arraylists de Informacao do Programa.
     * @throws InterruptedException - Thread.Sleep() causa esta excepcao.
     */
    public static void removerViagem(Manager manager) throws InterruptedException{
        String dado;
        int numero,loop;
        if(manager.viagens.isEmpty()){
            System.out.println("\nErro! Não Existem Viagens.\n");
            Thread.sleep(3000);
            return;
        }
        System.out.println("\n\n\t\t------REMOVER VIAGENS------\n\n");
        do{
            loop=0;
            for (int i=0;i<manager.viagens.size();i++){
                System.out.println("Viagem nº"+i+". Codigo:"+manager.viagens.get(i).getCodigo()+" | Origem:"+manager.viagens.get(i).getOrigem()+" | Destino:"+manager.viagens.get(i).getDestino());
            }
            dado=perguntaGeral("\nEscolha(Nº Viagem): ","inteiro",null);
            numero=Integer.parseInt(dado);
            if(numero>=manager.viagens.size() || numero < 0){
                System.out.println("\nPor Favor, Introduza Uma Viagem Listada Para Remover!\n");
                Thread.sleep(1500);
                loop=1;
            }
        }while(loop==1);
       
        manager.viagens.remove(numero);
        System.out.println("\nSuccess: Viagem Removida! :)");
        Thread.sleep(3000);
    }
    /** criarAutocarro - Funcao usada para criar Autocarros. 
     * @param manager - Classe Manager Com todos Os Arraylists de Informacao do Programa.
     * @throws InterruptedException - Thread.Sleep() causa esta excepcao.
     */
    public static void criarAutocarro(Manager manager) throws InterruptedException{
     
       Autocarro novoAuto = new Autocarro();
        String dado;
        int dadoInt,loop;
        System.out.println("\n\n\t\t------CRIAR AUTOCARRO------\n\n");
       
        do{
            loop=0;
            dado=perguntaGeral("Matricula: ","string",null);
            if(!(8==dado.length() && "-".equals(dado.substring(2,3)) && "-".equals(dado.substring(5,6)))){
                System.out.println("Matricula Não Válida!");
                loop=1;
            }
            for (Autocarro autocarro : manager.autocarros) {
                if (dado.equals(autocarro.getMatricula())) {
                    System.out.println("Matricula Já Usada!");
                    loop=1;
                }
            }
        }while(loop==1);
        novoAuto.setMatricula(dado);
       
        dado=perguntaGeral("Capacidade: ","inteiro",null);
        dadoInt=Integer.parseInt(dado);
        novoAuto.setCapacidade(dadoInt);        
       
        manager.autocarros.add(novoAuto);
       
        System.out.println("\nSuccess: Autocarro Criado! :)");
        Thread.sleep(3000);
    }
    /** alterarAutocarro - Funcao usada para alterar Autocarros.
     * @param manager - Classe Manager Com todos Os Arraylists de Informacao do Programa.
     * @throws InterruptedException - Thread.Sleep() causa esta excepcao.
     */
    public static void alterarAutocarro(Manager manager) throws InterruptedException{
      String dado;
        Double dadoDouble;
        int dadoInt,loop,numero;
        //Protecao (Autocarros Vazios)
        if(manager.autocarros.isEmpty()){
            System.out.println("\nErro! Não Existem Autocarros.\n");
            Thread.sleep(3000);
            return;
        }
       
        System.out.println("\n\n\t\t------ALTERAR AUTOCARRO------\n\n");
       
        System.out.println("Escolha Um Autocarro:\n");
        do{
            loop=0;
            for (int i=0;i<manager.autocarros.size();i++){
                System.out.println("Autocarro nº"+i+". Matricula:"+manager.autocarros.get(i).getMatricula()+"| Capacidade:"+manager.autocarros.get(i).getCapacidade());
            }
            dado=perguntaGeral("\nEscolha(Nº Autocarro): ","inteiro",null);
            numero=Integer.parseInt(dado); //neste caso dadoInt e o numero da viagem no array.
            if(numero>=manager.autocarros.size() || numero < 0){
                System.out.println("\nPor Favor, Introduza Um Autocarro Listado!\n");
                Thread.sleep(1500);
                loop=1;
            }
        }while(loop==1);
       
        dado=perguntaGeral("\nNova Capacidade: ","inteiro",null);
        dadoInt=Integer.parseInt(dado);
        for (int i=0;i<manager.viagens.size();i++){
            for (int j=0;j<manager.viagens.get(i).getAutocarros().size();j++){
                if(manager.autocarros.get(numero).getMatricula().equals(manager.viagens.get(i).getAutocarros().get(j).getMatricula())){
                    manager.viagens.get(i).alterarNumReservasMax(manager.viagens.get(i).getAutocarros().get(j).getCapacidade(), dadoInt);
                    manager.viagens.get(i).getAutocarros().get(j).setCapacidade(dadoInt);
                }
            }
        }
        manager.autocarros.get(numero).setCapacidade(dadoInt);
        System.out.println("\nSuccess: Autocarro Alterado! :)");
        Thread.sleep(3000);
    }
    /** mostrarAutocarro - Funcao usada para visualizar Autocarros.
     * @param manager - Classe Manager Com todos Os Arraylists de Informacao do Programa.
     * @throws InterruptedException - Thread.Sleep() causa esta excepcao.
     */
    public static void mostrarAutocarro(Manager manager) throws InterruptedException{
        
        String dado;
        int numero,loop,dadoInt;
        if(manager.autocarros.isEmpty()){
            System.out.println("\nErro! Não Existem Autocarros.\n");
            Thread.sleep(3000);
            return;
        }
        System.out.println("\n\n\t\t------MOSTRAR AUTOCARROS------\n\n");
        //Mostrar Todas as Viagens
        System.out.println("Escolha Um Autocarro:\n");
        do{
            loop=0;
            for (int i=0;i<manager.autocarros.size();i++){
                System.out.println("Autocarro nº"+i+". Matricula:"+manager.autocarros.get(i).getMatricula()+"| Capacidade:"+manager.autocarros.get(i).getCapacidade());
            }
            dado=perguntaGeral("\nEscolha(Nº Autocarro): ","inteiro",null);
            numero=Integer.parseInt(dado); //neste caso dadoInt e o numero da viagem no array.
            if(numero>=manager.autocarros.size() || numero < 0){
                System.out.println("\nPor Favor, Introduza Um Autocarro Listado!\n");
                Thread.sleep(1500);
                loop=1;
            }
        }while(loop==1);
       
        System.out.println("\nAutocarro nº"+numero+"\nMatricula:"+manager.autocarros.get(numero).getMatricula()+"\nCapacidade:"+manager.autocarros.get(numero).getCapacidade()+"\n\n0.Voltar");
       
        do{
            loop=0;
            dado=perguntaGeral("\nEscolha: ","inteiro",null);
            dadoInt=Integer.parseInt(dado);
            if(dadoInt!=0){
                System.out.println("ERRO! Não Existe Essa Opção!");
                loop=1;
            }
        }while(loop==1);
        System.out.println("\nSuccess: Voltando Para O Menu! :)");
        Thread.sleep(3000);
    }
    /** removerAutocarro - Funcao usada para remover Autocarros.
     * @param manager - Classe Manager Com todos Os Arraylists de Informacao do Programa.
     * @throws InterruptedException - Thread.Sleep() causa esta excepcao.
     */
    public static void removerAutocarro(Manager manager) throws InterruptedException{
        
        String dado;
        int numero,loop;
        if(manager.autocarros.isEmpty()){
            System.out.println("\nErro! Não Existem Autocarros.\n");
            Thread.sleep(3000);
            return;
        }
       
        System.out.println("\n\n\t\t------REMOVER AUTOCARROS------\n\n");
        //Mostrar Todas os Autocarros
        System.out.println("Escolha Um Autocarro:\n");
        do{
            loop=0;
            for (int i=0;i<manager.autocarros.size();i++){
                System.out.println("Autocarro nº"+i+". Matricula:"+manager.autocarros.get(i).getMatricula()+"| Capacidade:"+manager.autocarros.get(i).getCapacidade());
            }
            dado=perguntaGeral("\nEscolha(Nº Autocarro): ","inteiro",null);
            numero=Integer.parseInt(dado); //neste caso dadoInt e o numero da viagem no array.
            if(numero>=manager.autocarros.size() || numero < 0){
                System.out.println("\nPor Favor, Introduza Um Autocarro Listado!\n");
                Thread.sleep(1500);
                loop=1;
            }
        }while(loop==1);
       
        for (int i=0;i<manager.viagens.size();i++){
            for (int j=0;j<manager.viagens.get(i).getAutocarros().size();j++){
                if(manager.autocarros.get(numero).getMatricula().equals(manager.viagens.get(i).getAutocarros().get(j).getMatricula())){
                    System.out.println("ERRO! Autocarro Utilizado Numa Viagem!\nVoltando ao Menu...");
                    Thread.sleep(2500);
                    return;
                }
            }
        }
               
        manager.autocarros.remove(numero);
        System.out.println("\nSuccess: Viagem Removida! :)");
        Thread.sleep(3000);
    }
    /** criarCliente - Funcao usada para criar Cliente.
     * @param manager - Classe Manager Com todos Os Arraylists de Informacao do Programa.
     * @throws InterruptedException - Thread.Sleep() causa esta excepcao.
     */
    public static void criarCliente(Manager manager) throws InterruptedException{
       
        int dadoInt,loop,tipo;
        String dado;
        Premium novoPremium = new Premium();
        Regular novoRegular = new Regular();
       
        System.out.println("\n\n\t\t------ CRIAR CLIENTE------\n\n");
       
        System.out.println("1.Premium\n2.Regular");
        do{
            loop=0;
            dado=perguntaGeral("\nEscolha: ","inteiro",null);
            tipo=Integer.parseInt(dado); //neste caso dadoInt e o numero da viagem no array.
            if(tipo> 3 || tipo < 0){
                System.out.println("\nERRO! Opcão Não Valida\n");
                Thread.sleep(1500);
                loop=1;
            }
        }while(loop==1);
       
       
        do{
            loop=0;
            dado=perguntaGeral("Username: ","string",null);
            for (Cliente cliente : manager.clientes) {
                if (dado.equals(cliente.getUsername())) {
                    System.out.println("Username Já Utilizado");
                    loop=1;
                }
            }
        }while(loop==1);
        if(tipo == 1){
            novoPremium.setUsername(dado);
        }
        else{
            novoRegular.setUsername(dado);
        }
       
        dado=perguntaGeral("Nome: ","string",null);
        if(tipo == 1){
            novoPremium.setNome(dado);
        }
        else{
            novoRegular.setNome(dado);
        }
       
        dado=perguntaGeral("Morada: ","string",null);
        if(tipo == 1){
            novoPremium.setMorada(dado);
        }
        else{
            novoRegular.setMorada(dado);
        }
       
        do{
            loop=0;
            dado=perguntaGeral("Email: ","string",null);
            if(-1==dado.indexOf("@")){
                System.out.println("Email Não Valido");
                loop=1;
            }
        }while(loop==1);
        if(tipo == 1){
            novoPremium.setEmail(dado);
        }
        else{
            novoRegular.setEmail(dado);
        }
       
        do{
            loop=0;
            dado=perguntaGeral("NIF: ","inteiro",null);
            dadoInt=Integer.parseInt(dado);
            if ((dadoInt >= 999999999 || dadoInt <= 100000000)){
                System.out.println("ERRO! NIF Precisa De 9 Números");
                loop=1;
            }
            for (Cliente cliente: manager.clientes){
                if (dadoInt==cliente.getNif()){
                    System.out.println("ERRO! NIF Já Se Encontra No Sistema");
                    loop=1;
                }
            }
        }while(loop==1);
        if(tipo == 1){
            novoPremium.setNif(dadoInt);
        }
        else{
            novoRegular.setNif(dadoInt);
        }
       
        do{
            loop=0;
            dado=perguntaGeral("Telefone: ","inteiro",null);
            dadoInt=Integer.parseInt(dado);
            if ((dadoInt >= 999999999 || dadoInt <= 100000000)){
                System.out.println("ERRO! Telefone Precisa De 9 Números");
                loop=1;
            }
        }while(loop==1);
        if(tipo == 1){
            novoPremium.setTelefone(dadoInt);
        }
        else{
            novoRegular.setTelefone(dadoInt);
        }
       
        dado=perguntaGeral("Password: ","string",null);
        if(tipo == 1){
            novoPremium.setPassword(dado);
        }
        else{
            novoRegular.setPassword(dado);
        }
       
        if(tipo == 1){
            manager.clientes.add(novoPremium);
        }
        else{
            manager.clientes.add(novoRegular);
        }
       
        System.out.println("\nSuccess: Cliente Criado! :)");
        Thread.sleep(3000);
    }
    /** alterarCliente - Funcao usada para alterar Clientes.
     * @param manager - Classe Manager Com todos Os Arraylists de Informacao do Programa.
     * @throws InterruptedException - Thread.Sleep() causa esta excepcao.
     */
    public static void alterarCliente(Manager manager) throws InterruptedException{
        String dado;
        int dadoInt,loop,numero;
        //Protecao (Autocarros Vazios)
        if(manager.clientes.isEmpty()){
            System.out.println("\nErro! Não Existem Clientes\n");
            Thread.sleep(3000);
            return;
        }
       
        System.out.println("\n\n\t\t------ALTERAR CLIENTE------\n\n");
       
        System.out.println("Escolha Um Cliente:\n");
        do{
            loop=0;
            for (int i=0;i<manager.clientes.size();i++){
                System.out.println("Cliente nº"+i+" Nome:"+manager.clientes.get(i).getNome()+"| NIF:"+manager.clientes.get(i).getNif());
            }
            dado=perguntaGeral("\nEscolha(Nº Cliente): ","inteiro",null);
            numero=Integer.parseInt(dado); //neste caso dadoInt e o numero da viagem no array.
            if(numero>=manager.clientes.size() || numero < 0){
                System.out.println("\nPor Favor, Introduza Um Autocarro Listado!\n");
                Thread.sleep(1500);
                loop=1;
            }
        }while(loop==1);
       
        System.out.println("\n1.Username:"+manager.clientes.get(numero).getUsername()
                +"\n2.Nome:"+manager.clientes.get(numero).getNome()
                +"\n3.Morada:"+manager.clientes.get(numero).getMorada()
                +"\n4.Email:"+manager.clientes.get(numero).getEmail()
                +"\n5.Telefone:"+manager.clientes.get(numero).getTelefone()
                +"\n6.Password:"+manager.clientes.get(numero).getPassword()
                +"\n\n0.Voltar");
 
        do{
            loop=0;
            dado=perguntaGeral("\nAlterar: ","inteiro",null);
            dadoInt=Integer.parseInt(dado); //neste caso dadoInt e a opcao.
            if(dadoInt>6 || dadoInt < 0){
                System.out.println("\nPor Favor, Introduza Uma Opção Válida!\n");
                loop=1;
            }
        }while(loop==1);
       
        switch(dadoInt){
            case 1:do{
                    loop=0;
                    dado=perguntaGeral("Username: ","string",null);
                    for (Cliente cliente : manager.clientes) {
                        if (dado.equals(cliente.getUsername())) {
                            System.out.println("Username Já Utilizado");
                            loop=1;
                        }
                    }
                    }while(loop==1);
                    manager.clientes.get(numero).setUsername(dado);break;
               
            case 2:dado=perguntaGeral("Nome: ","string",null);
                   manager.clientes.get(numero).setNome(dado);break;
       
            case 3:dado=perguntaGeral("Morada: ","string",null);
                   manager.clientes.get(numero).setMorada(dado);break;
               
            case 4:do{
                    loop=0;
                    dado=perguntaGeral("Email: ","string",null);
                    if(-1==dado.indexOf("@")){
                        System.out.println("Email Não Valido");
                        loop=1;
                    }
                   }while(loop==1);
                   manager.clientes.get(numero).setEmail(dado);break;
               
            case 5:do{
                    loop=0;
                    dado=perguntaGeral("Telefone: ","inteiro",null);
                    dadoInt=Integer.parseInt(dado);
                    if ((dadoInt >= 999999999 || dadoInt <= 100000000)){
                        System.out.println("ERRO! Telefone Precisa De 9 Números");
                        loop=1;
                    }
                   }while(loop==1);
                   manager.clientes.get(numero).setTelefone(dadoInt);break;
       
            case 6:dado=perguntaGeral("Password: ","string",null);
                   manager.clientes.get(numero).setPassword(dado);break;
           
            case 0:break;
        }
       
        System.out.println("\nSuccess: Cliente Alterado! :)");
        Thread.sleep(3000);
    }
    /** monstrarCliente - Funcao usada para visualizar Clientes.
     * @param manager - Classe Manager Com todos Os Arraylists de Informacao do Programa.
     * @throws InterruptedException - Thread.Sleep() causa esta excepcao.
     */
    public static void mostrarCliente(Manager manager) throws InterruptedException{
        String dado;
        int loop,numero,dadoInt;
       
        if(manager.clientes.isEmpty()){
            System.out.println("\nErro! Não Existem Clientes\n");
            Thread.sleep(3000);
            return;
        }
       
        System.out.println("\n\n\t\t------MOSTRAR CLIENTES------\n\n");
       
        System.out.println("Escolha Um Cliente:\n");
        do{
            loop=0;
            for (int i=0;i<manager.clientes.size();i++){
                System.out.println("Cliente nº"+i+" Nome:"+manager.clientes.get(i).getNome()+"| NIF:"+manager.clientes.get(i).getNif());
            }
            dado=perguntaGeral("\nEscolha(Nº Cliente): ","inteiro",null);
            numero=Integer.parseInt(dado); //neste caso dadoInt e o numero da viagem no array.
            if(numero>=manager.clientes.size() || numero < 0){
                System.out.println("\nPor Favor, Introduza Um Cliente Listado!\n");
                Thread.sleep(1500);
                loop=1;
            }
        }while(loop==1);
       
        System.out.println(""+manager.clientes.get(numero).toString());
        for(int i=0;i<manager.clientes.get(numero).getReservas().size();i++){
            System.out.println(""+manager.clientes.get(numero).getReservas().get(i).getViagem().getCodigo());
        }
        System.out.println("\n\n0.Voltar");
       
        do{
            loop=0;
            dado=perguntaGeral("\nEscolha: ","inteiro",null);
            dadoInt=Integer.parseInt(dado);
            if(dadoInt!=0){
                System.out.println("ERRO! Não Existe Essa Opção!");
                loop=1;
            }
        }while(loop==1);
        //exit
        System.out.println("\nSuccess: Voltando Para O Menu! :)");
        Thread.sleep(3000);
    }
    /** removerCliente - Funcao usada para remover Clientes.
     * @param manager - Classe Manager Com todos Os Arraylists de Informacao do Programa.
     * @throws InterruptedException - Thread.Sleep() causa esta excepcao.
     */
    public static void removerCliente(Manager manager) throws InterruptedException{
        
        String dado;
        int loop,numero,dadoInt;
       
        if(manager.clientes.isEmpty()){
            System.out.println("\nErro! Não Existem Clientes\n");
            Thread.sleep(3000);
            return;
        }
       
        System.out.println("\n\n\t\t------REMOVER CLIENTES------\n\n");
       
        System.out.println("Escolha Um Cliente:\n");
        do{
            loop=0;
            for (int i=0;i<manager.clientes.size();i++){
                System.out.println("Cliente nº"+i+" Nome:"+manager.clientes.get(i).getNome()+"| NIF:"+manager.clientes.get(i).getNif());
            }
            dado=perguntaGeral("\nEscolha(Nº Cliente): ","inteiro",null);
            numero=Integer.parseInt(dado); //neste caso dadoInt e o numero da viagem no array.
            if(numero>=manager.clientes.size() || numero < 0){
                System.out.println("\nPor Favor, Introduza Um Cliente Listado!\n");
                Thread.sleep(1500);
                loop=1;
            }
        }while(loop==1);
       
        manager.clientes.remove(numero);
        System.out.println("\nSuccess: Cliente Removido! :)");
        Thread.sleep(3000);
    }
    /** viagemMaisVendida - Funcao usada para determinar Viagem mais vendida de um determinado mes.
     * @param manager - Classe Manager Com todos Os Arraylists de Informacao do Programa.
     * @throws InterruptedException - Thread.Sleep() causa esta excepcao.
     */
    public static void viagemMaisVendida(Manager manager) throws InterruptedException{
       
        int contador=0,numero=0,dadoInt,loop,ano,mes,check=0;
        String dado;
        if(manager.viagensRealizadas.isEmpty()){
            System.out.println("\nErro! Não Existem Viagens Realizadas.\n");
            Thread.sleep(3000);
            return;
        }
        
        ano=Integer.parseInt(perguntaGeral("","data","ano"));
        for (Viagem viagensRealizada : manager.viagensRealizadas) {
            if (viagensRealizada.getData().getAno() == ano) {
                check=1;
            }
        }
        
        mes=Integer.parseInt(perguntaGeral("","data","mes"));
        for (Viagem viagensRealizada : manager.viagensRealizadas) {
            if (viagensRealizada.getData().getMes() == mes && viagensRealizada.getData().getAno()==ano) {
                check=1;
            }
        }
        
        if(check==0){
            System.out.println("ERRO! Nao Existem Viagens Efetuadas Nesse Mes do Ano\nVoltando ao Menu...");
            Thread.sleep(2000);
            return;
        }
        
        for(int i=0;i<manager.viagensRealizadas.size();i++){
            if(manager.viagensRealizadas.get(i).getNumReservas() > contador && manager.viagensRealizadas.get(i).getData().getAno()==ano && manager.viagensRealizadas.get(i).getData().getMes()==mes){
                contador=manager.viagensRealizadas.get(i).getNumReservas();
                numero=i;
            }
        }
        System.out.println("A Viagem Mais Vendida:");
        System.out.println(""+manager.viagensRealizadas.get(numero).toString());
        System.out.println("\n\n0.Voltar");
       
        do{
            loop=0;
            dado=perguntaGeral("\nEscolha: ","inteiro",null);
            dadoInt=Integer.parseInt(dado);
            if(dadoInt!=0){
                System.out.println("ERRO! Não Existe Essa Opção!");
                loop=1;
            }
        }while(loop==1);
        System.out.println("\nSuccess: Voltando ao Menu... :)");
        Thread.sleep(3000);
    }
    /** clienteMaisViagens - Funcao usada para determinar o Cliente com Mais Viagens Efetuadas.
     * @param manager - Classe Manager Com todos Os Arraylists de Informacao do Programa.
     * @throws InterruptedException - Thread.Sleep() causa esta excepcao.
     */
    public static void clienteMaisViagens(Manager manager) throws InterruptedException{
        
        int contador=0,numero=0,loop,dadoInt,check=0,ano,mes;
        String dado;
        
        if(manager.clientes.isEmpty()){
            System.out.println("\nErro! Não Existem Clientes\n");
            Thread.sleep(3000);
            return;
        }
       
        ano=Integer.parseInt(perguntaGeral("","data","ano"));
        for (Viagem viagensRealizada : manager.viagensRealizadas) {
            if (viagensRealizada.getData().getAno() == ano) {
                check=1;
            }
        }
        
        mes=Integer.parseInt(perguntaGeral("","data","mes"));
        for (Viagem viagensRealizada : manager.viagensRealizadas) {
            if (viagensRealizada.getData().getMes() == mes && viagensRealizada.getData().getAno()==ano) {
                check=1;
            }
        }
        
        if(check==0){
            System.out.println("ERRO! Nao Existem Viagens Efetuadas Nesse Mes do Ano\nVoltando ao Menu...");
            Thread.sleep(2000);
            return;
        }
        
        for(int i=0;i<manager.clientes.size();i++){
            if(manager.clientes.get(i).getReservas().size() > contador){
                contador = manager.clientes.get(i).getReservas().size();
                numero=i;
            }
        }
       
        System.out.println("Cliente Com Mais Viagens:");
        manager.clientes.get(numero).toString();
        System.out.println("\n\n0.Voltar");
       
        do{
            loop=0;
            dado=perguntaGeral("\nEscolha: ","inteiro",null);
            dadoInt=Integer.parseInt(dado);
            if(dadoInt!=0){
                System.out.println("ERRO! Não Existe Essa Opção!");
                loop=1;
            }
        }while(loop==1);
       
        System.out.println("\nSuccess: Voltando ao Menu... :)");
        Thread.sleep(3000);
    }
    /** viagemSemReservas - Funcao usada para visualizar as Viagens sem Reservas.
     * @param manager - Classe Manager Com todos Os Arraylists de Informacao do Programa.
     * @throws InterruptedException - Thread.Sleep() causa esta excepcao.
     */
    public static void viagemSemReservas(Manager manager) throws InterruptedException{
     
        int dadoInt,loop,check=0,ano,mes;
        String dado;
        if(manager.viagens.isEmpty()){
            System.out.println("\nErro! Não Existem Viagens.\n");
            Thread.sleep(3000);
            return;
        }
        
        ano=Integer.parseInt(perguntaGeral("","data","ano"));
        for (Viagem viagensRealizada : manager.viagensRealizadas) {
            if (viagensRealizada.getData().getAno() == ano) {
                check=1;
            }
        }
        
        mes=Integer.parseInt(perguntaGeral("","data","mes"));
        for (Viagem viagensRealizada : manager.viagensRealizadas) {
            if (viagensRealizada.getData().getMes() == mes && viagensRealizada.getData().getAno()==ano) {
                check=1;
            }
        }
        
        if(check==0){
            System.out.println("ERRO! Nao Existem Viagens Efetuadas Nesse Mes do Ano\nVoltando ao Menu...");
            Thread.sleep(2000);
            return;
        }
        
        System.out.println("\n\n\t\t------VIAGENS SEM RESERVAS------\n\n");
       
        for (int i=0;i<manager.viagens.size();i++){
            if(manager.viagens.get(i).getNumReservas()==0 && manager.viagensRealizadas.get(i).getData().getAno()==ano && manager.viagensRealizadas.get(i).getData().getMes()==mes){
                System.out.println(""+manager.viagens.get(i).toString());
                for (int j=0;j<manager.viagens.get(i).getAutocarros().size();j++){
                    System.out.println("Autocarro nº"+i+": Matricula:"+manager.viagens.get(i).getAutocarros().get(j).getMatricula()+"| Capacidade:"+manager.viagens.get(i).getAutocarros().get(j).getCapacidade());
                }
            }        
        }
        System.out.println("\n\n0.Voltar");
       
        do{
            loop=0;
            dado=perguntaGeral("\nEscolha: ","inteiro",null);
            dadoInt=Integer.parseInt(dado);
            if(dadoInt!=0){
                System.out.println("ERRO! Não Existe Essa Opção!");
                loop=1;
            }
        }while(loop==1);
       
        System.out.println("\nSuccess: Voltando ao Menu... :)");
        Thread.sleep(3000);
    
    }
    /** viagemComReservas - Funcao usada para visualizar as Viagens com Reservas.
     * @param manager - Classe Manager Com todos Os Arraylists de Informacao do Programa.
     * @throws InterruptedException - Thread.Sleep() causa esta excepcao.
     */
    public static void viagemComReservas(Manager manager) throws InterruptedException{
    
        int loop,dadoInt,check=0,mes,ano;
        String dado;
        if(manager.viagens.isEmpty()){
            System.out.println("\nErro! Não Existem Viagens.\n");
            Thread.sleep(3000);
            return;
        }
        
        ano=Integer.parseInt(perguntaGeral("","data","ano"));
        for (Viagem viagensRealizada : manager.viagensRealizadas) {
            if (viagensRealizada.getData().getAno() == ano) {
                check=1;
            }
        }
        
        mes=Integer.parseInt(perguntaGeral("","data","mes"));
        for (Viagem viagensRealizada : manager.viagensRealizadas) {
            if (viagensRealizada.getData().getMes() == mes && viagensRealizada.getData().getAno()==ano) {
                check=1;
            }
        }
        
        if(check==0){
            System.out.println("ERRO! Nao Existem Viagens Efetuadas Nesse Mes do Ano\nVoltando ao Menu...");
            Thread.sleep(2000);
            return;
        }
        
        System.out.println("\n\n\t\t------VIAGENS COM RESERVAS------\n\n");
       
        for (int i=0;i<manager.viagens.size();i++){
            if(manager.viagens.get(i).getNumReservas()!=0 && manager.viagensRealizadas.get(i).getData().getAno()==ano && manager.viagensRealizadas.get(i).getData().getMes()==mes){
                System.out.println(""+manager.viagens.get(i).toString());
                for (int j=0;j<manager.viagens.get(i).getAutocarros().size();j++){
                    System.out.println("Autocarro nº"+i+": Matricula:"+manager.viagens.get(i).getAutocarros().get(j).getMatricula()+"| Capacidade:"+manager.viagens.get(i).getAutocarros().get(j).getCapacidade());
                }
            }        
        }
        System.out.println("\n\n0.Voltar");
       
        do{
            loop=0;
            dado=perguntaGeral("\nEscolha: ","inteiro",null);
            dadoInt=Integer.parseInt(dado);
            if(dadoInt!=0){
                System.out.println("ERRO! Não Existe Essa Opção!");
                loop=1;
            }
        }while(loop==1);
       
        System.out.println("\nSuccess: Voltando ao Menu... :)");
        Thread.sleep(3000);
    
    }
    /** menuReviews - Funcao chamada pelo Cliente que deixa fazer uma reviews ou
     * consultar.
     * @param manager - Classe Manager Com todos Os Arraylists de Informacao do Programa.
     * @throws InterruptedException - Thread.Sleep() causa esta excepcao.
     */
    public static void menuReviews(Manager manager) throws InterruptedException{
           
            String escolha;
            Scanner sc = new Scanner(System.in);
     
            while(true){
               
                System.out.println("1.Fazer review de uma viagem realizada\n"
                        + "2.Ler comentários & Pontuaçoes de viagens realizadas"
                        + "\n\n0.Voltar ao menu inicial");
                System.out.print("\nEscolha: ");
                escolha=sc.nextLine();
               
                switch(escolha){
                    case "1":fazerReview(manager);break;
                    case "2":lerReviews(manager);break;
                    case "0":return;
                    default:
                        System.out.println("\nEssa Opção Não é valida");Thread.sleep(2000);
                }       menuReviews(manager);  
            }
        }
    /** reservasCanceladas - Funcao usada para visualizar as Reservas que foram canceladas.
     * @param manager - Classe Manager Com todos Os Arraylists de Informacao do Programa.
     * @throws InterruptedException - Thread.Sleep() causa esta excepcao.
     */
    public static void reservasCanceladas(Manager manager) throws InterruptedException{
     
        int loop,dadoInt;
        String dado;
       
        if(manager.reservasCanceladas.isEmpty()){
            System.out.println("\nErro! Não Existem Reservas Canceladas.\n");
            Thread.sleep(3000);
            return;
        }
        System.out.println("\n\n\t\t------RESERVAS CANCELADAS------\n\n");
       
        for (int i=0;i<manager.reservasCanceladas.size();i++){
            System.out.println(""+manager.reservasCanceladas.toString());
        }
        System.out.println("\n\n0.Voltar");
       
        do{
            loop=0;
            dado=perguntaGeral("\nEscolha: ","inteiro",null);
            dadoInt=Integer.parseInt(dado);
            if(dadoInt!=0){
                System.out.println("ERRO! Não Existe Essa Opção!");
                loop=1;
            }
        }while(loop==1);
       
        System.out.println("\nSuccess: Voltando ao Menu... :)");
        Thread.sleep(3000);
        
    }
    /** melhorViagem - Funcao usada para determinar a melhor Viagem (rating).
     * @param manager - Classe Manager Com todos Os Arraylists de Informacao do Programa.
     * @throws InterruptedException - Thread.Sleep() causa esta excepcao.
     */
    public static void melhorViagem(Manager manager) throws InterruptedException{
        
        int loop,dadoInt,contador=0,numero=0,check=0,ano,mes;
        String dado;
       
        if(manager.viagensRealizadas.isEmpty()){
            System.out.println("\nErro! Não Existem Viagens Realizadas.\n");
            Thread.sleep(3000);
            return;
        }
        
        ano=Integer.parseInt(perguntaGeral("","data","ano"));
        for (Viagem viagensRealizada : manager.viagensRealizadas) {
            if (viagensRealizada.getData().getAno() == ano) {
                check=1;
            }
        }
        
        mes=Integer.parseInt(perguntaGeral("","data","mes"));
        for (Viagem viagensRealizada : manager.viagensRealizadas) {
            if (viagensRealizada.getData().getMes() == mes && viagensRealizada.getData().getAno()==ano) {
                check=1;
            }
        }
        
        if(check==0){
            System.out.println("ERRO! Nao Existem Viagens Efetuadas Nesse Mes do Ano\nVoltando ao Menu...");
            Thread.sleep(2000);
            return;
        }
        
        for (int i=0;i<manager.viagensRealizadas.size();i++){
            if(manager.viagensRealizadas.get(i).getReviews().getMediaPontuacao() > contador && manager.viagensRealizadas.get(i).getData().getAno()==ano && manager.viagensRealizadas.get(i).getData().getMes()==mes){
                contador = manager.viagensRealizadas.get(i).getReviews().getMediaPontuacao();
                numero=i;
            }
        }
        if(contador==0){
            System.out.println("ERRO! Não Existem Reviews");
            return;
        }
        System.out.println("-----Melhor Viagem------");
        manager.viagensRealizadas.get(numero).toString();
        System.out.println("\n\n0.Voltar");
       
        do{
            loop=0;
            dado=perguntaGeral("\nEscolha: ","inteiro",null);
            dadoInt=Integer.parseInt(dado);
            if(dadoInt!=0){
                System.out.println("ERRO! Não Existe Essa Opção!");
                loop=1;
            }
        }while(loop==1);
       
        System.out.println("\nSuccess: Voltando ao Menu... :)");
        Thread.sleep(3000);
    }
    /**fazerReview - Funcao para criar uma Review.
     * @param manager - Classe Manager Com todos Os Arraylists de Informacao do Programa.
     * @throws InterruptedException - Thread.Sleep() causa esta excepcao.
     */
    public static void fazerReview(Manager manager) throws InterruptedException{
           
            Cliente reviewer = new Cliente();
            ArrayList <Cliente> clientes = manager.getClientes();
            int codigo,pontuacao;
            String comentario;
            Scanner sc = new Scanner(System.in);
            Scanner comment = new Scanner(System.in);
           
            for(Cliente cliente: clientes){
                if(cliente.getVerificaOnline() == 1 ){
                    reviewer = cliente;
                }
            }
           
            if(manager.viagensRealizadas.isEmpty()){
                System.out.println("\nNao existem da qual pode fazer review\n");Thread.sleep(2000);
                return;
            }
            
            for(Viagem viagens: manager.viagensRealizadas){
                System.out.println("\n"+viagens.toString());
            }
            
            System.out.println("\n\nQue viagem pertende avaliar?\n(Insira o codigo da viagem)");
           
            
            codigo = sc.nextInt();
           
            for(int i=0;i<manager.viagensRealizadas.size();i++){
                if(codigo == manager.viagensRealizadas.get(i).getCodigo()){
                    System.out.println("Viagem encontrada!\nQuanto acha que a viagem merece? (1-5):");
                    pontuacao = sc.nextInt();
                    System.out.println("\nEscreva um comentario na viagem:");
                    comentario = comment.nextLine();
                    manager.viagensRealizadas.get(i).getReviews().getComentarios().add(reviewer.getNome() +" disse:" +"\n" +comentario +"\n");
                    if(manager.viagensRealizadas.get(i).getReviews().getMediaPontuacao()==0){
                        manager.viagensRealizadas.get(i).getReviews().setMediaPontuacao(pontuacao);
                    }
                    else{
                        manager.viagensRealizadas.get(i).getReviews().setMediaPontuacao((pontuacao+manager.viagensRealizadas.get(i).getReviews().getMediaPontuacao())/2);
                    }
                    System.out.println("Comentario inserido com sucesso!\nA voltar ao menu de reviews...\n\n");Thread.sleep(2000);
                    return;
                }
                else{
                System.out.println("Essa viagem nao foi realizada (ou nao existe), a voltar ao menu de reviews....");Thread.sleep(2000);
                return;
                }
            }          
   }
    /** Funcao para consultar Reviews.
    * @param manager - Classe Manager Com todos Os Arraylists de Informacao do Programa.
    * @throws InterruptedException - Thread.Sleep() causa esta excepcao.
    */
    public static void lerReviews(Manager manager) throws InterruptedException{
       
        ArrayList <Viagem> viagensReviewed = new ArrayList();
        ArrayList <String> comentarios = new ArrayList();
        int codigo;
        Scanner sc = new Scanner(System.in);
       
        for(Viagem viagem : manager.viagensRealizadas){
            if(viagem.getReviews().getMediaPontuacao()!=0)
                viagensReviewed.add(viagem);
        }
        
        if(viagensReviewed.isEmpty()){
            System.out.println("\nNao existem viagens com reviews ainda!");Thread.sleep(2000);
            return;
        }
       
        System.out.println("De que viagem pretende ler avaliacoes?\n(Insira o codigo da viagem)");
        codigo = sc.nextInt();
       
        for(Viagem viagem : viagensReviewed){
            if(viagem.getCodigo()==codigo){
                System.out.println("A apresentar reviews para a viagem de codigo "+viagem.getCodigo());
                comentarios = viagem.getReviews().getComentarios();
                for(String comentario: comentarios){
                    System.out.println("\n" +comentario);
                }
                System.out.println("\nMedia pontuacao -" +viagem.getReviews().getMediaPontuacao()+"\n");
            }
            else{
                System.out.println("Essa viagem nao foi realizada (ou nao tem reviews), a voltar ao menu de reviews....");Thread.sleep(2000);
                return;
            }
        }
        
        System.out.println("A voltar ao menu de reviews...");Thread.sleep(2000);
        return;
    }
    /** perguntaGeral - Funcao usada para perguntar e obter o dado correspondente a pergunta 
    * com proteçoes em termos de inteiros, string , Double , etc.
    * @param pergunta - String com a pergunta que quer.
    * @param tipo - String com o tipo de dado que quer protejer (ex: Se pretender 
    * obter uma resposta/dado inteiro , deverá introduzir "inteiro".
    * @param subtipo - String com o subtipo do tipo , por exemplo , em termos de Data 
    * o subtipo que poderá introduzir "mes" , "ano". (Parametro nao foi muito desenvolvido).
    * @return - Returns um String com o dado.
    */
    public static String perguntaGeral(String pergunta,String tipo,String subtipo){
   
        int loop,dadoInt;
        boolean verifica;
        String retorno,remove,dado;
        Scanner sc= new Scanner(System.in);
        sc.useLocale(Locale.US); // Aparentemente o scanner so funciona com hasnextdouble corretamente se tiver este locale.
       
        do {
            System.out.print(""+pergunta);
            switch (tipo) {
                case "inteiro":
                    verifica=sc.hasNextInt();
                    if (verifica != true) {
                        System.out.println("Dado Não Valido! Introduza Novamente");
                        remove=sc.nextLine();
                    } else {
                        retorno = sc.nextLine();
                        return retorno;
                    }
                    break;
                case "string":
                    verifica=sc.hasNextInt();
                    if (verifica == true) {
                        System.out.println("Dado Não Valido! Introduza Novamente");
                        remove=sc.nextLine();
                    } else {
                        retorno = sc.nextLine();
                        return retorno;
                    }
                    break;
                case "double":
                    verifica=sc.hasNextDouble();
                    if (verifica != true) {
                        System.out.println("Dado Não Valido! Introduza Novamente");
                        remove=sc.nextLine();
                    } else {
                        retorno = sc.nextLine();
                        return retorno;
                    }
                    break;
                case "data":
                    switch(subtipo){
                        case "ano":
                            do{
                                loop=0;
                                dado=perguntaGeral("Ano: ","inteiro",null);
                                dadoInt=Integer.parseInt(dado);
                                if (dadoInt < 2015 ){
                                    System.out.println("Este Ano Não é Válido!");
                                    loop=1;
                                }
                            }while(loop==1);
                            return dado;
                        case "mes":
                            do{
                                loop=0;
                                dado=perguntaGeral("Mes: ","inteiro",null);
                                dadoInt=Integer.parseInt(dado);
                                if (dadoInt >12 || dadoInt <= 0 ){
                                    System.out.println("Este Mes Não é Válido!");
                                    loop=1;
                                }
                            }while(loop==1);
                            return dado;
                    }
            }
        }while (true);
    }
    /** realizarViagem - Funcao para realizar Viagem.
     * @param manager - Classe Manager Com todos Os Arraylists de Informacao do Programa.
     * @throws InterruptedException - Thread.Sleep() causa esta excepcao. 
     */
    public static void realizarViagem(Manager manager) throws InterruptedException{
     
        String dado;
        int numero,loop;
        if(manager.viagens.isEmpty()){
            System.out.println("\nErro! Não Existem Viagens.\n");
            Thread.sleep(3000);
            return;
        }
        System.out.println("\n\n\t\t------REALIZAR VIAGEM------\n\n");
        do{
            loop=0;
            for (int i=0;i<manager.viagens.size();i++){
                System.out.println("Viagem nº"+i+". Codigo:"+manager.viagens.get(i).getCodigo()+" | Origem:"+manager.viagens.get(i).getOrigem()+" | Destino:"+manager.viagens.get(i).getDestino());
            }
            dado=perguntaGeral("\nEscolha(Nº Viagem): ","inteiro",null);
            numero=Integer.parseInt(dado);
            if(numero>=manager.viagens.size() || numero < 0){
                System.out.println("\nPor Favor, Introduza Uma Viagem Listada Para Remover!\n");
                Thread.sleep(1500);
                loop=1;
            }
            if(manager.viagens.get(numero).getNumReservas()==0){
                System.out.println("ERRO! O Autocarro Encontra-se Vazio!");
                Thread.sleep(1500);
                return;
            }
        }while(loop==1);
       
        manager.viagensRealizadas.add(manager.viagens.get(numero));
        manager.viagens.remove(numero);
       
        System.out.println("\nSuccess: Boa Viagem! :)");
        Thread.sleep(3000);
    
    }
    /** escreveFicheiros - Funcao usada para escrever Objeto Manager num ficheiro de texto.
     * @param manager - Classe Manager Com todos Os Arraylists de Informacao do Programa.
     */
    public static void escreveFicheiros(Manager manager){
        try{
            FicheiroDeObjectos fcliente= new FicheiroDeObjectos();
            fcliente.abreEscrita("FicheiroManager.txt");
            fcliente.escreveObjecto(manager);
            fcliente.fechaEscrita();
        }catch(Exception e){
            System.out.println("ERRO EXCEPTION!");
        }
    }
    /** leFicheiros - Funcao que permite a leitura dos ficheiros de objetos.
     * @param manager - Classe Manager Com todos Os Arraylists de Informacao do Programa.
     * @return - Returns Classe Manager que contem todos os dados dos ArrayLists.
     */
    public static Manager leFicheiros(Manager manager){
        Manager retorno = new Manager();
        try{
            FicheiroDeObjectos fcliente= new FicheiroDeObjectos();
            fcliente.abreLeitura("FicheiroManager.txt");
            retorno=(Manager)fcliente.leObjecto();
            fcliente.fechaLeitura();
        }catch(IOException | ClassNotFoundException e){
            System.out.println("ERRO EXCEPTION!");
        }
        return retorno;
    }
    /** listaDeEspera - Funcao que mostra a lista de espera.
     * @param manager - Classe Manager Com todos Os Arraylists de Informacao do Programa.
     */
    public static void listaDeEspera(Manager manager){
        
        
        System.out.println("Lista de clientes em espera: ");
        manager.listaDeEspera.stream().forEach((cliente) -> {
            System.out.println(cliente.toString()+"\n");
        });

    }
    /** estatisticaVendas - Funcao que mostra as estatisticas.
     * @param manager - Classe Manager Com todos Os Arraylists de Informacao do Programa.
     * @throws java.lang.InterruptedException
     */
    public static void estatisticaVendas(Manager manager) throws InterruptedException{
        int dadoInt,check=0,dia=0,contador=0,contadordia=0,mes=0;
        if(manager.viagensRealizadas.isEmpty()){
            System.out.println("\nErro! Não Existem Viagens Realizadas.\n");
            Thread.sleep(3000);
            return;
        }
        System.out.println("\n\n\t\t------ESTATISTICA------\n\n");
        dadoInt=Integer.parseInt(perguntaGeral("","data","ano"));
        for (Viagem viagensRealizada : manager.viagensRealizadas) {
            if (viagensRealizada.getData().getAno() == dadoInt) {
                check=1;
            }
        }
        if(check==0){
            System.out.println("ERRO! Nao Existem Viagens Efetuadas Nesse Ano\nVoltando ao Menu...");
            Thread.sleep(2000);
            return;
        }
        System.out.println("Numero de Vendas de Cada Mes:");
        for(int j=1;j<13;j++){
            for (Viagem viagensRealizada : manager.viagensRealizadas) {
                if (viagensRealizada.getData().getAno() == dadoInt && viagensRealizada.getData().getMes() == j) {
                    contador++;
                }
            }
            System.out.println(j+"º Mes: "+contador);
            contador=0;
        }
        System.out.println("Dia do Ano com Mais Vendas");
        for(int j=1;j<13;j++){
            for(int i=1;i<31;i++){
                for (Viagem viagensRealizada : manager.viagensRealizadas) {
                    if (viagensRealizada.getData().getAno() == dadoInt && viagensRealizada.getData().getMes() == j && viagensRealizada.getData().getDia() == i) {
                        contador++;
                    }
                }
                if(contador > contadordia){
                    contadordia=contador;
                    dia=i;
                    mes=j;
                }
            }
        }
        System.out.println("Dia:"+dia+"/"+mes);
        Thread.sleep(5000);
    }
    /** criarAdmin - Funcao usada para criar Adminstradores.
     * @param manager - Classe Manager Com todos Os Arraylists de Informacao do Programa.
     * @throws InterruptedException - Thread.Sleep() causa esta excepcao.
     */
    public static void criarAdmin(Manager manager) throws InterruptedException{
        int dadoInt,loop,tipo;
        String dado;
        Admin novoadmin= new Admin();
       
        System.out.println("\n\n\t\t------ CRIAR ADMIN------\n\n");
       
        do{
            loop=0;
            dado=perguntaGeral("Username: ","string",null);
            for (Cliente cliente : manager.clientes) {
                if (dado.equals(cliente.getUsername())) {
                    System.out.println("Username Já Utilizado");
                    loop=1;
                }
            }
        }while(loop==1);
        novoadmin.setUsername(dado);
       
        dado=perguntaGeral("Nome: ","string",null);
        novoadmin.setNome(dado);
       
        dado=perguntaGeral("Morada: ","string",null);
        novoadmin.setMorada(dado);
       
        do{
            loop=0;
            dado=perguntaGeral("Email: ","string",null);
            if(-1==dado.indexOf("@")){
                System.out.println("Email Não Valido");
                loop=1;
            }
        }while(loop==1);
        novoadmin.setEmail(dado);
       
        do{
            loop=0;
            dado=perguntaGeral("NIF: ","inteiro",null);
            dadoInt=Integer.parseInt(dado);
            if ((dadoInt >= 999999999 || dadoInt <= 100000000)){
                System.out.println("ERRO! NIF Precisa De 9 Números");
                loop=1;
            }
            for (Cliente cliente: manager.clientes){
                if (dadoInt==cliente.getNif()){
                    System.out.println("ERRO! NIF Já Se Encontra No Sistema");
                    loop=1;
                }
            }
        }while(loop==1);
        novoadmin.setNif(dadoInt);
       
        do{
            loop=0;
            dado=perguntaGeral("Telefone: ","inteiro",null);
            dadoInt=Integer.parseInt(dado);
            if ((dadoInt >= 999999999 || dadoInt <= 100000000)){
                System.out.println("ERRO! Telefone Precisa De 9 Números");
                loop=1;
            }
        }while(loop==1);
        novoadmin.setTelefone(dadoInt);
       
        dado=perguntaGeral("Password: ","string",null);
        novoadmin.setPassword(dado);
       
        manager.administradores.add(novoadmin);
       
        System.out.println("\nSuccess: Admin Criado! :)");
        Thread.sleep(3000);
    }
}