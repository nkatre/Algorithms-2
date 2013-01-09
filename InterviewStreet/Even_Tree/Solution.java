/*
 * Solution to the Even Tree InterviewStreet Challenge.
 *
 * Approach: We need to count the number of edges in the graph
 * such that a cut of the graph on the given edge will 
 * decompose it into two components of even size each. We
 * are given that the graph is an acyclic undirected tree
 * and we can use this information to devise an efficient solution.
 * We begin by identifying leaf nodes (degree 1) and then recursively
 * determine and store the sizes of all subtrees rooted at non-leaf
 * nodes in the graph. No edge connecting to a leaf can be cut so
 * these are automatically excluded. We are given that the graph
 * will always be decomposable into one or more even-sized components,
 * implying that we simply need to check the size of each subtree rooted
 * at a non-leaf and non-root node to determine if the edge leading to it
 * (from the root) could be cut. If the size is even, we say yes and
 * increment the count of edges to be cut.
 *
 * @author Sanjay Paul
 * @date 12.25.2012
*/

import java.io.*;
import java.util.*;

class Solution {
    public static void main(String args[]) throws IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = buff.readLine().trim().split(" ");
        int nnodes = Integer.parseInt(arr[0]);
        int nedges = Integer.parseInt(arr[1]);
        if (nnodes <= 2){
            System.out.println("0");
            System.exit(0);
        }

        // Construct the adjacency list from the input
        HashMap<Integer, LinkedList<Integer>> adjlist = new HashMap<Integer, LinkedList<Integer>>();
        for (int i = 0; i < nedges; i++) {
            String[] tmp = buff.readLine().trim().split(" ");
            int u = Integer.parseInt(tmp[0]);
            int v= Integer.parseInt(tmp[1]);
            if(!adjlist.containsKey(u)) adjlist.put(u,new LinkedList<Integer>());
            if(!adjlist.containsKey(v)) adjlist.put(v,new LinkedList<Integer>());
            adjlist.get(u).add(v);
            adjlist.get(v).add(u);
        }
        
        int[] subtree_sizes = new int[nnodes+1];
        Arrays.fill(subtree_sizes,1);
        List<Integer> current = new ArrayList<Integer>();
        boolean[] marked = new boolean[];
        
        // Initialize current list to the leaves
        for (Integer key : adjlist.keySet()) {
            if(adjlist.get(key).size()==1) { 
                current.add(key);
                marked[key] = true;
            }
        }

        // Proceed recursively, bottom-up to calculate
        // subtree sizes.
        while (current.size()>0) {
            HashSet<Integer> next = new HashSet<Integer>();
            for (int i = 0; i < current.size(); i++) {
                int child = current.get(i);
                int parent = adjlist.get(child).pop();
                subtree_sizes[parent]+=subtree_sizes[child];
                List<Integer> list = adjlist.get(parent);
                list.remove(current.get(i));
                if(list.size()==1) next.add(parent);
            }
            current = new ArrayList<Integer>(next);
            System.out.print(current.size() + ", ");
        }
        int count = 0;
        for (int i : subtree_sizes) {
            if(i%2==0) count++;
        }
        System.out.println(count);
    }
}
