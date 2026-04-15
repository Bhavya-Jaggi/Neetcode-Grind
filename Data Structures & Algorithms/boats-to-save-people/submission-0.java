class Solution {
    public int numRescueBoats(int[] people, int limit) {

        int len = people.length;
        int i = 0 , j = len - 1;
        int boat = 0;

        Arrays.sort(people);

        while(j >= i)
        {
            int start = people[i];
            int end = people[j];

            if(start + end <= limit)
            {
                boat++;
                j--;
                i++;
            }
            else
            {
                boat++;
                j--;
            }
        }

        return boat;
    }
}