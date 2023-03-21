package com.code_exercises;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EasyTest {

    @Test
    void factorialTest() {
        assertEquals(Easy.factorial(1),1);
        assertEquals(Easy.factorial(4),24);
        assertEquals(Easy.factorial(6),720);
        assertEquals(Easy.factorial(8),40320);
    }

    @Test
    void linearSearchTest() {
        assertEquals(Easy.linearSearch(6,new Integer[] {3,1,3,2,6,9,7,6}),4);
        assertEquals(Easy.linearSearch(10,new Integer[] {10}),0);
        assertEquals(Easy.linearSearch(10,new Integer[] {103, -110}),-1);
        assertEquals(Easy.linearSearch(22,new Integer[] {22, 22, 22, 22}),0);
    }

    @Test
    void reverseStringWithSB() {
        assertEquals(Easy.reverseStringWithSB("java interview"),"weivretni avaj");
        assertEquals(Easy.reverseStringWithSB("aba"),"aba");
        assertEquals(Easy.reverseStringWithSB("code exercise"),"esicrexe edoc");
        assertEquals(Easy.reverseStringWithSB("yes"),"sey");
    }

    @Test
    void findMaximum() {
        assertEquals(Easy.findMaximum(new Integer[]{0,1}),1);
        assertEquals(Easy.findMaximum(new Integer[]{505,10}),505);
        assertEquals(Easy.findMaximum(new Integer[]{20,20,20}),20);
        assertEquals(Easy.findMaximum(new Integer[]{2}),2);
    }

    @Test
    void average() {
        assertEquals(Easy.average(List.of(0,1)),0.5,0.001);
        assertEquals(Easy.average(List.of(100,10)),55);
        assertEquals(Easy.average(List.of(20,20,20)),20);
        assertEquals(Easy.average(List.of(2)),2);

    }

    @Test
    void averageWithStream() {
        assertEquals(Easy.average(List.of(0,1)),0.5,0.001);
        assertEquals(Easy.average(List.of(100,10)),55);
        assertEquals(Easy.average(List.of(20,20,20)),20);
        assertEquals(Easy.average(List.of(2)),2);
    }

    @Test
    void upperCase() {
        assertEquals(Easy.upperCase(List.of("abc","bbb")),List.of("ABC","BBB"));
        assertEquals(Easy.upperCase(List.of("ab","abcd")),List.of("AB","ABCD"));
        assertEquals(Easy.upperCase(List.of("aaa")),List.of("AAA"));
    }

    @Test
    void getElement() {
        assertEquals(Easy.getElement(List.of(3,79,55,3),2),55);
        assertEquals(Easy.getElement(List.of(3,79,55),2),55);
        assertEquals(Easy.getElement(List.of(3,79),2),-1);
    }

    @Test
    void findSecondLargest() {
        assertEquals(Easy.findSecondLargest(new Integer[]{1,3,4}),3);
        assertEquals(Easy.findSecondLargest(new Integer[]{-1,4,2,1}),2);
        assertEquals(Easy.findSecondLargest(new Integer[]{2,4,6}),4);
    }
}