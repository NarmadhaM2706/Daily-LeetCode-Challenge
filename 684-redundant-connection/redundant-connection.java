class Redundant{
    int[] set;
	Redundant(int n){
		set=new int[n+1];
		for(int i=1;i<=n;i++) set[i]=i;
	}
    int find(int x) {
		while(set[x]!=x) x=set[x];
		return set[x];
	}
	boolean union(int a,int b) {
		a=find(a);
		b=find(b);
		if(a==b) return false;
        set[a]=b;
        return true;
	}
}
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        Redundant r=new Redundant(edges.length);
        for(int[] edge:edges){
            if(!r.union(edge[0],edge[1])) return edge;
        }
        return new int[]{};
    }
}