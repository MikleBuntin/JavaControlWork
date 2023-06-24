package org.example.repository;

import org.example.model.Toy;

import java.io.*;
import java.util.ArrayList;

public class Repo {
    static File file = new File("All.txt");

    public Repo() throws FileNotFoundException {
    }

    public static void addToy() {
    }


    public void addToy(Toy toy) {
        try(FileWriter fileWriter = new FileWriter(file, true)){
            fileWriter.write(toy.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void viewAll() {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            while (line != null) {
                System.out.println(line);
                line = bufferedReader.readLine();
            }
            fileReader.close();
        } catch(IOException e){throw new RuntimeException(e);}
        }


    public static Integer getNewID() {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();

            Integer newID = 0;
            Integer id = 0;
            while (line != null) {
                String[] subLine = line.split("ID=");
                id = Integer.parseInt(subLine[1].split(", ")[0]);
                if (id >= newID) {newID = ++id;}
                line = bufferedReader.readLine();
            }
            fileReader.close();
            return newID;
        }
        catch(IOException e){
            throw new RuntimeException(e);
        }
    }

    public static void deleteToy(Integer delID) {
        FileReader fileReader = null;
        try {
            ArrayList<String> stringList = new ArrayList<>();
            fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            Integer id = 0;
            while (line != null) {
                String[] subLine = line.split("ID=");
                id = Integer.parseInt(subLine[1].split(", ")[0]);
                if (id != delID) {stringList.add(line);}
                else {
                    String[] subLine2 = line.split(, "count=");
                    Integer count = Integer.parseInt(subLine2[1].split(";")[0]);
                    String line2 = subLine2[0] + (count - 1) + ";"+ "\n";
                    stringList.add(line2);
                }
                line = bufferedReader.readLine();
            }
            fileReader.close();

            new FileWriter(file, false).close();
            FileWriter fileWriter = new FileWriter(file, true);
                for (String str: stringList) {
                    fileWriter.write(str + '\n');
                }
                fileWriter.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public static Integer getSummOfPercent() {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            Integer summOfPercent = 0;
            while (line != null) {
                String[] subLine = line.split("percent=");
                summOfPercent += Integer.parseInt(subLine[1].split(", ")[0]);
                line = bufferedReader.readLine();
            }
            fileReader.close();
            return summOfPercent;
        }
        catch(IOException e){
            throw new RuntimeException(e);
        }
    }
    public static Integer winToy(Double winNumber) {
        FileReader fileReader = null;
        try {
            Integer id = null;
            fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            Integer summOfPercent = 0;
            while (line != null) {
                String[] subLine1 = line.split("ID=");
                id = Integer.parseInt(subLine1[1].split(", ")[0]);
                String[] subLine2 = line.split("percent=");
                summOfPercent += Integer.parseInt(subLine2[1].split(", ")[0]);
                if (winNumber <= summOfPercent) return id;
                line = bufferedReader.readLine();
            }
            fileReader.close();
        }
        catch(IOException e){
            throw new RuntimeException(e);
        }
    }

}