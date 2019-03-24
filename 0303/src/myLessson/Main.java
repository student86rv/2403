package myLessson;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String inputString = "dog watch man";
        System.out.println(reverseString(inputString));

        List<Integer[]> listOfArrays = new ArrayList<>();

        Integer[] arr1 = {1,2,3};
        Integer[] arr2 = {2,3,5};
        Integer[] arr3 = {2,7};

        listOfArrays.add(arr1);
        listOfArrays.add(arr2);
        listOfArrays.add(arr3);

        Iterator iterator = new Iterator(listOfArrays);






    }



    public static String reverseString(String inputString) {
        try {
            String[] tmp = inputString.split(" ");
            StringBuilder sb = new StringBuilder();
            for (int i = tmp.length - 1; i >= 0; i--) {
                sb.append(tmp[i] + " ");
            }
            return sb.toString();
        } catch (NullPointerException e) {
            return "Incorrect input";
        }
    }
}
