package Section_4;

import java.util.LinkedList;

public class EventRobot 
{
    /**
    * Calculates minimum required charge for robots.
    *
    * - 1 <= pathways.length < 1000
    * - pathways[i].length == 3
    * - pathways[i] = [x, y, c] - where 1 <= x,y <= n, -1000 <= c <= 1000
    * - n (number of buildings) >= 1
    * - 1 <= headquarters <= n
    * Pairs of (x,y) in pathways are unique. (i.e., no multiple edges.)
    */
    public int minimumCharge(int[][] pathways, int n, int headquarters) 
    {
        int[] pathCostArr = new int[n];     // Used to store the minimum cost needed to get from starting vertex to other verticies  

        for (int i = 0; i < pathCostArr.length; i++)
            pathCostArr[i] = Integer.MAX_VALUE;     // Set cost of verticies to +INFINITY initilly
        
        // Set cost from starting building
        LinkedList<int[]> startBuildingPaths = getOutgoingPaths(pathways, headquarters);
        
        while (!startBuildingPaths.isEmpty())
        {
            int[] path = startBuildingPaths.remove();   // get an outgoing path from headquarters
            int toBuildingNum = path[1];                // get building number that path is going to
            pathCostArr[toBuildingNum - 1] = path[2];   // set the cost from headquarters to this building
        }

        // Iterate through every building and determine the cost to get there
        for (int i = 0; i < n; i++)                 
        {
            int[] prevPathCostArr = pathCostArr.clone();        // 'pathCostArr' before entering the inner-for-loop
            for (int k = 0; k < pathways.length; k++)           // Iterate through the pathways
            {
                int[] currentPath = pathways[k];
                int currentBuildingNum = currentPath[0];    

                if (pathCostArr[currentBuildingNum - 1] == Integer.MAX_VALUE)       // if the cost to get to this building is +INFINITY,  (minus 1 because array starts at 0 and building count start at 1)
                    continue;                                                       // check next building (Cost to this building is not yet determined)
                else                                                                // Otherwise, a path/cost to this building has been determined.
                    updateCost(pathways, pathCostArr, currentBuildingNum);
            }

            if (prevPathCostArr.equals(pathCostArr))                                // break earlier if no change happens
                break;
        }

        int minCost = -1;

        for (int i = 0; i < pathCostArr.length; i++)
        {
            if ((pathCostArr[i] != Integer.MAX_VALUE) && pathCostArr[i] > minCost)
                minCost = pathCostArr[i];
        }

        return minCost; 
    }

    protected static LinkedList<int[]> getOutgoingPaths(int[][] pathways, int buildingNum)  // protected static for now
    {
        LinkedList<int[]> returnList = new LinkedList<>();

        for (int i = 0; i < pathways.length; i++)
        {
            if (pathways[i][0] == buildingNum)
                returnList.add(pathways[i]);
        }

        return returnList;
    }

    private void updateCost(int[][] pathways, int[] pathCostArr, int currentBuildingNum)
    {
        LinkedList<int[]> buildingPaths = getOutgoingPaths(pathways, currentBuildingNum);    // get the paths outgoing from this building.

        while (!buildingPaths.isEmpty())
        {
            int[] outgoingPath = buildingPaths.remove();
            int toBuildingNum = outgoingPath[1] - 1;                                    // get building number we are traversing to, subtract 1 to get 'pathCostArr' location
            int costToBuilding = pathCostArr[currentBuildingNum - 1] + outgoingPath[2];     // Add the cost to get to this building and the cost of path to get to other building,

            if (costToBuilding < pathCostArr[toBuildingNum])                            // if the resulting cost is less than the current cost to get to this building, set cost to resulting cost.
                pathCostArr[toBuildingNum] = costToBuilding;
        }
    }

    public static void main(String[] args) 
    {
        // Sample Inputs and Outputs

        // Example 1
        int[][] pathways1 = {{1,2,4}};
        int headquarters1 = 1;
        int n1 = 2;
        printSampleExample(1, pathways1, n1, headquarters1);

        // Example 2
        int[][] pathways2 = pathways1;
        int headquarters2 = 2;
        int n2 = 2;
        printSampleExample(2, pathways2, n2, headquarters2);

        // Example 3
        int[][] pathways3 = {{2,1,3}, {2,3,2}, {3,4,5}};
        int headquarters3 = 2;
        int n3 = 4;
        printSampleExample(3, pathways3, n3, headquarters3);

        // Example 4
        int[][] pathways4 = {{2,1,3}, {2,3,4}, {3,4,-2}, {2,4,5}};
        int headquarters4 = 2;
        int n4 = 4;
        printSampleExample(4, pathways4, n4, headquarters4);
    }

    private static void printSampleExample(int exampleNum, int[][] pathways, int n, int headquarters)
    {
        EventRobot robot = new EventRobot();
        int minCharge = robot.minimumCharge(pathways, n, headquarters);
        System.out.printf("\nExample %d) \npathways = %s | n = %d, headquarters = %d \nMinimum Cost is: %d\n", exampleNum, pathwaysToString(pathways), n, headquarters, minCharge);
    }

    private static String pathwaysToString(int[][] array)
    {
        String returnStr = "[";

        for (int i = 0; i < array.length; i++)
        {
            returnStr += "[";
            int[] path = array[i];
            for (int k = 0; k < path.length; k++)
            {
                returnStr += path[k];
                
                if (k + 1 != path.length)
                    returnStr += ", ";
            }
            returnStr += "]";
            if (i + 1 != array.length)
                returnStr += ", ";
            
        }

        returnStr += "]";
        return returnStr;
    }
}
