//Amanda Nguyen Problem 4 
public class RelationalUtil{
	public static boolean isIncreasing(int a, int b, int c) {
		return a < b && b < c;
	}
	public static boolean isDecreasing(int a, int b, int c) {
		return a > b && b > c;
	}
	public static boolean isBetween(int a, int b, int c){
		return (a <= b && b <= c) || (a >= b && b >= c);
	}
	public static boolean isPositive(int a){
		return( a >= 0);

	}
	public static boolean isNegative(int a){
		return( a < 0);
	}
	public static boolean overlaps(int min1, int max1, int min2, int max2){
		return min1 <= max2 && min2 <= max1;
	}
}
