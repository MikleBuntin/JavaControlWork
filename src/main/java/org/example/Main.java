package org.example;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Добрый день!");
        Scanner iScanner = new Scanner(System.in);
        while (true) {
            System.out.println("Доступные операции:");
            System.out.println(
                    "1 - Добавить игрушки; \n" +
                            "2 - Играть \n" +
                            "Q - выйти");
            String str = iScanner.nextLine();
            if (str.equals("Q")) {
                iScanner.close();
                break;
            } else if (str.equals("1")) {
                Controller.add();

            } else if (str.equals("2")) {
                userController.addUser();
            }
            else if (str.equals("3")) Controller.deleteUser();
            else if (str.equals("4")) Controller.getCheck();
            else if (str.equals("5")) Controller.enrollment();
            else if (str.equals("6")) Controller.consumption();
        }
    }

}}