package edu.umb.cs680.hw11;
import java.util.Comparator;
public class DominationComparator implements Comparator<Car>{

	@Override
	public int compare(Car arg0, Car arg1) {
		return arg1.getDominationCount()-arg0.getDominationCount();
	}

}
