package com.code_exercises;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ModerateTest {

    @Test
    void fizzBuzzTest() {
        assertEquals(Moderate.fizzBuzz(1),String.valueOf(1));
        assertEquals(Moderate.fizzBuzz(5),"Buzz");
        assertEquals(Moderate.fizzBuzz(15),"FizzBuzz");
        assertEquals(Moderate.fizzBuzz(3),"Fizz");
        assertEquals(Moderate.fizzBuzz(121),String.valueOf(121));
        assertEquals(Moderate.fizzBuzz(125),"Buzz");
    }

    @Test
    void isPrimeTest() {
        assertEquals(Moderate.isPrime(5),true);
        assertEquals(Moderate.isPrime(13),true);
        assertEquals(Moderate.isPrime(15),false);
        assertEquals(Moderate.isPrime(917),false);
        assertEquals(Moderate.isPrime(919),true);
    }

    @Test
    void fibonnaciTest() {
        assertEquals(Moderate.fibonnaci(0),0);
        assertEquals(Moderate.fibonnaci(3),2);
        assertEquals(Moderate.fibonnaci(9),34);
    }

    @Test
    void fibonnaciRecursionTest() {
        assertEquals(Moderate.fibonnaciRecursion(0),0);
        assertEquals(Moderate.fibonnaciRecursion(3),2);
        assertEquals(Moderate.fibonnaciRecursion(9),34);
    }

    @Test
    void isPalindromeTest() {
        assertTrue(Moderate.isPalindrome("aba"));
        assertFalse(Moderate.isPalindrome("abc"));
        assertTrue(Moderate.isPalindrome("c"));
        assertFalse(Moderate.isPalindrome("abac"));
        assertTrue(Moderate.isPalindrome("abba"));
        assertFalse(Moderate.isPalindrome("kahwfgvjwyervl"));
    }

    @Test
    void evenFibonacciSumTest() {
        assertEquals(Moderate.evenFibonacciSum(50),44);
        assertEquals(Moderate.evenFibonacciSum(450),188);
        assertEquals(Moderate.evenFibonacciSum(1000),798);
    }

    @Test
    void gcdTest() {
        assertEquals(Moderate.gcd(55,5),5);
        assertEquals(Moderate.gcd(16,4),4);
        assertEquals(Moderate.gcd(1052,52),4);
        assertEquals(Moderate.gcd(15,65),5);
        assertEquals(Moderate.gcd(55,54),1);
    }

    @Test
    void gcdRecursionTest() {
        assertEquals(Moderate.gcdRecursion(55,5),5);
        assertEquals(Moderate.gcdRecursion(16,4),4);
        assertEquals(Moderate.gcdRecursion(1052,52),4);
        assertEquals(Moderate.gcdRecursion(15,65),5);
        assertEquals(Moderate.gcdRecursion(55,54),1);
    }

    @Test
    void packageRiceTest() {
        assertEquals(Moderate.packageRice(2,2,12),true);
        assertEquals(Moderate.packageRice(2,1,12),false);
        assertEquals(Moderate.packageRice(2,1,5),true);
        assertEquals(Moderate.packageRice(5,3,24),false);
        assertEquals(Moderate.packageRice(2,7,18),false);
        assertEquals(Moderate.packageRice(2,10,18),true);
    }

    @Test
    void searchTest() {
        assertEquals(Moderate.search(List.of("abc","bbb")),List.of("abc"));
        assertEquals(Moderate.search(List.of("ab","abcd")),List.of());
        assertEquals(Moderate.search(List.of("aaa")),List.of("aaa"));
    }

    @Test
    void getStringTest() {
        assertEquals(Moderate.getString(List.of(1,5,7,8)),"o1,o5,o7,e8");
        assertEquals(Moderate.getString(List.of(103,44)),"o103,e44");
        assertEquals(Moderate.getString(List.of(100)),"e100");
    }

    @Test
    void decodeTest() {
        assertEquals(Moderate.decode("xvm"),"car");
        assertEquals(Moderate.decode("evqv"),"java");
        assertEquals(Moderate.decode("diozmqdzr"),"interview");
    }

    @Test
    void sumsToTargetTest() {
        assertEquals(Moderate.sumsToTarget(new Integer[]{1,3,4},5),true);
        assertEquals(Moderate.sumsToTarget(new Integer[]{2,4,6},5),false);
        assertEquals(Moderate.sumsToTarget(new Integer[]{-1,4,2,1},0),true);
        assertEquals(Moderate.sumsToTarget(new Integer[]{-1,4,2,1},1),true);
    }
}