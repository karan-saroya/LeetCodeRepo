class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k)
    {
        int l = 0, r = 0, ans = 0;
        HashMap<Character, Integer> freqCount = new HashMap<>();
        for (r = 0; r < s.length(); r++)
        {
            if (freqCount.containsKey(s.charAt(r)))
            {
                    freqCount.replace(s.charAt(r), freqCount.get(s.charAt(r)) + 1);
            }
            else
            {
                freqCount.put(s.charAt(r), 1);
            }

            while( freqCount.size() > k && l <= r)
            {
                char remove = s.charAt(l);
                freqCount.replace(remove, freqCount.get(remove) - 1);
                if(freqCount.get(remove) == 0)
                    freqCount.remove(remove);
                l++;
            }

            ans = Math.max(ans, r-l+1);

        }
        return ans;

    }
}