#language: pt
Funcionalidade: Realizar desafio
  Como um candidato
  Para que eu possa realizar o desafio da B2W
  Preciso elaborar os casos de testes automatizados


  Contexto: Navegar no site do desafio
    Dado que entrei no link do desafio
    Então página é exibida

  Esquema do Cenário: Verificar o preenchimento da planilha end-to-end
    Dado que preencho os campos <nome> e <email>
    Quando seleciono a cor <cor> e sobremesa <sobremesa> favoritas
    E seleciono minha comida favorita <comida>
    E seleciono o número <numero> do quanto gosto de animais
    E seleciono os esportes de minha preferência
    E seleciono os ingredientes de cada sanduíche
    Então seleciono o dia de hoje
    E seleciono a hora adiantada
    Quando clico no botão submit
    Então formulário é enviado
    Exemplos:
      | nome        | email           | cor      | sobremesa | comida  | numero |
      | teste teste | teste@gmail.com | Verde    | sorvete   | Massas  | 10     |
      | teste teste | teste@gmail.com | Azul     | Bolo      | Carnes  | 8      |
      | teste teste | teste@gmail.com | Vermelho | Fruta     | Legumes | 9      |

    @wip
  Cenário: Verificar mensagem de erro no campo nome
    Quando preencho o campo ˜nome˜ com texto "teste"
    Então mensagem de erro para preencher o sobrenome é exibida

  Cenário: Verificar mensagem de erro no campo e-mail
    Quando preencho o campo ˜email˜ com texto "teste@"
    Então mensagem de erro para preencher e-mail válido é exibida

  Cenário: Verificar preenchimento do campo Outros em sobremesa favorita
    Quando preencho o campo ˜Other˜ com texto "teste"
    Então sobremesa Other é selecionada


  Esquema do Cenário: Verificar campos obrigatórios
    Dado que preencho os campos <nome> e <email>
    Quando seleciono a cor <cor> e sobremesa <sobremesa> favoritas
    E seleciono minha comida favorita <comida>
    E seleciono o número <numero> do quanto gosto de animais
    E seleciono <condicao1> para <esporte1>
    E seleciono <condicao2> para <esporte2>
    E seleciono <condicao3> para <esporte3>
    E seleciono <condicao4> para <esporte4>
    Então seleciono os ingredientes <ingrediente>, <ingrediente>, <ingrediente>, <ingrediente>, <ingrediente> para <sanduiche>
    Quando seleciono o dia de hoje
    E seleciono a hora adiantada
    E clico no botão submit
    Então formulário é enviado
    Exemplos:
      | nome  | email           | cor   | sobremesa | comida | numero | condicao1 | esporte1 | condicao2 | esporte2 | condicao3 | esporte3 | condicao4 | esporte4 |
      | teste | teste@gmail.com | verde | sovete    | Massas | 10     | Bom       | Rugby    | Mediano   | Baseball | Futebol   | eSport   | Ótimo     | Futebol  |





