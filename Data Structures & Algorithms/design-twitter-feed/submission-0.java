class Twitter 
{

    private class Tweet //Custom inner class to serve as a DS in itself to encapsulate tweetId and time
    {
        int tweetId;
        int time;

        Tweet(int tweetId , int time)
        {
            this.tweetId = tweetId;
            this.time = time;
        }
    }

    int timeStamp;
    Map<Integer , Set<Integer>> followMap; //Map to store who(currUser) follows who all
    Map<Integer , List<Tweet>> tweetMap; //Map to store tweets of particular user

    public Twitter() 
    {
        
        timeStamp = 0;
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();

    }
    
    public void postTweet(int userId, int tweetId) 
    {

        timeStamp++; //We are using this to order tweets according to time they are posted cuz Map doesn't
        // store in ordered-fashion 
        Tweet currTweet = new Tweet(tweetId , timeStamp);
        if(tweetMap.containsKey(userId))
        {
            List<Tweet> temp = tweetMap.get(userId);
            temp.add(currTweet);
            tweetMap.put(userId , temp);
        }
        else
        {
            List<Tweet> temp = new ArrayList<>();
            temp.add(currTweet);
            tweetMap.put(userId , temp);
        }

        
    }
    
    public List<Integer> getNewsFeed(int userId) 
    {

        PriorityQueue<Tweet> minHeap = new PriorityQueue<>( (a,b) -> Integer.compare(a.time , b.time) );
        //Lambda expression to tell minHeap how to sort in ascening order.

        // Collections.sort( minHeap ,  (a,b) -> Integer.compare(a.time , b.time));

        // The above line doesn't work cuz u dumb idiot, heap sorts itself and for this(sorts itself) to 
        // happen you need to specify that in it's(heap's) definition itself not later in the code.
        // Moreover 'Collections.sort()' is STRICTLY built only for 'List' structure like 'ArrayList' or
        // 'LinkedList' not for PriorityQueue. 


        
        // Set<Integer> usersToFetch = followMap.get(userId);
        // usersToFetch.add(userId); 
            // This is wrong cuz i am altering the whole database instead by adding 
            // the user itself since it would indeed simplify logic here but think about whole system
            // design later if a brand new user comes in and he sees he has one follower(he himself) 
            // that would be soo awkward

            //To overcome all this we 'pass by value' here creating a temp Set and copying data
        Set<Integer> usersToFetch = new HashSet<>();
        usersToFetch.add(userId);

        if(followMap.containsKey(userId))
            usersToFetch.addAll(followMap.get(userId));
            //u are copying whole Set DS and then adding to newly made Set DS only

        for(Integer currUser : usersToFetch) //HashSet doesn't need that EntrySet thingy
        {
            if(tweetMap.get(currUser) != null)
            {
                List<Tweet> userTweetList = tweetMap.get(currUser);
                for(int i = 0 ; i < userTweetList.size() ; i++)
                {
                    minHeap.offer(userTweetList.get(i));
                    if(minHeap.size() > 10)
                        minHeap.poll();
                }
            }
        }

        //Since now the heap is all set and done (it has sorted top 10 entries form all the followed users)
        //We now 'unpack' the heap since we are required to return List<Integers>

        List<Integer> res = new LinkedList<>();
        //We are using LL instead of ArrayList(AL) cuz we have to reverse the order of the tweets given by 
        // minHeap and add the popped element to the front(adding to front automatically reverses)
        // if we use AL we have to write .add(0 , ...) which takes O(N) while LL does it O(1)

        while(minHeap.size() > 0)
        {
            res.addFirst(minHeap.poll().tweetId);//poll() returns 'Tweet' object we are only concerned for
            //'tweetId' not the timestamp so we extract only tweetId
            // We are doing 'addFirst' cuz we want to keep the old tweets at the last and the new ones at the
            // front for instance look below:

            // Heap pops Tweet 1 (Oldest). addFirst puts it at the front. -> [Tweet 1]

            // Heap pops Tweet 2 (Middle). addFirst puts it at the front. -> [Tweet 2, Tweet 1]

            // Heap pops Tweet 3 (Newest). addFirst puts it at the front. -> [Tweet 3, Tweet 2, Tweet 1]
        }

        return res;
        
    }
    
    public void follow(int followerId, int followeeId) {

        if(followMap.get(followerId) != null)
            followMap.get(followerId).add(followeeId);
        else
        {
            Set<Integer> temp =  new HashSet<>();//Inside () u declare size of Set u cannot assign value init
            temp.add(followeeId);
            followMap.put(followerId , temp);
        }
        
    }
    
    public void unfollow(int followerId, int followeeId) {

        if(followMap.get(followerId) != null)
            followMap.get(followerId).remove(followeeId);
        
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */