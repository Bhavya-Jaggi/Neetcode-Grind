class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int len = nums.length;
        Map<Integer , List<Integer>> hashMap = new HashMap<>();

        if(len == 1)
            return false;

        for(int i = 0 ; i < len ; i++)
        {
            if(!hashMap.containsKey(nums[i]))
            {
                List<Integer> tempList = new ArrayList<Integer>();
                tempList.add(i);
                hashMap.put(nums[i] , tempList);
            }
            else
            {
                //U caNNOT DO THIS directly cuz java is chutiya .add() returns boolean so it is basically
                //hashMap.put(nums[i] , true) this TRUE causes type mismatch err
                
                //hashMap.put(nums[i] , hashMap.get(nums[i]).add(i) );

                //Instead do this

                hashMap.get(nums[i]).add(i);
                //Idhar ho ye raha hai ki java use karta hai References ka to .get() direct address le ata hai map ke andar vali list ka usme tum turant .add() se update akr dete ho kyuki ye .add() directly map ke andar jo list present thi uspar laga hai to map bina .put() use kiye list ko update kar dia!
            }
        }
        
        for(Map.Entry<Integer , List<Integer>> entry : hashMap.entrySet())
        {
            if( hashMap.get(entry.getKey()).size() > 1 )
            {
                int left = 0;
                int right = 1;
                while(right < hashMap.get(entry.getKey()).size() )
                {
                    if(entry.getValue().get(right) - entry.getValue().get(left) <= k)
                        return true;
                    left++;
                    right++;
                }
            }
        }
        return false;
    }
}