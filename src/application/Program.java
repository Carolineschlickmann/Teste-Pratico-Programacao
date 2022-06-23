package application;

import java.math.BigDecimal;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import entities.Funcionario;
import util.MetodosEstaticos;

public class Program {

	public static void main(String[] args) throws ParseException {
		List<Funcionario> funcionarioList = new ArrayList<>();

		Funcionario f1 = new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador");
		funcionarioList.add(f1);

		Funcionario f2 = new Funcionario("Joao", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador");
		funcionarioList.add(f2);

		Funcionario f3 = new Funcionario("Caio", LocalDate.of(1961, 5, 02), new BigDecimal("9836.14"), "Coordenador");
		funcionarioList.add(f3);

		Funcionario f4 = new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor");
		funcionarioList.add(f4);

		Funcionario f5 = new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcao");
		funcionarioList.add(f5);

		Funcionario f6 = new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador");
		funcionarioList.add(f6);

		Funcionario f7 = new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador");
		funcionarioList.add(f7);

		Funcionario f8 = new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente");
		funcionarioList.add(f8);

		Funcionario f9 = new Funcionario("Heloisa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"),"Eletrecista");
		funcionarioList.add(f9);

		Funcionario f10 = new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente");
		funcionarioList.add(f10);

		System.out.println("___Impressao Lista de Funcionarios___");
		for (Funcionario f : funcionarioList)
			System.out.println(f);

		HashMap<String, List<Funcionario>> map = new HashMap<>();
		for (Funcionario f : funcionarioList) {
			map.put(f.getFuncao(), funcionarioList.stream().filter(x -> x.getFuncao() == f.getFuncao()).toList());
		}

		for (Funcionario f : funcionarioList) {
			double amount = 1.1;
			BigDecimal valor = BigDecimal.valueOf(amount);
			f.setSalario(f.getSalario().multiply(valor));
		}

		System.out.println();
		System.out.println("___Impressao Map com aumento de 10% no salario dos Funcionarios___");
		{
			map.forEach((k, v) -> System.out.println(k + ": " + v));
		}

		System.out.println();
		System.out.println("___Funcionarios aniversariantes mes 10 e 12___");
		for (Funcionario f : funcionarioList)
			if (f.getDataNascimento().getMonthValue() == 10 || f.getDataNascimento().getMonthValue() == 12)
				System.out.println(f);

		System.out.println();
		System.out.println("___Funcionario com maior idade___");
		System.out.println(funcionarioList.stream().min(Comparator.comparing(Funcionario::calcularIdade)));

		System.out.println();
		System.out.println("___Funcionarios por ordem alfabetica___");
		Collections.sort(funcionarioList, Comparator.comparing(Funcionario::getNome));
		for (Funcionario f : funcionarioList) {
			System.out.println(f);
		}

		System.out.println();
		System.out.println("___Soma dos salarios___");
		System.out.println(MetodosEstaticos.somaSalarios(funcionarioList));

		System.out.println();
		System.out.println("___Salarios minimos de cada funcionario___");
		MetodosEstaticos.calculateSalariosMinimos(funcionarioList).forEach((r, s) -> System.out.println("Funcionario: " + r.getNome() + " | Salarios minimos:  " + String.format("%.1f", s)));
	}
}
