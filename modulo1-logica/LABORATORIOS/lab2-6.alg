algoritmo "lab2-6"
// Fun��o :
// Autor :
// Data : 5/3/2016
// Se��o de Declara��es 
var
   nome, combustivel : caractere
   valor, desconto, valorPago, totalDesconto, totalPago : real
inicio
      totalDesconto <- 0
      totalPago <- 0

      enquanto (verdadeiro) faca
          escreval("Insira o valor do carro")
          leia(valor)
          
          se (valor = 0) entao
               escreval("Fim da leitura de dados")
               interrompa
          fimse
          
          escreval("Insira o combust�vel do carro:")
          escreval("A - �lcool")
          escreval("G - Gasolina")
          escreval("D - Diesel")
          leia(combustivel)
          
          escolha (combustivel)
          caso "A"
              desconto <- valor * 25 / 100
          caso "G"
              desconto <- valor * 21 / 100
          caso "D"
              desconto <- valor * 14 / 100
          outrocaso
              escreval("Combust�vel inv�lido")
              interrompa
          fimescolha
          
          valorPago <- valor - desconto
          
          escreval("O desconto foi de: ", desconto)
          escreval("O valor pago � de: ", valorPago)
          
          totalDesconto <- totalDesconto + desconto
          totalPago <- totalPago + valorPago
      fimenquanto
      
      escreval("Total de desconto: ", totalDesconto)
      escreval("Total pago: ", totalPago)
fimalgoritmo
