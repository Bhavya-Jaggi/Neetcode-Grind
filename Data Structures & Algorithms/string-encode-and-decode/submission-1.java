class Solution {

    public String encode(List<String> strs) {
        String res = "";
        for(int i = 0; i < strs.size() ; i ++)
        {
            res += strs.get(i) + ";";
        }
        return res;
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        String temp = "";
        for(int i=0; i < str.length() ; i++)
        {
            char ch = str.charAt(i);
            if(ch != ';')
            {
                temp += ch;
            }
            else
            {
                res.add(temp);
                temp = "";
            }
        }
        return res;
    }
}
