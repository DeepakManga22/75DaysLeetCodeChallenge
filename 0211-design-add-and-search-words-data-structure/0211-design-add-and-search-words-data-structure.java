class WordDictionary {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }
    
    // Add word to Trie
    public void addWord(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }
    
    // Search with support for '.'
    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int i, TrieNode node) {
        if (node == null) return false;

        if (i == word.length()) {
            return node.isEnd;
        }

        char ch = word.charAt(i);

        // If character is '.'
        if (ch == '.') {
            for (TrieNode child : node.children) {
                if (dfs(word, i + 1, child)) {
                    return true;
                }
            }
            return false;
        } 
        // Normal character
        else {
            return dfs(word, i + 1, node.children[ch - 'a']);
        }
    }
}
/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */