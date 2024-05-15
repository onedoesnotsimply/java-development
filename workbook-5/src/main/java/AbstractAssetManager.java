import com.pluralsight.AbstractAsset;
import com.pluralsight.Cash;

public class AbstractAssetManager {
    public static void main(String[] args) {
        Cash cashStash = new Cash("My stash of cash", "September 8, 2020", 200);

        System.out.println("I have $"+cashStash.getValue()+" cash");

        cashStash.addCash(25.0);

        System.out.println("Now I have $"+cashStash.getValue()+" cash");
    }
}
