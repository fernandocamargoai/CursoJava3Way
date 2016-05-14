package br.com.threeway.banco.util;

import java.util.Calendar;
import java.util.Date;


public class DataUtil {

    //diaDaSemana que representa Domingo
    public static int DOMINGO = Calendar.SUNDAY;
    //diaDaSemana que representa Segunda-Feira
    public static int SEGUNDA = Calendar.MONDAY;
    //diaDaSemana que representa Terça-Feira
    public static int TERCA = Calendar.TUESDAY;
    //diaDaSemana que representa Quarta-Feira
    public static int QUARTA = Calendar.WEDNESDAY;
    //diaDaSemana que representa Quinta-Feira
    public static int QUINTA = Calendar.THURSDAY;
    //diaDaSemana que representa Sexta-Feira
    public static int SEXTA = Calendar.FRIDAY;
    //diaDaSemana que representa Sábado
    public static int SÁBADO = Calendar.SATURDAY;

    // MesDoAno que representa Janeiro
    public static int JANEIRO = Calendar.JANUARY;
    // MesDoAno que representa Fevereiro
    public static int FEVEREIRO = Calendar.FEBRUARY;
    // MesDoAno que representa Março
    public static int MARCO = Calendar.MARCH;
    // MesDoAno que representa Abril
    public static int ABRIL = Calendar.APRIL;
    // Dia do Mês
    public static int diaDoMes = Calendar.DAY_OF_MONTH;
    // Dia da semana
    public static int diaDaSemana = Calendar.DAY_OF_WEEK;

    // Método estático anônimo. As instruções dentro deste bloco
    // estático são executadas quando a classe é carregada,
    // ou seja, somente uma vez.
    static {
        System.out.println("Entrando no bloco estático.");
        Date data = Calendar.getInstance().getTime();
        System.out.println("Saindo do bloco estático data = " + formateDataHora(data));
    }

    public static Date data() {
        return Calendar.getInstance().getTime();
    }

    public static Calendar data(int dia, int mes, int ano) {
        return data(dia, mes, ano, 0, 0, 0);
    }

    public static Calendar data(int dia, int mes, int ano, int hora, int min, int seg) {
        Calendar data = Calendar.getInstance();
        data.set(ano, --mes, dia, hora, min, seg);
        data.set(Calendar.MILLISECOND, 0);
        return data;
    }

    public static Calendar data(String data) {
        String[] split = data.split("/");
        return data(Integer.valueOf(split[0]),
                Integer.valueOf(split[1]),
                Integer.valueOf(split[2]));
    }

    public static Date getDate(Calendar data) {
        return data.getTime();
    }

    public int getAno(Date data) {
        final Calendar calendario = Calendar.getInstance();
        calendario.setTime(data);
        return calendario.get(Calendar.YEAR);
    }

    public int getMes(Date data) {
        final Calendar calendario = Calendar.getInstance();
        calendario.setTime(data);
        return calendario.get(Calendar.MONTH);
    }

    public int getDia(Date data) {
        final Calendar calendario = Calendar.getInstance();
        calendario.setTime(data);
        return calendario.get(Calendar.DAY_OF_MONTH);
    }

    public Calendar somarDia(Date data, int numDias) {
        final Calendar calendario = Calendar.getInstance();
        calendario.setTime(data);
        calendario.add(Calendar.DAY_OF_MONTH, numDias);
        return calendario;
    }

    public static String formateData(Date data) {
        return new java.text.SimpleDateFormat("dd/MM/yyyy").format(data);
    }

    // método estático que retorna o valor da data formatado como String
    public static String formateDataHora(Date data) {
        return new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm").format(data);
    }

    // método de instância que retorna o valor da data formatado como String
    public String formateDataHoraInstancia(Date data) {
        return new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm").format(data);
    }


}
