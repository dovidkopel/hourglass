package shapes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FixedHourGlass9ShapeExtractor {
	public static List<ShapePath> getShapes(NumericGrid grid) {
		List<ShapePath> shapes = new ArrayList();
		for(int x=0; x < grid.getWidth(); x++) {
			for(int y=0; y < grid.getHeight(); y++) {
				ShapePath aa = new FixedHourGlass9Shape(grid, new Coordinate(x, y));
				if(aa != null && aa.getCoordinates().size() == 7 && aa.getCoordinates().stream().allMatch(c -> c.getValue() != null)) {

					shapes.add(aa);
				}
			}
		}

		return shapes;
	}

	public static List<List<Integer>> getShapeValues(NumericGrid grid) {
		return getShapes(grid).stream().map(sp -> sp.getCoordinates().stream().map(c ->
			(Integer) c.getValue()
		).collect(Collectors.toList())).collect(Collectors.toList());
	}

	public static Integer getMaxShapeSum(NumericGrid grid) {
		return getShapes(grid).stream().mapToInt(
			sp -> sp.getCoordinates().stream().mapToInt(c -> (Integer) c.getValue()).sum()
		).max().getAsInt();
	}
}
