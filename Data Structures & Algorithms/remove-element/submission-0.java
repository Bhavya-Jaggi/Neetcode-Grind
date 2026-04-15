class Solution {
    public int removeElement(int[] nums, int val) {

        int k = 0;
        List<Integer> arrList = new ArrayList<>();

        for(int num : nums)
        {
            if(num == val)
                continue;
            k++;
            arrList.add(num);
        }
        for(int i = 0 ; i < arrList.size() ; i++)
        {
            nums[i] = arrList.get(i);
        }
        return k;
        
    }
}