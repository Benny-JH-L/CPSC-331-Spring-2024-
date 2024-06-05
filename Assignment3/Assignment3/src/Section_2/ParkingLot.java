package Section_2;

import java.util.LinkedList;

// Containing the ParkingLot and Car classes
public class ParkingLot 
{
    protected static final int LEN = 20;
    protected LinkedList<Car>[] parkingLot;

    public ParkingLot()
    {
        parkingLot = new LinkedList[LEN];
    }

}

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
     * Sets the parking spot information of the Car, splitting the level and spot number.
     * @param parkingSpot a String, of the parking spot (Ex. 1-12: level 1, space 12)
     */
    private void setParkingSpot(String parkingSpot)
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
