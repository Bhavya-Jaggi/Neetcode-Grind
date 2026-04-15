class Solution {
    public String longestCommonPrefix(String[] strs) {

        if(strs.length == 1)
            return strs[0];
        
        String com = strs[0];
        String common = "";
    
        for(String str : strs)
        {
            if(str.equals(""))
                return "";

            int len = Math.min(str.length() , com.length());
            int i = 0;

            while(i < len)
            {
                char ch = str.charAt(i);
                char hc = com.charAt(i);
                if(ch != hc && i == 0)
                    return "";
                else if(ch == hc)
                    common += ch;
                else
                    break;
                i++;
            }
            com = common;
            common = "";
        }
        return com;
    }
}