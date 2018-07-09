package shapes;

public class NumericGrid extends Grid<Integer> {
	public NumericGrid(Integer[][] arr) {
		super(arr);
	}

	public Integer getDefaultValue() {
		return null;
	}
}