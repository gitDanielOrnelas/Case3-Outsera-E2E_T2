#Author: Daniel Ornelas
#Test Case Outsera
Feature: Realizar compra e validar confirmação do pedido.

  # Realizar o acesso ao site "https://automationexercise.com/",
  # Realizar compra e validar mensagem na tela "Congratulations! Your order has been confirmed!"
  Scenario: Acessar o Site de compras, realizar o login, efetuar a compra e validar mensagem final.
    Given que acesse o site de compras
    And efetuar o login no sistema
    And verificar se o login foi realizado
    And validar que o carrinho está vazio
    When adicionar itens no carrinho
    And ir para o checkout
    And realizar o pagamento
    Then devemos validar mensagem com sucesso: "Congratulations! Your order has been confirmed!"
	## Fim
