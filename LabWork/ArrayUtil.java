public class ArrayUtil{
	//Amanda Nguyen Problem 5 MinMaxByValue
		public static int findMinValue(int[] array){
			int min = array[0];
			for (int value : array) {
				if (value < min) {
					min = value;

				}	
			}
			return min;
		}

		public static int findMaxValue(int[] array) {
			int max = array[0];
			for (int value : array) {
				if (value > max) {
					max = value;

				}
			}
			return max;
		}
		//Amanda Nguyen problem 6 MinMaxByIndex
		public static int getCount(int element, int[] array){
			int count = 0;
			for(int value: array){
				if ( value == element){
					count++;
			}
		}
		return count;	
	}
	public static int[] findMinIndex(int[] array) {
		int min = findMinValue(array);
		int count = getCount(min, array);
		int[] indices = new int[count];

		count = 0;
		for (int i=0; i<array.length; i++) {
			if (array[i] == min) {
				indices[count++] = i;
			}
		}
		return indices;
	}
	public static int[] findMaxIndex(int[] array){
		int max = findMaxValue(array);
		int count = getCount(max, array);
		int[] indices = new int[count];

		count = 0;
		for (int i=0; i<array.length; i++) {
			if (array[i] == max) {
				indices[count++] = i;
			}
		}
		return indices;
	}
	//Amanda Nguyen Problem 4 Array Contains
	static boolean contains(String element, String[] array){
		int t = 0;
		for(int i=0; i<array.length; i++){
			if(element.equals(array[i]))
				t = 1;
		}
		if(t == 1)
			return true;
		else 
			return false;	
	}
	
}

