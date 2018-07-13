package com.rizwan.idx.service;

import com.rizwan.idx.model.TrieNode;

import java.util.HashSet;
import java.util.Set;

public class TrieNodeService {

    public TrieNode insert(TrieNode root, String word){

        TrieNode node = root;

        for(int i=0;i<word.length();i++){

           TrieNode charNode=node.getCharMap().get(word.charAt(i));

           if(charNode==null){
               charNode=new TrieNode();
           }
           charNode.getTokens().add(word);
           node = charNode;
        }

        return root;
    }

    public Set<String> searchPrefix(TrieNode root, String prefix){

        TrieNode node = root;

        for(int i=0;i<prefix.length();i++){
            TrieNode charNode = node.getCharMap().get(prefix.charAt(i));
            if(charNode==null){
                return new HashSet<>();
            }
            node = charNode;
        }
        return node.getTokens();
    }
}
