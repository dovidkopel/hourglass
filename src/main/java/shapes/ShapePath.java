package shapes;

import java.util.Collection;

// An interface that describes a shape's path
public interface ShapePath {
	// Right now order doesn't matter... if we are going to make a 
	// Sudoku style game order and direction may matter
	Collection<Coordinate> getCoordinates();
	default <T> Coordinate<T> getNextCoordinate(Grid<T> grid, Coordinate<T> origin, Coordinate<T> current) throws IndexOutOfBoundsException {
		try {
			T v = grid.getCoordinateValue(current);
			current.setValue(v);
			return current;
		} catch(java.lang.AssertionError e) {
			throw new IndexOutOfBoundsException();
		}
	}
}