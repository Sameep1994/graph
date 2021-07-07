import java.util.Iterator;
import java.util.LinkedList;

public class ArticulationPoint {
    /*Articulation point: Removing this vertex and its associated edges
     * increase the connected components
     *
     *
     * Start DFS from any point
     * (when we find a visited vertex and its in call stack its a back edge)
     *
     * Discovery time: is a timer when a vertex is visited timer is increased
     * Low value: lowest discovery time vertex reachable using edge and back edge
     *
     *
     * two rules for articulation pt:
     * 1.if root of DFS tree has 2 children its Art pt.
     * 2.low[v] >= disc[u] means if no ancestor is reachable from a vertx its articulation point*/
    static class Graph
    {
        private int V;

        private LinkedList<Integer> adj[];
        int time = 0;
        static final int NIL = -1;

        Graph(int v)
        {
            V = v;
            adj = new LinkedList[v];
            for (int i=0; i<v; ++i)
                adj[i] = new LinkedList();
        }

        void addEdge(int v, int w)
        {
            adj[v].add(w);
            adj[w].add(v);
        }

        void APUtil(int u, boolean visited[], int disc[],
                    int low[], int parent[], boolean ap[])
        {

            int children = 0;

            visited[u] = true;

            disc[u] = low[u] = ++time;

            Iterator<Integer> i = adj[u].iterator();
            while (i.hasNext())
            {
                int v = i.next();
                if (!visited[v])
                {
                    children++;
                    parent[v] = u;
                    APUtil(v, visited, disc, low, parent, ap);


                    low[u] = Math.min(low[u], low[v]);


                    if (parent[u] == NIL && children > 1)
                        ap[u] = true;

                    if (parent[u] != NIL && low[v] >= disc[u])
                        ap[u] = true;
                }

                else if (v != parent[u])
                    low[u] = Math.min(low[u], disc[v]);
            }
        }

        void AP()
        {

            boolean visited[] = new boolean[V];
            int disc[] = new int[V];
            int low[] = new int[V];
            int parent[] = new int[V];
            boolean ap[] = new boolean[V];


            for (int i = 0; i < V; i++)
            {
                parent[i] = NIL;
                visited[i] = false;
                ap[i] = false;
            }

            for (int i = 0; i < V; i++)
                if (visited[i] == false)
                    APUtil(i, visited, disc, low, parent, ap);

            for (int i = 0; i < V; i++)
                if (ap[i] == true)
                    System.out.print(i+" ");
        }

        public static void main(String args[])
        {
            System.out.println("Articulation points in first graph ");
            Graph g = new Graph(5);
            g.addEdge(1, 0);
            g.addEdge(0, 2);
            g.addEdge(2, 1);
            g.addEdge(0, 3);
            g.addEdge(3, 4);
            g.AP();
            System.out.println();
        }
    }

}
