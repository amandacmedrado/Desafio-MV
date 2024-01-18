# Desafio MV
<h2> Sistema XPTO </h2>

O programa cria conta de clientes, seja pessoa física ou jurídica, onde os mesmos podem realizar transações de transferências entre contas bancárias e o sistema XPTO salva e gerencia essas movimentações gerando relatórios a respeito delas. Foram implementados três tipos de relatórios: Relatório de saldo do cliente X, Relatório de saldo do cliente X e período e Relatório de saldo de todos os clientes.

O programa foi desenvolvido da seguinte maneira:

* Desenvolvimento em Java Console App;
* Classes de modelo, dados, negócio e dos testes de unidade foram criadas e encontram-se separadas 
fisicamente em camadas na solução, para uma melhor distinção na análise e manutenção do código. Como também a melhor execução
dos testes de unidade, ao facilitar o entendimento de cada teste unitário, ganhamos em qualidade;
* Foram implementadas operações de busca, cadastro, atualização  e exclusão para as classes: pessoa física, pessoa jurídica e conta bancária.

Recursos utilizados:

* JUnit: framework de teste unitário para a linguagem de programação Java. Ele fornece um ambiente para escrever, organizar e executar testes automatizados em unidades de código Java.

Para iniciar o projeto, basta apenas configurar e executar a classe Main.java e observar as mensagens de saída no console.

Para executar os testes de unidade deve-se configurar e executar as classes: ControladorContaBancariaTest.java, ControladorPessoaFisicaTest.java e ControladorPessoaJuridicaTest.java

OBS: o programa funciona em uma única execução. No momento as entidades estão sendo salvas localmente em arquivos .dat que estão na pasta "Arquivos", todavia o script de banco de dados relacional da aplicação foi criado e pode ser executado no banco de dados MySQL. O modelo do banco, o script e a imagem que foram gerados encontram-se na pasta "BD_XPTO". Ficará como trabalho futuro: realizar a integração do banco de dados MySQL com o sistema XPTO.
