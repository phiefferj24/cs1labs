public class Add {
    public static long addAll(int x) {
        long y = 0;
        for(int i = 1; i < x + 1; i++) y += i;
        return y;
    }
}
