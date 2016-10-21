package com.oliver.IO;

import java.io.*;

/**
 * Created by ning on 9/9/16.
 */
public class IOTest {

    private FileInputStream fileInputStream;
    private FileReader fileReader;
    private FileOutputStream fileOutputStream;
    private FileWriter filewriter;

    /**
     *
     * @throws IOException
     */
    public void testStream() throws IOException{
        try {
            fileInputStream = new FileInputStream("resources/xanadu.txt");
            fileOutputStream = new FileOutputStream("resources/outagain.txt");
            int c;

            while ((c =fileInputStream.read()) != -1) {
                fileOutputStream.write(c);
            }
        } finally {
            if (fileInputStream!= null) {
                fileInputStream.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
        }
    }

    /**
     * testReader
     * @throws IOException
     */
    public void testReader() throws IOException{
        try {
            fileReader = new FileReader("resources/input.txt");
            filewriter = new FileWriter("resources/output.txt");
            int c;

            while ((c =fileReader.read()) != -1) {
                filewriter.write(c);
            }
        } finally {
            if (fileReader!= null) {
                fileReader.close();
            }
            if (filewriter != null) {
                filewriter.close();
            }
        }
    }


    /**
     *
     * @throws IOException
     */
    public  void testbuffer() throws IOException {
        BufferedReader inputStream = null;
        PrintWriter outputStream = null;

        try {
            inputStream = new BufferedReader(new FileReader("resources/xanadu.txt"));
            outputStream = new PrintWriter(new FileWriter("resources/characteroutput.txt"));

            String l;
            while ((l = inputStream.readLine()) != null) {
                outputStream.println(l);
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }

    
}
