package org.example;
import org.example.controller.Controller;

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
                            "3 - Просмотреть остаток игрушек \n" +
                            "Q - выйти");
            String str = iScanner.nextLine();
            if (str.equals("Q")) {
                iScanner.close();
                break;
            } else if (str.equals("1")) {
                Controller.add();
            } else if (str.equals("2")) {
                Controller.play();
            } else if (str.equals("3")) {
                Controller.view();
            }
        }
    }
}