class Solution {
 public String minWindow(String s, String t)
    {
        int l = 0, r = 0;
        int start = 0, length = Integer.MAX_VALUE;
        int[] freqArrLC = new int[26];
        int[] freqArrUC = new int[26];
        int[] tarArrLC = new int[26];
        int[] tarArrUC = new int[26];

        for (int i = 0; i < 26; i++)
        {
            freqArrLC[i] = freqArrUC[i] = tarArrUC[i] = tarArrLC[i] = 0;
        }

        for (int i = 0; i < t.length(); i++)
        {

            if (Character.isLowerCase(t.charAt(i)))
            {
                tarArrLC[t.charAt(i) - 'a']++;
            } else
            {
                tarArrUC[t.charAt(i) - 'A']++;
            }
        }


        for (r = 0; r < s.length(); r++)
        {
            if(Character.isLowerCase(s.charAt(r)))
            {
                freqArrLC[s.charAt(r) - 'a']++;
            }
            else
                freqArrUC[s.charAt(r) - 'A']++;


            while(l <=  r  && isSuperSet(freqArrLC, freqArrUC, tarArrLC, tarArrUC))
            {
                if(length > r-l+1)
                {
                    start = l;
                    length = r-l+1;
                }
                if(Character.isLowerCase(s.charAt(l)))
                {
                    freqArrLC[ s.charAt(l)- 'a']--;
                }
                else
                {
                    freqArrUC[ s.charAt(l)- 'A']--;
                }
                l++;
            }


        }




        if(length == Integer.MAX_VALUE)
            return "";
        return s.substring(start, start+ length);

    }
    public boolean isSuperSet(int[] freqLC, int[] freqUC, int[] tarLC, int[] tarUC)
    {

        boolean valid = true;
        for(int i=0;i<26;i++)
        {
            if(!(freqLC[i] >= tarLC[i] && freqUC[i] >= tarUC[i])){
                valid = false;
                break;
            }

        }
        return valid;
    }
}