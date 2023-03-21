package com.code_exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Easy {
    public static void main(String[] args) {
    }

    /*
    Factorial
Write a method that calculates the factorial of a given number.
Factorial is the product of all positive integers less than or equal to n. For example, factorial(4) = 4x3x2x1 = 24.
TIP: To make it more interesting, try to do it recursively.
     */

    static Integer factorial(Integer n) {
        int result=1;
        for(int i=1; i<=n; i++) {
            result*=i;
        }
        return result;
    }

    /*
    Linear Search
Write a method that returns the index of the first occurrence of given integer in a list.
Assume that the index of the first element in the list is zero.
If the number does not exist return -1.
     */

    static int linearSearch(Integer n, Integer[] list) {
        int index=-1;
        for(int i=0; i<list.length; i++) {
            if(n.equals(list[i])) {
                index=i;
                break;
            }
        }
        return index;
    }

    /*
    Reverse String
Write a method that reverses a string.
For example, 'java interview' becomes 'weivretni avaj'.
     */

    static String reverseStringWithSB(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }

/*
Find Maximum
Write a method that returns the largest integer in the list.
You can assume that the list has at least one element.
 */

    static Integer findMaximum(Integer[] list) {
        Integer maximum=0;
        for(int i=0; i<list.length; i++) {
            if (maximum<list[i])maximum = list[i];
        }
        return maximum;
    }

    /*
    Average Value (Java 8 Lambdas and Streams)
Write a method that returns the average of a list of integers.
     */

    static Double average(List<Integer> list) {
        Integer sum=0;
        for(Integer element : list) {
            sum+=element;
        }
        return (double) sum / (double) list.size();
    }

    static Double averageWithStream(List<Integer> list) {
        return list.stream()
                .mapToInt(i -> i)
                .average()
                .getAsDouble();
    }

    /*
    Convert to Upper Case (Java 8 Lambdas and Streams)
Write a method that converts all strings in a list to their upper case.
     */

    static List<String> upperCase(List<String> list) {
        return list.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }

    /*
    Nth Odd Element
Write a method that returns the nth odd element of a list. If the index of the element exceeds the list size,
then return -1.
     */

    static Integer getElement(List<Integer> list, Integer n) {
        List<Integer> oddList = new ArrayList<>();
        for(Integer number : list){
            if (number % 2 == 1) oddList.add(number);
        }
        if(n > oddList.size() - 1) return -1;
        else return oddList.get(n);
    }

    /*
    Find Second Largest Number in Array
Find the second largest number in an integer array. You can assume a minimum array length of two.
     */


    static Integer findSecondLargest(Integer[] arr) {
        Integer largest=Integer.MIN_VALUE;
        Integer secondLargest=Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++) {
            if(arr[i]>largest) {
                secondLargest = largest;
                largest = arr[i];
            }
            if (arr[i]<largest & arr[i]>secondLargest) secondLargest = arr[i];
        }
        System.out.println(largest + " " + secondLargest);
        return secondLargest;
    }
}
