Feature: Criar uma nova conta

  Como usuario novo
  Eu desejo criar uma nova conta

  Scenario Outline: Deve criar conta com sucesso
    Given que acesso a aplicação
    When que acesso sign
    And informo email para cadastro
    And informo os dados para cadastro "<first_name>" "<last_name>" "<password>" "<adress>" "<adress2>" "<city>" "<zip_code>" "<additional_info>" "<home_phone>" "<mobile_phone>" "<assign_adress>"
    Then realizo cadastro com sucesso
    And valido os dados cadastrados

    Examples:

      |first_name		|last_name		|password		|adress		|adress2		|city		|zip_code		|additional_info		|home_phone		|mobile_phone		|assign_adress		|
      |Gus			    |S Lima			|123456			|rua Abc	|Arat			|SP			|00000  		|Novo Teste				|1128887373		|11982828282		|gustav				|