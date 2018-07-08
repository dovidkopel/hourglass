package shapes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FixedHourGlass9Shape implements ShapePath, Serializable {
	private NumericGrid grid;

	private Coordinate origin;

	private List<Coordinate> cs = new ArrayList();

	// 3, 1, 3

	public FixedHourGlass9Shape(NumericGrid grid, Coordinate origin) {
		this.grid = grid;
		this.origin = origin;

		//System.out.println("This is a shape from the origin: "+origin.toKey());

		Coordinate[] points = new Coordinate[] {
			new Coordinate(origin.getX(), origin.getY()), // 0, 0
			new Coordinate(origin.getX()+1, origin.getY()), // 1, 0
			new Coordinate(origin.getX()+2, origin.getY()), // 2, 0
			new Coordinate(origin.getX()+1, origin.getY()+1), // 1, 1
			new Coordinate(origin.getX(), origin.getY()+2), // 0, 2
			new Coordinate(origin.getX()+1, origin.getY()+2), // 1, 2
			new Coordinate(origin.getX()+2, origin.getY()+2) // 2, 2
		};

		for(Coordinate c : points) {
			try {
				Coordinate cv = getNextCoordinate(grid, origin, c);
				//System.out.println(cv);
				cs.add(cv);
			} catch(IndexOutOfBoundsException e) {
				System.err.println(c.getX()+", "+c.getY()+": is invalid!");
				cs.clear();
			}
		}
	}

	public List<Coordinate> getCoordinates() {
		return cs;
	}

	// Get the first three elements on one line
	// Get the next element on one line
	// Get the last three elements on one line
	Coordinate[] getLine(int lineNumber) {
		Coordinate[] tmp = new Coordinate[3];

		switch(lineNumber) {
			case 0:
				for(int x=0; x <= 2; x++) {
					tmp[x] = cs.get(x);
				}
				break;
			case 1:
				tmp[0] = cs.get(4);
				break;
			case 2:
				for(int x=0; x <= 2; x++) {
					tmp[x] = cs.get(x+4);
				}
				break;
		}
		return tmp;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		if(cs.size() == 7 && cs.stream().allMatch(c -> c.getValue() != null)) {
			int[] lines = new int[]{0, 1, 2};
			for(int line : lines) {
				if(line == 1) {
					sb.append("  ");
				}
				for(Coordinate c : getLine(line)) {
					if(c != null) {
						Object v = c.getValue();

						if(v != null) {
							sb.append(v);
						}
					}
				}
				if(lines.length > 1) {
					sb.append("  ");
				}
				if(line == 0 || line == 1) {
					sb.append("\n");
				}
			}
		}

		return sb.toString();
	}
}