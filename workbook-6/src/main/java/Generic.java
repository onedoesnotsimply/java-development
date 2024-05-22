import java.util.ArrayList;
import java.util.Collections;

public class Generic<T> {

    public ArrayList<T> distinctElements(ArrayList<T> originalList){
        // Clear the list
        ArrayList<T> uniqueList = new ArrayList<>();

        // For each item in the original list
        for (T item : originalList){

            if (!uniqueList.contains(item)){
                uniqueList.add(item);
            }
        }
        return uniqueList;
    }

    public ArrayList<T> mergeList(ArrayList<T> listOne, ArrayList<T> listTwo) {
        ArrayList<T> mergedList = new ArrayList<>();

        if (listOne.size()==listTwo.size()) {
            for (int i = 0; i < listOne.size(); i++){
                mergedList.add(listOne.get(i));
                mergedList.add(listTwo.get(i));
            }
        }
        return mergedList;
    }

    public ArrayList<T> reversedList(ArrayList<T> originalList) {
        Collections.reverse(originalList);
        return originalList;

    }

}
