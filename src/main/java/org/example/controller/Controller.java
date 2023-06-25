package org.example.controller;

import org.example.model.Toy;
import org.example.repository.Repo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import static java.lang.Math.random;


public class Controller {
    public static void add() throws IOException {
        Integer id = Repo.getNewID();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название:");
        String name = scanner.nextLine();
        System.out.println("Введите процент выпадения:");
        Integer percent = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите количество игрушек:");
        Integer count = Integer.parseInt(scanner.nextLine());
        Repo.addToy(new Toy(id, name, percent, count));
    }

    public static void play() {
        Integer summOfPercent = Repo.getSummOfPercent();
        Double winNumber = random()*(summOfPercent + 1);
        Repo.deleteToy(Repo.winToy(winNumber));

    }

    public static void view() {
        Repo.view();
    }
}
