// import java.util.*;
class Solution {
    public int[] sort2Arrs(int a[],int b[])
    {
        int i=0,j=0,n,m,c=0;
        n=a.length;
        m=b.length;
        int arr[] = new int [n+m];
        while(i<n && j<m)
        {
            if(a[i] <= b[j])
            {
                arr[c] = a[i];
                i++;
            }
            else
            {
                arr[c] = b[j];
                j++;
            }
            c++;
        }
        while(i<n)
        {
            arr[c] = a[i];
            c++;
            i++;
        }
        while(j<m)
        {
            arr[c] = b[j];
            c++;
            j++;
        }
        return arr;
    }
    public int[] sortArray(int[] nums) {
        int n = nums.length;

        if(n == 1)
            return nums;

        int left[] = Arrays.copyOfRange(nums , 0 , n/2);
        int right[] = Arrays.copyOfRange(nums , n/2 , n);

        left = sortArray(left);
        right = sortArray(right);

        return sort2Arrs(left , right);


    }
}