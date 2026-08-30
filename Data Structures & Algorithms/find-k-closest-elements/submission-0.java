class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        

        int left = 0; 
        int len = arr.length;
        int right = len - 1;
        int size = right - left + 1;
        List<Integer> res = new ArrayList<>();
        

        while(k != size)
        {
            int front = Math.abs(x - arr[left]);
            int back = Math.abs(x - arr[right]);

            if(front <= back)
            {
               right--; 
            }
            else
            {
                left++;
            }
            size = right - left + 1;
        }
        for(int i = left ; i <= right ; i++)
        {
            res.add(arr[i]);
        }
        return res;
    }
}