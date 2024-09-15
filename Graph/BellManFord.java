class Solution {
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        // Write your code here
        
        int dist [] = new int [V];
        Arrays.fill(dist, (int)(1e08));
        dist[S] = 0;
        
        for(int i = 0; i < V-1; i++) {
            for(int j = 0; j < edges.size(); j++) {
                int u = edges.get(j).get(0);
                int v = edges.get(j).get(1);
                int weight = edges.get(j).get(2);
                
                if (dist[u] != (int)(1e8) && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                }
            }
        }
        
        for(int j = 0; j < edges.size(); j++) {
                int u = edges.get(j).get(0);
                int v = edges.get(j).get(1);
                int weight = edges.get(j).get(2);
                
                if(dist[u] != (int)(1e8) && dist[u] + weight < dist[v]) {
                    return new int [] {-1};
                }
            }
        
        return dist;
    }
}