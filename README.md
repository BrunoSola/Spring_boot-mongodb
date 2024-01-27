<h1>Spring Boot MongoDB Project</h1>

<p>
    Bem-vindo ao projeto Spring Boot MongoDB! Este projeto é um exemplo simples de uma aplicação Spring Boot integrada com o MongoDB, incluindo operações básicas de CRUD e demonstrações de associações entre objetos.
</p>

<h2>Objetivos do Projeto</h2>

<ol>
    <li><strong>Compreender as principais diferenças entre paradigma orientado a documentos e relacional</strong></li>
    <li><strong>Implementar operações de CRUD</strong></li>
    <li><strong>Refletir sobre decisões de design para um banco de dados orientado a documentos</strong></li>
    <li>
        <strong>Implementar associações entre objetos:</strong>
        <ul>
            <li>Objetos aninhados</li>
            <li>Referências</li>
        </ul>
    </li>   
    <li><strong>Realizar consultas com query methods e @query (simples e com critérios)</strong></li>
</ol>

<h2>Tecnologias e Ferramentas Utilizadas</h2>
<div style="display: inline_block">
  <img  alt="JAVA" src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white"/>
  <img  alt="SPRING" src="https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white" />
  <img  alt="MONGODB" src="https://img.shields.io/badge/MongoDB-4EA94B?style=for-the-badge&logo=mongodb&logoColor=white" />  
  <img  alt="POSTMAN" src="https://img.shields.io/badge/Postman-ED8B00?style=for-the-badge&logo=postman&logoColor=orange&color=black" />
  <img  alt="INTELLIJ" src="https://img.shields.io/badge/IntelliJ_IDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white"/>   
</div>


<h2>Instalação do MongoDB</h2>

<h3>Checklist para Windows:</h3>

<ul>
    <li><a href="https://www.mongodb.com">Baixar o MongoDB Community Server</a></li>
    <li>Baixar e realizar a instalação com opção "Complete"</li>
    <li><a href="https://docs.mongodb.com/manual/tutorial/install-mongodb-on-windows/">Configurar o ambiente MongoDB</a>:
        <ul>
            <li>Criar a pasta \data\db</li>
            <li>Acrescentar em PATH: C:\Program Files\MongoDB\Server\versao\bin (adapte para sua versão)</li>
        </ul>
    </li>
    <li>Testar no terminal: <code>mongod</code></li>
</ul>

<h3>Checklist para Mac:</h3>

<ul>
    <li><a href="https://brew.sh">Instalar o Homebrew</a></li>
    <li>Instalar o MongoDB via Homebrew: <code>brew install mongodb</code></li>
    <li>Criar pasta /data/db: <code>sudo mkdir -p /data/db</code></li>
    <li>Liberar acesso na pasta criada: <code>sudo chown -Rv `whoami` /data/db</code></li>
    <li>Testar no terminal: <code>mongod</code></li>
</ul>

<h2>Instalação do Mongo Compass</h2>

<h3>Checklist:</h3>

<ul>
    <li>Instalar o <a href="https://www.mongodb.com/products/compass">MongoDB Compass</a></li>
    <li>File -> New -> Spring Starter Project</li>
    <li>Escolher somente o pacote Web por enquanto</li>
    <li>Rodar o projeto e testar: <a href="http://localhost:8080">http://localhost:8080</a></li>
    <li>Se quiser mudar a porta padrão do projeto, incluir em application.properties: <code>server.port=${port:8081}</code></li>
</ul>

<h2>Instalação do Postman</h2>

<h3>Requisitos Iniciais</h3>

<ul>
    <li>Verifique se o seu sistema atende aos requisitos mínimos para instalar o Postman.</li>
    <li>Navegue até <a href="https://www.postman.com/downloads/">https://www.postman.com/downloads/</a>.</li>
</ul>

<h3>Recursos Adicionais</h3>

<ul>
    <li>Para obter mais informações, consulte a <a href="https://learning.postman.com/docs/getting-started/introduction/">documentação oficial do Postman</a>.</li>
</ul>

<h2>Como Executar o Projeto</h2>

<ol>
    <li>Clone o repositório: <code>git clone https://github.com/BrunoSola/Spring_boot-mongodb.git</code></li>
    <li>Navegue até o diretório do projeto: <code>cd Spring_boot-mongodb</code></li>
    <li>Execute a aplicação: <code>./mvnw spring-boot:run</code></li>
</ol>

<p>
    Certifique-se de ter o MongoDB instalado localmente ou configure as informações de conexão no arquivo de configuração do Spring.
</p>

<h2>Endpoints</h2>
<h3>Métodos GET</h3>
<ul>
  <li><p>Buscar todos User do banco de dados: /users</p></li>
  <img src="https://img001.prntscr.com/file/img001/WeD14u5bQI-3_OQHKUHmiA.png" alt=""/><br><br>
  <li><a> Buscar o User por id: /users/id </a></li>
  <img src="https://img001.prntscr.com/file/img001/KXK4tCDVQtmyvD0oxyRytA.png" alt=""/><br><br>
  <li><a> Buscar os posts de determinado id: /users/id/posts </a></li>
  <img src="https://img001.prntscr.com/file/img001/uh8ojQyITf6lo_tP3q5Szw.png" alt=""/><br><br>
  <li><a> Buscar Post por ID (ID do post): /posts/id </a></li>
  <img src="https://img001.prntscr.com/file/img001/SJvTBQWrQSqm4hId6TmeBA.png" alt=""/><br><br>
  <li><a> Buscar Post por texto no título: /posts/titlesearch?text= </a></li>
  <img src="https://img001.prntscr.com/file/img001/8nY8gb3ERLGqRXMYbJLTTg.png"  alt=""/><br><br>
  <li><a> Busca Post, onde contenha o texto(Post, comment) e entre data min e max(obs: os 3 campos não são obrigatórios): /fullsearch?text=&minDate=&maxDate= (acrescentar os dados)</a></li>
  <img src="https://img001.prntscr.com/file/img001/cxo0e-K9Rjau7iogMHQrfw.png"  alt=""/><br>
  Obs: Coloquei text=ia como exemplo, para que a requisição trouxesse os 2 posts.
</ul>

<h3>Método POST</h3>

- Acrescentando um User: /users

```json
  {
      "name": "João",
      "email": "joao@gmail.com"
  }
```
<img src="https://img001.prntscr.com/file/img001/R-NpfqZXRBq151BEEFLNxA.png"  alt=""/>

<h3>Método PUT</h3>

- Editar um User: /users/id

```json
  {
      "name": "João da Silva",
      "email": "joao@gmail.com"
  }
```

<p>OBS:Posteriormente realizei o GET no mesmo Caminho</p>
<img src="https://img001.prntscr.com/file/img001/A-tF8Ra8TEaJSdZR-vPHQw.png"  alt=""/>

<h3>Método DELETE</h3>

- Deletar um User: /users/id

  <img src="https://img001.prntscr.com/file/img001/edAat0TnQfqugY_kxnIP3g.png"  alt=""/>

<h2>Contribuições</h2>

<p>
    Contribuições são bem-vindas! Sinta-se à vontade para abrir issues, enviar pull requests ou fornecer feedback.
</p>

