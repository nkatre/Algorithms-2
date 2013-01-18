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
        
        while (curr != null) {
            if (curr.left != null) {
                s.push(curr);
                curr = curr.left;
                continue;
            }
            System.out.print(curr.val + " ");
            while (curr.right==null) {
                if (!s.isEmpty()) {
                    curr = s.pop();
                    System.out.print(curr.val + " ");
                } else {
                    curr = null;
                    break;
                }
            }
            if (curr == null)
                break;
            curr = curr.right;
        }
    }

    // Find the kth largest
}
