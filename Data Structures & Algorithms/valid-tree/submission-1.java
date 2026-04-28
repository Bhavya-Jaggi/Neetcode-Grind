class Solution {
    public boolean validTree(int n, int[][] edges) {
        
        if(edges.length != n - 1)//Massive W condition to remember for a proper Tree definition 
            return false;

        Set<Integer> hashSet = new HashSet<>();

        Map<Integer , List<Integer>> hashMap = new HashMap<>();

        Queue<Integer> queue = new LinkedList<>();

        if(edges.length > 0)//Very bad practice i suppose 
        {
            queue.add(edges[0][0]);
            hashSet.add(edges[0][0]);
        }

        for(int i = 0 ; i < edges.length ; i++)
        {//Since it is an undirected graph we need to add both the entries
            //add First way 0 -> 1
            hashMap.putIfAbsent(edges[i][0] , new ArrayList<>());
            hashMap.get(edges[i][0]).add(edges[i][1]);

            //add 2nd way 1 -> 0
            hashMap.putIfAbsent(edges[i][1] , new ArrayList<>());
            hashMap.get(edges[i][1]).add(edges[i][0]);
        }
        
        int res = bfs(hashMap , hashSet , queue);

        return res == n ? true : false;

        
    }

    public int bfs(Map<Integer , List<Integer>> hashMap , Set<Integer> hashSet , Queue<Integer> queue)
    {
        int count = 1; //Start with one cuz i already added edges[0][0]
        while(true)
        {
            int len = queue.size();
            if(len == 0)
                break;
            
            while(len-- > 0)
            {
                int parent = queue.poll();

                List<Integer> children = hashMap.get(parent);

                if(children == null)
                    continue;

                for(int child : children)
                {
                    boolean t = hashSet.add(child);

                    if(t) //Avoids infinite loop(idk why tho)
                    {
                        count++;
                        queue.add(child);
                        // hashSet.add(child); Not needed since the addition to the hashSet is already done above 
                    }
                    //No need of any else condition since the count didn't increament it will automatically return false
                }
            }
        }

        return count;
    }
}
