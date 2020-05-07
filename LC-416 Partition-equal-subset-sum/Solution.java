
class Solution {
    public boolean canPartition(int[] nums) {
        
        int totalSum=0;
        for(int i=0;i<nums.length;i++)
        {
            totalSum=totalSum+nums[i];
        }
        
        //Now if sum is odd, it cannot be broken down into two equal sums:
        //For Ex: total sum is 23, it can either be 11+12 or 12+11, it can never be equal;
        //if sum is even, then only it can be broken down two two equal subsets;
        
        if(totalSum%2!=0)
        {
            return false;
        }
        
        //Now suppose sum is 22; to broke it into even sums, we need sum of 11 and 11;
        //Now if there is subset of sum 11 in array, obviously the left subset sum will also be 11 coz total is 11+11=22;
        //Now we just need to check if there is sum of totalsum/2; in array;
        
        
        int sum=totalSum/2;
        
        //Now we will apply dp for subset problem; 
        boolean dp[][]=new boolean[nums.length+1][sum+1];
        
        //Intialization;
        
        for(int i=0;i<=nums.length;i++)
        {
           for(int j=0;j<=sum;j++)
           {
               //now if there is no array, can we make subset of any sum other than 0;
               if(i==0)
               {
                   //means there is no array;
                   dp[i][j]=false;
               }
               
               if(j==0)
               {
                   //if subset to be generated is of 0 sum, its always possible;
                   dp[i][j]=true; //this will also cover when i and j both are 0;
               }
           }
        }
        
        
        for(int i=1;i<=nums.length;i++)
        {
            for(int j=1;j<=sum;j++)
            {
                if(nums[i-1]<=j)
                {
                    //either we include that number or not;
                    dp[i][j] = dp[i-1][j-nums[i-1]] || dp[i-1][j];
                }
                else
                {
                    //we have no choice, we cannot include it;
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[nums.length][sum];
        
        
    }
}
