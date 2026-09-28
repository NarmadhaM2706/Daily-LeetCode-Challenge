class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        int[] parent = new int[n]; // parent[i] = parent index for DSU
        int[] size = new int[n];   // size[i] = size of component with root i

        // Initialize DSU arrays
        for (int i = 0; i < n; i++) {
            size[i] = 1;
            parent[i] = i;
        }

        // Map to store email -> account index
        HashMap<String, Integer> map = new HashMap<>();
        // For each account, map all emails to their account representative
        for (int i = 0; i < n; i++) {
            List<String> acc = accounts.get(i);
            // Start from index 1 (skip name at index 0)
            for (int j = 1; j < acc.size(); j++) {
                String email = acc.get(j);
                if (!map.containsKey(email)) {
                    // First time seeing this email, map it to current account
                    map.put(email, i);
                } else {
                    // Email already seen, union current account with previous one
                    unionbysize(i, map.get(email), parent, size);
                }
            }
        }

        // Group emails by their parent account/component
        HashMap<Integer, List<String>> comp = new HashMap<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int i = entry.getValue();
            int u = findupar(i, parent); // Find representative parent
            String email = entry.getKey();
            comp.computeIfAbsent(u, k -> new ArrayList<>()).add(email);
        }

        // Prepare the result list
        List<List<String>> result = new ArrayList<>();
        for (int i : comp.keySet()) {
            List<String> emails = comp.get(i);
            Collections.sort(emails); // Sort emails lexicographically
            // Prepend the account name (from original accounts list)
            emails.add(0, accounts.get(i).get(0));
            result.add(emails);
        }
        return result;
    }

    // Find with path compression
    int findupar(int node, int[] parent) {
        if (node == parent[node]) return node;
        return parent[node] = findupar(parent[node], parent);
    }

    // Union by size to keep tree shallow
    void unionbysize(int u, int v, int[] parent, int[] size) {
        int ulp_u = findupar(u, parent); // ultimate parent of u
        int ulp_v = findupar(v, parent); // ultimate parent of v

        if (ulp_u == ulp_v) return; // already in the same set

        // Attach smaller tree to the larger tree
        if (size[ulp_u] >= size[ulp_v]) {
            size[ulp_u] += size[ulp_v];
            parent[ulp_v] = ulp_u;
        } else {
            size[ulp_v] += size[ulp_u];
            parent[ulp_u] = ulp_v;
        }
    }
}