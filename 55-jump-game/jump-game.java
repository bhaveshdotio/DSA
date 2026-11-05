class Solution {
    public boolean canJump(int[] nums) {
        // // 0 1 2 3 4
        // // 2 3 1 1 4
        // //i2
        // //j  3 
        // int k=0;
        // if(nums[k]==0){
        //     return false;
        // }
        // if(nums.length==1){
        //     return true;
        // }
        // int n=nums.length-1;
        // for(int i=0;i<nums.length;i++){
        //     int value=nums[i];
        //     for(int j=i+1;j<=i+value&&j<nums.length;j++){//value represents the maximum jump length, not the destination index
        //         int value1=nums[j];
        //         if(n-j<=value1){
        //             return true;
        //         }
        //     }
        // }
        // return false;
        // 0 1 2 3 4
        // 2 3 1 1 4
        //m 0+2=2[i=0]..max index reachable is 2{update the max}
        //if(current index>reachable index)-->false condition
        //m 1+3=4[i=1]..max index reachable is 4
        int n=nums.length-1;
        int maxreachindex=0;
        for(int i=0;i<nums.length;i++){
            if(i>maxreachindex){
                return false;
            }
            maxreachindex=Math.max(maxreachindex,i+nums[i]);
            if(maxreachindex>=n){
                return true;
            }
        }
        return true;
    }
}