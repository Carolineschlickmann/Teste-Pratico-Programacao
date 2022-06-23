package util;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import entities.Funcionario;

public class MetodosEstaticos {

	public static String somaSalarios(List<Funcionario> list) {
		double somaSalarios = 0;
		for (Funcionario f : list) {
			somaSalarios += f.getSalario().doubleValue();
		}

		BigDecimal total = BigDecimal.valueOf(somaSalarios);
		return MetodosEstaticos.formatadorMoeda(total);
	}

	public static String formatadorMoeda(BigDecimal value) {
		NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.getDefault());
		return currency.format(value);
	}

	public static HashMap<Funcionario, Double> calculateSalariosMinimos(List<Funcionario> list) {
		final BigDecimal salariominimo = BigDecimal.valueOf(1212.00);
		HashMap<Funcionario, Double> listaSalario = new HashMap<>();
		for (Funcionario f : list) {
			double numeroSalariosMinimos = f.getSalario().doubleValue() / salariominimo.doubleValue();
			listaSalario.put(f, numeroSalariosMinimos);
		}
		return listaSalario;
	}

}
