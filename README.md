# Trabalho 1
## Gerenciamento de Configuração de Software - PUCRS
Repositório para a prática com Git em Times.

### Requisitos 
1. Deseja-se um sistema para gerência de custos dos departamentos de uma empresa.
2. O sistema deverá ser implementado em Java Console /ou/ Web Puro (apenas
HTML+CSS+Javascript). Não utilizar frameworks ou outras dependências. A ideia é ter a base de
código o mais simples possível. Cuidar para que todos os membros do time conheçam a(s)
linguagem(s) escolhida(s).
3. Não implementar um mecanismo de persistência de dados. O sistema deverá manter dados
apenas em memória durante a execução.
4. Não implementar um mecanismo de login. No entanto, deverá ser possível identificar/alterar o
usuário/funcionário que está usando o sistema no momento.
5. O sistema deverá iniciar com dados já preenchidos (em bom número e de boa qualidade), de
forma a facilitar os testes.

### Funcionalidades desejadas
1. O sistema deverá permitir escolher de uma lista qual o funcionário que está usando o sistema
naquele momento (facilitando para não precisar implementar mecanismos de login).
2. O sistema deverá permitir incluir um novo funcionário, indicando matrícula, nome e o departamento
em que está associado.
3. O sistema deverá vir com departamentos previamente cadastrados. Por exemplo: RH, Compras,
Vendas, Expedição, Engenharia, Produção etc.
4. O sistema deverá permitir que o funcionário atualmente logado possa incluir um novo registro de
custo. Cada registro de custo deverá conter:
- o valor do custo
- a descrição do custo
- a data do custo
- a categoria do custo (aquisição de bens, manutenção de bens, outros serviços)
- e o departamento ao qual o custo foi vinculado.

> Exemplo: “aquisição de impressora colorida, R$ 980,00, 20/05/2023, para o depto de Vendas.”

6. O sistema deverá permitir pesquisar registros de custo pela descrição (Ex. pesquisar por
“impressora”), pela categoria, pela data ou pelo departamento. A listagem deverá ocorrer do mais
recente ao mais antigo. Todos os detalhes dos registros de custo deverão ser exibidos.
7. O sistema deverá permitir excluir apenas o registro de custo mais recente. O sistema deverá impedir
a exclusão de quaisquer outros registros mais antigos.
8. O sistema deverá permitir ao usuário visualizar um painel com os seguintes dados:
- o funcionário atualmente logado
- o valor total dos custos do mês atual
- o valor total dos custos dos últimos 3 meses, por departamento
- os 3 funcionários com a maior soma de custos registrados.
9. Duas funcionalidades a mais, à escolha do grupo.
  
 

 

#### [Mais informações sobre os requisitos do trabalho](https://github.com/w1ggor/Trabalho1-GCS/wiki/Documento-descritivo-do-trabalho)

### Alunos:
 - Marina Geller Yamaguti
 - Igor Marcel Moreira Xavier
 - Sabrina Velasque de Souza	
 - João Henrique Pires Bergallo
 - Daniel Araujo Rodrigues
 - Matheus Bueno de Oliveira
 - Lucas Cid Duarte
 - João Miguel Bonaldo Meier
 - Gabriel Palominos Teiga
 - Leonardo Soares da Silva
