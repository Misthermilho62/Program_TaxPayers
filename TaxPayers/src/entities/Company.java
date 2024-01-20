package entities;

public class Company extends TaxPayers{

	private Integer numberEmployees;
	
	public Company() {
		super();
	}
	
	public Company(String name, Double anualIncome, Integer numberEmployees) {
		super(name, anualIncome);
		this.numberEmployees = numberEmployees;
	}

	public Integer getNumberEmployees() {
		return numberEmployees;
	}

	public void setNumberEmployees(Integer numberEmployees) {
		this.numberEmployees = numberEmployees;
	}
	
	@Override
	public double tax() {
		double taxes;
		if (numberEmployees > 10) {
			taxes = getAnualIncome() * 0.14;
 		} else {
 			taxes = getAnualIncome() * 0.16;
  		}
		
		return taxes;
	}
}
