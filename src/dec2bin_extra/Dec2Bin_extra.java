/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dec2bin_extra;

import java.util.*;


/**
 *
 * @author Donna
 */
public class Dec2Bin_extra {
    static Scanner sc=new Scanner(System.in);
    static long origVal;

    public static void main(String[] args) {
        long decVal;
        int cType; //conversion type 1=recursive 2=string 3=array
        System.out.println("Convert decimal values to binary");
        decVal = getDecimalValue();
        while (decVal != 0 ) {
            cType = getConvertType();
            origVal = decVal;
            switch (cType) {
                case 1:
                    convertByRecursion(decVal);
                    break;
                case 2:
                    convertByString(decVal);
                    break;
                case 3:
                    convertByArray(decVal);
                    break;
            }
            
            System.out.println("\n");
            decVal = getDecimalValue();

        }
        System.out.println("\nThanks for using the decimal converter.");
    } //end of main



    public static void convertByRecursion(long decVal)  {
        int r; //r=remainder
        long nextVal;
        nextVal = decVal /2; //integer division
        r = (int)(decVal % 2); //long to modulus into integer so explicitly cast as integer
        System.out.println("Decimal  " + decVal + " divided by 2 equals " + nextVal + " with a remainder of: " + r);
        if (nextVal > 0) {
               convertByRecursion(nextVal);
       } else {
               System.out.print("\nTherefore the binary value of " + origVal + " is: ");
       }
       System.out.print(r);
    } //end convertByRecursion
    
    public static void convertByString(long decVal)  {
        int r; //r=remainder
        String b=""; //b=binary string - initialize
        long nextVal;
        do {
            nextVal = decVal /2; //integer division
            r = (int)(decVal % 2); //long to modulus into integer so explicitly cast as integer
            System.out.println("Decimal  " + decVal + " divided by 2 equals " + nextVal + " with a remainder of: " + r);
            b = String.valueOf(r) + b;
            decVal = nextVal;
          } while (decVal > 0);
           System.out.println("\nTherefore the binary value of " + origVal + " is: " + b);

    } //end convertByString

    
    //******************************************************************************
    // EXTRA CREDIT: CREATE DYNAMIC ARRAY
    //******************************************************************************
    
    
    public static void convertByArray(long decVal)  {
        ArrayList<Integer> r = new ArrayList<Integer>();
        int i=0; 
        String b=""; //b=binary string - initialize
        long nextVal;
 
        do {
            nextVal = decVal /2; //integer division
            r.add((int)(decVal % 2)); //long to modulus into integer so explicitly cast as integer
            System.out.println("Decimal  " + decVal + " divided by 2 equals " + nextVal + " with a remainder of: " + String.valueOf(r.get(i)) );
            i++;                         
            //print line and use r[i] and then increment counter
            decVal = nextVal;
        } while (decVal != 0);
        //enddo

               for (int j=i-1; j >=0; j--) 
                   // set index to end of array, decrease AFTER loop until index is at beginning/zero
               {
                   b = b + r.get(j);  //concatenate array alements while reading backwards
               } //endfor
 
            System.out.println("\nTherefore the binary value of " + origVal + " is: " + b);

} //end class


    public static long getDecimalValue() {
        long dV;
        do {
            try {
               System.out.println("\nPlease enter your decimal value to be converted (0 to quit): ");
               dV = sc.nextLong();
               if (dV < 0) { //check for positive integers
                   System.out.println("Please enter non-negative values.");
               }
            } catch (Exception e) {
                System.out.println("Illegal input - integers only please.");
                dV = -1;
                sc.next();
            }
        } while (dV < 0);
        return dV;

        } // end getDecimalValue

    public static int getConvertType()  {
        int cType;
        do {
            try {
               System.out.println("Enter conversion type 1=Recursive, 2=String, 3=Array");
               cType = sc.nextInt();
               if (cType < 1 || cType > 3 ) { //check for positive integers
                   System.out.println("Please enter 1, 2 or 3.");
               }
            } catch (Exception e) {
                System.out.println("Illegal input - integers only please.");
                cType = -1;
                sc.next();
            }
            } while (cType < 1 || cType > 3);
        return cType;

    }//end of getConvertType


} //end of  class



