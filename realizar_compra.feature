Feature: Realizar compra

  Eu como usuario do sistema
  Desejo realizar uma compra


Scenario: Realizar uma compra

  Given acesso o site
  When seleciono um produto
  And realizo o checkout
  Then finalizo a compra
  And valido minhas compras
