class Solution {
    public boolean lemonadeChange(int[] bills) {

        if(bills[0] > 5)
            return false;

        
        int[] notes = new int[2];

        for(int i = 0 ; i < bills.length ; i++)
        {
            int change = bills[i] - 5;

            if(change == 0)
                notes[0]++;

            else if(change == 5)
            {
                if(notes[0] == 0)
                    return false;
                notes[1]++;
                notes[0]--;
            }
            else if(change == 15)
            {
                if((notes[1] >= 1 && notes[0] >= 1))
                {
                    notes[0]--;
                    notes[1]--;
                }
                else if(notes[0] >= 3)
                    notes[0] -= 3;
                else
                    return false;
            }
        }
        return true;

        
    }
}