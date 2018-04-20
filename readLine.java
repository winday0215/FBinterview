// return a line of a file with read 4k
class Solution {
public string read() {
        int i = 0;
        string res;
        while (i == 0 || res[i-1] != '/n') {
                if (read_pos >= write_pos) {
                        read_pos = 0;
                        cur = read4k();
                        write_pos = cur.size();
                        if (write_pos == 0) return res;
                }
                res += cur[read_pos++];
                i++;
        }
        return res;
    }
int read_pos = 0, write_pos = 0;
string cur;
}
