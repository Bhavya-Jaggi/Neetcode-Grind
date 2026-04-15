class Solution {
    public int findKthLargest(int[] nums, int k) {
        
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    int ans = 0;

    for(int num : nums)
    {
        minHeap.offer(num);

        if(minHeap.size() > k)
            minHeap.poll();
    }

    // for(int i = 1 ; i <= k ; i++)
    // {
    //     int a = minHeap.poll();
    //     if(i == k)
    //         ans = a;
    // }

    return minHeap.poll();


    }
}