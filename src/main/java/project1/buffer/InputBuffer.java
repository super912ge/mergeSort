package project1.buffer;

import project1.utils.WordReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class InputBuffer extends Buffer {

    private int index = 0;

    private WordReader wordReader;

    private int endLoc;

    public InputBuffer(int size, File file, int loc) throws FileNotFoundException {

        super(size);

        wordReader = new WordReader(file,loc, size);

    }

    public void setBufferedReader(WordReader wordReader) throws IOException {

        this.wordReader = wordReader;
    }

    public boolean isReady(){

        return wordReader != null;
    }

    public void fillBuffer() {

        super.setBuffer(wordReader.generateSubList()) ;

        this.endLoc = wordReader.getLoc();

    }

    public void reset(){

        super.reset();

        index = 0;
    }

    public void closeBufferedReader() {

        if(this.wordReader != null) this.wordReader.close();
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getEndLoc() {

        return endLoc;
    }
}
