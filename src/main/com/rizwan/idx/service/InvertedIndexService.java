package com.rizwan.idx.service;

import com.rizwan.idx.model.Pair;

import java.util.*;

public class InvertedIndexService {

    public Map<String,List<Pair>> populateInvertedIndex(Map<String,Integer> values){

        Map<String,List<Pair>> iv = new HashMap<>();
        for(Map.Entry<String,Integer> rec:values.entrySet()){

            String[] splits = rec.getKey().split("_");
            for(String token:splits){
              List<Pair> existingRecord=iv.get(token);
              if(existingRecord==null){
                  existingRecord=new ArrayList<>();
                  iv.put(token,existingRecord);
              }
              existingRecord.add(new Pair(rec.getKey(),rec.getValue()));
            }
        }
        return iv;
    }

    public List<String> getSortedNames(Map<String,List<Pair>> ividx, Set<String> tokens){

        Set<Pair> pairs = new TreeSet<>();

        for(String token:tokens){
            if(ividx.get(token)!=null){
                pairs.addAll(ividx.get(token));
            }
        }

        List<String> names = new ArrayList<>();

        for(Pair pair:pairs){
            names.add(pair.getName());
        }
        return names;
    }
}
