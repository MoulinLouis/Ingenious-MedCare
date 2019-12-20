package constructor;

public class Stock {
	private int id;
	private String classification, substance, excipient, conservation, toxicity;
	
	public Stock() {
		this.id = id;
		this.classification = classification;
		this.substance = substance;
		this.excipient = excipient;
		this.conservation = conservation;
		this.toxicity = toxicity;
	}
	public int getId() {
		return id;
	}
	public String getClassification() {
		return classification;
	}
	public String getSubstance() {
		return substance;
	}
	public String getExcipient() {
		return excipient;
	}
	public String getConservation() {
		return conservation;
	}
	public String getToxicity() {
		return toxicity;
	}
}
