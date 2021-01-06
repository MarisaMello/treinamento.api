#language: pt
#enconding: UTF-8
#Author: Guilherme Teixeira

Funcionalidade: Validar a chamada dos dados meteorologicos atuais para um local

  @localByCountry
  Cenário: Validar a chamada dos dados meteorologicos para um local pelo nome do país
    Dado recuperar os parametros necessarios para localização pelo nome "Brazil"
    Quando realizar uma requisição GET no serviço pelo nome do país
    Então devo validar o nome "Brazil" no retorno do serviço


  @geographicCoordinates
  Cenário: validar a chamada dos dados meteorologicos para uma cordenadas
    Dado recuparar os parametros lat "38.450001" e long "44.98333"
    E informo o appid
    Quando realizar uma requisição GET no serviço para cordenadas
    Então devo validar o nome "Taglag" no retorno do serviço

  @zipCode
  Cenário: validar a chamada dos dados meteorologico para um zip code
    Dado recuperar os parametros Zip Code "35559"
    E informo o appid
    Quando realizar uma requisição GET no serviço para zip code
    Então devo validar o nome "Glen Allen" no retorno do serviço

  @callCurent
  Cenário: validar a chamada dos dados meteorologico para area retangular
    Dado recuperar os parametros bbox "12,32,15,37,10"
    E informo o appid
    Quando realizar uma requisição GET no serviço para a área retangular
    Então devo validar a "list"

  @citiesInCircle
  Cenário: validar a chamada dos dados meteorologico para cidade em circulo
    Dado recuparar os parametros lat "38.450001", long "44.98333",cnt "5"
    E informo o appid
    Quando realizar uma requisição GET no serviço para a cidade de circulo
    Então devo validar a "list"

  @callForSeveralCityIDs
  Cenário: validar a chamada dos dados meterologicos para vários Ids
    Dado recuperar os parametros ids "3245,1806589,2792333"
    E informo o appid
    Quando realizar uma requisição GET no serviço para os ids
    Então devo validar a "list"