class TimeMap {


    Map<String , List<String[]>> myMap;

    public TimeMap() {
        myMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        
        List<String[]> tempList = new ArrayList<>();
        if(myMap.containsKey(key))
        {
            tempList = myMap.get(key);
            tempList.add(new String[] {value , "" + timestamp});
            myMap.put(key , tempList);
        }
        else
        {
            tempList.add(new String[]{value , "" + timestamp});
            myMap.put( key , tempList );
            //tempList.clear()  This is wrong refer to notes
        }
    }
    
    public String get(String key, int target) {
        String str ="";
        
        if(!myMap.containsKey(key))
            return str;

        //List<String[]> tempList = new ArrayList<>(myMap.get(key)); Very much overhead in this line 530ms runtime

        List<String[]> tempList = myMap.get(key); //After this i had 184ms runtime
        int left = 0, right = tempList.size() - 1;


        if(target < Integer.parseInt(tempList.get(0)[1]))
        {
            return str;
        }

        while(left <= right)
        {
            int med = (left + right ) / 2;
            int curr = Integer.parseInt( tempList.get(med)[1] );

            
            if( target >= curr )
            {
                str = tempList.get(med)[0];
                left = med + 1;
            }
            else if( target < curr)
            {
                right = med - 1;
            }
        }

        return str;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */