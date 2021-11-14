import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

class Main {
    static Deque<Integer> mainStack = new ArrayDeque<>();
    static Deque<Integer> maxStack = new ArrayDeque<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();

        while (i >= 0) {
            String s = sc.nextLine();
            if (s.split(" ").length > 1) {
                pushV(Integer.parseInt(s.split(" ")[1]));
            }
            if ("pop".equals(s)) {
                popV();
            }
            if ("max".equals(s)) {
                System.out.print("\n" + getMax());
            }
            i--;
        }
    }

    public static void pushV(int el) {
        mainStack.push(el);
        if (mainStack.size() == 1) {
            maxStack.push(el);
            return;
        }

        if (el > maxStack.peek()) {
            maxStack.push(el);
        } else {
            maxStack.push(maxStack.peek());
        }
    }

    public static void popV() {
        mainStack.pop();
        maxStack.pop();
    }

    public static int getMax() {
        return maxStack.peek();
    }
}