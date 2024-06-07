package Section_2;

import java.util.LinkedList;

// CPSC 331 -Spring 2024- Assignment 3 | Advanced ADT With Applications
// Name: Benny Liang | UCID: 30192142

// Containing the ParkingLot and Car classes
public class ParkingLot 
{
    protected static final int LEN = 20;
    protected LinkedList<Car>[] parkingLot;

    public ParkingLot()
    {
        parkingLot = new LinkedList[LEN];

        for (int i = 0; i < LEN; i++)
            parkingLot[i] = new LinkedList<>();
    }

}

class Car
{
    String licensePlate, parkingSpot;

    public Car(String licencePlate, String parkingSpot)
    {
        this.licensePlate = licencePlate;
        this.parkingSpot = parkingSpot;
    }
}
