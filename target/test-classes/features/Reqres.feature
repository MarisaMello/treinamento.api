#language: pt
#enconding: UTF-8
#Author: Marisa de Mello

  Funcionalidade: Validar a chamada das requisições de usuario

    @listarUsuarios
    Cenario:  validar a lista de usuário
      Dado recuperar as informações da pagina "2" da lista de usuário
      Quando  realizar as requisição GET no serviço para listar os usuários
      Então  validar que a pagina "2" da lista foi mostrada com sucesso

    @singleUser
    Cenario: validar um unico usuário da lista
      Dado recuperar as informações do id "2" da lista de usuário
      Quando realizar uma requisição GET no serviço para listar um unico usuários
      Então validar que o id "2" da lista foi mostrada com sucesso

    @singleUserNot
    Cenario: validar usuário não encontrado
      Dado recuperar as informações do id "23" da lista de usuário
      Quando realizar uma requisição GET no serviço para listar um unico usuários
      Então validar que o id "23" da lista não foi encontrado

    @resorceList
    Cenario: validar usuário desconhecido
      Dado recuperar as informações da pagina "2" da lista de usuário
      Quando  realizar as requisição GET no serviço para  usuário desconhecido
      Então  validar que a pagina "2" da lista foi mostrada com sucesso

    @singleResorce
    Cenário: Validar unico usuário desconhecido
      Dado recuperar as informações do id "2" da lista de usuário
      Quando  realizar as requisição GET no serviço para unico usuario
      Então  validar que o id "2" da lista foi mostrada com sucesso

    @singleResorceNotFound
    Cenário: validar recurso não encontrado
      Dado recuperar as informações do id "23" da lista de usuário
      Quando  realizar as requisições Get  no serviço pra listar usuario não encontrado
      Então  validar que o id "23" da lista não foi encontrado

    @create
    Cenário:  validar o cadastro do usuário
      Dado recuperar as informações de um novo usuario
      Quando realizar a requisição POST no serviço para criar um novo usuario
      Então validar que usuário foi criado com sucesso

    @update
    Cenário: Validar a alteração do nome de usuario
      Dado recuperar as informações de alteração de um usuário
      Quando realizar uma requisição PUT no serviço para alterar um usuário
      Então validar que as informações de usuário foi alterado com sucesso

    @deleteUser
    Cenário: Validar a exclusão de um usuário
      Quando realizar uma requição DELETE no serviço para exclusão de um usuário
      Então validar que o usuário foi excluido com sucesso

    @registerSuccessful
    Cenário: validar registro de usuário
      Dado recuperar as informações de um email "tobias.funke@reqres.in" e senha "pistol" válido
      Quando realizar uma requisição POST no serviço para registro do usuário
      Então validar que o id "9" da lista foi mostrada com sucesso

    @registerUnsuccessful
    Cenário: validar registro sem sucesso
      Dado recuperar as informações de um email "tobias.funke@reqres.in" e senha "" válido
      Quando  realizar uma requisição POST no serviço para registro
      Então validar a mensagem de erro  "Missing password"

    @loginSuccessful
    Cenário: validar login com sucesso
      Dado recuperar as informações de um email "tobias.funke@reqres.in" e senha "pistol" válido
      Quando realizar uma requisição POST no serviço para o login
      Então validar a mensagem na tela "QpwL5tke4Pnpja7X9"
