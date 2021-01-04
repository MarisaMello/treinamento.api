#language: pt
#enconding: UTF-8
#Author: Guilherme Teixeira

Funcionalidade: Validar a chamada dos dados meteorologicos atuais para um local

  @localByCountry
  Cenário: Validar a chamada dos dados meteorologicos para um local pelo nome do país
    Dado recuperar os parametros necessarios para localização pelo nome "Brazil"
    Quando realizar uma requisição GET no serviço pelo nome do país
    Então devo validar o nome "Brazil" no retorno do serviço