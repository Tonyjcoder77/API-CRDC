# API CRDC

Endpoints para executar as seguintes operações:
- Fazer Upload de um arquivo com informações de transferências financeiras (CRDC)
  processar o arquivo validando os seus dados e carga de bases relacionais a partir
  dos dados validados;
- CRUD para entidade Empresa e Transações para manipular as bases carregadas;
- Geração de token para acesso as API´s a partir do id e senha de usuario das API´s;

O sistema inclui tabelas de: Empresas, Transações e Usuarios
Para esta versão as tabelas estão na memoria h2.
Ao iniciar o sistema valores iniciais são carregados nas tabelas a partir do 
data.sql que fica no folder Resources.
O Usuario defalut carregado na tabela Usuarios é:

Usuario: FrontUser
Email: frontUser@email.com
Senha:123456

O controle de acesso ocorre a partir do login pela API de autenticação:
/auth

Para entrar e gerar o token digite a emai:frontUser@email.com e a senha:123456

A partir do login recupera-se o token e usa nas proximas requisições
Copie o token gerado e use para executar as demais APIs.
Importante: Quando for colocar o token no header para executar as API´s, colocar:
Bearer token_gerado
É necessario colocar "Bearer" no começo do token para especificar o tipo de token

A aplicação está documentada no swagger:
http://localhost:8080/swagger-ui.html#/

Para fazer o build basta ir na opção Package->Run Maven Build
A partir daí é gerado o arquivo JAR que é o executável do projeto que 
deve ser copiado para o servidor.
É necessário antes deste procedimento gera um application.properties de produção
que apontará para o banco de dados de produção. É necessário tbem configurar as variaveis 
de ambiente no application.properties.


OBS: Quando for rodar o programa alterar no application.propertied o parametro:
app.path.arquivos=C:/Users/POSITIVO/Desktop/Paraiso/
Apontar para o seu diretório onde se encontra o seu arquivo de upload.

 

 