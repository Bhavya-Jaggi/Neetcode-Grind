class LRUCache {

    //Defining Doubly Linked List Node Class
    class Node
    {
        int key;
        int val;
        Node next;
        Node prev;

        Node(int key , int val) //Constructor of the class
        {
            this.key = key;
            this.val = val;
        }
    }

    Map<Integer , Node> myMap = new HashMap<>();
    int capacity;
    Node head;
    Node tail;

    //Helper func for adding a new node
    public void addToHead(Node newNode)
    {
        
        newNode.next = head.next; //Good thinking req 
        Node dummyTail = head.next;
        dummyTail.prev = newNode;

        head.next = newNode;
        newNode.prev = head;


        // myMap.put(key , newNode); not needed u just do the pure pointer stuff here leave the map part for put() function 
    }

    //Helper function to remove node
    public void removeNode(Node curr)
    {

        (curr.next) .prev = curr.prev;//curr ke next par jo element hai uska prev = curr ka prev
        (curr.prev) .next = curr.next; //curr ke prev par jo element hai uska next = curr ka next

    }

    //Helper function to move a node to head
    public void moveToHead(Node curr)
    {
        removeNode(curr);
        addToHead(curr);
    }

    

    public LRUCache(int capacity) {
        this.capacity = capacity;

        //Initializing dummy node
        head = new Node(-1 , -1);
        tail = new Node(-1 , -1);

        //Connecting two dummy nodes
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {

        if(myMap.containsKey(key))
        {
            Node curr = myMap.get(key);
            moveToHead(curr);
            return curr.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {

        if(myMap.containsKey(key))
        {
            Node curr = myMap.get(key);
            curr.val = value;
            moveToHead(curr);
            myMap.put(key , curr);
        }
        else
        {
            Node curr = new Node(key,value); //Only create a newNode when there is a need not everytim cuz it causes huge overhead
            if(myMap.size() < capacity) //map.size() is much more consistent than maitaining a variable 
            {
                addToHead(curr);
                myMap.put(key , curr);
                
            }
            else
            {
                myMap.remove( (tail.prev) .key); //Pheley map se hatao kyuki agar line 100 aur line 99 swap ho gai to node hatt chuka hoga fir tum 2nd last node remove kar doge
                removeNode(tail.prev);//Ab Node ko LL se hatao
                addToHead(curr); 
                myMap.put(key , curr); //Update map
            }
        }
        
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */