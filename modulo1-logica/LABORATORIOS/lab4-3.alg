funcao obtenhaMenor(numero1, numero2 : inteiro) : inteiro
var

inicio
       se (numero1 < numero2) entao
          retorne numero1
       senao
          retorne numero2
       fimse
fimfuncao

procedimento invertaValores(i, j : inteiro)
var
   temp : inteiro
inicio
   temp <- numeros[i]
   numeros[i] <- numeros[j]
   numeros[j] <- temp
fimprocedimento

algoritmo "semnome"
var
   numeros : vetor[0..2] de inteiro
   i : inteiro
inicio
   para i de 0 ate 2 faca
        escreval("Insira um número")
        leia(numeros[i])
   fimpara
   
   se (obtenhaMenor(numeros[0], numeros[1]) = numeros[1]) entao
      invertaValores(0, 1)
   fimse
   
   se (obtenhaMenor(numeros[1], numeros[2]) = numeros[2]) entao
      invertaValores(1, 2)
   fimse
   
   se (obtenhaMenor(numeros[0], numeros[1]) = numeros[1]) entao
      invertaValores(0, 1)
   fimse

   para i de 0 ate 2 faca
        escreva(numeros[i], " ")
   fimpara
   
fimalgoritmo
