//First try baby
class Solution {
    public int[] findOrder(int numC, int[][] pre) {

        int[] res = new int[numC];

        int freq[] = new int[numC];

        Map<Integer , List<Integer>> hashMap = new HashMap<>();

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0 ; i < pre.length ; i++)//Big Brian Time
        {
            hashMap.putIfAbsent(pre[i][1] , new ArrayList<>());
            hashMap.get(pre[i][1]).add(pre[i][0]);
            freq[pre[i][0]]++;
        }

        for(int i = 0 ; i < freq.length ; i++)//Adding all the cases with 0 pre-requisites 
        {
            if(freq[i] == 0)
                queue.add(i);
        }

        res = bfs(hashMap , queue , freq , numC);

        return res;
        
    }

    public int[] bfs(Map<Integer , List<Integer>> hashMap , Queue<Integer> queue , int[] freq , int numC)
    {

        int[] res = new int[numC];

        int i = 0;

        //Kahn's Algorithm 
        while(!queue.isEmpty())
        {
            int curr = queue.poll();

            List<Integer> temp = hashMap.get(curr);

            res[i++] = curr;

            if(temp == null)//Important check for elements who don't point to other elements
                continue;

            for(int a : temp)
            {
                freq[a]--;
                if(freq[a] == 0)//Immidiately add the element which turned 0
                    queue.add(a);
            }
        }

        //If a cycle is detected res = [0,1,0,0,0,0] this means it's a cycle so we return empty res
        if(i != numC)
            return new int[0];


        return res;
    }
}