package br.com.threeway.banco.tests;

import br.com.threeway.banco.util.DataUtil;

import java.util.Date;

public class ExemploMetodoEstatico {

    public static void main(String[] args) {
        Date data = new Date();
        //Invocando metodo estático, nao é preciso instanciar a classe UtilData
        System.out.println(DataUtil.formateDataHora(data));
        //Metodo estático pode ser invocado por uma instancia da classe UtilData
        DataUtil idata = new DataUtil();
        System.out.println(idata.formateDataHora(data));
        //Metodo de instancia so pode ser invocado por uma instancia
        System.out.println(idata.formateDataHoraInstancia(data));
        //Metodos de instancia nao podem ser invocados diretamente ocorre erro de compilacao
        DataUtil.formateDataHora(data);
    }
}