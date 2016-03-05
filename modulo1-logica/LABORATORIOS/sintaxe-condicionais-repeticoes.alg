algoritmo "semnome"

var
   numero : inteiro

inicio
      escreval("Insira um número")
      leia(numero)
      
      se (numero > 10) entao
           escreval("Número maior do que 10!")
      senao
           escreval("Número menor ou igual a 10!")
      fimse
      
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
      
      enquanto (numero <= 10) faca
           escreva(numero)
           numero <- numero + 1
      fimenquanto
      
      repita
           escreva(numero)
           numero <- numero + 1
      ate (numero >= 10)
      
      para numero de 1 ate 10 faca
           escreva(numero)
      fimpara
fimalgoritmo
