package myLessson;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {

    private static final int BUFFER_SIZE = 4096;

    public static void main(String[] args) {
//        String userDir = System.getProperty("user.dir");
//        File homeDir = new File(userDir);
//        System.out.println(homeDir);
//
//        if (homeDir.exists() && homeDir.isDirectory()) {
//            File[] files = homeDir.listFiles();
//            for (File file: files) {
//                System.out.println(file.getName());
//            }
//        }
        printFiles(System.getProperty("user.dir"));
    }

    private static void printFiles (String startDir) {
        File homeDir = new File(startDir);
        if (homeDir.exists() && homeDir.isDirectory()) {
            File[] files = homeDir.listFiles();
            for (File file: files) {
                System.out.println(file.getName());
                printFiles(file.getAbsolutePath());
            }
        }
    }

    public static void downloadFile(String fileURL, String saveDir) throws IOException {
        URL url = new URL(fileURL);
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
        int responseCode = httpConn.getResponseCode();

        // always check HTTP response code first
        if (responseCode == HttpURLConnection.HTTP_OK) {
            String fileName = fileURL.substring(fileURL.lastIndexOf("/") + 1, fileURL.length());
            String contentType = httpConn.getContentType();
            int contentLength = httpConn.getContentLength();

            System.out.println("Content-Type = " + contentType);
            System.out.println("Content-Length = " + contentLength);
            System.out.println("fileName = " + fileName);

            // opens input stream from the HTTP connection
            InputStream inputStream = httpConn.getInputStream();
            String saveFilePath = saveDir + File.separator + fileName;

            // opens an output stream to save into file
            FileOutputStream outputStream = new FileOutputStream(saveFilePath);

            int bytesRead = -1;
            byte[] buffer = new byte[BUFFER_SIZE];
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            outputStream.close();
            inputStream.close();

            System.out.println("File downloaded");
        } else {
            System.out.println("No file to download. Server replied HTTP code: " + responseCode);
        }
        httpConn.disconnect();
    }
}
