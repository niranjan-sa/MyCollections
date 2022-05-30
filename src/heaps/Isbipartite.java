class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int []color = new int[n];
        Arrays.fill(color, -1);
        
        
        for(int start = 0 ; start < graph.length; start++) {
            if(color[start] == -1) {
                Stack<Integer> stk = new Stack();
                stk.push(start);
                color[start] = 0;
                
                while(!stk.isEmpty()) {
                    int node = stk.pop();
                    for(int nbr: graph[node]) {
                        if(color[nbr] == -1) {
                            color[nbr] = color[node]^1;
                            stk.push(nbr);
                        } else if(color[nbr] == color[node]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    } 
}
// Check if adjacent graph nodes can be colored in different colors. 
// Is Graph Bipartite? 
