class Solution {
    public int lastStoneWeight(int[] stones) {
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); //MaxHeap needs this Collections.reverseOrder()

        for(int stone : stones)
        {
            maxHeap.offer(stone);
        }

        while(maxHeap.size() > 1) //Since you need atmax one element
        {
            int a = maxHeap.poll();
            int b = maxHeap.poll();
            

            a = a - b;
            if(a == 0) //If stones cancel each other don't put 0 back into heap cuz at one point of time heap will be all 0's and then infinte loop
                continue;

            maxHeap.offer(a);
        }

        if(maxHeap.size() == 1)
            return maxHeap.peek();
        
        return 0;


    }
}