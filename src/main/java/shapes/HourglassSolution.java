package shapes;

import java.io.*;
import java.util.*;

// Let's first describe a shape
// Assumption: we will only have two dimensions
// We want to make this work if we choose to change the shape
// We want this to work if we make the shape larger, rotate
// If we change the size of the two dimensional array
// What about if we want to allow for overflow

// Have an interface that is used to describe the shape
// Then have a shape implementation
// Then you plugin the grid implementation in and get all shapes that are subsets




// The grid that shapes live inside
// Undefined coordinates that are wthin the grid will have a default value

// shapes.Grid doesn't know anything about shapes...




public class HourglassSolution {


	// Complete the hourglassSum function below.
	static int hourglassSum(Integer[][] arr) {
		NumericGrid g = new NumericGrid(arr);
		g.init();
		return FixedHourGlass9ShapeExtractor.getMaxShapeSum(g);
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		Integer[][] arr = new Integer[6][6];

		for (int i = 0; i < 6; i++) {
			String[] arrRowItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int j = 0; j < 6; j++) {
				int arrItem = Integer.parseInt(arrRowItems[j]);
				arr[i][j] = arrItem;
			}
		}

		int result = hourglassSum(arr);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
