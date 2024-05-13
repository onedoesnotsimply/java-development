import com.pluralsight.Car;
import com.pluralsight.Hovercraft;
import com.pluralsight.SemiTruck;
import com.pluralsight.Moped;

public class Vehicles {
    public static void main(String[] args) {

        // Make a moped
        Moped sadNSlow = new Moped(2, 2,100,500,"Honda", "Adv150","Yellow", 100);
        System.out.println("Moped: \nBalance: "+sadNSlow.getBalance()+"\nPassengers: "+sadNSlow.getNumberOfPassengers());
        System.out.println(" ");

        // Make a semi truck
        SemiTruck bigBlue = new SemiTruck(105, 4, 80000,35000,"Freightliner","Class 8","Blue", true);
        System.out.println("Semi Truck:\nHas trailer: "+ bigBlue.getTrailer()+"\nFuel Capacity: "+bigBlue.getFuelCapacity());
        System.out.println(" ");

        // Make a car
        Car daisy = new Car(11, 5, 875,2531, "Toyota", "Prius", "Red", "Compact",false);
        System.out.println("Car:\nIs convertible: "+ daisy.isConvertible()+"\nCar type: "+daisy.getType());
        System.out.println(" ");

        // Make a hovercraft
        Hovercraft flyBoy = new Hovercraft(15, 5, 1000, 4000, "Tesla", "Hovercraft", "Gray", 18);
        System.out.println("Hovercraft:\nColor: "+ flyBoy.getColor()+"\nFeet in the air: "+flyBoy.getYPosition());
    }
}
