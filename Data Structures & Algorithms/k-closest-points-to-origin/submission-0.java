class Solution {

    class PointData
    {
        int [] coOrdinates;
        double distance;

        public PointData(int[] coOrdinates , double distance)
        {
            this.coOrdinates = coOrdinates;
            this.distance = distance;
        }
    }



    public int[][] kClosest(int[][] points, int k) {
        
        double o = 0.0;


        PriorityQueue<PointData> maxHeap = new PriorityQueue<>((pd1,pd2) -> Double.compare(pd2.distance , pd1.distance));
        //What this does it takes two custom(class) objects and arranges them in descending(maxHeap) order
        //Since we cannot store two data's into a Heap. Therefore we built a custom class -> wrapped the data in it
        //-> then we use this class as a custom datatype for the heap
        

        for(int i = 0 ; i < points.length ; i++)
        {
            // double dist = Math.pow(( points[i][0] - o ) , 2) + Math.pow(( points[i][1] - o ) , 2);
            // Dont write above statement math.pow slows down the code we just need to compare so root and squaring is worthless wasteage of CPU

            double dist = (points[i][0] * points[i][0]) + (points[i][1] * points[i][1]);

            PointData pd = new PointData(new int[] { points[i][0] , points[i][1] } , dist);

            maxHeap.offer(pd);

            if(maxHeap.size() > k)
                maxHeap.poll();

            
        }

        //Now let's unpack are resultant heap since we have a return type of int[][]
        int [][] res = new int[k][2];
        for(int i = 0 ; i < k ; i++)
        {
            res[i] = maxHeap.poll().coOrdinates;
            // maxHeap.poll() pops the PointData object, and .coOrdinates grabs its 1D array [x, y].
            // Because Java treats 2D arrays as an "array of arrays", res[i] represents a single 
            // empty row (a 1D slot). We are directly plugging the entire [x, y] array into that 
            // slot in one swift move, avoiding the need to copy x and y individually!
        }

        return res;//Return the final array


    }
}