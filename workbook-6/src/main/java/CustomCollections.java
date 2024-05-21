import com.pluralsight.collection.FixedList;

import java.time.LocalDate;

public class CustomCollections {
    public static void main(String[] args) {
        FixedList fixedList = new FixedList<>(3);
        fixedList.add(10);
        fixedList.add(3);
        fixedList.add(92);
        fixedList.add(43); // this line should fail
        System.out.println(fixedList.getItems());
        System.out.println(fixedList.getItems().size());
        FixedList<LocalDate> dates = new FixedList<>(2);
        dates.add(LocalDate.now());
        dates.add(LocalDate.now());
        dates.add(LocalDate.now()); // this line should fail
        //dates.add(15); can only add the correct types
    }
}
