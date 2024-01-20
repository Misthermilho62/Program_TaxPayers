package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayers;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<TaxPayers> list = new ArrayList<>();
		
		System.out.print("Enter the number of tax payers: ");
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			System.out.println("Tax payer #" + (i + 1) + " data:");
			System.out.print("Individual or company (i/c)? ");
			char ch = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Anual income: ");
			double anualIncome = sc.nextDouble();
			
			if (ch == 'i') {
				System.out.print("Health expenditures: ");
				double healthExpenditures = sc.nextDouble();
				
				list.add(new Individual(name, anualIncome, healthExpenditures));
				
			} else {
				System.out.print("Number of employees: ");
				int numberEmployee = sc.nextInt();
				
				list.add(new Company(name, anualIncome, numberEmployee));
			}
		}
		
		System.out.println();
		System.out.println("TAXES PAID:");
		for (TaxPayers tp : list) {
			System.out.println(tp.getName() + ": $ " + String.format("%.2f", tp.tax()));
		}
		
		System.out.println();
		double sum = 0.0;
		for (TaxPayers tp : list) {
			sum += tp.tax();
		}
		
		System.out.println("TOTAL TAXES: $ " + String.format("%.2f", sum));
		
		sc.close();
	}

}
