package Sorts;


import java.util.Random;

public class InsertSort {

	public static final int MIN_NUMBER = 0, MAX_NUMBER = 1000000000;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/* Make initial array (to test against) and print it */

		int[] array1of1000 = generateRandomArray(1000, MIN_NUMBER, MAX_NUMBER);
		int[] array2of1000 = generateRandomArray(1000, MIN_NUMBER, MAX_NUMBER);
		int[] array3of1000 = generateRandomArray(1000, MIN_NUMBER, MAX_NUMBER);
		int[] rising1000 = generateRisingArray(1000);
		int[] declining1000 = generateDecliningArray(1000);

		int[] array1of10000 = generateRandomArray(10000, MIN_NUMBER, MAX_NUMBER);
		int[] array2of10000 = generateRandomArray(10000, MIN_NUMBER, MAX_NUMBER);
		int[] array3of10000 = generateRandomArray(10000, MIN_NUMBER, MAX_NUMBER);
		int[] rising10000 = generateRisingArray(10000);
		int[] declining10000 = generateDecliningArray(10000);

		int[] array1of100000 = generateRandomArray(100000, MIN_NUMBER, MAX_NUMBER);
		int[] array2of100000 = generateRandomArray(100000, MIN_NUMBER, MAX_NUMBER);
		int[] array3of100000 = generateRandomArray(100000, MIN_NUMBER, MAX_NUMBER);
		int[] rising100000 = generateRisingArray(100000);
		int[] declining100000 = generateDecliningArray(100000);

		int[] array1of1000000 = generateRandomArray(1000000, MIN_NUMBER, MAX_NUMBER);
		int[] array2of1000000 = generateRandomArray(1000000, MIN_NUMBER, MAX_NUMBER);
		int[] array3of1000000 = generateRandomArray(1000000, MIN_NUMBER, MAX_NUMBER);
		int[] rising1000000 = generateRisingArray(1000000);
		int[] declining1000000 = generateDecliningArray(1000000);

		long[] timeList = new long[20];

		System.out.println("ARRAY OF 1000 BEFORE SORTING: \n");
		printArrayInfo(array1of1000);
		System.out.println("ARRAY OF 1000 AFTER SORTING: \n");
		timeList[0] = sort(array1of1000);
		printArrayInfo(array1of1000);
		System.out.println("The following is the time it takes to sort each array (in nanoseconds!):");
		timeList[1] = sort(array2of1000);
		timeList[2] = sort(array3of1000);
		timeList[3] = sort(rising1000);
		timeList[4] = sort(declining1000);
		System.out.println("Sort a random array size 1,000: " + timeList[0]);
		System.out.println("Sort a random array size 1,000: " + timeList[1]);
		System.out.println("Sort a random array size 1,000: " + timeList[2]);
		System.out.println("Sort a sorted array size 1,000: " + timeList[3]);
		System.out.println("Sort a reverse-sorted array size 1,000: " + timeList[4] + "\n");

		timeList[5] = sort(array1of10000);
		timeList[6] = sort(array2of10000);
		timeList[7] = sort(array3of10000);
		timeList[8] = sort(rising10000);
		timeList[9] = sort(declining10000);
		System.out.println("Sort a random array size 10,000: " + timeList[5]);
		System.out.println("Sort a random array size 10,000: " + timeList[6]);
		System.out.println("Sort a random array size 10,000: " + timeList[7]);
		System.out.println("Sort a sorted array size 10,000: " + timeList[8]);
		System.out.println("Sort a reverse-sorted array size 10,000: " + timeList[9] + "\n");

		timeList[10] = sort(array1of100000);
		timeList[11] = sort(array2of100000);
		timeList[12] = sort(array3of100000);
		timeList[13] = sort(rising100000);
		timeList[14] = sort(declining100000);
		System.out.println("Sort a random array size 100,000: " + timeList[10]);
		System.out.println("Sort a random array size 100,000: " + timeList[11]);
		System.out.println("Sort a random array size 100,000: " + timeList[12]);
		System.out.println("Sort a sorted array size 100,000: " + timeList[13]);
		System.out.println("Sort a reverse-sorted array size 100,000: " + timeList[14] + "\n");

		System.out.println(
				"The next sort may take aprox. 15~20 minutes per array, terminate unless you plan on waiting that much.");
		timeList[15] = sort(array1of1000000);
		System.out.println("Sort a random array size 1,000,000: " + timeList[15]);
		timeList[16] = sort(array2of1000000);
		System.out.println("Sort a random array size 1,000,000: " + timeList[16]);
		timeList[17] = sort(array3of1000000);
		System.out.println("Sort a random array size 1,000,000: " + timeList[17]);
		timeList[18] = sort(rising1000000);
		System.out.println("Sort a sorted array size 1,000,000: " + timeList[18]);
		timeList[19] = sort(declining1000000);
		System.out.println("Sort a reverse-sorted array size 1,000,000: " + timeList[19]);

	}

	public static long sort(int myArray[]) {

		long startTime = System.nanoTime();

		for (int i = 1; i < myArray.length; i++) {
			int current = myArray[i];
			int j = i - 1;
			while (j >= 0 && myArray[j] > current) {
				myArray[j + 1] = myArray[j];
				j--;
			}
			myArray[j + 1] = current;
		}

		long endTime = System.nanoTime();
		long totalTime = endTime - startTime;
		// System.out.println("Time it took to sort (in nanoseconds): " + totalTime);
		return totalTime;
	}

	// make a new array of a random size, and fill it with random numbers
	public static int[] generateRandomArray(int ArrSize, int minNum, int maxNum) {
		int[] myArray = new int[ArrSize];
		for (int i = 0; i < ArrSize; i++) {
			myArray[i] = getRandomNumberInRange(minNum, maxNum);
		}
		return myArray;
	}

	public static int[] generateRisingArray(int ArrSize) {
		int[] myArray = new int[ArrSize];
		int curr = getRandomNumberInRange(0, 3);
		for (int i = 0; i < ArrSize; i++) {
			myArray[i] = curr;
			curr += getRandomNumberInRange(1, 10);
		}
		return myArray;
	}

	public static int[] generateDecliningArray(int ArrSize) {
		int[] myArray = new int[ArrSize];
		int curr = getRandomNumberInRange(0, 3);
		for (int i = ArrSize - 1; i >= 0; i--) {
			myArray[i] = curr;
			curr += getRandomNumberInRange(1, 10);
		}
		return myArray;
	}

	// generate a new number in range (inclusive of edges)
	public static int getRandomNumberInRange(int min, int max) {
		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}
		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}

	// print the array and it's information
	public static void printArrayInfo(int[] myArray) {
		System.out.println("Array information:\nArray Size: " + myArray.length + "\nArray contents:");
		for (int i : myArray) {
			System.out.print(i + ", ");
		}
		System.out.println("\n");
	}

}
