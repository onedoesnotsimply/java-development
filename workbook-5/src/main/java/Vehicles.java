import com.pluralsight.Car;
import com.pluralsight.Hovercraft;
import com.pluralsight.SemiTruck;
import com.pluralsight.Moped;
import com.pluralsight.Vehicle;

public class Vehicles {
    public static void main(String[] args) {
        // Make a moped
        Moped sadNSlow = new Moped();
        sadNSlow.setColor("Yellow");

        // Make a semi truck
        SemiTruck bigRed = new SemiTruck();
        bigRed.setHasTrailer(true);
        bigRed.setColor("Red");

        // Make a car
        Car daisy = new Car();
        daisy.setConvertible(true);
        daisy.setColor("White");

        // Make a hovercraft
        Hovercraft flyBoy = new Hovercraft();
        flyBoy.setColor("Black");
        flyBoy.setNumberOfPassengers(4);

    }
}
