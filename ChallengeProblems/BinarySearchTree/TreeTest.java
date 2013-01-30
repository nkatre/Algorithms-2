public class TreeTest {

    public static void main(String args[]) {
        int[][] tests = {   {1,2,3,4,5,6,7},
                            {1,4,5,8,12},
                            {-3,2,13,45},
                            {1}
                        }; 
        for (int[] test : tests) {
            TreeNode root = TreeUtilities.constructBST(test);
            TreeUtilities.printBinaryTree(root);
            System.out.print("\nInorder Traversal: ");
            TreeUtilities.printInorderTraversal(root);
            System.out.print("\n2nd Largest : ");
            try {
                System.out.print(TreeUtilities.getKthLargest(root,2));
                System.out.print(" 5th Largest: "+TreeUtilities.getKthLargest(root,5));
            } catch (Exception e) {
                System.out.println(" K value is out of bounds.");
            }
            System.out.println();
        }
    }
}
