class Solution {

    private int nextNumber(int n) {

        int sum = 0;

        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }

        return sum;
    }

    public boolean isHappy(int n) {

        int slow = n;
        int fast = n;
while (fast!=1)
{
    slow=nextNumber(slow);
    fast=nextNumber(nextNumber(fast));
    if(slow==fast&&fast!=1)
    {
        return false;
    }
}
  return true;      
    }
}