import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(scanner);
        // Вывод меню.
        while (true)
            try {
                printMenu();
                int userInput = scanner.nextInt();
                // Обработка ввода пользователя.
                switch (userInput) {
                    case 0:
                        scanner.close();
                        System.out.println("Выход");
                        System.exit(0);
                    case 1:
                        stepTracker.kitStepDay();
                        break;
                    case 2:
                        stepTracker.printStatResult();
                        break;
                    case 3:
                        stepTracker.kitStepsObjective();
                        break;
                    default:
                        System.out.println("Такой команды нет.");
                        break;
                }
            }
            catch (InputMismatchException e) {
                System.out.println("Неверный ввод !");
                scanner.next();
            }
    }

    // Метод вывода меню.
    private static void printMenu() {
        System.out.println("Что вы хотите сделать?: ");
        System.out.println("1 - Ввести количество шагов за определённый день.");
        System.out.println("2 - Напечатать статистику за определённый месяц.");
        System.out.println("3 - Изменить цель по количеству шагов в день.");
        System.out.println("0 - Выйти из приложения.");



    }
}