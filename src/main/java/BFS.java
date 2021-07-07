import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public static void main(String[] args) {

        int V = 5;
        ArrayList<ArrayList<Integer> > adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 4);
        addEdge(adj, 1, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 1, 4);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 4);
        BFSWrapper(adj,4);
    }
/*
*
*Similar as level order traversal we just maintain visited
* since we might come back to a node again
*
* */
    public static void BFS(ArrayList<ArrayList<Integer>> adj,boolean visited[],Integer s) {
        Queue<Integer> q = new LinkedList<>();
        visited[s]=true;
        //push the source in queue
        q.add(s);
        while (!q.isEmpty()) {
            int u = q.poll();
            System.out.println(u+ " ");
            //see if the adjacent of source is visited
            for (int v : adj.get(u)) {
                //if not mark as visited and push in queue
                if (visited[v]==false) {
                    visited[v] = true;
                    q.add(v);
                }
            }
        }
    }
    //to find the connected elements use a count varaible,island popular interview ques
    public static void BFSWrapper(ArrayList<ArrayList<Integer>> adj,int v){
        boolean[] visited = new boolean[v+1];
        //to handle disjoint graphs
        for(int i=0;i<visited.length;i++){
            if(visited[i]==false){
                BFS(adj,visited,i);
            }
        }
    }

    static void addEdge(ArrayList<ArrayList<Integer> > adj,
                        int u, int v)
    {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
}
