package com.so.leetcode;

/**
 * LeetCode 208. 实现 Trie (前缀树)
 * <p>
 * Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，
 * 用于高效地存储和检索字符串数据集中的键。
 * 这一数据结构有相当多的应用情景，例如自动补完和拼写检查。
 * <p>
 * 请你实现 Trie 类：
 * - Trie() 初始化前缀树对象。
 * - void insert(String word) 向前缀树中插入字符串 word 。
 * - boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
 * - boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
 * <p>
 * 示例：
 * 输入
 * ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
 * [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
 * 输出
 * [null, null, true, false, true, null, true]
 * <p>
 * 解释
 * Trie trie = new Trie();
 * trie.insert("apple");
 * trie.search("apple");   // 返回 True
 * trie.search("app");     // 返回 False
 * trie.startsWith("app"); // 返回 True
 * trie.insert("app");
 * trie.search("app");     // 返回 True
 *
 * @author FlyHippo
 * @version 1.0
 **/
public class Q208_ImplementTrie {

    /**
     * Trie树节点类
     */
    static class TrieNode {
        // 子节点数组，对应26个字母
        private TrieNode[] children;
        // 标记当前节点是否为某个单词的结尾
        private boolean isEndOfWord;

        public TrieNode() {
            // 初始化子节点数组
            children = new TrieNode[26];
            // 默认不是单词结尾
            isEndOfWord = false;
        }
    }

    TrieNode root = new TrieNode();


    /**
     * 向前缀树中插入字符串 word
     *
     * @param word 需要插入的字符串
     */
    public void insert(String word) {
        // 从根节点开始
        TrieNode current = root;

        // 遍历单词中的每个字符
        for (char ch : word.toCharArray()) {
            // 计算字符相对于'a'的索引
            int index = ch - 'a';

            // 如果当前字符对应的子节点不存在，则创建新节点
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }

            // 移动到子节点
            current = current.children[index];
        }

        // 标记单词结尾
        current.isEndOfWord = true;
    }

    /**
     * 搜索字符串 word 是否在前缀树中
     *
     * @param word 需要搜索的字符串
     * @return 如果字符串 word 在前缀树中，返回 true；否则，返回 false
     */
    public boolean search(String word) {
        // 查找单词
        TrieNode node = searchPrefix(word);

        // 如果找到了前缀且最后一个节点标记为单词结尾，则返回true
        return node != null && node.isEndOfWord;
    }

    /**
     * 检查是否存在以 prefix 为前缀的字符串
     *
     * @param prefix 需要查询的前缀
     * @return 如果之前已经插入的字符串中存在以 prefix 为前缀的，返回 true；否则，返回 false
     */
    public boolean startsWith(String prefix) {
        // 只要能找到前缀即可
        return searchPrefix(prefix) != null;
    }

    /**
     * 搜索指定前缀并返回最后一个节点
     *
     * @param prefix 需要搜索的前缀
     * @return 前缀的最后一个节点，如果不存在则返回null
     */
    private TrieNode searchPrefix(String prefix) {
        // 从根节点开始
        TrieNode current = root;

        // 遍历前缀中的每个字符
        for (char ch : prefix.toCharArray()) {
            // 计算字符相对于'a'的索引
            int index = ch - 'a';

            // 如果当前字符对应的子节点不存在，则说明前缀不存在
            if (current.children[index] == null) {
                return null;
            }

            // 移动到子节点
            current = current.children[index];
        }

        // 返回前缀的最后一个节点
        return current;
    }

    public static void main(String[] args) {
        Q208_ImplementTrie trie = new Q208_ImplementTrie();

        // 测试示例
        trie.insert("apple");
        System.out.println("search(\"apple\"): " + trie.search("apple"));   // 应该输出 true
        System.out.println("search(\"app\"): " + trie.search("app"));       // 应该输出 false
        System.out.println("startsWith(\"app\"): " + trie.startsWith("app")); // 应该输出 true
        trie.insert("app");
        System.out.println("search(\"app\"): " + trie.search("app"));       // 应该输出 true
    }
}