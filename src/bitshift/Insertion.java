package bitshift;

public class Insertion {

    int updateBits(int n, int m, int i, int j) {
        int allOnes = ~0;
        int left = allOnes << (j + 1);
        int right = (1 << i) - 1;

        int mask = left | right;
        int nCleared = n & mask;
        int mShifted = m << i;
        return nCleared | mShifted;
    }
}
