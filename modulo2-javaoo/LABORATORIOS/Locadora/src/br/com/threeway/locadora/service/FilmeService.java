package br.com.threeway.locadora.service;

import br.com.threeway.locadora.domain.Filme;
import br.com.threeway.locadora.domain.TipoDeFilme;
import br.com.threeway.locadora.util.DataUtil;

import java.util.Date;

public class FilmeService {

    public static double calculePrecoDeLocacacao(Filme filme, Date dataLocacao, Date dataDevolucao){
        int dias = DataUtil.conteDiasEntreDatas(dataLocacao, dataDevolucao);

        TipoDeFilme tipoDeFilme = filme.getTipoDeFilme();
        int diasLocacao = tipoDeFilme.getQuantidadeDeDias();
        double valorDaLocacao = tipoDeFilme.getValorDaLocacao();
        double valorDaRelocacao = tipoDeFilme.getValorDaRelocacao();

        if(dias <= diasLocacao){
            return valorDaLocacao;
        }
        else {
            return valorDaLocacao + (dias - diasLocacao) * valorDaRelocacao;
        }
    }

}
