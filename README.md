# Upload REST API

## Descrição
API em REST desenvolvida com a função de salvar imagens enviadas em um servidor, retornando o caminho de onde o arquivo foi salvo. O projeto em questão foi desenvolvido em conjunto com [Luciano Sampaio Stuart](https://github.com/lucianostuart).

## Instalação
### Requisitos
- Maven
- Postgresql

### Inicializando
```bash
    ~$ git clone https://github.com/mira-oza/upload-api.git
    ~$ cd upload-api/
    ~$ sudo mvn spring-boot:run
```

### Configuração
#### Porta
Para configurar a porta em que o serviço estará rodando, abra o arquivo `application.properties`, em `src/main/resources`, e altere a linha server.port=`8080`, alterando a parte destacado para a porta que você desejar.

#### Diretório
Para configurar o diretório onde os arquivos serão salvos, abra o arquivo `RESTController.java`, em `src/main/java/com/github/miraoza/uploadimage/controller`, e altere a linha static final String saveDirectory  = `"/var/www/api-images"`, alterando a parte destacada para o caminho do diretório onde as imagens serão salvas.;

## Uso
Após executar os comandos acima, use o comando abaixo para enviar uma requisição `POST` para salvar a imagem:

```bash
    ~$ curl localhost:8080/upload-image/0 -F file=@caminho/da/imagem/
```
Note que, se você mudou a porta, mude `8080` para a porta que você configurou.


---
## Creditos
Documentos, vídeos e materiais utilizados no desenvolvimento da aplicação:

[4CatsDev](https://gitlab.com/4catsdev)

[Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
