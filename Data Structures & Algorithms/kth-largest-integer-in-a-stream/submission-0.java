class KthLargest {

    private PriorityQueue<Integer> minHeap; //Mandatory since we are dealing with class design
    private int k;

    public KthLargest(int k, int[] nums) {
        this.minHeap = new PriorityQueue<>();
        this.k = k;


        for(int i = 0 ; i < nums.length ; i++) //Feeding the heap
        {
           add(nums[i]); 
        }
    }


    
    public int add(int val) {
        
        minHeap.offer(val); //We can add the number temporarily and then later check if it was greate than original kth largest number

        if(minHeap.size() > k) //Now we validate if it was indeed larger then remove the topmost min element of the heap
            minHeap.poll();

        return minHeap.peek();


    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */