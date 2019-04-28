public class Main {
    public static void main2(String[] args) {
        int x = run(10) + 1;
    }

    private static int run(int i){
        return i > 0 ? i + 45 : i * 15 + i;
    }

    public static void main(String[] args) {
        String s = new StringBuffer()
                .append("Hello")
                .append("world")
                .append("!")
                .toString();
    }
}
