package Exercise2;

/**
 * Write an efficient algorithm to print k largest elements in an array.
 * build a max heap
 */
public class Exercise2Heap 
{
    public class TreeNode
    {
        TreeNode right;
        TreeNode left;
        int val;

        public TreeNode(int val)
        {
            this.val = val;
            right = null;
            left = null;
        }
    }

    private TreeNode[] maxHeap;
    private int currentIndex;
    int[] arr;
    
    public Exercise2Heap(int[] arr)
    {
        this.arr = arr;
        currentIndex = 0;
        createMaxHeap();
    }

    private void createMaxHeap()
    {
        for (int i = 0; i < arr.length; i++)
        {
            TreeNode nn = new TreeNode(arr[i]);
            maxHeap[currentIndex] = nn;
            fixHeapAfterAdd(currentIndex);
            currentIndex++;        
        }
    }

    private void fixHeapAfterAdd(int currentIndex)
    {
        int parentIndex = (currentIndex - 1)/2;
        TreeNode parentNode = maxHeap[parentIndex];
        TreeNode addedNode = maxHeap[currentIndex];

        if (addedNode.val > parentNode.val)
        {
            // Swap
            TreeNode tmp = parentNode;
            maxHeap[parentIndex] = addedNode;
            maxHeap[currentIndex] = tmp;
            fixHeapAfterAdd(parentIndex);
        }
    }

    private int remove()
    {
        int returnVal = maxHeap[0].val;
        maxHeap[0] = maxHeap[currentIndex - 1];
        maxHeap[currentIndex - 1] = null;
        sink(0);
        currentIndex--;
    }

    /**
     * Fixes heap after remove.
     */
    private void sink(int currentIndex)
    {
        int leftVal = Integer.MIN_VALUE, rightVal = Integer.MIN_VALUE;
        int leftIndex = 2*currentIndex + 1;
        int rightIndex = 2*currentIndex + 2;

        if (maxHeap[leftIndex] != null)
            leftVal = maxHeap[leftIndex].val;
        if (maxHeap[rightIndex] != null)
            rightVal = maxHeap[rightIndex].val;

        if (leftVal > rightVal && leftIndex > maxHeap[currentIndex].val)
        {
            // Swap parent and left child.
            TreeNode tmp = maxHeap[leftIndex];
            maxHeap[leftIndex] = maxHeap[currentIndex];
            maxHeap[currentIndex] = tmp;
            
        }
        else if 
    }

    /**
     * 
     * @param k an int, number of largest elements to print.
     * For example, if k = 3, print the 3 largest elements in the array. If the array = {3, 9, 1, 10, 4} -> prints 10, 9, 4
     */
    public void printLargestElements(int k)
    {

    }
}
