class Solution {
   public int totalFruit(int[] fruits)
    {
        int l = 0, r = 0, ans = 0;
        HashMap<Integer, Integer> count = new HashMap<>();
        for ( r = 0; r < fruits.length; r++)
        {
            if(count.containsKey(fruits[r])){
                count.replace(fruits[r], count.get(fruits[r]) + 1);
            }
            else
                count.put(fruits[r], 1);

            //System.out.println(count.values().stream().toList());
                
            while(l < r && count.size() > 2)
            {
                //System.out.println("L: "+ l + "  R:" + r);
                count.replace(fruits[l], count.get(fruits[l])-1);
                //System.out.println(count.values().stream().toList());
                //System.out.println(fruits[l]);
                if(count.get(fruits[l]) == 0)
                    count.remove(fruits[l]);
                l++;
            }
            ans = Math.max(ans, r-l+1);
        }
        return ans;

    }
}