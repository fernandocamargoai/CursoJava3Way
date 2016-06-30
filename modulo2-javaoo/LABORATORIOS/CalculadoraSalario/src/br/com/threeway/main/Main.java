package br.com.threeway.main;

import br.com.threeway.dominio.Cargo;
import br.com.threeway.dominio.Funcionario;
import br.com.threeway.servico.CalculadoraDeSalario;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);



        Funcionario funcionario = new Funcionario();

        System.out.println("Insira o nome do funcionário");
        funcionario.setNome(scanner.nextLine());

        System.out.println("Insira o salário do funcionário");
        funcionario.setSalario(scanner.nextDouble());

        Cargo[] cargos = Cargo.values();

        System.out.println("Selecione um cargo:");
        for(int i=0; i<cargos.length; i++){
            System.out.println((i+1) + " - " + cargos[i]);
        }
        int index = scanner.nextInt() - 1;
        if(index < 0 || index >= cargos.length){
            System.out.println("Cargo inexistente");
            return;
        }

        funcionario.setCargo(cargos[index]);

        CalculadoraDeSalario calculadoraDeSalario = new CalculadoraDeSalario();

        System.out.println("O novo salário do funcionário "
                + funcionario.getNome() + " será de " +
                NumberFormat.getCurrencyInstance().format(calculadoraDeSalario.calculeNovoSalario(funcionario)));
    }

}
