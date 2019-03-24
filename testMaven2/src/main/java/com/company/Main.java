package com.company;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        /*User user = new User("Alex", 20);
        User user1 = new User("Vova", 25);

        Group group = new Group();
        group.add(user);
        group.add(user1);*/

//        User user = new User("Alex", 22);
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        String json = gson.toJson(user);
//        System.out.println(json);
//        writeTofile(json, "test_file.txt");
        /*String newGroup = readFromFile("group1.xml");
        System.out.println(newGroup);*/
		
		Group group1 = xmlToObject(readFromFile("group1.xml"));
		writeToFile(objectToJson(group2), group1.json);	
    }
	
	public static Group xmlToObject(String xmlString) {
		XmlMapper xmlMapper = new XmlMapper();
		return xmlMapper.readValue(xmlString, Group.class);
	}
	
	public static String objectToJson(Object object) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(user);
	}

/*
	public static void objectToXml(Object object) {
		try {
			XmlMapper xmlMapper = new XmlMapper();
            xmlMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
            String xml = xmlMapper.writeValueAsString(group);
            writeToFile(xml, "group.xml");
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
	}*/
	
    public static void writeToFile(String string, String fileName) {
        try {
            FileUtils.writeStringToFile(
                    new File(fileName),
                    string,
                    "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readFromFile(String fileName) {
        String string = "";
        try {
            string = FileUtils.readFileToString(new File(fileName), "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return string;
    }
}
