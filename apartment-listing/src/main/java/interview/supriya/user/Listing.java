package interview.supriya.user;

import org.joda.time.LocalDate;

public class Listing {

	private String suburb;
	private double price;
	private LocalDate date;

	public Listing(String suburb, double price, LocalDate date) {
		this.suburb = suburb;
		this.price = price;
		this.date = date;
	}

	public String getSuburb() {
		return suburb;
	}

	public void setSuburb(String suburb) {
		this.suburb = suburb;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

}
