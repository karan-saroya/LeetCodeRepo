class Solution {
    public int characterReplacement(String s, int k)
    {

        int maxFreq =0, l= 0, r= 0;
        int[] count = new int[26];
        int ans = 0;
        for(int i=0;i<count.length;i++)
            count[i] =0;

        for(r=0;r<s.length();r++)
        {
            count[s.charAt(r) - 'A']++;
            if(count[s.charAt(r) - 'A'] > maxFreq)
                maxFreq =  count[s.charAt(r) - 'A'];

            while(l <=r  && r- l + 1 - maxFreq> k)
            {
                maxFreq= 0;
                count[ s.charAt(l) - 'A']--;

                for(int i=0;i<26;i++)
                {
                    if(count[i] > maxFreq)
                        maxFreq = count[i];
                }
                l++;
            }
            if(r-l +1 > ans)
                ans = r-l+1;
        }

        return ans;


    }
}