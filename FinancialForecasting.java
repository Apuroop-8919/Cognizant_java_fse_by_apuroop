public class Main {
    public static double futureValueRecursive(double presentValue, double growthRate, int years) {
        if (years == 0) return presentValue;
        return futureValueRecursive(presentValue, growthRate, years - 1) * (1 + growthRate);
    }

    public static double futureValueIterative(double presentValue, double growthRate, int years) {
        double futureValue = presentValue;
        for (int i = 0; i < years; i++) {
            futureValue *= (1 + growthRate);
        }
        return futureValue;
    }

    public static void main(String[] args) {
        double presentValue = 1000.0;  
        double growthRate = 0.05;      
        int years = 5;

        double fvRecursive = futureValueRecursive(presentValue, growthRate, years);
        double fvIterative = futureValueIterative(presentValue, growthRate, years);

        System.out.printf("Recursive Future Value after %d years: %.2f%n", years, fvRecursive);
        System.out.printf("Iterative Future Value after %d years: %.2f%n", years, fvIterative);
    }
}
