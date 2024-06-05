package Section_2;

import java.util.LinkedList;

// Containing the ParkingLot and Car classes
public class ParkingLot 
{
    class Car
    {
        String licensePlate;

        public Car(String licencePlate)
        {
            this.licensePlate = licencePlate;
        }
    }

    private final int ARRAY_SIZE = 20;
    private ParkingLot[] parkingLot = new ParkingLot[ARRAY_SIZE];
    
    // level's are the indicies of the array and space number is the linked list

}
