package myLessson;

import java.io.File;

public class Main {

    public static void main(String[] args) {

        int count = 0;
        System.out.println(printFiles("C:/Hillel/RV86/testFile2/testSrc", count));
    }
    private static int printFiles (String startDir, int count) {

        File homeDir = new File(startDir);
        if (homeDir.exists() && homeDir.isDirectory()) {
            File[] files = homeDir.listFiles();
            for (File file: files) {

                if (!file.isDirectory()) {
                    String fileName = file.getName();
                    String nameAndExtension[] = fileName.split(".");

                    if (nameAndExtension.length >1 && nameAndExtension[1].equals("java")) {
                        count++;
                    }
                }

                System.out.println(file.getName());
                printFiles(file.getAbsolutePath(), count);
            }
        }
        return count;
    }
}
