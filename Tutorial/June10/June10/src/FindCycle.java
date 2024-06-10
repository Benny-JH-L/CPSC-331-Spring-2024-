import java.util.Stack;

/**
 * DOES NOT WORK
 */
public class FindCycle
{
    public static void findCycle(Node[][] adjacencyMatrix)
    {
        Stack<Node> stack = new Stack();
        stack.push(adjacencyMatrix[0][0]);
        
        for (int i = 0; i < adjacencyMatrix.length && !stack.isEmpty(); i++)
        {
            for (int k = 0; k < adjacencyMatrix[0].length; k++)
            {
                Node node = stack.pop();
                if (node.isVisited && node.value == 1)
                {
                    node.isVisited = true;
                    if (adjacencyMatrix[k][i].value == 1)
                        adjacencyMatrix[k][i].isVisited = true;
                }
                else
                {
                    stack.push();   // adjacent nodes
                }
            }
        }

    }
}

class Node
{
    boolean isVisited;
    int value;              // Either 0 or 1, 1 means true, 0 means false.

    public Node(int value)
    {
        isVisited = false;
        this.value = value;
    }
}


