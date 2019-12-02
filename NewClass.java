/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trees;

/* This class is used to illustrate the Comparable interface */
/* It also overrides equals(),hashCode(), toString() */

class Author implements Comparable<Author>{
    String firstName;
    String lastName;
/* Constructor */
    public Author(String inlast, String infirst) {
		lastName=inlast;
		firstName=infirst;

	}

// compareTo should return < 0 if this is supposed to be
// less than other, > 0 if this is supposed to be greater than
// other and 0 if they are supposed to be equal
    @Override
    public int compareTo(Author other){
                if (this.lastName.equals(other.lastName))
			return (this.firstName.compareTo(other.firstName));
		else
			return (this.lastName.compareTo(other.lastName));
    }

/* equals() returns true if both the lastname and the firstname are the same */
    public boolean equals(Author other) {
        return this.lastName.equals(other.lastName) &&
                this.firstName.equals(other.firstName);
	}

	/* hashCode() returns the sum of the individual Strings' hashCode() values */
    @Override
	public int hashCode() {
		return lastName.hashCode()+firstName.hashCode();
	}

    @Override
	public String toString() {
		return "The author's name is: " + firstName + " " + lastName;
	}

	
}
