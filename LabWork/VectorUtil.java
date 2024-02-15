//Amanda Nguyen Problem 8 VectorUtil

public class VectorUtil{
	public static double dotProduct(double[] vector1, double[] vector2) {
	double sum = 0;
	for(int i=0; i<vector1.length; i++) {
		sum += vector1[i] * vector2[i]; }

		return sum;
	}
}