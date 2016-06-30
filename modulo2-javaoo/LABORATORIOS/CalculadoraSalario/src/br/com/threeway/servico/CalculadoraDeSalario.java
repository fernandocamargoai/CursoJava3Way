package br.com.threeway.servico;

import br.com.threeway.dominio.Cargo;
import br.com.threeway.dominio.Funcionario;

public class CalculadoraDeSalario {

    public Double calculeNovoSalario(Funcionario funcionario){
        Double salario = funcionario.getSalario();
        Cargo cargo = funcionario.getCargo();

//        return salario + salario *
//                (salario >= cargo.getLimiar() ?
//                        cargo.getPorcentagemMaiorQueLimiar() :
//                        cargo.getPorcentagemMenorQueLimiar()) / 100;

        if(salario >= cargo.getLimiar()){
            return salario + salario * cargo.getPorcentagemMaiorQueLimiar() / 100;
        }
        else {
            return salario + salario * cargo.getPorcentagemMenorQueLimiar() / 100;
        }
    }

}
