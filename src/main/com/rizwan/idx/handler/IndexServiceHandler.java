package com.rizwan.idx.handler;

import com.rizwan.idx.model.Pair;
import com.rizwan.idx.model.TrieNode;
import com.rizwan.idx.service.InvertedIndexService;
import com.rizwan.idx.service.TrieNodeService;
import com.rizwan.idx.service.impl.JsonService;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class IndexServiceHandler {

    private static Map<String,List<Pair>> ividx = new HashMap<>();

    private static TrieNode trie = new TrieNode();

    private static TrieNodeService trieNodeService = new TrieNodeService();

    private static InvertedIndexService invertedIndexService = new InvertedIndexService();

    public synchronized static void populateIndexAndTrie(InputStream is) throws IOException {
        Map<String,Integer> pairs=new JsonService().readData(is);
        ividx=invertedIndexService.populateInvertedIndex(pairs);

        for(String key:ividx.keySet()){
            trie=trieNodeService.insert(trie,key);
        }
    }

    public static List<String> searchPrefix(String prefix){
        Set<String> tokens = trieNodeService.searchPrefix(trie,prefix);
        Set<Pair> pairs = new TreeSet<>();

        for(String tk:tokens){
            pairs.addAll(ividx.get(tk));
        }

        List<String> names = new ArrayList<>();

        for(Pair pair:pairs){
            names.add(pair.getName());
        }
        return names;
    }
}
