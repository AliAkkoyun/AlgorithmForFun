package ArraysAndHashing;


import javax.swing.*;
import java.util.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

    }
    public static boolean containsDuplicate(int[] nums){
        HashSet<Integer> mySet = new HashSet<>();

        for(int i=0;i<nums.length; i++){
            if(mySet.contains(nums[i])) return true;
            mySet.add(nums[i]);
        }
        return false;
    }

    public static boolean isAnagram(String s, String t){
        if(s.length() != t.length()) return false;

        char[] s_charArray = s.toCharArray();
        char[] t_charArray = t.toCharArray();
        Arrays.sort(s_charArray);
        Arrays.sort(t_charArray);
        for(int i=0; i<s_charArray.length; i++){
            if(s_charArray[i] != t_charArray[i]) return false;
        }
        return true;
    }
    public static int[] twoSum(int[] nums, int target){
        int[] twoSumTargetArr = new int[2];

        for(int i=0; i<nums.length; i++){
            for (int j=i+1; j<nums.length;j++){
                if (nums[i] + nums[j] == target) {
                    twoSumTargetArr[0] = i;
                    twoSumTargetArr[1] = j;
                }
            }
        }
        return twoSumTargetArr;
    }

    public static List<List<String>> groupAnagrams(String[] strs){
      List<List<String>> resultList = new ArrayList<>();
      Map<String, List<String>> map = new HashMap<>();

      for(String str : strs){
          char[] charArray = str.toCharArray();
          Arrays.sort(charArray);
          String sortedCharArray = new String(charArray);

          if(map.containsKey(sortedCharArray)){
              map.get(sortedCharArray).add(str);
          } else {
              List<String> tempList = new ArrayList<>();
              resultList.add(tempList);
              tempList.add(str);
              map.put(sortedCharArray, tempList);
          }
      }
      return resultList;
    }
}
