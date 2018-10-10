package project1.utils;

import project1.buffer.Buffer;

import java.io.File;

public class Phase1 {

    private File file ;

    private int bufferSize = IdealBlockSize.VALUE;

    private WordReader wordReader;



    public Phase1(String fileName) {

        file = new File(fileName);




    }

    void outPut(){


    }

}
