class Solution {
    public int climbStairs(int n) {
        if(n<=2){
            return n;
        }
        int x1 = 1;
        int x2 = 2;
        for(int i=3;i<=n;i++){
            int curr = x1+x2;
            x1 = x2;
            x2 = curr;
        }
        return x2;
    }
}
        
        
 