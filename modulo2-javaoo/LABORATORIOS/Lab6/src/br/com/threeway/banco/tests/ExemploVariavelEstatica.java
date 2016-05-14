package br.com.threeway.banco.tests;

import br.com.threeway.banco.util.DataUtil;

public class ExemploVariavelEstatica {
    
    public static void main(String[] args){
        // Acessando atributos estaticos da classe DataUtil
        // veja que você não precisou criar uma instância da classe DataUtil
        System.out.println("Dia da semana " + DataUtil.DOMINGO);
        System.out.println("Dia da semana " + DataUtil.SEGUNDA);
        System.out.println("Dia da semana " + DataUtil.QUARTA);
        System.out.println("Dia da semana " + DataUtil.SABADO);
        // Acessando atributos de instância da classe DataUtil
        // Você tem que criar uma instância da classe antes de você poder acessar seu valor.
        DataUtil data = new DataUtil();
        System.out.println("Mes do ano " + data.JANEIRO);
        System.out.println("Mes do ano " + data.FEVEREIRO);
        System.out.println("Mes do ano " + data.ABRIL);
        System.out.println("Mes do ano " + data.MARCO);
        // O atributo estático pode ser acessado por uma variável de instância
        System.out.println("Dia da Semana " + data.diaDaSemana);
        data.diaDaSemana = 3;
        System.out.println("Mudou Dia da Semana " + data.diaDaSemana);

        DataUtil data2 = new DataUtil();
        System.out.println("instancia 1 Dia do Mes " + DataUtil.diaDoMes);
        System.out.println("instancia 2 Dia do Mes " + data2.diaDoMes);
        data2.diaDoMes = 20;
        System.out.println("instancia 1 Mudou Dia do Mes " + DataUtil.diaDoMes);
        System.out.println("instancia 2 Mudou Dia do mês " + data2.diaDoMes);


    }
    
}
