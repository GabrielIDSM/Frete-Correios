# Frete-Correios Public API (Spring Boot Application)

## Sobre o Projeto

O Frete-Correios é uma API desenvolvida para implementar o Web Service dos Correios e ser utilizada **diretamente do Front-end** de uma aplicação ou site. Sites desenvolvido com React, Angular e outros frameworks podem enfrentar problemas com **CORS**, a API Frete-Correios resolve isso.

## Deploy (Heroku)

https://gabrielidsm-fretecorreios.herokuapp.com/

## Request Model (.../correios/frete)

```
{
  	"servico":"41106",
    "cepOrigem":"25943509",
    "cepDestino":"25555100",
    "formato":"1",
    "comprimento":60.0,
    "altura":25.0,
    "largura":25.0,
    "diametro":0.0,
    "peso":2.0
}
```

## Response Model

```
{
    "valor": "34,20",
    "prazo": "16"
}
```

## Equipe

Frete-Correios é um projeto desenvolvido por Gabriel Inácio ([Github](https://github.com/GabrielIDSM)/[LinkedIn](https://www.linkedin.com/in/gabriel-inacio-uff/))

## Contato

E-mail: gabrielinacio@id.uff.br
