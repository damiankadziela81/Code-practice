package org.example;

class FizzBuzzKata {

    public static void main(String[] args) {
        printNumbers(1000);
    }

    static void printNumbers(int upTo){
        for(int i=0; i<=upTo; i++) {
            StringBuilder result = new StringBuilder();
            //check if contains number
            boolean contains3 = false;
            boolean contains5 = false;
            String number = Integer.toString(i);
            char arr[] = number.toCharArray();
            for(int j=0; j<arr.length; j++){
                if(arr[j]=='3') contains3 = true;
                if(arr[j]=='5') contains5 = true;
            }
            if(contains3) result.append("Fizz");
            if(contains5) result.append("Buzz");
            //check if divisable
            if(i%3==0)result.append("Fizz");
            if(i%5==0)result.append("Buzz");
            if (result.isEmpty()) result.append(number);
            System.out.println("[" + i + "] " + result);
        }
    }
}
