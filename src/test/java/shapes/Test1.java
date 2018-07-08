package shapes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;


public class Test1 {

	@Test
	public void test1() {
		Integer[][] arr = new Integer[][] {
			{1, 1, 1, 0, 0, 0},
			{0,1,0,0,0,0},
			{1,1,1,0,0,0},
			{0,0,2,4,4,0},
			{0,0,0,2,0,0},
			{0,0,1,2,4,0},
		};
		NumericGrid grid = new NumericGrid(arr);
		grid.init();
		int max = FixedHourGlass9ShapeExtractor.getMaxShapeSum(grid);
		Assertions.assertEquals(19, max);
	}

	@Test
	public void test2() {
		Integer[][] arr = new Integer[][]{
			{-9, -9, -9, 1, 1, 1},
			{0, -9, 0, 4, 3, 2},
			{-9, -9, -9, 1, 2, 3},
			{0, 0, 8, 6, 6, 0},
			{0, 0, 0, -2, 0, 0},
			{0, 0, 1, 2, 4, 0}
		};

		NumericGrid grid = new NumericGrid(arr);
		grid.init();

		List<ShapePath> shapes = FixedHourGlass9ShapeExtractor.getShapes(grid);
		for(ShapePath s : shapes) {
			System.out.println(s);
		}

		int max = FixedHourGlass9ShapeExtractor.getMaxShapeSum(grid);
		Assertions.assertEquals(28, max);
	}

}
