class Solution {
    List<Integer> curr = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        helper(candidates,target,0,ans,0);

        return ans;
        
    }

    public void helper(int[] can, int target, int index,List<List<Integer>> ans,int sum){

        if(index == can.length){
            return ;
        }
        if(sum == target){
            ans.add(new ArrayList<>(curr));
            return ;
        }

        if(sum > target){
            return;
        }

        curr.add(can[index]);
        helper(can,target,index,ans,sum + can[index]);
        curr.remove(curr.size()-1);
        helper(can,target,index+1,ans,sum);


    }
}