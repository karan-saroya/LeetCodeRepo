class Solution {
     public int lengthOfLongestSubstring(String s)
    {
        int l=0,r=0;
        HashSet<Character> hasSeen = new HashSet<Character>();
        int ans = 0;
        for(r =0;r< s.length();r++)
        {
            if(!hasSeen.contains(s.charAt(r)))
            {
                hasSeen.add(s.charAt(r));
                if(ans < r-l+1 )
                {
                    ans = r-l+1;
                }

            }
            else {
                while ( l < r  && s.charAt(l) != s.charAt(r))
                {
                    hasSeen.remove(s.charAt(l));
                    l++;
                }
                if(s.charAt(l) == s.charAt(r) && l != r)
                {
                    l++;
                    if(ans < r-l +1)
                    {
                        ans = r-l +1;
                    }
                }
                else
                {
                    System.out.println("This should never happen");
                }

            }


        }

        return ans;

    }
}