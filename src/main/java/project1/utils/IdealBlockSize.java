package project1.utils;

import java.io.BufferedOutputStream;
import java.io.OutputStream;

class IdealBlockSize {
    // You could alternatively use BufferedInputStream and System.in .
    private static class MyBufferedOS extends BufferedOutputStream {
        MyBufferedOS() { super(System.out); }
      //  public MyBufferedOS(OutputStream out) { super(out); }
        private int bufferSize() { return buf.length; }
    }

    public static int VALUE = new IdealBlockSize.MyBufferedOS().bufferSize();
}