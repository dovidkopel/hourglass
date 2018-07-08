package shapes;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public abstract class Grid<T> {
	private int width;

	private int height;

	private T[][] data;

	protected Map<Coordinate, T> values = new HashMap();

	public Grid(T[][] arr) {
		this.data = arr;
	}

	public void init() {
		calculateHeight();
		calculateWidth();
		extract();
	}

	private void extract() {
		for(int x=0; x < this.width; x++) {
			for(int y=0; y < this.height; y++) {
				setCoordinateValue(new Coordinate(x, y), getValue(x, y));
			}
		}
	}

	private void calculateHeight() {
		this.height = data.length;
	}

	private void calculateWidth() {
		this.width = Arrays.stream(data).mapToInt(c -> c.length).max().getAsInt();
	}

	private Object[] getRow(int r) {
		return data[r];
	}

	private T getValue(int x, int y) {
		Object[] aa = getRow(y);
		return (T) aa[x];
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public void setCoordinateValue(Coordinate coordinate, T value) {
		try {
			// Don't allow a coordinate outside of the defined size
			assert(coordinate.getX() >= 0);
			assert(coordinate.getY() >= 0);
			assert(coordinate.getX() < width);
			assert(coordinate.getY() < height);
			// Don't allow a null value
			assert(value != null);
			//System.out.println("Setting coordinate: "+coordinate.toKey()+": "+value);

			this.values.put(
				coordinate,
				value
			);
		} catch(java.lang.AssertionError e) {
			System.err.println(e.toString());
		}
	}

	public T getCoordinateValue(Coordinate coordinate) {

		try {
			assert(coordinate.getX() >= 0);
			assert(coordinate.getY() >= 0);
			assert(coordinate.getX() < width);
			assert(coordinate.getY() < height);

			if(values.containsKey(coordinate)) {
				T v = values.get(coordinate);
				//System.out.println("Getting coordinate: "+coordinate.getX()+", "+coordinate.getY()+": "+v);
				return v;
			}
		} catch(java.lang.AssertionError e) {

		}

		return getDefaultValue();
	}

	public boolean isValid(Coordinate coordinate) {
		try {
			assert(coordinate.getX() >= 0);
			assert(coordinate.getY() >= 0);
			assert(coordinate.getX() < width);
			assert(coordinate.getY() < height);

			return values.containsKey(coordinate);
		} catch(java.lang.AssertionError e) {

		}
		return false;
	}

	abstract T getDefaultValue();
}