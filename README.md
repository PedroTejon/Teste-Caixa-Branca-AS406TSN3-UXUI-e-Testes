## Exercício - Teste Caixa Branca - AS406TSN3 - UX/UI e Testes de Software
Atividade feita para a matéria de UX/UI e Testes de Software (AS406TSN3) ministrada pelo Professor Daniel Ohata na Facens.

### Erros encontrados no código original
- O código apresenta uma organização inconsistente, como a falta de quebra de linhas e indentações em certos lugares, e de espaçamento insconsistente.
- Estilo de nomenclatura inconsistente, com termos sendo utilizados ambos em inglês e português.
- A importação do Driver de conexão `Class.forName("com.mysql.jdbc.Driver").newInstance()` é considerada depreciada, substituir por `Class.forName("com.mysql.jdbc.Driver").newInstance()`.
- A url de conexão do banco de dados apresenta credenciais hard-coded, seria melhor adicioná-las em variáveis de ambientes ou secrets e importar dentro do código.
- Ao rodar `conn = DriverManager.getConnection(url);`, dá exceção `InvalidConnectionAttributeException` que pode ser devido às novas versões do conector, para resolver foi necessário adicionar `&useTimezone=true&serverTimezone=UTC` a url de conexão.
- O código possui try/catch que não fazem nada para o handling de exceções no catch. Além disso, os catches no código estão capturando a classe `Exception`, o que significa que não existe handling especiais para exceções específicas.
- Na definição da variável `sql` dentro do método `verificarUsuario()`, a definição pode ser simplificada ao adicionar o statement SQL inteiro dentro de uma única string, ou text block caso deseje manter a quebra de linha dentro do código. Além disso, existe a separação das aspas simples do resto da string nas linhas `sql += "where login = " + "'" + login + "'";` e `sql += " and senha = " + "'" + senha + "'";`, quando pode-se inserir-lás dentro da string.
- As variáveis `st` e `rs`não possuem boa nomenclatura, podendo ser renomeadas para `statement` e `resultSet` para maior clareza.