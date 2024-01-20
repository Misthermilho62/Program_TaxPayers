package entities;

public class Individual extends TaxPayers {

	private Double healthExpenditures;
	
	public Individual() {
		super();
	}
	
	public Individual(String name, Double anualIncome, Double healthExpenditures) {
		super(name, anualIncome);
		this.healthExpenditures = healthExpenditures;
	}

	public Double getHealthExpenditures() {
		return healthExpenditures;
	}

	public void setHealthExpenditures(Double healthExpenditures) {
		this.healthExpenditures = healthExpenditures;
	}
	
	@Override
	public double tax() {
		double taxes;
		if (getAnualIncome() < 20000.00) {
			taxes = getAnualIncome() * 0.15 - healthExpenditures * 0.5;
		} else {
			taxes = getAnualIncome() * 0.25 - healthExpenditures * 0.5;
		}
		if (taxes < 0.0) {
			taxes = 0.0;
		}
		return taxes;
	}
}
