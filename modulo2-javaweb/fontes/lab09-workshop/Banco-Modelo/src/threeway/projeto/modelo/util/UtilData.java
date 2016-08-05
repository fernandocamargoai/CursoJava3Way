package threeway.projeto.modelo.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class UtilData {

	// representa Domingo
	static final int DOMINGO = Calendar.SUNDAY;

	// Segunda-Feira
	static final int SEGUNDA = Calendar.MONDAY;

	// Terça-Feira
	static final int TERÇA = Calendar.TUESDAY;

	// Quarta-Feira
	static final int QUARTA = Calendar.WEDNESDAY;

	// Quinta-Feira
	static final int QUINTA = Calendar.THURSDAY;

	// Sexta-Feira
	static final int SEXTA = Calendar.FRIDAY;

	// Sábado
	static final int SABADO = Calendar.SATURDAY;

	// Constrói uma data representando agora
	public static Date data() {

		return Calendar.getInstance().getTime();
	}

	// Constrói uma data representando um dado dia.
	// Para efetuar comparações entre datas, hora será 00:00:00.0 (0 horas, 0 minutos, 0 segundos, 0 milissegundos)
	public static Calendar data(int dia, int mes, int ano) {

		return data(dia, mes, ano, 0, 0, 0);
	}

	// Constrói uma data representando um dado dia e hora.
	// Para permitir comparações de datas, os milissegundos da data são zerados.
	public static Calendar data(int dia, int mes, int ano, int hora, int min, int seg) {

		Calendar data = Calendar.getInstance();
		data.set(ano, --mes, dia, hora, min, seg);
		data.set(Calendar.MILLISECOND, 0);
		return data;
	}

	// Retorna uma data com dia, mes e ano passado como String e formato como argumento
	public static Calendar data(String data) {

		return data(Integer.valueOf(data.split("/")[0]), Integer.valueOf(data.split("/")[1]), Integer.valueOf(data.split("/")[2]));
	}

	public static Date getDate(Calendar data) {

		return data.getTime();
	}

	// Formata uma data no formato dd/mm/aaaa
	public static String DDMMAAAA(Date data) {

		return new java.text.SimpleDateFormat("dd/MM/yyyy").format(data);
	}

	// Formata uma data no formato dd/mm/aaaa hh:mm
	public static String DDMMAAAAHHMM(Date data) {

		return new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm").format(data);
	}

	// método estático que retorna o valor da data formatado como String
	public static String formataData(Date data) {

		return new java.text.SimpleDateFormat("dd/MM/yyyy  HH:mm").format(data);
	}
	
	public static String formatarDataHora(Date data){
		
		return  new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(data);
	}

	// Retorna o Ano correspondente a esta data
	public int getAno(Date data) {

		final Calendar calendario = Calendar.getInstance();

		calendario.setTime(data);

		return calendario.get(Calendar.YEAR);
	}

	// Retorna o mês correspondendo a esta data.
	public int getMes(Date data) {

		final Calendar calendario = Calendar.getInstance();

		calendario.setTime(data);

		return calendario.get(Calendar.MONTH);
	}

	// Retorna o dia correspondendo a esta data.
	public int getDia(Date data) {

		final Calendar calendario = Calendar.getInstance();

		calendario.setTime(data);

		return calendario.get(Calendar.DAY_OF_MONTH);
	}

	// Acrescenta um número de dias à data.
	public void somarDia(Date data, int numDias) {

		final Calendar calendario = Calendar.getInstance();

		calendario.setTime(data);

		calendario.add(Calendar.DAY_OF_MONTH, numDias);
	}
}
