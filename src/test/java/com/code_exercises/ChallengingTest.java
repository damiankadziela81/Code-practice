package com.code_exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChallengingTest {

    Challenging challenging = new Challenging();

    @Test
    void findLongestPalindromeTest() {
        assertEquals(challenging.findLongestPalindrome("abattd"),"aba");
        assertEquals(challenging.findLongestPalindrome("abc"),"a");
        assertEquals(challenging.findLongestPalindrome("abcba"),"abcba");
        assertEquals(challenging.findLongestPalindrome("thhwerw"),"hh");
    }

    @Test
    void findLongestCommonSequenceTest() {
        assertEquals(challenging.findLongestCommonSequence("abattd","gdgeaba"),"aba");
        assertEquals(challenging.findLongestCommonSequence("abc","sdsad"),"a");
        assertEquals(challenging.findLongestCommonSequence("abcba","abcba"),"abcba");
        assertEquals(challenging.findLongestCommonSequence("aaa","aaa"),"aaa");
    }

    @Test
    void largestPrimeFactorTest() {
        assertEquals(challenging.largestPrimeFactor(2),2);
        assertEquals(challenging.largestPrimeFactor(55),11);
        assertEquals(challenging.largestPrimeFactor(455),13);
        assertEquals(challenging.largestPrimeFactor(1015),29);
        assertEquals(challenging.largestPrimeFactor(13195),29);
    }

    @Test
    void getNumberSmallBagsTest() {
        assertEquals(challenging.getNumberSmallBags(2,2,12),2);
        assertEquals(challenging.getNumberSmallBags(2,1,12),-1);
        assertEquals(challenging.getNumberSmallBags(2,1,5),0);
        assertEquals(challenging.getNumberSmallBags(5,3,24),-1);
        assertEquals(challenging.getNumberSmallBags(2,7,18),-1);
        assertEquals(challenging.getNumberSmallBags(2,10,18),8);
    }
}