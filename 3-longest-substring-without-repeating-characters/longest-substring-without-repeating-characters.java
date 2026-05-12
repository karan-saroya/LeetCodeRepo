class Solution {
     public int lengthOfLongestSubstring(String s)
    {
        int l=0, r=0;
        HashSet<Character> dupCheck = new HashSet<Character>();
        int max =0;
        for(l=0;l<s.length() && r< s.length();)
        {
            if(dupCheck.contains(s.charAt(r)))
            {
                while(l <r )
                {
                    dupCheck.remove(s.charAt(l));
                    char check = s.charAt(l);
                    l++;
                    if(check == s.charAt(r))
                        break;
                }
            }
            dupCheck.add(s.charAt(r));
            r++;
            if(r-l  > max)
                max = r-l;
        }
        return max;

    }
}