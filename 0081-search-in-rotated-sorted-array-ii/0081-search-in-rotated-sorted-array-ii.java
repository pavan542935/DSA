class Solution {
    public boolean search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            // Target found
            if (nums[mid] == target) {
                return true;
            }
            
            // Edge case for duplicates: unable to determine which half is sorted
            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low++;
                high--;
            } 
            // Left half is sorted
            else if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1; // Target is in the left sorted half
                } else {
                    low = mid + 1;  // Target is in the right half
                }
            } 
            // Right half is sorted
            else {
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;  // Target is in the right sorted half
                } else {
                    high = mid - 1; // Target is in the left half
                }
            }
        }
        
        return false;
    }
}