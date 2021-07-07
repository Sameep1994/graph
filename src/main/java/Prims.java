import java.util.Arrays;

public class Prims {

    //Needs revisit
    public static void main(String[] args) {

        int graph[][] = new int[][] { { 0, 2, 0, 6, 0 },
                { 2, 0, 3, 8, 5 },
                { 0, 3, 0, 0, 7 },
                { 6, 8, 0, 0, 9 },
                { 0, 5, 7, 9, 0 } };

        System.out.println(prim(graph,5));
    }
    //we have to find a path with min weight that connects all the vertices directly or through another vertex
    /*we maintain array to see if current vertex is visited
    * we maintain another array init as infinite select the min weight edge of all*/
    public static int prim(int[][] graph,int v){

        int res =0;
        boolean[] visited = new boolean[v];
        int[] key = new int[v];
        Arrays.fill(key,Integer.MAX_VALUE);
//for frst vertex
        key[0]=0;
        //running for all vertices
        for(int count=0;count<v;count++) {

            int u = -1;
            //finding the smallest key not yet included in mset
            for (int i = 0; i < v; i++) {
                if (!visited[i] && (u == -1 || key[i] < u))
                    u = i;
                }
                    //updating result;
                    visited[u] = true;
                    res = res+key[u];
                    //if the vertex is not visited, there exist a link b/w them which is smaller than weight of curr edge then we consider that
                    for (int V = 0; V < v; V++)
                        if (visited[V]==false && graph[u][V] != 0 && graph[u][V] < key[V])
                            key[V] = graph[u][V];
        }
        return res;
    }
}
