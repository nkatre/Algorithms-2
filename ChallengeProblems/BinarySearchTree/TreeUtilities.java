import java.util.*;

public class TreeUtilities {

    // Given a sorted array of integers (warning: no check
    // performed), output the root node of a BST across
    // the elements of the input array.
    public static TreeNode constructBST(int[] arr) {
        if (arr == null) return null;
        return recursiveConstruct(arr, 0, arr.length-1);
    }

    private static TreeNode recursiveConstruct(int[] arr, int start, int end) {
        if (start > end || end < start)
            return null;
        if (start==end)
            return new TreeNode(arr[start]);

        int medindex = (start + end) / 2;
        TreeNode root = new TreeNode(arr[medindex]);
        root.left = recursiveConstruct(arr,start,medindex-1);
        root.right = recursiveConstruct(arr,medindex+1,end);
        return root;
    }

    // Prints a binary tree in level order
    public static void printBinaryTree(TreeNode root) {
        LinkedList<TreeNode> q = new LinkedList<TreeNode>();
        q.addLast(root);
        TreeNode sentinel = new TreeNode(0); 
        q.addLast(sentinel);
        TreeNode empty = new TreeNode(0);

        while (!q.isEmpty()) {
            TreeNode node = q.removeFirst();
            if (node == sentinel) {
                System.out.println();
                if (q.isEmpty())
                    break;
                q.addLast(sentinel);
                continue;
            }
            if (node == empty) {
                System.out.print("_ ");
                continue;
            }
            System.out.print(node.val + " ");
            if(node.left!=null) q.addLast(node.left);
            else q.addLast(empty); 
            if(node.right!=null) q.addLast(node.right);
            else q.addLast(empty);
        }
    }

    // Print an inorder traversal given a binary tree
    public static void printInorderTraversal(TreeNode root) {
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode curr = root;
        
        while (!s.isEmpty() || curr!=null) {
            if (curr != null) {
                s.push(curr);
                curr = curr.left;
            } else {
                curr = s.pop();
                System.out.print(curr.val + " ");
                curr = curr.right;
            }
        }
    }

    // Return the kth largest element in a binary search tree
    public static int getKthLargest(TreeNode root, int k) throws Exception {
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode curr = root;
        int j = 0; // indicating that the node is jth largest

        while (!s.isEmpty() || curr!=null) {
            if (curr!=null) {
                s.push(curr);
                curr = curr.left;
            } else {
               curr = s.pop(); 
               j++;
               if (j == k)
                return curr.val;
               if (j > k)
                   throw new Exception();
               curr = curr.right;
            }
        }
        throw new Exception();
    }
}
