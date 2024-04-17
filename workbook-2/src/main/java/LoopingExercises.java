public class LoopingExercises {
    static int iterator = 0;

    public static void main(String[] args) throws InterruptedException {
        whileLoops();
        System.out.println(" ");
        doWhileLoops();
        System.out.println(" ");
        forLoops();
    }

    public static void whileLoops() {
        while (iterator < 5){
            System.out.println("I love Java");
            iterator++;
        }
    }

    public static void doWhileLoops() {
        do {
            System.out.println("I love Java");
            iterator--;
        }
        while (iterator>0);
    }

    public static void forLoops() throws InterruptedException {
        for (int i=10; i>0; i--){
            System.out.println(i);
            Thread.sleep(1000);
        }
        System.out.println("Launch!");
    }
}
