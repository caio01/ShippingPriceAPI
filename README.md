# ShippingPriceAPI
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/caio01/ShippingPriceAPI/blob/master/LICENSE) 

# Sobre o projeto
ShippingPriceAPI é uma aplicação desenvolvida em SpringBoot, para cálculo de frete baseado na região do CEP informado.
A mesma utiliza a API VIA CEP (https://viacep.com.br/), para realizar a consulta do CEP.

A Documentação da API em questão, pode ser encontrada no seguinte endpoint: (http://localhost:3334/swagger-ui.html#/)

![image](https://user-images.githubusercontent.com/49879702/224508059-5e39b1ac-ff59-4d50-9983-e86e04982407.png)

# Exercício Proposto
Construir uma API REST de consulta de endereço e cálculo de frete para um determinado CEP.
O contrato da API deve ser conforme especificado abaixo:

![image](https://user-images.githubusercontent.com/49879702/224508295-9f6982e3-d352-45b5-a63f-bb7a7b1380f5.png)

Para a busca do endereço do CEP, você deve consultar a API VIA CEP, conforme a documentação https://viacep.com.br/. 
O valor do frete é fixo de acordo com as regiões do Brasil: Sudeste (R$ 7,85), Centro-Oeste (R$ 12,50), Nordeste (R$ 15,98), Sul (R$ 17,30) e Norte (R$ 20,83).
O CEP é obrigatório e pode ser passado com ou sem máscara na entrada e se o CEP não for encontrado uma mensagem informativa deve ser retornada para o cliente.

# Tecnologias utilizadas
- Java 11
- Spring Boot
- Maven
- API REST Template
- Documentação desenvolvida com Swagger
- Testes unitários com JUnit5

# Autor

Caio Oliveira
