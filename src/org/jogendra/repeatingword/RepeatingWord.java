package org.jogendra.repeatingword;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class RepeatingWord {

  public static void main(String[] args){

    String[] wordList={"AAA","AAA","BBB","BBB","BBB","CC","CC","XXX","XXX","PP","QQ","XXX","XXX"};

        ;
    LinkedHashMap<String,Integer> wordCount=new LinkedHashMap<>();
    int i=0;
    while(i<wordList.length){
      String word=wordList[i];
      if(wordCount.containsKey(word)){
        wordCount.put(word,wordCount.get(word)+1);
      }
      else{
        wordCount.put(word,1);
      }
      i++;
    }

    Set<Map.Entry<String,Integer>> entrySet=wordCount.entrySet();
    ArrayList<Map.Entry<String,Integer>>list=new ArrayList<>(entrySet);

    /*
    sort the array list accorsing to count
     */
    Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
      @Override
      public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
        return o2.getValue().compareTo(o1.getValue());
      }
    });

    for(i=0;i<5;i++){
      Map.Entry<String,Integer> entry=list.get(i);
      System.out.println(entry.getKey()+" "+entry.getValue());
    }
  }
}
