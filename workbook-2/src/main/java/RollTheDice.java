

public class RollTheDice {
    /*
    Rolls a pair of dice 20 times, displaying the results and counting
    the amount of times that 2, 4, 6 and 7 are rolled.
    */

    // Create the Dice class
    public static class Dice {
        // Create the roll method
        public int roll() {
            return (int) (Math.random() * 6) + 1;
        }
    }

    public static void main(String[] args) {
        // Create an instance of Dice
        Dice dice = new Dice();

        // Initialize roll and counter variables
        int roll1;
        int roll2;
        int counter2=0;
        int counter4=0;
        int counter6=0;
        int counter7=0;

        // Roll the dice 20 times
        for (int i = 0; i < 20; i++){
            // Roll both of the dice
            roll1 = dice.roll();
            roll2 = dice.roll();

            // Count the amount of times 2, 4, 6 and 7 appeared
            int rollTotal = roll1+roll2;

            switch (rollTotal){
                case 2:
                    counter2++;
                    break;
                case 4:
                    counter4++;
                    break;
                case 6:
                    counter6++;
                    break;
                case 7:
                    counter7++;
                    break;
            }
            // Output the results of the roll
            System.out.printf("Roll %d: %d - %d Sum: %d", i+1, roll1,roll2, rollTotal);
            System.out.println(" ");
        }
        System.out.println("2 was rolled "+counter2+" times");
        System.out.println("4 was rolled "+counter4+" times");
        System.out.println("6 was rolled "+counter6+" times");
        System.out.println("7 was rolled "+counter7+" times");

    }



}
