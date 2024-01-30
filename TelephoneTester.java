package homework;
public class TelephoneTester
{
    // A class TelephoneTester, has a main method that tests class Telephone.
    public static void main(String[] args)
    {
        Telephone phone1 = new Telephone();
        Telephone phone2 = new Telephone(5550002, TelephoneType.LAND_LINE);
        Telephone phone3 = new Telephone(5550003, TelephoneType.Satellite);
        phone1.dial(5550002); // Calling 5550002 from 5550001
        phone1.printRecentDialedNumbers(); // Prints 5550002
        phone1.redial(); // Prints Error: Call already in progress.
        phone1.disconnect(); //Call ends with 5550002
        System.out.println();
        phone2.dial(5550001); // Calling 5550001 from 5550002
        phone2.printRecentDialedNumbers(); // Prints 5550001
        phone2.disconnect(); //Call ends with 5550001
        System.out.println();
        System.out.println("Using redial method");
        phone2.redial(); // Calling 5550001 from 5550002
        System.out.println();
        System.out.println("Calling itself(phone number 1 calling 5550001): ");
        phone1.dial(5550001); // Prints Error: Cannot call your own number.
        System.out.println(); // Prints new line
        System.out.println("Call on 5550003 ? ");
        phone3.disconnect();
        phone3.redial();
        System.out.println();

        /**
         * Prints the telephone number, type of
         * phone, and most recently dialed number
         */
        System.out.println("Phone 1:\n" + phone1);
        System.out.println();
        System.out.println("Phone 2:\n" + phone2);
        System.out.println();
        System.out.println("Phone 3:\n" + phone3);
        System.out.println();


        //checks and prints result whether two telephone numbers are equal or not.

        System.out.println("Are Phone Number 1 and Phone Number 2 equal? :  " + phone1.equals(phone2)); // false
        System.out.println("Are Phone Number 1 and Phone Number 3 equal? : " + phone1.equals(phone3));// false
        System.out.println("Are Phone Number 2 and Phone Number 3 equal? : " + phone2.equals(phone3));// false
        System.out.println();

        // get the total number of phone calls made from any phone.
        System.out.println("Total Calls made : " + Telephone.getTotalCalls()); // Total Calls: 3
    }
} //End of class TelephoneTester
