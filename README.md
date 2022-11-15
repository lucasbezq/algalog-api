### AlgaLog API

REST API de um sistema de **Gerenciamento de Entregas**, implementado em Java com Spring Boot.

### Sistema de Gerenciamento de Entregas
Trata-se de um sistema básico, criado para o gerenciamento de entregas, por meio do cadastro dos principais dados de uma entrega, o registro dos relacionamentos com o respectivo Cliente e Destinatário, e o controle do fluxo da entrega, por meio do status, com a possibilidade de registrar o histórico de possíveis ocorrencias relacionadas às entregas. 

![Untitled](https://user-images.githubusercontent.com/68922997/201790444-3e7d9e8c-f5e7-4236-9b5a-15a42ee22412.png)

### Requisitos
<li><a href="https://git-scm.com/">Git</li>
<li><a href="https://www.oracle.com/java/technologies/downloads/">Java JDK</li>
<li><a href="https://dev.mysql.com/downloads">MySQL</li>
<li><a href="https://maven.apache.org/download.cgi">Maven</li>

### Executando o Projeto
1° Baixe o repositório deste projeto executando o comando Git: `git clone https://github.com/aguiardafa/gerenciamento-entregas-api`;
</br></br>
2° Execute o comando Maven `mvn clean install` pelo terminal na raiz da pasta do repositório, para baixar as dependências do projeto através do Maven;
</br></br>
3° Ainda com o terminal aberto na raiz do repositório, execute o comando Maven `mvn spring-boot::run` para executar a aplicação;
</br>
<li>A mensagem que a parece no final <code>Tomcat started on port(s): 8080 (http)</code> é o indicativo de que a aplicação foi iniciada e está acessível na porta 8080</li>
</br></br>
4° Acesse a URL <code>http://localhost:8080/entregas</code> pelo navegador para visualizar a aplicação
</br>
<li>Para uma melhor experiência de acesso aos endpoints da API, é recomendado a utilização de um API Client, para facilitar a interação e visualização das APIs, como exemplos mais famosos temos o <a href="https://www.postman.com/">Postman</a> e o <a href="https://insomnia.rest/">Insomnia</a>.</li>
<li>Importe o arquivo <a href="https://schema.getpostman.com/json/collection/v2.1.0/collection.json">AlgaLog API.postman_collection.json</a> no seu API Client de preferência, que todos os endpoints da API serão disponibilizados.</li>
</br>

### Ferramentas e Tecnologias utilizadas
<li><a href="https://spring.io/">Spring</li>
<li><a href="https://www.devmedia.com.br/introducao-a-jpa-java-persistence-api/28173">JPA</li>
<li><a href="https://www.postman.com/">Postman</li>
<li><a href="https://projectlombok.org/">Lombok</li>
<li><a href="https://dev.mysql.com/downloads/workbench/">MySQL Workbench</li>
<li><a href="https://flywaydb.org/">Flyway</li>
<li><a href="https://beanvalidation.org/">Bean Validation</li>
<li><a href="https://spring.io/blog/2013/11/01/exception-handling-in-spring-mvc">Exception Handler</li>
<li><a href="http://modelmapper.org/getting-started/">Model Mapper</li>
<li><a href="https://medium.com/beelabacademy/domain-driven-design-vs-arquitetura-em-camadas-d01455698ec5#:~:text=O%20DDD%20(Domain%20Driven%20Design,neg%C3%B3cios%20que%20tratamos%20como%20dom%C3%ADnio."> Domain Driven Design</li>
<li><a href="https://www.devmedia.com.br/introducao-a-web-services-restful/37387#:~:text=O%20padr%C3%A3o%20REST%20determina%20como,entidade%20em%20um%20dado%20momento.">Padrão REST API</li>


