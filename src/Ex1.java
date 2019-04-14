import java.util.Scanner;

public class Ex1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        extragereData(input);
    }


    public static void verificareNrEgale() {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = s.nextInt();
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] == a[i]) {
                    System.out.println(a[i]);
                }
            }

        }

    }


    public static String showExtension(String a) {
//        return a.split("\\.")[1].toLowerCase();

        String[] m = a.split("\\.");
        String ext = m[1];
        String extensieToLowerCase = ext.toLowerCase();
        return extensieToLowerCase;
    }

    public static void extrageCuSubstring(String a) {
        Integer myYear = Integer.valueOf(a.substring(0, 4));
        Integer myMonth = Integer.valueOf(a.substring(4, 6));
        Integer myDay = Integer.valueOf(a.substring(6, 8));
        System.out.println("year: " + myYear);
        System.out.println("month: " + myMonth);
        System.out.println("day: " + myDay);
    }

    public static void extreageCuSplitDePunct(String a) {
        String[] m = a.split("\\.");
        Integer myYear = Integer.valueOf(m[0]);
        Integer myMonth = Integer.valueOf(m[1]);
        Integer myDay = Integer.valueOf(m[2]);
        System.out.println("year: " + myYear);
        System.out.println("month: " + myMonth);
        System.out.println("day: " + myDay);
    }

    public static void extragereCuSplitDeSlash(String data) {
        String[] j = data.split("/");
        Integer myYear = Integer.valueOf(j[0]);
        Integer myMonth = Integer.valueOf(j[1]);
        Integer myDay = Integer.valueOf(j[2]);
        System.out.println("year: " + myYear);
        System.out.println("month: " + myMonth);
        System.out.println("day: " + myDay);
    }

    public static void extragereData(String input) {
        if (!input.contains(".") && !input.contains("/")) {
            extrageCuSubstring(input);
        }

        if (input.contains("/")) {
            extragereCuSplitDeSlash(input);
        }

        if (input.contains(".")) {
            extreageCuSplitDePunct(input);
        }


    }
}
