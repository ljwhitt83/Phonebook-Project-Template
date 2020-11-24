package home;


public class Person implements Comparable<Person> {
	
	private String fName;
	private String mName;
	private String lName;
	private Address address;
	private String phone;
	
	
	public Person(String fName, String mName, String lName, Address address, String phone) {
		super();
		this.fName = fName;
		this.mName = mName;
		this.lName = lName;
		this.address = address;
		this.phone = phone;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getfuName() {
		return fName + " " + mName + " " + lName;
	}
	
	@Override
	public String toString() {
		String bPhone = phone;
		bPhone = bPhone.replaceAll("\\s", "");
		bPhone = bPhone.replaceAll("(\\d{3})(\\d{3})(\\d+)", "($1)-$2-$3");
		phone = bPhone;
		return "Person [fName=" + fName + ", mName=" + 
				mName + ", lName=" + lName + ", address=" + 
				address + ", phone=" + phone + "]";
	}

	@Override
	public int compareTo(Person o) {
		return getfName().compareTo(o.getfName());
	}

	
}
