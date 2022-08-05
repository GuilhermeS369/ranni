# Ranni

## O Projeto
Esse é um projeto Back-end (Webservices, JPA+Hibernate) onde você pode ter um banco com produtos, categorias, usuários e pedidos com status.

O projeto hoje encontra-se online no Heroku, [teste aqui.](https://ranni-app.herokuapp.com/users)

## 📋 Pré-requsitos

### Instalar o PostgresSQL

- https://www.enterprisedb.com/postgresql-tutorial-resources-training?uuid=db55e32d-e9f0-4d7c-9aef-b17d01210704&campaignId=7012J000001NhszQAC

### Java Zulu: 

- https://cdn.azul.com/zulu/bin/zulu18.32.11-ca-jdk18.0.2-win_x64.msi

## 🔧 Instruções 

### Instalar o PostgresSQL

Baixar e realizar a instalação colocando a senha Master como "36423537"

### Instalar o Zulu

Baixar e realiza a instalação marcando a opção JAVA_HOME para instalação.

Verificar se foi registrando a variavel de ambiente, caso contrario registrar.

### Package

Baixar o App: https://drive.google.com/file/d/15ArxFHobg9o-XjGbST7AnHAifc6co6zS/view?usp=sharing

Alocar os arquivos em questão e abrir o Executavel.bat.

### Heroku

Caso queria subir o projeto no Heroku, mudar no application.properties, o perfil ativo para "prod" e fazer as demais configurações no próprio Heroku.

## ⚙️ Usabilidade (Requisições) 

Veja e teste as requisições por este link:
https://ranni-app.herokuapp.com/swagger-ui.html#/

Ou veja abaixo:

`GET` Users

```yaml

Buscar todos:
localhost:8080/users
```
```yaml
Buscar pelo ID:
localhost:8080/users/{ID}
Exemplo:
localhost:8080/users/1
```
___________________________________________________________________________________________________________________

`POST` Users

```yaml
Inserir um novo usuário:
localhost:8080/users/

Enviar no Body em formato JSON:
{
"name" : "Alice",
"email" : "Alice@gmail.com"
"phone" : "999999999"
"password" : "123456"
}
```
____________________________________________________________________________________________________________________

`PUT` Users

```yaml
Alterar um usuário existente:
localhost:8080/users/{ID}
Exemplo:
localhost:8080/users/1

Enviar no Body em formato JSON:
{
"name" : "Alice",
"email" : "Alice@gmail.com"
"phone" : "999999999"
}
```
____________________________________________________________________________________________________________________

`DELETE` Users

```yaml
localhost:8080/users/{ID}
Exemplo:
localhost:8080/users/1
```
____________________________________________________________________________________________________________________

____________________________________________________________________________________________________________________

`GET` Product

```yaml

Buscar todos:
localhost:8080/products
```
```yaml
Buscar pelo ID:
localhost:8080/products/{ID}
Exemplo:
localhost:8080/products/1
```
___________________________________________________________________________________________________________________

`POST` Product

```yaml
Inserir um novo produto:
localhost:8080/products/

Enviar no Body em formato JSON:
{
"name" : "Notebook",
"description" : "Notebook gamer",
"price" : "99.99",
"imgUrl" : "www.yyyy.com/yyy.png"
}
```
____________________________________________________________________________________________________________________

`PUT` Product

```yaml
Alterar um produto existente:
localhost:8080/products/{ID}
Exemplo:
localhost:8080/products/1

Enviar no Body em formato JSON:
{
"name" : "Notebook",
"description" : "Notebook gamer",
"price" : "99.99",
"imgUrl" : "www.yyyy.com/yyy.png"
}
```

```yaml
Colocar uma categoria em um produto:
localhost:8080/products/{ID}/cat
Exemplo:
localhost:8080/products/1/cat

Enviar no Body em formato JSON:
{
"id" : 1,
"name" : "Eletronics"
}
```

____________________________________________________________________________________________________________________

`DELETE` Product

```yaml
localhost:8080/products/{ID}
Exemplo:
localhost:8080/products/1
```
____________________________________________________________________________________________________________________

____________________________________________________________________________________________________________________


`GET` Category

```yaml

Buscar todos:
localhost:8080/categories
```
```yaml
Buscar pelo ID:
localhost:8080/categories/{ID}
Exemplo:
localhost:8080/categories/1
```
___________________________________________________________________________________________________________________

`POST` Category

```yaml
Inserir uma nova categoria:
localhost:8080/categories/

Enviar no Body em formato JSON:
{
"name" : "Eletronics"
}
```
____________________________________________________________________________________________________________________
`PUT` Category

```yaml

Alterar uma categoria existente:
localhost:8080/categories/{ID}
Exemplo:
localhost:8080/categories/1

Enviar no Body em formato JSON:
{
"name" : "Books"
}
```
____________________________________________________________________________________________________________________
`DELETE` Category

```yaml
localhost:8080/categories/{ID}
Exemplo:
localhost:8080/categories/1
```
____________________________________________________________________________________________________________________
____________________________________________________________________________________________________________________
`GET` Orders

```yaml

Buscar todos:
localhost:8080/orders
```
```yaml
Buscar pelo ID:
localhost:8080/orders/{ID}
Exemplo:
localhost:8080/orders/1
```
___________________________________________________________________________________________________________________

`POST` Orders

```yaml
Inserir um novo pedido:
localhost:8080/orders

Enviar no Body em formato JSON:
{
     "moment": "2019-06-20T19:53:07Z",
     "orderStatus" :1,
     "client":{
            "id": 1,
            "name": "Maria Brown",
            "email": "maria@gmail.com",
            "phone": "988888888",
            "password": "123456"
        },
        "items": [{
                "quantity": 2,
                "price": 90.5,
                "subTotal": 181.0,
                "product": {
                    "id": 1,
                    "name": "The Lord of the Rings",
                    "description": "Lorem ipsum dolor sit amet, consectetur.",
                    "price": 90.5,
                    "imgUrl": "",
                    "categories": [
                        {
                            "id": 2,
                            "name": "Books"
                        }
                    ]
                }
           } 
      ]
       
}

```
____________________________________________________________________________________________________________________

`DELETE` Orders

```yaml
localhost:8080/orders/{ID}
Exemplo:
localhost:8080/orders/1
```
____________________________________________________________________________________________________________________

## 🛠️ Construído com

* [SpringToolsSuite4](https://spring.io/guides/gs/sts/) - IDE
* [SpringBoot](https://spring.io/) - Framework principal
* [Maven](https://maven.apache.org/) - Gerente de Dependência
* [PostgreSQL](https://www.postgresql.org/about/) - Banco de dados


## 🎁 Expressões de gratidão

* Gostaria de agradecer ao professor Nelio Alves por oferecer um curso que trás além de conteúdo super atualizado uma formula de ensino que já nos apresenta às boas práticas do desenvolvimento de software, sem falar na excelente didática.
 
* Github do mesmo: [acenelio](https://github.com/acenelio)

## 📄 Licença

The scripts and documentation in this project are released under the [MIT License](license)
