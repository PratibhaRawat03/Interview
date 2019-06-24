package com.conversion.test;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.conversion.NumberToWords;
import com.conversion.exception.NumberException;

public class NumberToWordConvertorTest {
	private static NumberToWords numberToWords;

	@BeforeClass
	public static void initNumberToWord() {
		numberToWords = new NumberToWords();
	}

	@AfterClass
	public static void initNumberToWordAfter() {
		System.out.println("All Test Cases Executed");
	}
	@Test
	public void singleDigit() throws NumberException {
     String word = numberToWords.convert(1);
     assertEquals(" one", word);
	}
	@Test
	public void twoDigit() throws NumberException {
		 String word = numberToWords.convert(21);
	     assertEquals(" twenty one", word);
	}
	@Test
	public void threeDigit() throws NumberException {
		 String word = numberToWords.convert(211);
	     assertEquals(" two hundred and  eleven", word);
	}
	
	@Test
	public void fourDigit() throws NumberException {
		 String word = numberToWords.convert(2111);
	     assertEquals(" two thousand  one hundred and  eleven", word);
	}
	
	@Test
	public void fiveDigit() throws NumberException {
		 String word = numberToWords.convert(21111);
	     assertEquals(" twenty one thousand  one hundred and  eleven", word);
	}
	
	@Test
	public void sixDigit() throws NumberException {
		 String word = numberToWords.convert(211111);
	     assertEquals(" two hundred and  eleven thousand  one hundred and  eleven", word);
	}
	
	@Test
	public void sevenDigit() throws NumberException {
		 String word = numberToWords.convert(2111111);
	     assertEquals(" two million  one hundred and  eleven thousand  one hundred and  eleven", word);
	}
	
	@Test
	public void eightDigit() throws NumberException {
		 String word = numberToWords.convert(21111111);
	     assertEquals(" twenty one million  one hundred and  eleven thousand  one hundred and  eleven", word);
	}
	
	@Test
	public void nineDigit() throws NumberException {
		 String word = numberToWords.convert(211111111);
	     assertEquals(" two hundred and  eleven million  one hundred and  eleven thousand  one hundred and  eleven", word);
	}
	
	@Test
	public void tenDigit() throws NumberException {
		 String word = numberToWords.convert(2111111111);
	     assertEquals(" two billion  one hundred and  eleven million  one hundred and  eleven thousand  one hundred and  eleven", word);
	}
	
	@Test
	public void elevenDigit() throws NumberException {
		 String word = numberToWords.convert(21111111111L);
	     assertEquals(" twenty one billion  one hundred and  eleven million  one hundred and  eleven thousand  one hundred and  eleven", word);
	}
	@Test
	public void twelveDigit() throws NumberException {
		 String word = numberToWords.convert(211111111111L);
	     assertEquals(" two hundred and  eleven billion  one hundred and  eleven million  one hundred and  eleven thousand  one hundred and  eleven", word);
	}
	
}
