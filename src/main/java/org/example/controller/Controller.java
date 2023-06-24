import org.example.repository.Repo;

import java.io.FileNotFoundException;
import java.io.IOException;

import static java.lang.Math.random;


public class Controller {
    private static UserService userService = new UserService();
    private static MoneyService moneyService = new MoneyService();

    public void add() throws IOException {
    Repo.addToy();
    }

    public void addUser() throws FileNotFoundException {
        userService.addUser();
    }

    public static void deleteUser() throws FileNotFoundException {
        userService.deleteUser();
    }

    public static void getCheck() {
        moneyService.getCheck();
    }

    public static void enrollment() {
        moneyService.enrollment();
    }
    public static void consumption() {
        moneyService.consumption();
    }


    public void play() {
        Integer summOfPercent = Repo.getSummOfPercent();
        Double winNumber = random()*(summOfPercent + 1);
        Repo.deleteToy(Repo.winToy(winNumber));

    }
}
