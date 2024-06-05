package Exercise1;
public class IsCompleteTACode 
{
    TreeNodeNew1 root = null;

    public int count(TreeNodeNew1 root)
    {
        if (root == null)
            return 0;
        
        return (count(root.left) + count(root.right) + 1);
    }

    public boolean checkComplete(TreeNodeNew1 root, int count, int index)
    {
        if (root == null)
            return true;
        else if (index >= count)
            return false;
        
        boolean leftSide = checkComplete(root.left, count, 2*index + 1);
        boolean rightSide = checkComplete(root.left, count, 2*index + 2);

        return (leftSide && rightSide);
    }

    public static void main(String[] args) 
    {
        IsCompleteTACode binaryTree = new IsCompleteTACode();
        
        binaryTree.root = new TreeNodeNew1(0);
        binaryTree.root.left = new TreeNodeNew1(1);
        binaryTree.root.right = new TreeNodeNew1(2);
        binaryTree.root.left.left = new TreeNodeNew1(3);
        int count = binaryTree.count(binaryTree.root);
        System.out.println(count);
        System.out.println(binaryTree.checkComplete(binaryTree.root, count, 0));
    }
}

class TreeNodeNew1
{
    TreeNodeNew1 right = null;
    TreeNodeNew1 left = null;
    int val;

    public TreeNodeNew1(int val)
    {
        this.val = val;
    }
}
