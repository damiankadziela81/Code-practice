package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
//        reverseString();
//        swapTwoNumbersWithoutThirdVariable();
//        countUniqueWordsWithHashMap();
//        iterateHashMap();
//        isNumberPrime();
//        isStringPalindrome();
//        fibonacci();
//        iterateArray();
//        howManyDuplicateCharacters();
//        secondHighestNumberInArray();
//        armstrongNumber();
//        removeSpaces();
        pyramidPattern();

    }

    static boolean isEven(Integer number) {
        return Integer.toBinaryString(number).endsWith("0");
    }

    static void reverseString() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your string:");
        String string = scanner.nextLine();

        for (int i = 0; i < string.length();i++){
            System.out.print(string.charAt(string.length()-i-1));
        }
    }

    static void swapTwoNumbersWithoutThirdVariable(){
        Scanner intScanner = new Scanner(System.in);
        System.out.println("Enter first value");
        int x = intScanner.nextInt();
        System.out.println("Enter second value");
        int y = intScanner.nextInt();
        System.out.println("Initial order " + x + " " + y);
        x = y + x; //both in x
        y = x - y; //both(x) - y gets original x
        x = x - y; //both(still x) - y(now original x) gets original y
        System.out.println("Swapped " + x + " " + y);
    }

    static void countUniqueWordsWithHashMap(){
        String string = "How many many unique words are in in this sentence?";
        String[] splittedString = string.split(" ");
        int counter = 0;
        HashMap<String,Integer> map = new HashMap<>();
        for(String s: splittedString){
            if(map.containsKey(s)){
                map.put(s,map.get(s) + 1);
            } else {
                map.put(s,1);
                counter++;
            }
        }
        System.out.println(map + "Number of unique words: " + counter);

    }

    static void iterateHashMap(){
        HashMap<String,Integer> map = new HashMap<>();
        map.put("Adam",1);
        map.put("Beata",2);
        map.put("Cecylia",3);
        System.out.println(map.values());
        System.out.println(map.entrySet());

        for(String key : map.keySet()){
            System.out.println(map.get(key));
        }
        System.out.println("FOR EACH LOOP");
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            System.out.println("Key: " + entry.getKey());
            System.out.println("Value: " + entry.getValue());
        }
        System.out.println("WHILE LOOP");
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry me = iterator.next();
            System.out.println("Key: " + me.getKey() + " Value: " + me.getValue());
        }
    }

    static void isNumberPrime(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj liczbe: ");
        int number = scanner.nextInt();
        boolean isPrime = true;
        for(int i=2; i<number; i++){
            if(number%i==0) {
                isPrime = false;
                break;
            }
            System.out.println(number + " % " + i + " = " + (number%i));
        }
        if(isPrime) System.out.println("To jest liczba pierwsza!");
        else System.out.println("To nie jest liczba pierwsza");
    }

    static void isString1TheSameAsReversedString2(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj 1-szy ciąg znaków: ");
        String string1 = scanner.nextLine();
        System.out.println("Podaj 2-gi ciąg znaków: ");
        String string2 = scanner.nextLine();
        boolean isPalindrome = true;
        if(string1.length()==string2.length()){
            for (int i = 0; i < string1.length(); i++){
                if(string1.charAt(i)!=string2.charAt(string1.length() - i - 1)) isPalindrome = false;
            }
        } else {
            System.out.println("Te ciągi nie są nawet równe!");
        }
        if(isPalindrome) System.out.println("To są palindromy");
        else System.out.println("To nie są palindromy");

    }

    static void isStringPalindrome(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter string: ");
        String original = scanner.nextLine();
        String reversed = "";
        boolean isPalindrome = true;
        for(int i = original.length()-1; i>=0; i--){
            reversed = reversed + original.charAt(i); //tu bedzie duzo obiektów typu String, lepiej uzyc StringBuilder (bo jest mutowalny)
        }
        if(original.equals(reversed)) System.out.println("string is palindrome (using equals)");
        else System.out.println("string is not palindrome (using equals)");

        //without reversed variable
        for(int i = 0; i < original.length(); i++){
            if(original.charAt(i)!=original.charAt(original.length()-i-1))isPalindrome=false;
        }
        System.out.println("Reversed string is: " + reversed);
        if(isPalindrome) System.out.println("string is palindrome");
        else System.out.println("string is not palindrome");
    }

    static void fibonacci(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj ilość iteracji");
        int iter = scanner.nextInt();
        int a = 0;
        int b = 0;
        int c = 1;
        for (int i = 0; i < iter; i++) {
            a = b;
            b = c;
            c = a + b;
            System.out.println(a);
        }

        System.out.println("---------------LIST---------------");
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        for(int i = 2; i<iter;i++){
            list.add(list.get(i-2)+list.get(i-1));
        }
        System.out.println(list);
        System.out.println(list.get(iter-1));
    }

    static void iterateArray(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println("----------for loop-------------");
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
        System.out.println("------------while loop----------");
        int i = 0;
        while(i < list.size()){
            System.out.println(list.get(i));
            i++;
        }
        System.out.println("---------while with iterator----------");
        Iterator itr = list.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }

        System.out.println("------------enhanced for loop-----");
        for(Integer element : list){
            System.out.println(element);
        }
    }

    static void howManyDuplicateCharacters(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj string");
        String string = scanner.nextLine();
        int count = 0;
        char[] chars = string.toCharArray();
        for(int i=0; i<chars.length-1;i++){
            for(int j=i+1; j<chars.length;j++){
                if(chars[i]==chars[j]){
                    count++;
                    System.out.println(""+chars[i] + chars[j]);
                    break;
                }

            }
        }
        System.out.println("Zduplikowanych znaków jest: " + count);
    }

    static void secondHighestNumberInArray(){
        Random random = new Random();
        int array[] = new int[10];
        for (int i=0; i< array.length; i++){
            array[i] = random.nextInt(0,100);
            System.out.println(array[i]);
        }

        int firstHighest=0;
        int secondHighest=0;
        for(int i=0; i< array.length; i++){
            if(array[i]>firstHighest){
                secondHighest = firstHighest;
                firstHighest = array[i];
            }
            else if(array[i]>secondHighest){
                secondHighest=array[i];
            }
        }
        System.out.println("Highest: " + firstHighest);
        System.out.println("Second highest: " + secondHighest);
    }

    static void armstrongNumber(){

        int temp,a,c=0;
        //get individual decimals
        int n=153;
        temp=n;
        while(n>0) {
            a = n % 10;
            n = n / 10;
            c = c + (a * a * a);
            System.out.println("a = " + a + " n = " + n + " c = " + c);
        }
        if(temp==c) System.out.println("armstrong number");
        else System.out.println("not armstrong number");
    }

    static void removeSpaces(){
        String string = " Remove All The Spaces ";
        String string2 = string.replace(" ","");
        System.out.println(string + "\n" + string2);

        System.out.println("--------------as SB -------------");
        StringBuilder sb = new StringBuilder();
        char[] chars = string.toCharArray();
        for(char c : chars){
            if(c!=' ')sb.append(c);
        }
        System.out.println(sb);
    }

    //Pyramids
    //    https://www.digitalocean.com/community/tutorials/pyramid-pattern-programs-in-java
    static void pyramidPattern() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of rows: ");
        int rows = scanner.nextInt();

        System.out.println("Choose your pattern [1-7]");
        int pattern = scanner.nextInt();
        switch(pattern) {
            case 1: pyramidPattern1(rows);
            break;
            case 2: pyramidPattern2(rows);
            break;
            case 3: pyramidPattern3(rows);
            break;
            case 4: pyramidPattern4(rows);
            break;
            case 5: pyramidPattern5(rows);
            break;
            case 6: pyramidPattern6(rows);
            break;
            case 7: pyramidPattern7(rows);
            break;
        }
    }

    private static void printWhiteSpaces(int howMany) {
        for(int i = 0; i < howMany; i++) System.out.print(" ");
    }

    private static void pyramidPattern1(int rows) {
        for(int i = 1; i <= rows; i++){
            printWhiteSpaces(rows-i);
            for(int j = 1; j<=i; j++) System.out.print(i + " ");
            System.out.println();
        }
    }
    private static void pyramidPattern2(final int rows) {
        for(int i = 1; i <= rows; i++){
            printWhiteSpaces(rows - i);
            for(int j=1; j<=i; j++) System.out.print(j + " ");
            System.out.println();
        }
    }

    private static void pyramidPattern3(final int rows) {
        for(int i = 0; i < rows; i++){
            printWhiteSpaces(rows - i);
            for(int j=0; j<=i; j++) System.out.print("* ");
            System.out.println();
        }
    }

    private static void pyramidPattern4(final int rows) {
        for(int i = 0; i <= rows; i++){
            printWhiteSpaces(2*(rows - i));
            for(int j=1; j<=i; j++) System.out.print(j + " ");
            for(int j=i-1; j>0; j--) System.out.print(j + " ");
            System.out.println();
        }
    }

    private static void pyramidPattern5(final int rows) {
        for(int i = rows; i >= 1; i--){
            printWhiteSpaces(2*i);
            for(int j=i; j<=rows; j++) System.out.print(j + " ");
            for(int j=rows-1; j>=i ; j--) System.out.print(j + " ");
            System.out.println();
        }
    }

    private static void pyramidPattern5Alternate(final int rows) {
        for(int i = 0; i < rows; i++){
            printWhiteSpaces(2*(rows - i));
            for(int j=rows-i; j<=rows; j++) System.out.print(j + " ");
            for(int j=rows-1; j>=rows-i; j--) System.out.print(j + " ");
            System.out.println();
        }
    }

    private static void pyramidPattern6(final int rows) {
        for (int i = 0; i < rows; i++) {
            printWhiteSpaces(i);
            for(int j=rows-i; j>0; j--) System.out.print("* ");
            System.out.println();
        }
    }

    private static void pyramidPattern7(final int rows) {
        for (int i = 0; i < rows; i++) {
            printWhiteSpaces(i);
            for(int j=rows-i; j>0; j--) System.out.print(rows-i + " ");
            System.out.println();
        }
    }
}