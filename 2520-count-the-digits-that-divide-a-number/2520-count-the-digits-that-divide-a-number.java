class Solution {
    public int countDigits(int num) {
        int count=0;
        int d;
        for(int i=num;i>0;i=i/10)
        {
            d = i%10;
            if (num%d==0)
            count++;
        }
        return count;

    }
}