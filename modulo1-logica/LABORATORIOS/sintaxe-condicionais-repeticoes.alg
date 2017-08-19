algoritmo "semnome"

var
   numero : inteiro

inicio
      escreval("Insira um número")
      leia(numero)
      
      // Condicional se
      se (numero > 10) entao
           escreval("Número maior do que 10!")
      fimse
      
      // Condicional se-senão
      se (numero > 10) entao
           escreval("Número maior do que 10!")
      senao
           escreval("Número menor ou igual a 10!")
      fimse
      
      // Condicional de escolha
      escolha (numero)
      caso 1
           escreva("um")
      caso 2, 3, 4
           escreva("dois, três ou quatro")
      caso 7
           escreva("sete")
      outrocaso
           escreva("nenhum dos anteriores")
      fimescolha
      
      // Laço enquanto
      enquanto (numero <= 10) faca
           escreva(numero)
           numero <- numero + 1
      fimenquanto
      
      // Laço repita-até
      repita
           escreva(numero)
           numero <- numero + 1
      ate (numero >= 10)
      
      // Laço para
      para numero de 1 ate 10 faca
           escreva(numero)
      fimpara
      
      // Quebra de laço com interrompa (aplicável a qualquer laço)
      enquanto (numero <= 10) faca
           escreva(numero)
           se (numero = 5) entao
                interrompa
           fimse
           numero <- numero + 1
      fimenquanto
fimalgoritmo
