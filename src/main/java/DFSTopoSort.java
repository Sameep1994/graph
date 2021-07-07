import java.util.ArrayList;
import java.util.Stack;

public class DFSTopoSort {
    public static int V=6;
    private static ArrayList<ArrayList<Integer>> adj;
    public static void main(String[] args) {
        adj = new ArrayList<ArrayList<Integer>>(V);
        for (int i=0; i<V; ++i)
            adj.add(new ArrayList<Integer>());
        addEdge(adj,5, 2);
        addEdge(adj,5, 0);
        addEdge(adj,4, 0);
        addEdge(adj,4, 1);
        addEdge(adj,2, 3);
        addEdge(adj,3, 1);
        topologicalSort();

    }
    static void addEdge(ArrayList<ArrayList<Integer>> adj,
                        int u, int v)
    {
        adj.get(u).add(v);
    }
//for all non visited node we call the helper method
    static void topologicalSort()
    {
        Stack<Integer> stack = new Stack<Integer>();

        // Mark all the vertices as not visited
        boolean visited[] = new boolean[V];


        // Call the recursive helper
// function to store
        // Topological Sort starting
        // from all vertices one by one
        for (int i = 0; i < V; i++)
            if (visited[i] == false)
                topologicalSortUtil(i, visited, stack);

        // Print contents of stack
        while (stack.empty()==false)
            System.out.print(stack.pop() + " ");
    }
//marks the current node visited true, checks if adj is not visited call the method recursively for that method
    static void topologicalSortUtil(
            int v, boolean visited[],
            Stack<Integer> stack)
    {
        // Mark the current node as visited.
        visited[v] = true;
        Integer i;

        // Recur for all the vertices adjacent
        // to thisvertex
        for(int u:adj.get(v))
        {
            if (!visited[u])
                topologicalSortUtil(u, visited, stack);
        }

        // Push current vertex to stack
// which stores result
        stack.push(v);
    }
}
