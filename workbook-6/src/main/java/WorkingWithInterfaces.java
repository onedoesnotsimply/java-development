import com.pluralsight.Person;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class WorkingWithInterfaces {
    public static void main(String[] args) {
        List<Person> myFamily = new ArrayList<Person>();
        myFamily.add( new Person("Dana", "Wyatt", 63) );
        myFamily.add( new Person("Zachary", "Westly", 31) );
        myFamily.add( new Person("Harriet", "Westly", 30) );
        myFamily.add( new Person("Harriet", "Westly", 15) );
        myFamily.add( new Person("Elisha", "Aslan", 14) );
        myFamily.add( new Person("Elisha", "Aslan", 28) );
        myFamily.add( new Person("Elisha", "Aslan", 18) );
        myFamily.add( new Person("Elias", "Aslan", 14) );
        myFamily.add( new Person("Ian", "Auston", 16) );
        myFamily.add( new Person("Zephaniah", "Hughes", 9) );
        myFamily.add( new Person("Ezra", "Aiden", 17) );


        Collections.sort(myFamily);

        for (Person person : myFamily) {
            System.out.println(person.getFirstName()+" "+person.getLastName()+" "+person.getAge());
        }
    }
}
