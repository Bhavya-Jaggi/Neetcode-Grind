class Solution {
    public String minWindow(String s, String t) {

        Map<Character , Integer> target = new HashMap<>();
        Map<Character , Integer> window = new HashMap<>();
        int left,right,tempLen = Integer.MAX_VALUE;
        int need = 0,have = 0;
        List<Character> temp = new ArrayList<>();
        String str = "" , tempStr = "";

        if(s.length() < t.length())
            return "";
        if(s.equals(t))
            return s;

        for(int i = 0; i < t.length() ; i++)
        {
            char ch = t.charAt(i);
            if(target.containsKey(ch))
                target.put(ch , target.get(ch) + 1);
            else
            {
                need++;
                target.put(ch , 1);
            }
        }
        

        for(left = 0 , right = 0;right < s.length() ; right++)
        {
            char ch = s.charAt(right);
            temp.add(ch);

            if(target.containsKey(ch))
            {
                if(window.containsKey(ch))
                    window.put(ch , window.get(ch) + 1);
                else
                {
                    window.put(ch , 1);
                    
                }
                
                if(target.get(ch).intValue() == window.get(ch).intValue()) //i have to fix this
                    have++;
                
                if(have == need)
                {
                    if(tempLen > temp.size())
                    {
                        tempStr = "";
                        tempLen = temp.size();
                        for(int i = left ; i <= right ; i++)
                        {
                            tempStr += temp.get(i);
                        }
                        str = tempStr;
                    }
                    while(have == need)
                    {
                        char hc = s.charAt(left);
                        if(window.containsKey(ch) && tempLen > temp.size())
                        {
                            tempStr = "";
                            tempLen = temp.size();
                            for(Character c : temp)
                            {
                                tempStr += c;
                            }
                            str = tempStr;
                        }
                        temp.remove(0);
                        left++;
                        if(window.containsKey(hc))
                        {
                            window.put(hc , window.get(hc) - 1);
                            if(window.get(hc) < target.get(hc))
                                have--;
                        }

                    }
                }

            }
        }

        return str;
    }
}