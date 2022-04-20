import java.util.Scanner;

public class StepTracker {
    // Создаем переменную типа Scanner.
    private final Scanner scanner;
    // Заданная цель по количеству шагов.
    private int objectiveSteps = 10000;
    // Двухмерный массив.
    private final int[][] monthToData = new int[12][30];
    // Создаем объект класса Converter.
    private final Converter converter = new Converter();
    // Объявляем переменную для количества дней в месяце.
    private final int daySum = monthToData[0].length;
    // Объявляем конструктор StepTracker.
    public StepTracker(Scanner scanner){
        this.scanner = scanner;
    }
    //Вычисление количества шагов за день.
    public void kitStepDay(){
        int steps;
        int month;
        int day;
        do {
            System.out.println("Введите месяц: ");
            month = scanner.nextInt();
        }while (month < 1 || month > 12);
        do {
            System.out.println("Введите день: ");
            day = scanner.nextInt();
        }while (day < 1 || day > 30);
        do {
            System.out.println("Введите количество пройденных шагов:");
            steps = scanner.nextInt();
        }while (steps < 0 || steps > 90000);
        monthToData[month - 1][day - 1] = steps;
    }

    // Считывание месяца который ввёл пользователь.
    public int readMonth(){
        int statMonth;
        do {
            System.out.println("Введите месяц: ");
            statMonth = scanner.nextInt();
        }while (statMonth < 1 || statMonth > 12);
        return statMonth;
    }

    // Расчет количества пройденных шагов за месяц.
    public int findStepCount(int statMonth) {
        int fullMonthSteps =0;
        for (int day = 0; day < daySum; day++) {
            fullMonthSteps += monthToData[statMonth - 1][day];
        }
        return fullMonthSteps;
    }

    // Вывод количества шагов пройденных за день.
    public void printDayData(int statMonth, int fullMonthSteps) {
        System.out.print(" Статистика за : " + statMonth + " месяц.");
        System.out.println();
        for (int day = 0; day < daySum; day++) {
            if (day < daySum - 1) {
                System.out.print(" " + (day + 1) + "-й День : " + monthToData[statMonth - 1][day] + ",");
            } else {
                System.out.print(" " + (day + 1) + "-й День : " + monthToData[statMonth - 1][day]);
                System.out.println();
            }
        }
        System.out.print(" Общее количество шагов за месяц : " + fullMonthSteps);
        System.out.println();

    }

    // Расчет показателей за месяц.
    public void findStepCountData(int fullMonthSteps){
        System.out.print(" Среднее количество шагов за месяц : " + fullMonthSteps / daySum);
        System.out.println();
        System.out.print(" Пройденная дистанция : " + converter.convertStepToDistance(fullMonthSteps) + " км.");
        System.out.println();
        System.out.print(" Количество сожжённых килокалорий : "
                + converter.convertStepToCalories(fullMonthSteps) + " ккал.");
        System.out.println();
    }

    //Максимальное количество пройденных шагов за 1 день в месяце.
    public void findMaxMonthSteps(int statMonth) {
        int maxMonthSteps = 0;
        for (int day = 0; day < daySum; day++) {
            if (maxMonthSteps < monthToData[statMonth - 1][day]) {
                maxMonthSteps = monthToData[statMonth - 1][day];
            }
        }
        System.out.print(" Максимальное количество шагов за месяц : " + maxMonthSteps);
        System.out.println();
    }

    //  Расчет лучшей серии.
    public void findBestMonthSeries(int statMonth) {
        int countBest = 0;
        int bestSeries = 0;
        for (int day = 0; day < daySum; day++) {
            if (monthToData[statMonth- 1][day] >= objectiveSteps) {
                bestSeries++;
                if (countBest < bestSeries) {
                    countBest = bestSeries;
                }
            } else {
                bestSeries = 0;
            }
        }
        System.out.print(" Лучшая серия : " + countBest);
        System.out.println();
    }

    // Вывод статистики.
    public void  printStatResult() {
        int statMonth = readMonth();
        int fullMonthSteps = findStepCount(statMonth);
        printDayData(statMonth, fullMonthSteps);
        findMaxMonthSteps(statMonth);
        findStepCountData(fullMonthSteps);
        findBestMonthSeries(statMonth);
    }

    // Новая цель по количеству шагов.
    public void kitStepsObjective(){
        do {
            System.out.println("Текущая цель по количеству шагов : " + objectiveSteps);
            System.out.println("Введите новое значение: ");
            objectiveSteps = scanner.nextInt();
        }while (objectiveSteps <= 0);
        System.out.println("Новая цель по количеству шагов " + objectiveSteps + "!");
    }
}