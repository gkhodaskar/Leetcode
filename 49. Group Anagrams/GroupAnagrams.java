// Problem Description: https://leetcode.com/problems/group-anagrams/

import java.util.*;

class GroupAnagrams{

    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, LinkedList<String>> digest = new HashMap<String, LinkedList<String>>();

        // HashMap stores the strings with key as alphabetically sorted representation of that string
        // e.g. "aet" (alphabetically sorted) --> "eat", "tea", "ate"

        for(String s : strs){
            char[] charr = s.toCharArray();
            Arrays.sort(charr);
            String tmp = new String(charr);

            if(!digest.containsKey(tmp)){
                digest.put(tmp, new LinkedList<String>());

            }
            digest.get(tmp).add(s);
        }

        return new LinkedList<List<String>>(digest.values());
    }
}