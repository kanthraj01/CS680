package edu.umb.cs680.hw12;
import java.util.Comparator;
public class AlphabeticalComparator implements Comparator<ApfsElement>{

		@Override
		public int compare(ApfsElement o1, ApfsElement o2) {
			return o1.getName().compareTo(o2.getName());
		}
}
