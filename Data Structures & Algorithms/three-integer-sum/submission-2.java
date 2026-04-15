class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, Integer> myMap = new HashMap<>();

        for (int i = 0; i < len; i++) {
            myMap.put(nums[i], i);
        }

        for (int i = 0; i < len; i++) {
            int currFirst = nums[i];
            for (int j = 0; j < len; j++) {
                int currSecond = nums[j];
                if (i == j)
                    continue;
                
                int currThird = -(currFirst + currSecond);

                

                if (myMap.containsKey(currThird) && myMap.get(currThird) != i && myMap.get(currThird) != j) 
                {
                    int flag = 1;
                    List<Integer> tempList = new ArrayList<>();
                    for (int k = 0; k < res.size(); k++) 
                    {
                        if (res.size() > 0) 
                        {

                            tempList = res.get(k);
                            if 
                            (
                                (tempList.get(0) == currFirst || tempList.get(1) == currFirst || tempList.get(2) == currFirst)
                                &&
                                (tempList.get(0) == currSecond || tempList.get(1) == currSecond || tempList.get(2) == currSecond)
                                &&
                                (tempList.get(0) == currThird || tempList.get(1) == currThird || tempList.get(2) == currThird)
                            ) 
                            {
                                flag = 0;
                                break;
                            }
                        }
                    }
                    List<Integer> arrList = new ArrayList<>();

                    if (flag == 1) {
                        arrList.add(currFirst);
                        arrList.add(currSecond);
                        arrList.add(currThird);

                        res.add(arrList);
                    }

                }
            }
        }

        return res;

    }
}