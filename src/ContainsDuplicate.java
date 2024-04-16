import java.util.HashSet;

public class ContainsDuplicate {
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
}
