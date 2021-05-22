package edu.umb.cs680.hw12;
import java.util.Comparator;
public class ReverseAlphabeticalComparator implements Comparator<ApfsElement> {

	public int compare(ApfsElement obj1, ApfsElement obj2) {
		return obj2.getName().compareTo(obj1.getName());
	}
}
