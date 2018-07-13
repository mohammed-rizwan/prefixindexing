package com.rizwan.idx.model;

import java.util.*;

public class TrieNode {

    private Set<String> tokens = new HashSet<>();
    Map<Character,TrieNode> charMap = new HashMap<>();

    public Set<String> getTokens() {
        return tokens;
    }

    public void setTokens(Set<String> tokens) {
        this.tokens = tokens;
    }

    public Map<Character, TrieNode> getCharMap() {
        return charMap;
    }

    public void setCharMap(Map<Character, TrieNode> charMap) {
        this.charMap = charMap;
    }

}
