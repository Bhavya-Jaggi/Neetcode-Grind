class Solution {
    public boolean canFinish(int numC, int[][] pre) {

        Map<Integer , List<Integer>> hashMap = new HashMap<>();

        int[] inDegree = new int[numC];

        Queue<Integer> queue = new LinkedList<>();

        int count;

        for(int i = 0 ; i < pre.length ; i++) //U need pre.length here cuz courses are too many
        {
            // hashMap.put(pre[i][1] , hashMap.getOrDefault(pre[i][1] , new ArrayList<>()).add(pre[i][0]) );

            //The above line won't work cuz it returns a boolean and u cannot .add() to a boolean
            hashMap.putIfAbsent(pre[i][1] , new ArrayList<>());
            hashMap.get(pre[i][1]).add(pre[i][0]);


            inDegree[pre[i][0]]++;
        }

        for(int i = 0 ; i < numC ; i++) //Idk why but numC works here as a limit
        {
            if(inDegree[i] == 0)
                queue.add(i);
        }

        count = bfs(queue , hashMap , inDegree);

        if(count == numC)
            return true;
        
        return false;
        
    }

    public int bfs(Queue<Integer> queue , Map<Integer , List<Integer>> hashMap , int[] inDegree)
    {
        int count  = 0;
            while(!queue.isEmpty())
            {
                int curr = queue.poll();
                inDegree[curr] = -1; //Prevents from re-couting the '0's already counted 
                count++;

                List<Integer> temp = hashMap.get(curr);
                if(temp == null) //Save from nullPointerException
                    continue;
                for(int a : temp) //Decreasing the frequecny of all the pre couserses by 1
                {
                    inDegree[a]--;
                    if(inDegree[a] == 0)
                        queue.add(a);
                }
            }
        
        return count;
    }
}