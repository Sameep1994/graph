import java.util.ArrayList;

public class DFS {
    public static void main(String[] args) {

        int V = 5;
        ArrayList<ArrayList<Integer> > adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 1, 4);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 4);
        DFSWrapper(adj,4);

    }
    /*Pick source, print it
    * pick its adjacent and recursively call its adjacent
    *repeat till all vertex are visited once and printed
    *
    *applications:
    * cycle detection
    * topological sort
    * strongly connected components
    * solve maze and similar problem
    * path finding
    *
    *
    *
    *
    * similar to pre order traversal*/

public static void DFS(ArrayList<ArrayList<Integer>> adj, boolean[] visited,int s){

        visited[s]=true;
    System.out.println(s+" ");
        for(int u: adj.get(s)){
            if(visited[u]==false) {
                DFS(adj, visited, u);
            }
        }
}

public static void DFSWrapper(ArrayList<ArrayList<Integer>> adj,int nodes){
        boolean[] visited = new boolean[nodes+1];
        for(int i=0;i<visited.length;i++){
            if(visited[i]==false){
                DFS(adj,visited,i);
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
