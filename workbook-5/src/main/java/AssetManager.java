import com.pluralsight.Asset;
import com.pluralsight.House;
import com.pluralsight.VehicleAsset;

import java.util.ArrayList;

public class AssetManager {
    public static void main(String[] args) {
        ArrayList<Asset> assets = new ArrayList<>();

        House house1 = new House("My house", "05-15-2022", 150000.0,"123 Somewhere Str", 1, 2100, 6000);
        House house2 = new House("My vacation home", "05-02-2024",250000, "345 Somewhere Nice", 2, 950, 10000);

        VehicleAsset vehicle1 = new VehicleAsset("My car", "06-24-2019", 30000, "Honda Civic", 2018, 150000);
        VehicleAsset vehicle2 = new VehicleAsset("Adam's car", "10-31-2017", 25000, "Ford Explorer", 2015, 200000);

        assets.add(house1);
        assets.add(house2);
        assets.add(vehicle1);
        assets.add(vehicle2);

        for (Asset asset : assets) {
            System.out.println(asset.getDescription());
            System.out.println(asset.getDateAquired());
            System.out.println(asset.getOriginalCost());
            System.out.println(asset.getValue());
        }

        for (int i = 0; i < assets.size(); i++){
            if (assets.get(i) instanceof House) {
                System.out.println("My house at : "+((House) assets.get(i)).getAddress());
            } else if (assets.get(i) instanceof VehicleAsset) {
                System.out.println("Vehicle year: "+((VehicleAsset) assets.get(i)).getYear());
                System.out.println("Make & Model "+((VehicleAsset) assets.get(i)).getMakeModel());
            }
        }
    }
}
