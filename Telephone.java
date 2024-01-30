package homework;
import java.util.ArrayList;
import java.util.List;
public class Telephone
{
    /**
     * A class Telephone, has the following features:
     * a. A telephone whith one of a set of specific types.
     * b. A constructor that automatically assigns the next number in the sequence
     * beginning with 5550001, the second 5550002, the third 5550003, and so on
     * using a static variable.
     * c. A constructor that takes a telephone number as a parameter and uses that
     * number for the telephone.
     * @param nextnumber assigns the next number in the sequence beginning with 5550001
     * @param phonenumber returns a phone number
     * @param phoneType returns  one of several different types: land line, mobile, or satellite.
     * @param RecentDialedNumber returns  most recently dialed numbers in reverse chronological order
     * @param onCall returns  call is already in progress with this phone
     * @param dialedNumbers prints  phone is starting a call and to which number.
     * @param TotalCalls returns the total number of phone calls made from any phone.
     */
    private static int nextnumber = 5550001;
    private static int TotalCalls = 0;

    private int phonenumber;
    private TelephoneType phoneType;
    private int RecentDialedNumber;
    private boolean onCall;

    private List<Integer> dialedNumbers;

    public Telephone() {
        this.phonenumber = nextnumber++;
        this.phoneType = TelephoneType.Mobile;
        this.RecentDialedNumber = -1;
        this.onCall = false;
        this.dialedNumbers = new ArrayList<>();
    }

    public Telephone(int phoneNumber, TelephoneType phoneType)
    {
        this.phonenumber = phoneNumber;
        this.phoneType = phoneType;
        this.RecentDialedNumber = -1;
        this.onCall = false;
        this.dialedNumbers = new ArrayList<>();
    }


    public void dial(int number)
    {
        /**
         *  A telephone has a method to dial a phone number.
         * i. If the number is the same as the telephone’s own number, prints an
         * error.
         * ii. If a call is already in progress with this phone, prints an error.
         * iii. Otherwise, prints a message that the phone is starting a call and to
         * which number.
         */
        if (number == this.phonenumber) //  If the number is the same as the telephone’s own number
        {
            System.out.println("Error: Cannot call your own number."); // prints an error.
        } else if (onCall) //If a call is already in progress with this phone
        {
            System.out.println("Error: Call already in progress."); //prints an error.
        }
        else
        {
            this.onCall = true;
            this.RecentDialedNumber = number; // RecentDialedNumber = number
            System.out.println("Starts Calling " + number + " from " + this.phonenumber); //prints a message that the phone is starting a call and to which number.
            TotalCalls++; // increment of number of calls
            dialedNumbers.add(number); // adds last dial number
        }
    }


    public void disconnect()
    {
        /**
         * A telephone has a method to disconnect a call in progress.
         * i. If a call is not in progress, print an error.
         * ii. Otherwise, print a message that the call is ending
         */
        if (!onCall)  //If a call is not in progress
        {
            System.out.println("Error: No call in progress."); //prints an error.
        } else
        {
            System.out.println("Call ended with " + RecentDialedNumber); // prints that the call is ending with the phone number of the other telephone
            onCall = false;
        }
    }

    public void redial()
    /**
     * A telephone has a redial method that starts a call with the most recently
     * dialed number.
     * i. If no call has yet been made, prints an error (there is no number to
     * redial).
     * ii. Otherwise, handles the call normally.
     */
    {
        if (RecentDialedNumber == -1)  //no call has yet been made
        {
            System.out.println("Error: No number to redial.");
        } else {
            dial(RecentDialedNumber); //handles the call normally
        }
    }

    public void printRecentDialedNumbers()
    {
        /**
         * Displays the 10 most recently dialed numbers in reverse
         * chronological order and prints those numbers.
         */
        System.out.print("Recent Dialed Number:");
        int count = 0;
        for (int number : dialedNumbers)
        {
            if (count >= 10 || number == -1) //reverse chronological order of recently dialed numbers
            {
                break;
            }
            System.out.println(number);
            count++;
        }
    }


    @Override
    public boolean equals(Object obj)
    {
        /**
         * Two telephones with the same phone number are considered equal to
         * each other.
         */
        if (this == obj) // if this and obj are the same reference, which means that the same instance of the object
        {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) // checks if obj is null or if it belongs to a different class than the current object (this).
        {
            return false;
        }
        Telephone other = (Telephone) obj;
        return phonenumber == other.phonenumber; //compare
    }

    @Override
    public String toString()
    {
        /**
         *  descriptive string representation for printing
         */
        return "Phone Number: " + phonenumber +
                "\nPhone Type: " + phoneType +
                "\nRecent Dialed Number: " + RecentDialedNumber;
    }

    public static int getTotalCalls()
    {
        /**
         * a method to get the total number of phone
         * calls made from any phone.
         */
        return TotalCalls;
    }
} // End of class Telephone

