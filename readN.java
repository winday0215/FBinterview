/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    char[] buffer = new char[4];
    int head = 0, tail = 0;
    
    private boolean readToBuffer(char[] buf, int index) {
        if (head == tail) {
            tail = read4(buffer);
            head = 0;
            if (tail == 0) {
                return false;
            }
        }
        buf[index] = buffer[head++];
        return true;
    }
    public int read(char[] buf, int n) {
        for (int i = 0; i < n; i++) {
            if (!readToBuffer(buf, i)) {
                return i;
            }
        }
        return n;
    }
}
