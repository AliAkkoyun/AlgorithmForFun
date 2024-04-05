import java.util.*;

public class MissingNumber {
    private static Random random = new Random();
    private static final int MISSING_NUMBER = 53;
    private static final int BOUND = 100;
    public static void main(String[] args) {


        ArrayList<Integer> myList = missingNumberListGenerator(BOUND, MISSING_NUMBER);
        int result = missingNumberFinder(myList);
        System.out.println("Missing Number = " + result);

    }

    private static int missingNumberFinder(ArrayList<Integer> myList){
        Collections.sort(myList);
        printList(myList);
        System.out.println("*****************************************************");

        int result = -1;

        for(int i=1; i<myList.size(); i++){
            if(myList.get(i) != myList.get(i-1)+1){
                result = myList.get(i)-1;
            }
        }
        if(result == -1 && myList.get(BOUND-2) == myList.size()-1){
            result = myList.size();
        }
        else if (result == -1 && !myList.contains(0)){
            result = 0;
        }

        return result;
    }
    private static ArrayList<Integer> missingNumberListGenerator(int bound, int missingNumber){
        if(missingNumber > bound){
            throw new IllegalArgumentException("missingNumber cannot bigger then bound");
        }
        int randomNumber = -1;
        ArrayList missingList = new ArrayList<Integer>();

        for(;;){
            randomNumber = random.nextInt(bound);
            if(randomNumber==missingNumber) continue;
            if(missingList.contains(randomNumber))continue;
            else missingList.add(randomNumber);
            if(missingList.size() == bound-1) break;
        }
        return missingList;

    }
    private static void printList(ArrayList<Integer> myList){

        for(int i=0; i< myList.size(); i++){
            System.out.println(myList.get(i));
        }

    }
}