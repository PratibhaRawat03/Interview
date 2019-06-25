package com.conversion;

import java.text.DecimalFormat;
import java.util.Scanner;

import com.conversion.exception.NumberException;
import com.conversion.utility.Utility;

public class NumberToWords {

	public static String convert(long number) throws NumberException {
		String str_num = Long.toString(number);
		String mask = "000000000000";
		DecimalFormat df = new DecimalFormat(mask);
		str_num = df.format(number);
		int thousands = Integer.parseInt(str_num.substring(9, 12));
		String tradBillions = getBillionDigits(str_num);
		String tradMillions = getMillionDigits(str_num);
		String hundredThousands = getThousandDigit(str_num);
		String thousand = Utility.numberConversion(thousands);
		return tradBillions + tradMillions + hundredThousands + thousand;
	}

	private static String getThousandDigit(String str_num) throws NumberException {
		try {
			int hundredThousand = Integer.parseInt(str_num.substring(6, 9));
			String hundredThousanddigit;
			switch (hundredThousand) {
			case 0:
				hundredThousanddigit = "";
				break;
			case 1:
				hundredThousanddigit = "one thousand ";
				break;
			default:
				hundredThousanddigit = Utility.numberConversion(hundredThousand) + " thousand ";
			}
			return hundredThousanddigit;
		} catch (Exception e) {
			throw new NumberException("getMillionDigits Error" + e.getMessage(), 500);
		}
	}

	private static String getMillionDigits(String str_num) throws NumberException {
		try {
			int million = Integer.parseInt(str_num.substring(3, 6));
			String tradMillions;
			switch (million) {
			case 0:
				tradMillions = "";
				break;
			case 1:
				tradMillions = Utility.numberConversion(million) + " million ";
				break;
			default:
				tradMillions = Utility.numberConversion(million) + " million ";
			}
			return tradMillions;
		} catch (Exception e) {
			throw new NumberException("getMillionDigits Error" + e.getMessage(), 500);
		}
	}

	private static String getBillionDigits(String str_num) throws NumberException {
		try {
			int billion = Integer.parseInt(str_num.substring(0, 3));
			String tradBillions;
			switch (billion) {
			case 0:
				tradBillions = "";
				break;
			case 1:
				tradBillions = Utility.numberConversion(billion) + " billion ";
				break;
			default:
				tradBillions = Utility.numberConversion(billion) + " billion ";
			}
			return tradBillions;
		} catch (Exception e) {
			throw new NumberException("getBillionDigits Error" + e.getMessage(), 500);
		}
	}

	/**
	 * testing
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String responseInWords = "";
		try {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please write the number & convert it to word :");
		long number = scan.nextLong();
		
			responseInWords = (number == 0) ? "Zero" : NumberToWords.convert(Math.abs(number));
		} catch (NumberException e) {
			System.out.println("Error{NumberException}! In Words  ::" + e.getCode() + " " + e.getMessage());

		} catch (Exception e) {
			System.out.println("Error{Exception}! In Words  ::" + e.getMessage());

		}
		System.out.println("In Words  ::" + responseInWords);

	}
}