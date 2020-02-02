package bitshift;

public class UsefulBitShiftOps {
    boolean getBit(int num, int i) {
        return (num & (1 << i)) != 0;
    }
}
