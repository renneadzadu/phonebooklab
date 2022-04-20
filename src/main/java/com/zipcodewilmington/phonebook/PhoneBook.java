package com.zipcodewilmington.phonebook;

import java.util.*;
//import java.util.HashMap;


/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {
    private final Map<String, List<String>> phonebook;


    public PhoneBook(Map<String, List<String>> phonebook) {
        this.phonebook = phonebook;
    }

    public PhoneBook() {
        phonebook = new HashMap<>();
    }

    public void add(String name, String phoneNumber) {
        ArrayList<String> number = new ArrayList<>(Arrays.asList(phoneNumber));
        phonebook.put(name,number);
    }

    public void addAll(String name, String... phoneNumbers) {
        ArrayList<String> number = new ArrayList<>();
        number.addAll(Arrays.asList(phoneNumbers));
        phonebook.put(name, number);
    }

    public void remove(String name) {
        phonebook.remove(name);
    }

    public Boolean hasEntry(String name) {
        boolean x = false;
        if(phonebook.containsKey(name)){
            x = true;
        }
        return x;
    }

    public List<String> lookup(String name) {

        return phonebook.get(name);
    }

    public String reverseLookup(String phoneNumber)  {

        List<List<String>> numbers = new ArrayList<List<String>>(phonebook.values());
        ArrayList<String> number = new ArrayList<>(Arrays.asList(phoneNumber));
        Integer x = numbers.indexOf(number);
        String[] names = phonebook.keySet().toArray(new String[phonebook.size()]);
        return names[x];
    }

    public List<String> getAllContactNames() {
        ArrayList<String> names = new ArrayList<>();
        for (String x : phonebook.keySet()){
            names.add(x);
        }
        return names;
    }

    public Map<String, List<String>> getMap() {
        return phonebook;
    }
}
