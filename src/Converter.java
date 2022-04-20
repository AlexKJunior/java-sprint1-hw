public class Converter {
    private final double STEP_DISTANCE = 0.00075;
    private final double STEP_KILOCALORIES = 0.05;



    // Конвертация шагов в километры(дистанцию).
    public double convertStepToDistance(int fullMonthSteps) {
        return fullMonthSteps * STEP_DISTANCE;
    }

    // Конвертация шагов в килокалории.
    public double convertStepToCalories(int fullMonthSteps) {
        return fullMonthSteps * STEP_KILOCALORIES;
    }
}
