package com.pluralsight;

public class PracticeOperations
{
    private String part1;
    private String part2;
    private String part3;

    private double num1;
    private double num2;
    private double num3;

    public PracticeOperations(String part1, String part2, String part3, double num1, double num2, double num3){
        this.part1 = part1;
        this.part2 = part2;
        this.part3 = part3;
        this.num1 = num1;
        this.num2 = num2;
        this.num3 = num3;
        calculate();
    }

    private void calculate() {
        // Concat strings
        String concatString = (part1+part2+part3);
        System.out.println(concatString);

        double addNum = (num1+num2) + num3;
        System.out.println("Addition results: " + addNum);

        double subNum = (num1-num2) - num3;
        System.out.println("Subtraction results: " + subNum);

        double mulNum = (num1*num2) * num3;
        System.out.println("Multiplication results: " + mulNum);

        double divNum = (num1/num2) / num3;
        System.out.println("Div results: " + divNum);

        double divNumWithAddition = (((divNum+10)+100)+1000);
        System.out.println("Accumulation result: " + divNumWithAddition);
    }

    public static void main(String[] args) {
        PracticeOperations practice = new PracticeOperations("This ", "is a", " string!",2.52,9.88,7.21);
    }
}
