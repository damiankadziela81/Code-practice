package com.code_exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Challenging {

    public static void main(String[] args) {

        Challenging challenging = new Challenging();
//        System.out.println("Longest Palindrome: " + challenging.findLongestPalindrome("abcba"));
//        System.out.println(challenging.findLongestCommonSequence("abattd","gdgeaba"));
        challenging.largestPrimeFactor(100);
    }

    /*
    Longest Palindrome in Word
A palindrome is a word which reads the same backward or forward.
'abcba' is a palindrome.
Write a method that returns the longest palindrome substring of a given string.
     */

    public String findLongestPalindrome(String word) {
        String longestPalindrome = "";
        for(int i=0; i<word.length()-1; i++) {
            for(int j = i+1; j<=word.length(); j++){
                String testWord = word.substring(i,j);
                if(isPalindrome(testWord)){
                    if(longestPalindrome.length()<testWord.length()) longestPalindrome = testWord;
                }
            }
        }
        return longestPalindrome;
    }
    public boolean isPalindrome(String word) {
        boolean result = true;
        for(int i=0; i<word.length()/2; i++) {
            if(word.charAt(i)!=word.charAt(word.length()-i-1)) result = false;
        }
        return result;
    }

    /*
    Longest Common Sequence
Given two strings, write a method that finds the longest common sub-sequence.
     */

    public String findLongestCommonSequence(String s1, String s2) {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        int longest = 0;
        String longestString = "";

        for (int i = 0; i < s1.length(); i++) {
            for (int j = i + 1; j <= s1.length(); j++) {
                list1.add(s1.substring(i,j));
            }
        }

        for (int i = 0; i < s2.length(); i++) {
            for (int j = i + 1; j <= s2.length(); j++) {
                list2.add(s2.substring(i,j));
            }
        }

        for(String ss1 : list1) {
            for(String ss2 : list2) {
                if (ss1.length()==ss2.length() && ss1.equals(ss2)) {
                    if (longest < ss1.length()) {
                        longest = ss1.length();
                        longestString = ss1;
                    }
                }
            }
        }

        return longestString;
    }

    /*
    Largest Prime Factor
The prime factors of 455 are 5, 7 and 13.
Write a method that calculates the largest prime factor of a given number.
Arrays.asList(2,3,5,7,11,13,17,19,23,29)
     */

    public Integer largestPrimeFactor(Integer n) {
        Integer result = 2;
        //generate prime numbers up to n
        List<Integer> primes = new ArrayList<>();
        primes.add(2);
        boolean isPrime = true;
        for(int number = 3; number <=n; number++) {
            isPrime = true;
            for(int divider = 2; divider <  number; divider++) {
                if(number%divider==0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) primes.add(number);
        }
        //check the highest prime factor
        for (int i = primes.size()-1; i > 0; i--) {
            if(n % primes.get(i) == 0) {
                result = primes.get(i);
                break;
            }
        }
        return result;
    }

    /*

    https://code-exercises.com/programming/hard/17/package-rice-bags-part-2

    Package Rice Bags (part 2)
Provided that you have a given number of small rice bags (1 kilo each) and big rice bags (5 kilos each), write a method
 that returns the minimum number of small bags necessary to package goal kilos of rice. Return -1 if it is not possible
  to package the required rice amount with the bags provided.
     */

    public Integer getNumberSmallBags(Integer big, Integer small, Integer goal) {
        //pack into big bags
        while (big>0 && goal>=5) {
            goal -= 5;
            big -= 1;
        }
        //check amount left
        if(goal > small) return -1;
        else return goal;
    }
}
