import java.util.ArrayList;
import java.util.List;
public class RK {
    // prime number
    private static long q = 36028797018963913L;

    public static <E> int subsequence(List<E> whole, List<E> part) {
        int n = whole.size();
        int m = part.size();
        long h = 1;               //calculate the indicator of the displaced letter
        for (int k = 1; k < m; k++) {
            h <<= 8;
            h %= q;
        }

        long p = 0;     // indicator of subsequence
        long t = 0;     // changed indicator on path of main list
        for (int k = 0; k < m; k++) {
            p = ((p << 8) | (part.get(k)).hashCode() % q);
            t = ((t << 8) | (whole.get(k)).hashCode() % q);
        }

        extLoop:
        for (int i = 0; i <= n-m; i++) {
            if (p == t) {
                // if indicators are euals check it
                for (int j = 0; j < m; j++) {
                    if (whole.get(i + j) != part.get(j)) {
                        // not coincide => continue search
                        continue extLoop;
                    }
                }
                // we found it!
                return i;
            } else if (i < n-m) {
                // shift list
                t = (((t - h * (whole.get(i)).hashCode()) << 8) | (whole.get(i+m)).hashCode() % q);
            }
        }
        return -1;
    }
    public static void main(String[] args) {


        List<Integer> whole = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            whole.add(i);
        }
        List<Integer> part = new ArrayList<>();
        for (int i = 4; i < 7; i++) {
            part.add(i);
        }

        int ndx = subsequence(whole, part);
            if (ndx >= 0) {
                System.out.println("Index of subseqence begining: " + ndx);
            } else {
                System.out.println("Cant found");
            }
        }
    }
