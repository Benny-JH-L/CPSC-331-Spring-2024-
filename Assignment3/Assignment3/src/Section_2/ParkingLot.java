package Section_2;

import java.util.LinkedList;

// Containing the ParkingLot and Car classes
public class ParkingLot 
{
    class Car
    {
        String licensePlate, parkingSpot, level, spotNum;

        public Car(String licencePlate, String parkingSpot)
        {
            this.licensePlate = licencePlate;
            this.parkingSpot = parkingSpot;
            setParkingSpot(parkingSpot);
        }

        /**
         * Sets the parking spot information of the Car.
         * @param parkingSpot a String, of the parking spot (Ex. 1-12: level 1, space 12)
         */
        public void setParkingSpot(String parkingSpot)
        {
            String s = "";
            for (int i = 0; i < parkingSpot.length() - 1; i++)
            {
                if (parkingSpot.charAt(i) != '-')
                    s += parkingSpot.charAt(i);
                else if (parkingSpot.charAt(i) == '-')
                {
                    level = s;      // setting level
                    s = "";         // reset string for spot   
                }
                else if (i + 1 == parkingSpot.length())
                    spotNum = s;    // setting spot #
            }
        }
    }

    private static final int LEN = 20;
    private LinkedList<Car>[] parkingLot;

    public ParkingLot()
    {
        parkingLot = new LinkedList[LEN];
    }

    /**
     * Precondition:
     * - 'licensePlate' is a non-empty String. 
     * 
     * Postcondition:
     * - ‘licensePlate.hashCode() % LEN’ is returned.
     * 
     * @param licensePlate a String.
     * @return an int.
     */
    public int hashValue(String licensePlate)
    {
        return licensePlate.hashCode() % LEN;
    }

    /**
     * Precondition:
     * - 'licensePlate' is a non-empty String. 
     * 
     * PostconditionL
     * - If the hash table contains a car with this license plate, return true. 
     * Otherwise return false.
     * 
     * @param licensePlate a String.
     * @return a boolean.
     */
    public boolean search(String licensePlate)
    {
        return false;
    }

    /**
     * Precondition: 
     * - ‘licensePlate’ is a non-empty string.
     * 
     * Postcondition: 
     * - If the hash table contains a car with this license plate, return the corresponding
     * parking spot. Otherwise, print a message indicating that no car with this license
     * plate was found in the hash table.
     * 
     * @param licesnePlate a String.
     * @return a String, the corresponding parking spot for this Car.
     */
    public String retrieve(String licesnePlate)
    {
        int hashValue = hashValue(licesnePlate);
        LinkedList<Car> levelParkedCars = parkingLot[hashValue];

        for (int i = 0; i < levelParkedCars.size() - 1; i++)
        {
            String licensePlateToCheck = levelParkedCars.get(i).licensePlate;
            if (licensePlateToCheck.equals(licesnePlate))
                return levelParkedCars.get(i).parkingSpot;            
        }

        System.out.printf("\nNo Car with license plate '%s' was found in the hash table.", licesnePlate);
        return null;
    }

    /**
     * Precondition: 
     * - ‘licensePlate’ is a non-empty string and ‘parkingSpot’ is a valid parking spot identifier (e.g., “1-23” for level 1, space 23).
     * 
     * Postcondition: 
     * - If the hash table does not contain a car with this license plate, a ‘Car’ object
     * with attributes ‘licensePlate’ and ‘parkingSpot’, it is added to the appropriate linked list in the
     * hash table. If a ‘Car‘ with this license plate is already in the hash table, its parking spot is
     * updated to the inputted parking spot.
     * 
     * @param licensePlate a String.
     * @param parkingSpot a String.
     */
    public void insert(String licensePlate, String parkingSpot)
    {
        String possibleParkedSpot = retrieve(licensePlate);
        int hashValue = hashValue(licensePlate);                // level, index of 'parkingLot' array

        // If retrieving did not result in a null parking spot, the Car with this licesnce plate is parked --> update parking spot.
        if (possibleParkedSpot != null)
        {
            LinkedList<Car> levelOfParkedCars = parkingLot[hashValue];

            // Go through linked list until we find the Car with the specified 'licensePlate'
            for (int i = 0; i < levelOfParkedCars.size() - 1; i++)
            {
                if (levelOfParkedCars.get(i).licensePlate.equals(licensePlate))
                {
                    levelOfParkedCars.get(i).parkingSpot = parkingSpot;     // update its 'parkingSpot'
                    break;
                }
            }
        }
        // If it did result in a null parking spot result, the Car with this license plate is not parked --> add it to the appropriate linked list in hash table.
        else
        {
            Car newCar = new Car(licensePlate, parkingSpot);
            parkingLot[hashValue].add(newCar);
        }
    }

    /**
     * Precondition: 
     * - ‘licensePlate’ is a non-empty string.
     * 
     * Postcondition: 
     * - If the hash table contains a ‘Car‘ with this license plate, this ‘Car‘ is removed
     * from the hash table. Otherwise, a message is printed indicating that no car with this license
     * plate was found in the hash table.
     * 
     * @param licensePlate a String.
     */
    public void delete(String licensePlate)
    {

    }

    /**
     * Precondition: 
     * - ‘arr’ is an array of LinkedList of ‘Car’.
     * 
     * Postcondition: 
     * - A string is returned consisting of one line per entry of the array, including
     * empty linked lists. Each line takes the form:
     * “ ArrayIndex: [LicensePlate:ParkingSpot, ...] ”
     * 
     * Refer to assignment pdf for example.
     */
    @Override
    public String toString()
    {

    }
    // level's are the indicies of the array and space number is the linked list

}
