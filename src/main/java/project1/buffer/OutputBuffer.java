package project1.buffer;

import project1.utils.Config;

import java.io.*;

public class OutputBuffer extends Buffer implements Serializable {

    private int current_OutputDocID;

    public OutputBuffer(int size) {

        super(size);

        current_OutputDocID = Config.getAndIncrementOutDocID();
    }

    public void append(int value) {

        try{

            getBuffer().add(value);

            if(getBuffer().size() == super.getSize()){

                writeBufferToFile();

                getBuffer().clear();
            }

        }catch (IOException ex){

            ex.printStackTrace();

        }
    }

    public void writeBufferToFile() throws IOException {

        File file = new File(String.format(Config.fname_format, current_OutputDocID));

        FileWriter fileWriter = new FileWriter(file, true);

        BufferedWriter bf = new BufferedWriter(fileWriter);

        PrintWriter printWriter = new PrintWriter(bf);

        for(Integer i : getBuffer()) {

            printWriter.println(String.format("%d", i));
        }

        printWriter.flush();

        printWriter.close();
    }

    public int getCurrent_OutputDocID() {
        return current_OutputDocID;
    }

    public void startNextFile(){

        super.reset();

        current_OutputDocID = Config.getAndIncrementOutDocID();
    }
}
