package Section_2;

import java.util.LinkedList;
import Section_2.Car;

// CPSC 331 -Spring 2024- Assignment 3 | Advanced ADT With Applications
// Name: Benny Liang | UCID: 30192142

// Containing the main method for tesing
public class ParkingLotManager 
{
    private ParkingLot parkingLotInstance;
    private LinkedList<Car>[] parkingLot;

    public ParkingLotManager()
    {
        parkingLotInstance = new ParkingLot();
        this.parkingLot = parkingLotInstance.parkingLot;
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
        return licensePlate.hashCode() % ParkingLot.LEN;
    }

    /**
     * Precondition:
     * - 'licensePlate' is a non-empty String. 
     * 
     * Postcondition:
     * - If the hash table contains a car with this license plate, return true. 
     * Otherwise return false.
     * 
     * @param licensePlate a String.
     * @return a boolean.
     */
    public boolean search(String licensePlate)
    {
        int hashValue = hashValue(licensePlate);
        LinkedList<Car> levelOfParkedCars = parkingLot[hashValue];

        for (int i = 0; i < levelOfParkedCars.size(); i++)                      // Go through the LinkedList<Car> at parkingLot[hashValue] and check each Car's license plate.
        {
            if (levelOfParkedCars.get(i).licensePlate.equals(licensePlate))     // Car with this license plate is parked, return true.
                return true;    
        }

        return false;                                                           // Otherwise return false.
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
     * @param licensePlate a String.
     * @return a String, the corresponding parking spot for this Car.
     */
    public String retrieve(String licensePlate)
    {
        int hashValue = hashValue(licensePlate);
        LinkedList<Car> levelParkedCars = parkingLot[hashValue];

        for (int i = 0; i < levelParkedCars.size(); i++)                        // Go through LinkedList<Car> at parkingLot[hashValue],
        {
            String licensePlateToCheck = levelParkedCars.get(i).licensePlate;   
            if (licensePlateToCheck.equals(licensePlate))                       // if the license plate of the Car in the linked list is the same as the licese plate in the parameter,
                return levelParkedCars.get(i).parkingSpot;                      // return the Car's parking spot.
        }

        // Print the message
        System.out.printf("\nNo Car with license plate '%s' was found in the hash table.", licensePlate);
        
        return null;                                                            // return null if a Car with this licensePlate does not exist in the parkingLot[hashValue].
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
        boolean carIsParked = search(licensePlate);
        int hashValue = hashValue(licensePlate);                // level, index of 'parkingLot' array

        // If searching results true, the Car with this licesnce plate is parked --> update parking spot.
        if (carIsParked)
        {
            LinkedList<Car> levelOfParkedCars = parkingLot[hashValue];

            // Go through linked list until we find the Car with the specified 'licensePlate'
            for (int i = 0; i < levelOfParkedCars.size(); i++)
            {
                if (levelOfParkedCars.get(i).licensePlate.equals(licensePlate))
                {
                    levelOfParkedCars.get(i).parkingSpot = parkingSpot;     // update its 'parkingSpot'
                    break;
                }
            }
        }
        // Otherwise the Car with this licensePlate is not parked --> add it to the appropriate linked list in hash table.
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
        String possibleParkedSpot = retrieve(licensePlate);

        // If the Car this this 'licensePlate' exists in the hash table, remove the Car from the hash table.
        if (possibleParkedSpot != null)
        {
            int hashValue = hashValue(licensePlate);

            // Going through the linked list and find the Car with the specified license plate.
            for (int i = 0; i < parkingLot[hashValue].size(); i++)
            {
                Car carToCheck = parkingLot[hashValue].get(i);

                if (carToCheck.licensePlate.equals(licensePlate))   // Found the Car, and remove it.
                {
                    parkingLot[hashValue].remove(i);                // removing the Car from the linked list.
                    break;
                }
            }
        }
        // If there is no Car with this 'licensePlate' exists in the hash table, retrieve(...) method call will print the message.
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
        String returnStr = "\n----ParkingLot----\n";
        LinkedList<Car> levelOfParkedCars;

        for (int i = 0; i < parkingLot.length; i++)             // Loop through LinkedList<Car>[] array indicies
        {
            levelOfParkedCars = parkingLot[i];
            returnStr += i + ": [";

            for (int k = 0; k < levelOfParkedCars.size(); k++)  // Loop through LinkedList<Car> elements
            {
                Car car = levelOfParkedCars.get(k);
                String s = car.licensePlate + ":" + car.parkingSpot;
                
                if (k + 1 != parkingLot[i].size())              // don't add a comma if it is the last element
                    s += ", ";
                returnStr += s;
            }
            returnStr += "]\n";
        }

        return returnStr;
    }

    public static void main(String[] args) 
    {
        ParkingLotManager manager = new ParkingLotManager();
        manager.insert("AB1234", "1-23");
        manager.insert("CD5678", "2-45");
        manager.insert("EF9012", "3-12");
        manager.insert("GH3456", "1-34");
        System.out.println(manager.toString());
    }
}
