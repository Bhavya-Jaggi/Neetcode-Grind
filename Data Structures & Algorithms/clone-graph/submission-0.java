/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {


        Map<Node , Node> hashMap = new HashMap<>();

        if(node == null) //Edge case
            return null;

        Node res = bfs(node , hashMap);

        return res;

    }

    public Node bfs(Node node , Map<Node , Node> hashMap)
    {
        Queue<Node> queue = new LinkedList<>();

        Node first = new Node(node.val); //We need to handle the first element beforehand and make it's deepcopy

        hashMap.put(node , first); //First element done!

        queue.add(node);//we need to add the first element beforehand cuz it's guaranteed 
        //to be not null

        while(!queue.isEmpty())
        {
            Node curr = queue.poll(); //Always use poll() so that the queue is dynamic not static(if use peek())
            

            for(Node padosi : curr.neighbors) //We iterate through ArrayList look how cool is enhanced For loop
            {
                //We only care for the condn when deep copy is not present in the hashMap cuz otherwise the wiring
                //would work perfectly fine if the element is not there we first need to add it!
                if(!hashMap.containsKey(padosi))
                {
                    Node new_cpy = new Node(padosi.val);//Using the given parametrized constructor
                    hashMap.put(padosi , new_cpy);//Updating the map accordingly 
                    queue.add(padosi);//Add the latest padosi in your queue for prcessing it
                }

                //Wiring part!

                Node new_curr = hashMap.get(curr);//Fetch the deepCopy of 'curr' Node
                Node new_currPadosi = hashMap.get(padosi);//Fetch the deepCopy of 'padosi' of curr node
                new_curr.neighbors.add(new_currPadosi);//Wire them together! Both the new ones are now connected!
            }
        }
        return first;//See how usefull it was to save the first node and return only that later!
    }
}