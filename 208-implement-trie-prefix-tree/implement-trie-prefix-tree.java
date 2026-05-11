class Trie {
    TrieNode root;
    public Trie() 
    {
        root = new TrieNode();
        

    }
    
    public void insert(String word) 
    {
        TrieNode node = root;
        for(int i=0;i<word.length();i++)
        {
            char c= word.charAt(i);
            int idx = c - 'a';
            if(node.children[idx] == null)
            {
                node.children[idx] = new TrieNode();
            }
            node= node.children[idx];

        }

        node.isEnd = true;

    }
    
    public boolean search(String word) 
    {
        TrieNode node = root;
        for(int i=0;i<word.length();i++)
        {
            int index = word.charAt(i) - 'a';
            if(node.children[index] == null)
                return false;
            node = node.children[index];
        }
        return node.isEnd;
        
    }
    
    public boolean startsWith(String prefix) 
    {
        TrieNode node = root;
        for(int i=0;i<prefix.length();i++)
        {
            int index = prefix.charAt(i) - 'a';
            if(node.children[index] == null)
                return false;
            node = node.children[index];
        }
        return true;
    }
}

class TrieNode
{
    TrieNode[] children;
    boolean isEnd= false;
    TrieNode()
    {
        children = new TrieNode[26];
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */