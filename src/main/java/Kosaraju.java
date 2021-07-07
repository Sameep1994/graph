import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class Kosaraju {
/*Used to find strongly connected components
*
*scc is when each vertex can be reached from any other vertex
*either directly or via any component
*a single vertex itself is scc
*
*if a vertex u -> v u can reach v but v cant go to u
*we want to start kosaraju from v
*
* steps:
*1.order the vertices in decrease order of finish times in DFS.
*2. Reverse all edges (when we reverse strongly connected stay strongly connected)
*3. Do DFS of reverse graph in order obtained in step 1. for every vertex print all
* reachable vertices as one strongly connected.
*
* implement step1 (Topological sort)
* 1.create empty stack
* 2. for each vertex u : if(u is not visited) DFS(u,st)
* 3. while(st not empty) pop item put in result (final order)
*
*
*
* DFS(u,st)
* 1.mark u visited
* 2. for every adj v if v is not visited DFS(v,st)
* 3.st.push(u) (extra step)
* */
    static class Graph
    {
        private int V;
        private LinkedList<Integer> adj[];

        Graph(int v)
        {
            V = v;
            adj = new LinkedList[v];
            for (int i=0; i<v; ++i)
                adj[i] = new LinkedList();
        }

        void addEdge(int v, int w) { adj[v].add(w); }

        void DFSUtil(int v,boolean visited[])
        {

            visited[v] = true;
            System.out.print(v + " ");

            int n;

            Iterator<Integer> i =adj[v].iterator();
            while (i.hasNext())
            {
                n = i.next();
                if (!visited[n])
                    DFSUtil(n,visited);
            }
        }
//step 2
        Graph getTranspose()
        {
            Graph g = new Graph(V);
            for (int v = 0; v < V; v++)
            {
                Iterator<Integer> i =adj[v].listIterator();
                while(i.hasNext())
                    g.adj[i.next()].add(v);
            }
            return g;
        }
//step 1
        void fillOrder(int v, boolean visited[], Stack stack)
        {
            visited[v] = true;

            Iterator<Integer> i = adj[v].iterator();
            while (i.hasNext())
            {
                int n = i.next();
                if(!visited[n])
                    fillOrder(n, visited, stack);
            }

            stack.push(new Integer(v));
        }

        void printSCCs()
        {
            Stack stack = new Stack();

            boolean visited[] = new boolean[V];
            for(int i = 0; i < V; i++)
                visited[i] = false;

            for (int i = 0; i < V; i++)
                if (visited[i] == false)
                    fillOrder(i, visited, stack);

            Graph gr = getTranspose();

            for (int i = 0; i < V; i++)
                visited[i] = false;
//step 3
            while (stack.empty() == false)
            {
                int v = (int)stack.pop();

                if (visited[v] == false)
                {
                    gr.DFSUtil(v, visited);
                    System.out.println();
                }
            }
        }

        public static void main(String args[])
        {
            Graph g = new Graph(5);
            g.addEdge(1, 0);
            g.addEdge(0, 2);
            g.addEdge(2, 1);
            g.addEdge(0, 3);
            g.addEdge(3, 4);

            System.out.println("Following are strongly connected components "+
                    "in given graph ");
            g.printSCCs();
        }
    }
}
