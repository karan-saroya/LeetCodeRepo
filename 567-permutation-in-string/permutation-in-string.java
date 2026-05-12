class Solution {
    public boolean checkInclusion(String s1, String s2) 
    {
        
        if(s2.length() < s1.length())
            return false; 
        System.out.println("Here");
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];    
        for(int i=0;i<s1.length();i++)
        {
            freq1[ s1.charAt(i)- 'a']++; 
        }

        for(int i=0;i<26;i++)
        {
            System.out.print(freq1[i] + " " );
        }

        for(int i=0;i<s1.length();i++)
        {
            freq2[s2.charAt(i)-  'a']++; 
        }
        

        System.out.println("");
        for(int i=0;i<26;i++)
        {
            System.out.print(freq2[i] + " " );
        }
        System.out.println("");

        boolean ans = false;
        for(int i=0;i<s2.length()-s1.length()+1;i++)
        {
            System.out.println(i + " I");
            if(i != 0)
            {
                freq2[s2.charAt(i-1) -'a']--;
                freq2[s2.charAt(i-1 + s1.length()) - 'a' ]++;
            }

            if(checkEq(freq1,freq2))
            {
                ans = true;
                break;
            }


        }
        return ans;


    }
    boolean checkEq(int[] freq1, int[] freq2)
    {
        for(int i=0;i<freq1.length;i++)
        {
            if(freq1[i] != freq2[i])
                return false;
        }

        return true;

    }

}
