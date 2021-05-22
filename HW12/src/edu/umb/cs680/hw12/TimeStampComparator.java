package edu.umb.cs680.hw12;
import java.util.Comparator;
public class TimeStampComparator implements Comparator<ApfsElement> {

	public int compare(ApfsElement obj1, ApfsElement obj2) {
		return obj2.getLastModified().compareTo(obj1.getLastModified());
	}
}
