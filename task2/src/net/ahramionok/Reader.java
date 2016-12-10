package net.ahramionok;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Kirill on 05.12.2016.
 */
public class Reader extends Thread {
    private ArrayList<String> collection;
    private String criteria;
    private String region;

    Reader(String criteria, String region) {
        this.criteria = criteria;
        this.region = region;
        this.collection = new ArrayList<>();
    }

    @Override
    public void run() {
        collection = readInfo(criteria, region);
    }

    private static boolean flag = false;

    private static ArrayList<String> readInfo(String type, String region) {
        ArrayList<String> info = new ArrayList<>();
        switch (type) {
            case "city": {
                File file = new File("../presets" + File.separator + region.toLowerCase() +
                        File.separator + "city.txt");
                info = readFromFile(file);
            } break;
            case "lastname": {
                File file = new File("../presets" + File.separator + region.toLowerCase() +
                        File.separator + "lastnames.txt");
                info = readFromFile(file);
            } break;
            case "middlename": {
                File file = new File("../presets" + File.separator + region.toLowerCase() +
                        File.separator + "middlenames.txt");
                info = readFromFile(file);
            } break;
            case "name": {
                File file = new File("../presets" + File.separator + region.toLowerCase() +
                        File.separator + "names.txt");
                info = readFromFile(file);
            } break;
            case "street": {
                File file = new File("../presets" + File.separator + region.toLowerCase() +
                        File.separator + "streets.txt");
                flag = true;
                info = readFromFile(file);
            } break;
        }
        return info;
    }

    // used to get all string from file
    private static ArrayList<String> readFromFile(File file) {
        ArrayList<String> container = new ArrayList<>();
        file.getName();
        try {
            if (file.getName().equals("streets.txt")) {
                String data;
                Integer currentIndex = 200000;
                FileInputStream fis = new FileInputStream(file);
                InputStreamReader isr = new InputStreamReader(fis, "windows-1251");
                BufferedReader bufferedReader = new BufferedReader(isr);
                while ((data = bufferedReader.readLine()) != null) {
                    container.add(currentIndex.toString() + "; " + data);
                    currentIndex++;
                }
                flag = false;
                return container;
            } else {
                String data;
                FileInputStream fis = new FileInputStream(file);
                InputStreamReader isr = new InputStreamReader(fis, "windows-1251");
                BufferedReader bufferedReader = new BufferedReader(isr);
                while ((data = bufferedReader.readLine()) != null) {
                    container.add(data);
                }
                return container;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    ArrayList<String> getCollection() {
        return collection;
    }
}
