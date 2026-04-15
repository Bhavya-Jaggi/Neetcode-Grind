// Solely done by myself solution

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        

        List<List<String>> str = new ArrayList<>();

        Map<String , List<String>> myMap = new HashMap<>();

        for(int i = 0 ; i < strs.length ; i++)
        {
            String currString = strs[i];       //Extracting strings one by one

            String currSortedString = sortString(currString);

            if(myMap.containsKey(currSortedString))
            {
                List<String> tempList = new ArrayList<>(myMap.get(currSortedString)); //We wrote here cuz we had to safely initialise temList with existing value in myMap

                tempList.add(currString);

                myMap.put(currSortedString , tempList);
            }
            else
            {
                List<String> tempList = new ArrayList<>();
                tempList.add(currString);

                myMap.put(currSortedString , tempList);
            }
        }

        for(String key : myMap.keySet())
        {
            str.add(myMap.get(key));
        }

        return str;

    }

    public String sortString(String str)
    {
        //to sort strings in just one line we can use most optimised Arrays.sort() but to convert a String into an Array we use a char[] 

        char[] chars = str.toCharArray();

        //Since now the String is converted to an ARRAY(be it char type) we are now legible to use Arrays.sort()
        Arrays.sort(chars);

        //Since now chars[] contains sorted character array we convert this char[] back to String but u cannot use .toString() cuz it's won't do the thing instead initialise a new string

        String res = new String(chars);

        return res;
    }
}