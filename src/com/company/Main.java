package com.company;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

     public static void main(String[] args) {
         //Setup
        Scanner scanInput = new Scanner(System.in);
        char[] attendenceRec = new char[] {'A', 'L','O'};

        System.out.println("Hello, this is a semi-modular solution to the Project Euler problem #191, how many days would you like to solve for?");
        int numDays = Integer.parseInt(scanInput.nextLine());

       StringExcersise.possibleStrings(numDays, attendenceRec, "", 0);

     }
}





    //A Class to hold all the possible operations I can do on a string
    class StringExcersise {


        //Finds all the permutations of a string
        public static void possibleStrings(int maxLength, char[] alphabet, String curr, int numValid) {
            // If the current string has reached it's maximum length
            if(curr.length() == maxLength) {
               // System.out.println(curr);
                if(StringExcersise.valid(curr)){
                    numValid++;
                    System.out.println(numValid);
                }
            } else { // Else add each letter from the alphabet to new strings and process these new strings again
                for(int i = 0; i < alphabet.length; i++) {
                    String oldCurr = curr;
                    curr += alphabet[i];
                    possibleStrings(maxLength,alphabet,curr, numValid);
                    curr = oldCurr;
                }
            }
        }







        //Checks a String for how many times a certain letter occurs
        public static int check_Letter (String base, char check){ //Checks for Lates
            int counter = 0;
            for( int i=0; i<base.length(); i++ ) {
                if( base.charAt(i) == check ) {
                    counter++;
                }
            }
            return counter;
        }

        public static boolean letter_builder(String base){ //Checks for letters in a row
            int numAbsent = 0;
            for (int i = 0; i < base.length(); i++){
                char check = base.charAt(i);

                if(check == 'A'){
                    numAbsent++;

                    if(numAbsent == 3){
                        return false;
                    }
                }else{
                    numAbsent = 0;
                }
            }
            return true;
        }





        //Finds if a string is "reward worthy"
        public static boolean valid(String base){
            if(StringExcersise.letter_builder(base) && StringExcersise.check_Letter(base, 'L') < 2){
                return true;
            }else{
                return false;
            }
        }

    }



