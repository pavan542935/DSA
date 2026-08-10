class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        boolean[] use = new boolean[nums.length];
        helper(nums,ans,0,use,curr);
        return ans;
        
    }
    public void helper(int[] nums, List<List<Integer>> ans ,int index,boolean[] use,List<Integer> curr){
        if(index == nums.length){
            ans.add(new ArrayList<>(curr));
            return ;
        }

        for(int i = 0 ; i< nums.length;i++){
            if(use[i]){
                continue;
            }

            use[i] = true;
            curr.add(nums[i]);

            helper(nums,ans,index+1,use,curr);

            curr.remove(curr.size()-1);
            use[i] = false;

        }

    }
}