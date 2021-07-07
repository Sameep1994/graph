import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class TopoSortKahnAlgo {
    public static int vertices=6;
    public static int[] indegree = new int[vertices];
    public static void main(String[] args) {
        Arrays.fill(indegree,0);
        ArrayList<ArrayList<Integer> > adj = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++)
            adj.add(new ArrayList<>());
        addEdge(adj,0,1);
        addEdge(adj,0,2);
        addEdge(adj,1,3);
        addEdge(adj,2,3);
        addEdge(adj,3,4);
        addEdge(adj,3,5);
        BFS(adj,indegree);

    }
    //it is a bfs based algo
    //topological sort is used for directed graph, where if a node has no dependecy is print frst and then its dependents are printed
    /*      0
           / \
    *   1       2
    1 and 2 are dep on 0 so 0 will print frst then 1 and 2 in any order
    * */
    //here we are using the concept of indegree
    //frst taking all the elements with 0 indegree and push in queue
    //later poping one by one print it and for its adj decrment the value once it becomes 0 we are pushing in queue
    //we are doing this bcoz the value with 0 indegree is indepent of any node
    //once it is done its adjacent are having one less dependency since that task is done
    // note in indegree array the array index represnt the node
    public static void BFS(ArrayList<ArrayList<Integer>> adj,int[] indegree) {
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int u = q.poll();

            System.out.println(u+ " ");

            for (int v : adj.get(u)) {
                if(indegree[v]>0){
                    indegree[v] = indegree[v] - 1;
                }
                if(indegree[v]==0) {
                    q.add(v);
                }
            }
        }
    }
    static void addEdge(ArrayList<ArrayList<Integer> > adj,
                        int u, int v)
    {
        adj.get(u).add(v);
        indegree[v]=indegree[v]+1;
    }
}
