package projecto;

import java.io.Serializable;
import java.util.ArrayList;
import static projecto.Projecto.perguntaGeral;

public class Regular extends Cliente implements Serializable{
    
    Regular(){};
    Regular(String n,String u,String m,String em,String pass,int ni,int t,ArrayList <Reserva> r){
        super(n,u,m,em,pass,ni,t,r);
    }
    
    @Override
    public Double precoPorCliente(Manager manager,Cliente cliente,Double preco) throws InterruptedException{
        return preco;
    }

    
    @Override
    public Double precoCancelamento(Manager manager,Cliente cliente,Double preco,Data dataViagem) throws InterruptedException{
        
        Double precoFinal = preco;
        Data dataActual = new Data();
        String dado;
        int dadoInt,loop;
        
        System.out.println("Data Do Cancelamento:");
        //Ano
        dadoInt=Integer.parseInt(perguntaGeral("","data","ano"));
        dataActual.setAno(dadoInt);
        //MES
        dadoInt=Integer.parseInt(perguntaGeral("","data","mes"));
        dataActual.setMes(dadoInt);
        //DIA
        do{
            loop=0;
            dado=perguntaGeral("Dia: ","inteiro",null);
            dadoInt=Integer.parseInt(dado);
            if (dadoInt >=32 || dadoInt<=0 || (dadoInt==31 && (dataActual.getMes()==2 || dataActual.getMes()==4 || dataActual.getMes()==6 || dataActual.getMes()==9 || dataActual.getMes()==11) ) || (dadoInt >= 29 && dataActual.getMes()==2)){
                System.out.println("Este Dia Não é Válido!");
                loop=1;
            }
        }while(loop==1);
        dataActual.setDia(dadoInt);
        
        if(dataActual.getAno()>dataViagem.getAno()){
            System.out.println("\nErro! Data da viagem é anterior á data de hoje! Tente novamente:\n");Thread.sleep(2000);
            precoCancelamento(manager,cliente,preco,dataViagem);
        } else if(dataActual.getAno()<dataViagem.getAno()){
            precoFinal = preco * 0.5;
        } else if(dataActual.getAno()==dataViagem.getAno()){
            if(dataActual.getMes()>dataViagem.getMes()){
                System.out.println("\nErro! Data da viagem é anterior á data de hoje! Tente novamente:\n");Thread.sleep(2000);
                precoCancelamento(manager,cliente,preco,dataViagem);   
            } else if(dataActual.getMes()<dataViagem.getMes()){
                if(dataActual.getDia()<=23 || dataViagem.getDia()>7){
                    precoFinal = preco * 0.5;
                }
                else{
                    if((dataActual.getDia()==23 && dataViagem.getDia()>1)||(dataActual.getDia()==25&&dataViagem.getDia()>2)||(dataActual.getDia()==26&&dataViagem.getDia()>3)||(dataActual.getDia()==27&&dataViagem.getDia()>4)||(dataActual.getDia()==28&&dataViagem.getDia()>5)||(dataActual.getDia()==29&&dataViagem.getDia()>6)||(dataActual.getDia()==30&&dataViagem.getDia()>7)){
                        precoFinal = preco *0.5;
                    }
                    else{
                        System.out.println("\nJa nao pode ser reembolsado. Pedimos desculpa pelo inconviniente\n");Thread.sleep(2000);
                        return preco;
                    }
                }
            } else if(dataActual.getMes()==dataViagem.getMes()){
                if(dataViagem.getDia()-dataActual.getDia()>=7){
                    precoFinal = preco *0.5;
                }
                else{
                    System.out.println("\nJa nao pode ser reembolsado. Pedimos desculpa pelo inconviniente\n");Thread.sleep(2000);
                    return preco;
                }
                
            }

                    
        }
        
        return precoFinal;
    }   
    
}
