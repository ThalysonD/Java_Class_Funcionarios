# Projeto Funcionário

Este é um projeto Java que modela funcionários de uma empresa, permitindo várias operações sobre eles. O projeto consiste em três classes principais:

1. **Pessoa.java**: Esta classe representa uma pessoa comum, contendo o nome e a data de nascimento da pessoa.

2. **Funcionario.java**: Esta classe estende a classe Pessoa e representa um funcionário da empresa. Além das informações herdadas da classe Pessoa, ela também contém o salário e a função do funcionário. A classe inclui métodos para obter e definir o salário, bem como para formatar os dados do funcionário em uma representação de string.

3. **Principal.java**: Esta é a classe principal que contém o método `main()`. Aqui são realizadas operações sobre os funcionários, como criação de uma lista de funcionários, remoção de funcionários por nome, impressão de todos os funcionários, aumento de salário, agrupamento de funcionários por função, identificação de funcionários com aniversário em determinados meses, identificação do funcionário mais velho, impressão dos funcionários em ordem alfabética, cálculo do total dos salários dos funcionários e cálculo dos salários em termos de salários mínimos.

O projeto também inclui uma estrutura básica de diretórios:

- **src/main/java/com/empresa/modelo**: Contém as classes que definem o modelo de dados do projeto.

- **src/main/java/com/empresa/principal**: Contém a classe principal que executa o programa.

- **bin**: Diretório onde seriam armazenados os arquivos binários, se houvesse.

- **lib**: Diretório onde seriam armazenadas as bibliotecas externas, se houvesse.

O código-fonte está organizado de forma modular, facilitando a manutenção e a extensão do projeto. Cada classe tem uma responsabilidade clara, seguindo os princípios de encapsulamento e coesão.

Para executar o projeto, basta compilar e executar a classe `Principal.java`. Certifique-se de ter uma JDK (Java Development Kit) instalada em seu ambiente de desenvolvimento.
