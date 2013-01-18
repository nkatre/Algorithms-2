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
            System.out.println();
            TreeUtilities.printInorderTraversal(root);
            System.out.println();
        }
    }
}
