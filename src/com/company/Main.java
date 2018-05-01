package com.company;

//Libraries
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanInput = new Scanner(System.in); //Allows user input from cmd

            //Ask the user for their input
            System.out.print("Hello, this is a semi-modular solution to the Project Euler problem #191, how many days would you like to solve for?");
            int numDays = Integer.parseInt(scanInput.nextLine());

            //Defines the Letters
            char[] attendenceRec = new char[] {'A', 'L','O'};
            StringExcersise.possibleStrings(30, attendenceRec, "");
     }
    }

    //A Class toi hold all the possible operations I can do on a string
    class StringExcersise {

        //Finds all the permutations of a string
        public static void possibleStrings(int maxLength, char[] alphabet, String curr) {

            // If the current string has reached it's maximum length
            if(curr.length() == maxLength) {
                StringExcersise.check_Letter(curr, 'L');
                System.out.println(curr);

                // Else add each letter from the alphabet to new strings and process these new strings again
            } else {
                for(int i = 0; i < alphabet.length; i++) {
                    String oldCurr = curr;
                    curr += alphabet[i];
                    possibleStrings(maxLength,alphabet,curr);
                    curr = oldCurr;
                }
            }
        }

        //Checks a String fro how many times a certain letter occurs
        public static int check_Letter (String base, char check){
            int counter = 0;
            for( int i=0; i<base.length(); i++ ) {
                if( base.charAt(i) == check ) {
                    counter++;
                }
            }
            return counter;
        }
    }


