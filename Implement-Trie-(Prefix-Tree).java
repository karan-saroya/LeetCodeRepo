1class Trie {
2    TrieNode root;
3    public Trie() 
4    {
5        root = new TrieNode();
6        
7
8    }
9    
10    public void insert(String word) 
11    {
12        TrieNode node = root;
13        for(int i=0;i<word.length();i++)
14        {
15            char c= word.charAt(i);
16            int idx = c - 'a';
17            if(node.children[idx] == null)
18            {
19                node.children[idx] = new TrieNode();
20            }
21            node= node.children[idx];
22
23        }
24
25        node.isEnd = true;
26
27    }
28    
29    public boolean search(String word) 
30    {
31        TrieNode node = root;
32        for(int i=0;i<word.length();i++)
33        {
34            int index = word.charAt(i) - 'a';
35            if(node.children[index] == null)
36                return false;
37            node = node.children[index];
38        }
39        return node.isEnd;
40        
41    }
42    
43    public boolean startsWith(String prefix) 
44    {
45        TrieNode node = root;
46        for(int i=0;i<prefix.length();i++)
47        {
48            int index = prefix.charAt(i) - 'a';
49            if(node.children[index] == null)
50                return false;
51            node = node.children[index];
52        }
53        return true;
54    }
55}
56
57class TrieNode
58{
59    TrieNode[] children;
60    boolean isEnd= false;
61    TrieNode()
62    {
63        children = new TrieNode[26];
64    }
65}
66
67/**
68 * Your Trie object will be instantiated and called as such:
69 * Trie obj = new Trie();
70 * obj.insert(word);
71 * boolean param_2 = obj.search(word);
72 * boolean param_3 = obj.startsWith(prefix);
73 */