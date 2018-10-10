package project1.buffer;

import java.io.*;
import java.util.Collections;
import java.util.List;

public class Buffer implements Serializable {

    public Buffer(int size){

        this.size = size;
    }

    private int size;

    private List<Integer> buffer;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<Integer> getBuffer() {
        return buffer;
    }

     void setBuffer(List<Integer> buffer) {
        this.buffer = buffer;
    }

    public void sort(){

        Collections.sort(buffer);
    }

    public void reset(){
        size = 0;
    }

}
