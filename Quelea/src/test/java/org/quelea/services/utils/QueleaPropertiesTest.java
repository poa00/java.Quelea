package org.quelea.services.utils;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class QueleaPropertiesTest {

    @Test
    // check whether properties file is sorted
    public void testIfPropertiesFileIsSorted() throws FileNotFoundException {
        // init properties
        QueleaProperties.init("");
        // trigger a properties write
        QueleaProperties.get().setCheckUpdate(true);
        // read the properties file
        Scanner scanner = new Scanner(new File(QueleaProperties.get().getQueleaUserHome(), "quelea.properties"));
        ArrayList<String> propertyKeys = new ArrayList<>();
        // read all property keys
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            if(line.charAt(0) != '#') {
                propertyKeys.add(line.split("=")[0]);
            }
        }
        // make a copy of key properties
        ArrayList<String> propertyKeysSorted = new ArrayList<>(propertyKeys);
        // sort the copy
        Collections.sort(propertyKeysSorted);
        // If both are equal then keys were already in sorted order
        Assert.assertEquals(propertyKeys, propertyKeysSorted);
    }

}
