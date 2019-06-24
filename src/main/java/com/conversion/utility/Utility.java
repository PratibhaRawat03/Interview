package com.conversion.utility;

public class Utility {
	private static final String[] tensDigit = { "", " ten", " twenty", " thirty", " forty", " fifty", " sixty",
			" seventy", " eighty", " ninety" };

	private static final String[] basicDigit = { "", " one", " two", " three", " four", " five", " six", " seven",
			" eight", " nine", " ten", " eleven", " twelve", " thirteen", " fourteen", " fifteen", " sixteen",
			" seventeen", " eighteen", " nineteen" };
	
	public static String numberConversion(int number) {
		String digit;

		if (number % 100 < 20) {
			digit = basicDigit[number % 100];
			number /= 100;
		} else {
			digit = basicDigit[number % 10];
			number /= 10;

			digit = tensDigit[number % 10] + digit;
			number /= 10;
		}
		if (number == 0)
			return digit;
		return basicDigit[number] + " hundred and " + digit;
	}

}
