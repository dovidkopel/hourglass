package shapes;

import java.io.Serializable;

// A single coordinate
public class Coordinate<T> implements Serializable {
	private int x;

	private int y;

	private T value;

	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public T getValue() {
		return value;
	}

	@Override
	public String toString() {
		if(value != null) {
			return x+", "+y+": "+value.toString();
		} else {
			return x+", "+y+": null";
		}
	}

	public String toKey() {
		return getX()+"-"+getY();
	}

	@Override
	public boolean equals(Object o) {
		if(o instanceof Coordinate) {
			return ((Coordinate)o).getX() == getX() && ((Coordinate)o).getY() == getY();
		}
		return false;
	}

	@Override
	public int hashCode() {
		return ((getX() + 1) * 17 ) + ((getY() + 1) * 13);
	}
}
