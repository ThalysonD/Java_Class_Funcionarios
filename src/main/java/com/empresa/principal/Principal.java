package main.java.com.empresa.principal;

import main.java.com.empresa.modelo.Funcionario;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;

public class Principal {
    public static void main(String[] args) {
        List<Funcionario> funcionarios = criarListaFuncionarios();
        
        removerFuncionarioPorNome(funcionarios, "João");

        System.out.println("\nTodos os funcionários:");
        imprimirFuncionarios(funcionarios);

        aumentarSalario(funcionarios, BigDecimal.valueOf(0.1));

        System.out.println("\nFuncionários agrupados por função:");
        imprimirFuncionariosAgrupadosPorFuncao(funcionarios);

        System.out.println("\nFuncionários que fazem aniversário nos meses 10 e 12:");
        imprimirFuncionariosAniversariantes(funcionarios, Month.OCTOBER, Month.DECEMBER);

        imprimirFuncionarioMaisVelho(funcionarios);

        System.out.println("\nFuncionários por ordem alfabética:");
        imprimirFuncionariosOrdenadosPorNome(funcionarios);

        imprimirTotalSalarios(funcionarios);

        imprimirSalariosEmSalariosMinimos(funcionarios, new BigDecimal("1212.00"));
    }

    private static List<Funcionario> criarListaFuncionarios() {
        return new ArrayList<>(Arrays.asList(
                new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"),
                new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"),
                new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"),
                new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"),
                new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"),
                new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"),
                new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"),
                new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"),
                new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"),
                new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente")
        ));
    }

    private static void removerFuncionarioPorNome(List<Funcionario> funcionarios, String nome) {
        funcionarios.removeIf(f -> f.getNome().equalsIgnoreCase(nome));
    }

    private static void imprimirFuncionarios(List<Funcionario> funcionarios) {
        funcionarios.forEach(System.out::println);
    }

    private static void aumentarSalario(List<Funcionario> funcionarios, BigDecimal aumento) {
        funcionarios.forEach(f -> f.setSalario(f.getSalario().multiply(BigDecimal.ONE.add(aumento))));
    }

    private static void imprimirFuncionariosAgrupadosPorFuncao(List<Funcionario> funcionarios) {
        Map<String, List<Funcionario>> funcionariosPorFuncao = funcionarios.stream()
                .collect(Collectors.groupingBy(Funcionario::getFuncao));

        funcionariosPorFuncao.forEach((funcao, lista) -> {
            System.out.println(funcao + ":");
            lista.forEach(f -> System.out.printf("    %s%n", f));
        });
    }

    private static void imprimirFuncionariosAniversariantes(List<Funcionario> funcionarios, Month... meses) {
        List<Month> mesesList = Arrays.asList(meses);
        funcionarios.stream()
                .filter(f -> mesesList.contains(f.getDataNascimento().getMonth()))
                .forEach(f -> System.out.printf("    %s%n", f));
    }

    private static void imprimirFuncionarioMaisVelho(List<Funcionario> funcionarios) {
        Funcionario maisVelho = funcionarios.stream()
                .min(Comparator.comparing(Funcionario::getDataNascimento))
                .orElseThrow(NoSuchElementException::new);
        int idade = Period.between(maisVelho.getDataNascimento(), LocalDate.now()).getYears();
        System.out.printf("\nFuncionário com a maior idade: %s, Idade: %d%n", maisVelho.getNome(), idade);
    }

    private static void imprimirFuncionariosOrdenadosPorNome(List<Funcionario> funcionarios) {
        funcionarios.stream()
                .sorted(Comparator.comparing(Funcionario::getNome))
                .forEach(f -> System.out.printf("    %s%n", f));
    }

    private static void imprimirTotalSalarios(List<Funcionario> funcionarios) {
        BigDecimal totalSalarios = funcionarios.stream()
                .map(Funcionario::getSalario)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.printf("\nTotal dos salários dos funcionários: %s%n", formatSalario(totalSalarios));
    }

    private static void imprimirSalariosEmSalariosMinimos(List<Funcionario> funcionarios, BigDecimal salarioMinimo) {
        System.out.println("\nSalários mínimos por funcionário:");
        funcionarios.forEach(f -> {
            BigDecimal salariosMinimos = f.getSalario().divide(salarioMinimo, 2, RoundingMode.HALF_UP);
            System.out.printf("    %s ganha %s salários mínimos%n", f.getNome(), salariosMinimos);
        });
    }

    private static String formatSalario(BigDecimal salario) {
        return String.format("%,.2f", salario).replace('.', ',');
    }
}
