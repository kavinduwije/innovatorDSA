

class House implements Comparable<House>{
	private String lastName;
	private String firstName;
	int lotNumber;
	private int price;
	private int squareFeet; 
	private int bedRooms; 

public  House(String lname, String fname, int ln,int p, int csf,int bedrooms) {
    lastName= lname;
    firstName = fname;
    lotNumber = ln;
    price = p; 
    squareFeet = csf;
    bedRooms=bedrooms;
  }
  
  @Override
	public int compareTo(House o) {
		int comparedSize = o.lotNumber;
		if (this.lotNumber > comparedSize) {
			return 1;
		} else if (this.lotNumber == comparedSize) {
			return 0;
		} else {
			return -1;
		}
	}

  public String toString() {
    return lastName + " \t" + firstName + " \t" + lotNumber + "\t " + price + "\t " + squareFeet+"\t "+bedRooms;
  }

public int lotNumber() {
	// TODO Auto-generated method stub
	return lotNumber;
}

public String firstName() {
	// TODO Auto-generated method stub
	return firstName;
}

public String lastName() {
	// TODO Auto-generated method stub
	return lastName;
}

public int price() {
	// TODO Auto-generated method stub
	return price;
}

public int squareFeet() {
	// TODO Auto-generated method stub
	return squareFeet;
}

public int bedRooms() {
	// TODO Auto-generated method stub
	return bedRooms;
}

  

  
}




