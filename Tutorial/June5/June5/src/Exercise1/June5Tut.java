package Exercise1;
public class June5Tut 
{

    public static void main(String[] args) 
    {
        TreeNodeApp root = new TreeNodeApp(12); // dont know why it doe snot work...

        boolean isComplete = isTreeComplete(root);    
        System.out.printf("Tree is complete: %s", isComplete);
    }

    public static boolean isTreeComplete(TreeNodeApp root)
    {
        return isTreeComplete(root);
    }

    private static boolean isTreeCompleteRecurr(TreeNodeApp root)
    {
        if ((root.left == null && root.right == null) || (root.left != null && root.right != null))
            return true;
        else if (root.left == null && root.right != null)
            return false;
        else
        {
            boolean leftComplete = isTreeCompleteRecurr(root.left);
            boolean rightComplete = isTreeCompleteRecurr(root.right);

            if (leftComplete && rightComplete)
                return true;
        }
        return false;
    }
}

class TreeNodeApp
{
    TreeNodeApp right;
    TreeNodeApp left;
    int value;

    public TreeNodeApp(int val)
    {
        this.value = val;
        right = null;
        left = null;
    }
}