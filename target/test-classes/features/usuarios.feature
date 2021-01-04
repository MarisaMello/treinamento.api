#language: pt
#enconding: UTF-8
#Author: Guilherme Teixeira

Funcionalidade: Validar a chamada das requisições de usuario

  @postUser
  Cenário: Validar a criação de um novo usuário
    Dado recuperar as informações de um novo usuario
    Quando realizar a requisição POST no serviço para criar um novo usuario
    Então validar que usuário foi criado com sucesso

  @putUser
  Cenário: Validar a alteração do nome de usuario
    Dado recuperar as informações de alteração de um usuário
    Quando realizar uma requisição PUT no serviço para alterar um usuário
    Então validar que as informações de usuário foi alterado com sucesso

  @deleteUser
  Cenário: Validar a exclusão de um usuário
    Quando realizar uma requição DELETE no serviço para exclusão de um usuário
    Então validar que o usuário foi excluido com sucesso

