package br.com.threeway.locadora.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DataUtil {

    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    public static int conteDiasEntreDatas(Date dataInicial, Date dataFinal){
        Calendar calendarInicial = getCalendarRepresentandoData(dataInicial);
        Calendar calendarFinal = getCalendarRepresentandoData(dataFinal);

        int dias = 0;

        while (!calendarInicial.equals(calendarFinal)){
            dias++;
            calendarInicial.add(Calendar.DAY_OF_MONTH, 1);
        }

        return dias;
    }

    public static Date getDate(String data) throws ParseException {
        return DATE_FORMAT.parse(data);
    }

    private static Calendar getCalendarRepresentandoData(Date data){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(data);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar;
    }

}
