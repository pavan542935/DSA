class Solution {
    public boolean hasAlternatingBits(int n) {
        String s = "";

        while(n > 0){
            s = s+(n%2);
            n = n/2;
        }

        char[] arr = s.toCharArray();

        for(int i =0;i<arr.length-1;i++){
            if(arr[i] == arr[i+1]){
                return false;
            }
        }

        return true;


    }
}