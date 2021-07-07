import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CycleDetectKahnAlgo {
    public static int vertices=6;
    public static int[] indegree = new int[vertices];
    public static void main(String[] args) {
        Arrays.fill(indegree,0);
        ArrayList<ArrayList<Integer> > adj = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++)
            adj.add(new ArrayList<>());
        addEdge(adj,0,1);
        addEdge(adj,4,1);
        addEdge(adj,1,2);
        addEdge(adj,2,3);
        addEdge(adj,3,1);

        System.out.println(BFS(adj,indegree));
    }
//we are using same khans algo just using a variable count to see if there exsits an cycle or not
    //if count is same as the num of vertices that means each vertex was
// visited once and there is no cycle else cycle exists
    public static boolean BFS(ArrayList<ArrayList<Integer>> adj,int[] indegree) {
        int count=0;
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int u = q.poll();

            for (int v : adj.get(u)) {
                if(indegree[v]>0){
                    indegree[v] = indegree[v] - 1;
                }
                if(indegree[v]==0) {
                    q.add(v);
                }
            }
            count++;
        }
        return (count!=vertices);
    }
    static void addEdge(ArrayList<ArrayList<Integer>> adj,
                        int u, int v)
    {
        adj.get(u).add(v);
        indegree[v]=indegree[v]+1;
    }
}
