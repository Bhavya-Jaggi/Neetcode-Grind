class Solution {
    Set<Integer> hashSet = new HashSet<>();
    public int countComponents(int n, int[][] edges) 
    {

        Map<Integer , List<Integer>> hashMap = new HashMap<>();

        int count = 0;

        for(int i = 0 ; i < edges.length ; i++)
        {
            hashMap.putIfAbsent(edges[i][0] , new ArrayList<>());
            hashMap.get(edges[i][0]).add(edges[i][1]);

            hashMap.putIfAbsent(edges[i][1] , new ArrayList<>());
            hashMap.get(edges[i][1]).add(edges[i][0]);
        }

        for(int i = 0; i < n ; i++)
        {
            if(hashSet.add(i))
            {
                bfs(n , edges , hashMap , i);
                count++;
            }
        }
        return count;
    }
    public void bfs(int n , int[][] edges , Map<Integer , List<Integer>> hashMap, int x)
    {
        
        Queue<Integer> queue = new LinkedList<>();

        queue.add(x);
        while(!queue.isEmpty())
        {
            int curr = queue.poll();
            List<Integer> temp = hashMap.get(curr);
            if(temp == null)
                continue;
            for(int a : temp)
            {
                if(hashSet.add(a))
                    queue.add(a);
            }

        }
    }
}   
