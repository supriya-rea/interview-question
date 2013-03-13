package interview.supriya.user;

public class Person {

	private String email;
	private boolean lookingForAcco;
	private Listing listing;

	public Person(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}

	public void isLookingForAccomodation(boolean lookingForAcco) {
		this.lookingForAcco = lookingForAcco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isLookingForAcco() {
		return lookingForAcco;
	}

	public void setLookingForAcco(boolean lookingForAcco) {
		this.lookingForAcco = lookingForAcco;
	}

	public void newListing(Listing listing) {
		this.listing = listing;
		// TODO Auto-generated method stub
		
	}

	public Listing getNewListing() {
		// TODO Auto-generated method stub
		return listing;
	}

}
