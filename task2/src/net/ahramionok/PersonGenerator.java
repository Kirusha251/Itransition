package net.ahramionok;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Kirill on 05.12.2016.
 */
public class PersonGenerator extends Thread {
    private ArrayList<Person> collection;
    private ArrayList<String> cities;
    private ArrayList<String> lastnames;
    private ArrayList<String> middlenames;
    private ArrayList<String> names;
    private ArrayList<String> streets;
    private String region1;
    private int size;
    private double mistakes;

    @Override
    public void run() {
        collection = generatePerson(cities, lastnames, middlenames, names, streets, size, mistakes, region1);
    }

    public String getRegion1() {
        return region1;
    }

    public void setRegion1(String region1) {
        this.region1 = region1;
    }

    ArrayList<Person> getCollection() {
        return collection;
    }

    PersonGenerator(ArrayList<String> cities, ArrayList<String> lastnames,
                    ArrayList<String> middlenames, ArrayList<String> names,
                    ArrayList<String> streets, int size, double mistakes) {
        this.cities = cities;
        this.lastnames = lastnames;
        this.middlenames = middlenames;
        this.names = names;
        this.streets = streets;
        this.collection = new ArrayList<>();
        this.size = size;
        this.mistakes = mistakes;
    }

    private ArrayList<Person> generatePerson(ArrayList<String> cities, ArrayList<String> lastnames,
                                             ArrayList<String> middlenames, ArrayList<String> names,
                                             ArrayList<String> streets, int size, double mistakes, String region) {

        ArrayList<Person> tempArrayList = new ArrayList<>();
        double currentMistakesPerField = mistakes / 5;
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            String currentLastName = lastnames.get(random.nextInt(lastnames.size()));
            String currentMiddleName = middlenames.get(random.nextInt(middlenames.size()));
            String currentName = names.get(random.nextInt(names.size()));
            String currentCityName = cities.get(random.nextInt(cities.size()));
            String currentStreet = streets.get(random.nextInt(streets.size()));
            String currentPhoneNumber = String.valueOf(random.nextInt(8000000) + 1000000);

            currentLastName = makeMistake(currentLastName, currentMistakesPerField);
            currentMiddleName = makeMistake(currentMiddleName, currentMistakesPerField);
            currentCityName = makeMistake(currentCityName, currentMistakesPerField);
            currentName = makeMistake(currentName, currentMistakesPerField);
            currentStreet = makeMistake(currentStreet, currentMistakesPerField);
            currentPhoneNumber = makeMistake(currentPhoneNumber, currentMistakesPerField);


            int currentHouse =random.nextInt(100);
            int currentFlat = random.nextInt(100);

            Person person = new Person(currentName, currentLastName, currentMiddleName, currentPhoneNumber
                    , currentCityName, currentStreet, currentHouse, currentFlat);
            person.setRegion(region);
            tempArrayList.add(person);
        }
        return tempArrayList;
    }

    private String makeMistake(String currentString, double mistakes) {
        if(mistakes != 0) {
            final String alphabet = "0123456789ABCDE";
            final int N = alphabet.length();
            //int currentMistakesCount = (int) Math.round(mistakes * currentString.length());
            Random random = new Random();
            String str = currentString;
            if(ThreadLocalRandom.current().nextDouble(0,1)<(mistakes-(int)mistakes)){
                mistakes = mistakes+1;
            }
            for (int i = 0; i < (int)mistakes; i++) {
                switch (ThreadLocalRandom.current().nextInt(3)) {
                    case 0: {

                                str = str.replace(str.charAt(random.nextInt(str.length())), alphabet.charAt(random.nextInt(N)));
                    } break;
                    case 1: {
                            str = str + String.valueOf(alphabet.charAt(random.nextInt(N)));
                    } break;
                    case 2: {
                        if(str.length()==1) {
                            str.replace(str.charAt(random.nextInt(str.length())), ' ');
                        }
                        else{
                            StringBuilder sb = new StringBuilder(str);
                            sb.deleteCharAt(random.nextInt(sb.length()));
                            str = sb.toString();
                        }
                    } break;
                }
            }
            return str;
        } else {
            return currentString;
        }
    }

}
