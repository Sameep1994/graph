import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathUnweightedGraph {
    public static int vertices=4;
    public static int[] distance=new int[vertices];

    public static void main(String[] args) {

        Arrays.fill(distance,Integer.MAX_VALUE);
        ArrayList<ArrayList<Integer> > adj = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++)
            adj.add(new ArrayList<>());
        addEdge(adj,0,1);
        addEdge(adj,0,2);
        addEdge(adj,1,2);
        addEdge(adj,1,3);
        addEdge(adj,2,3);
        BFS(adj,0);
        for(int i=0;i<distance.length;i++){
            System.out.println(distance[i]);
        }

    }

    //it is a bfs traversal problem, for any path to be shortest path in unweighted graph it has to pass through
    // the previously traversed edge
    //thatswhy we are maintaing a distance array and adding 1 to it for each traversal
    public static void BFS(ArrayList<ArrayList<Integer>> adj,Integer s) {
        boolean[] visited = new boolean[vertices];
        Queue<Integer> q = new LinkedList<>();
        visited[s]=true;
        distance[s]=0;
        //push the source in queue
        q.add(s);
        while (!q.isEmpty()) {
            int u = q.poll();
            System.out.println(u+ " ");
            //see if the adjacent of source is visited
            for (int v : adj.get(u)) {
                //if not mark as visited and push in queue
                if (visited[v]==false) {
                    distance[v]=distance[u]+1;
                    visited[v] = true;
                    q.add(v);
                }
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
