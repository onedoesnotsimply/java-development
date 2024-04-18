public class TestStatistics {
    /*
    Calculates the average, high score and low score of a list of test scores
     */
    static double[] testScores = {85.5,92.3,75.8,78.5,80.0,99.1,87.0,72.1,82.5,68.9};

    public static void main(String[] args) {
        averageCalculator(testScores);
        highestScore(testScores);
        lowestScore(testScores);
    }

    // Average calculator
    public static void averageCalculator(double[] scores){
        // Initialize the sum variable
        double sum = 0;
        for (double score : scores) {
            sum += score;
        }
        // Calculate the average
        double average = (double) sum/scores.length;

        // Print the results
        System.out.println("The average score is: "+average);
    }

    public static void highestScore(double[] scores) {
        double highScore = 0;

        for (double score : scores) {
            if (score > highScore){
                highScore = score;
            }
        }
        System.out.println("The highest score is: "+highScore);
    }

    public static void lowestScore(double[] scores){
        double lowestScore = 100;

        for (double score : scores){
            if (score < lowestScore){
                lowestScore = score;
            }
        }
        System.out.println("The lowers score is: "+lowestScore);
    }
}
