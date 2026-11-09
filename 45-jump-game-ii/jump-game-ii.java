class Solution {
    public int jump(int[] nums) {
        int mri=0;//maxreachindex
        int n=nums.length-1;
        int jump=0;
        int ejp=0;//endjumppoint
        for(int i=0;i<nums.length-1;i++){//i < nums.length: We may process the destination itself
        //i < nums.length - 1: We process only positions before the destination
            mri=Math.max(mri,i+nums[i]);
            if(i==ejp){ //break types ki agr 0 ya 2 aee then jump++;
                jump++;
                ejp=mri;
            }
        }
        return jump;

    }
}