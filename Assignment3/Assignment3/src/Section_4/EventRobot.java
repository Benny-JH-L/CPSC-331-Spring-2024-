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
        
        // pathCostArr[headquarters - 1] = 0;          // (I dont think i should have this) Set cost of starting vertex (Headquarters) to 0

        // Iterate through every building and determine the cost to get there
        for (int i = 0; i < n; i++)                 
        {
            for (int k = 0; k < pathways.length; k++)           // Iterate through the pathways
            {
                int[] currentPath = pathways[k];
                int currentBuildingNum = currentPath[0] - 1;    // minus 1 because array starts at 0 and building count start at 1

                if (pathCostArr[currentBuildingNum] == Integer.MAX_VALUE)       // if the cost to get to this building is +INFINITY, 
                    continue;                                                   // check next building (Cost to this building is not yet determined)
                else                                                            // Otherwise, a path/cost to this building has been determined.
                {
                    LinkedList<int[]> buildingPaths = getPaths(pathways, currentBuildingNum);    // get the paths outgoing from this building.

                    while (!buildingPaths.isEmpty())
                    {
                        int[] outgoingPath = buildingPaths.remove();
                        int toBuildingNum = outgoingPath[1] - 1;                                    // get building number we are traversing to, subtract 1 to get 'pathCostArr' location
                        int costToBuilding = pathCostArr[currentBuildingNum] + outgoingPath[2];     // Add the cost to get to this building and the cost of path to get to other building,

                        if (costToBuilding < pathCostArr[toBuildingNum])                            // if the resulting cost is less than the current cost to get to this building, set cost to resulting cost.
                            pathCostArr[toBuildingNum] = costToBuilding;
                    }
                }
            }
        }

        int minCost = Integer.MAX_VALUE;

        for (int i = 0; i < pathCostArr.length; i++)
        {
            if (pathCostArr[i] > minCost)
                minCost = pathCostArr[i];
        }

        return minCost; 
    }

    protected static LinkedList<int[]> getPaths(int[][] pathways, int building)  // protected static for now
    {
        LinkedList<int[]> returnList = new LinkedList<>();

        for (int i = 0; i < pathways.length; i++)
        {
            if (pathways[i][0] == building)
                returnList.add(pathways[i]);
        }

        return returnList;
    }

    public static void main(String[] args) 
    {
        // Testing
        int[][] pathways1 = {{1,2,4}};
        int headquarters1 = 1;
        getPaths(pathways1, headquarters1);

        int[][] pathways3 = {{2,1,3}, {2,3,2}, {3,4,5}};
        int headquarters3 = 2;
        getPaths(pathways3, headquarters3);
    }

}
