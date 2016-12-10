package net.ahramionok;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

/**
 * Created by Kirill on 05.12.2016.
 */
public class Main {
    public static void main(String[] args) {

        Reader cityReader = new Reader("city", args[0]);
        cityReader.start();
        Reader lastNameReader = new Reader("lastname", args[0]);
        lastNameReader.start();
        Reader middleNameReader = new Reader("middlename", args[0]);
        middleNameReader.start();
        Reader nameReader = new Reader("name", args[0]);
        nameReader.start();
        Reader streetReader = new Reader("street", args[0]);
        streetReader.start();

        try {
            cityReader.join();
            lastNameReader.join();
            middleNameReader.join();
            nameReader.join();
            streetReader.join();
        } catch (InterruptedException e) {
            System.out.println("Unable to join thread");
        }
        ArrayList<String> citiesList = cityReader.getCollection();
        ArrayList<String> lastNameList = lastNameReader.getCollection();
        ArrayList<String> middleNameList = middleNameReader.getCollection();
        ArrayList<String> nameList = nameReader.getCollection();
        ArrayList<String> streetList = streetReader.getCollection();

        ArrayList<Person> allPersons = new ArrayList<>();
        ArrayList<PersonGenerator> threads = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            PersonGenerator personGenerator = new PersonGenerator(citiesList, lastNameList, middleNameList,
                    nameList, streetList, Math.round(Integer.valueOf(args[1]) / 8), Double.valueOf(args[2]));
            personGenerator.setRegion1(args[0]);
            personGenerator.start();
            threads.add(personGenerator);
        }

        for (PersonGenerator thread: threads) {
            try {
                thread.join();
                allPersons.addAll(thread.getCollection());
            } catch (InterruptedException e) {
                System.out.println("Unable to join thread");
            }
        }

        for (Person person: allPersons) {
            try {
                BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));
                log.write(person.toString() + "\n");
                log.flush();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
