class Solution {
    static int WHITE = 1;
    static int GRAY = 2;
    static int BLACK = 3;
  /*
   Cycle detection plus topological sort.
  */
    boolean isPossible;
    Map<Integer, Integer> color;
    Map<Integer, List<Integer>> adjList;
    List<Integer> topologicalOrder;


    public void init(int n) {
        this.isPossible = true;
        this.color = new HashMap<>();
        this.adjList = new HashMap<Integer, List<Integer>>();
        this.topologicalOrder = new ArrayList<>();
        //init all vertices
        for(int i=0; i<n; i++) {
            this.adjList.put(i, new ArrayList<>());
            this.color.put(i, WHITE);
        }
    }
    
    public void dfs(int node) {
        //check if cycle found
        if(!this.isPossible) return;

        //start recursion 
        this.color.put(node, GRAY);
        //for all neighbros
        for(int nbr: this.adjList.get(node)) {
            if(this.color.get(nbr) == WHITE) {
                this.dfs(nbr);
            }
            else if(this.color.get(nbr)==GRAY) {
                this.isPossible = false;
                return;
            }
        }
        this.topologicalOrder.add(node);
        this.color.put(node, BLACK);
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        this.init(numCourses);
        
        //build graph
        for(int[] pair: prerequisites) {
            int src = pair[1];
            int dst = pair[0];
            this.adjList.get(src).add(dst);
        }

        //topo sort 
        for(int node: this.adjList.keySet()) {
            if(this.color.get(node)==WHITE) {
                dfs(node);
            }
        }
        
        int []order;
        if(this.isPossible) {
            order = new int[numCourses];
            int i = this.topologicalOrder.size()-1;
            for(int j = 0; j < topologicalOrder.size(); j++) {
                order[j] = topologicalOrder.get(i);
                i--;
            }
            return order;
        } else {
            return new int[0];
        }
    }
}
