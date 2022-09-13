package hot100.m049;

import java.util.*;

public class Solution {
/**
 * getOrDefault(Object key,V value):
 * 返回值:返回 key 相映射的的 value，如果给定的 key 在映射关系中找不到，则返回指定的默认值，即传递的第二个参数value。
 *
 */

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(String str:strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> list = map.getOrDefault(key,new ArrayList<>());
            list.add(str);
            map.put(key,list);
        }
        return new ArrayList<List<String>> (map.values());
    }
}
