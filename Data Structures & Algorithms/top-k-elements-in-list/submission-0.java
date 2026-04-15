class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer , Integer> myMap = new HashMap<>();

        int counter = 0;

        int[] arr = new int[k];

        List<Integer>[] bucket = new List[nums.length + 1]; //This is an "Array of Lists" NOTE the [] outside if i were to write it as List<Integers[]> this would have implied "List of Array"
        
        
        
        //we use bucket Sort to skip sorting alltogether which is causing my soultion to be O(N Log(N)) time complextity therefore we now store the element with frequency f(say) at the index f of the bucket array in this way we just used O(N) in mapping process only while retrival of the largest k elements only approximately take O(1)

        for(int i = 0 ; i < nums.length ; i++)
        {
            int curr = nums[i];
            if(myMap.containsKey(curr))
            {
                myMap.put(curr , myMap.get(curr)+1);
            }
            else
            {
                myMap.put(curr , 1);
            }
        }


        for(Map.Entry<Integer, Integer> entry : myMap.entrySet())
        {

            int value = entry.getValue();
            int key = entry.getKey();            

            if(
                bucket [ value ] == null
            )
            {
                bucket[value] = new ArrayList<>();
            }
            bucket[value].add(key); //WTF mind boggling line
        }

        for(int i = bucket.length - 1; i >= 0 && counter < k ; i--)
        {
            if(bucket[i] != null)
            {
                for(int j = 0 ; j < bucket[i].size() ; j++)  //too much brain power used to write this just write enhanced for loop instaed for(int nums : bucket[i])
                {
                    int num = bucket[i].get(j);

                    arr[counter++] = num;
                    if(counter == k)
                        break;
                }
            }
        }
        return arr;

    }
}