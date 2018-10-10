package project1.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WordReader {

    private BufferedReader inputStream;

    private List<Integer> intArr;

    private char[] charBuffer;

    private int loc ;

    public WordReader(File file, int loc, int bufferSize) throws FileNotFoundException {

        inputStream = new BufferedReader(new FileReader(file));

        charBuffer = new char[bufferSize];

        intArr = new ArrayList<>();

        this.loc = loc;
    }

    public int getLoc() {

        return loc;
    }

    public List<Integer> generateSubList() {

        if (inputStream == null) return null;

        int ch;

        StringBuilder stringBuilder = new StringBuilder();

        try {
            // skip space or tab


            while ((ch = inputStream.read(charBuffer, loc, charBuffer.length)) != -1) {

                boolean flag = false;

                while (ch > -1) {

                    char c = charBuffer[ch--];

                    if (c != ' ' && c != '\t' && c != '\n' && c != '\r') {

                        stringBuilder.append(c);

                        if (flag) {

                            loc += stringBuilder.length();

                            intArr.add(Integer.parseInt(stringBuilder.toString()));

                            stringBuilder.delete(0, stringBuilder.length());

                            flag = false;
                        }

                    } else {

                        loc++;

                        flag = true;
                    }
                }
            }

        } catch (IOException e) {

            e.printStackTrace();
        }

        return intArr;
    }

    public void close() {

    }
}
