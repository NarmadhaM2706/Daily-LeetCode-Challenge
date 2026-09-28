class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n+1];
        for(int i = 1; i <= n; i++){
            parent[i] = i;
        }
        for(int[] edge: edges){
            int u = edge[0], v = edge[1];
            int rootU = find(parent, u);
            int rootV = find(parent, v);
            if(rootU == rootV) return edge;
            parent[rootU] = rootV;
        }
        return new int[0];
    }
    private int find(int[] parent, int node){
        if(parent[node] != node){
            parent[node] = find(parent, parent[node]);
        }
        return parent[node];
    }
}