import java.util.*;

public class CodeChef {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


        /** SOl 1 starts ***/
        int pencils = 0;
        int pens = 0;
        int pencilCp = 0;
        int penCp = 0;
        /*while(scanner.hasNextInt()) {
            pencils = scanner.nextInt();
            pens = scanner.nextInt();
            pencilCp = scanner.nextInt();
            penCp = scanner.nextInt();
        }

        int totalAmountSpent = (pencils*pencilCp) + (pens*penCp);

        System.out.println(totalAmountSpent);*/

        /** SOl 1 starts ends **/

        /*** sol2 starts here **/
        // findMultiples();
        /*** sol2 ends here **/


        /*** find all factors starts here **/
       // findFactors();
        /*** find all factors ends here **/


        /*** reverse a number starts here **/
        // reverseNumber();
        /*** reverse a number  ends here **/


        /** Lapindrome starts here **/
       // lapindromes_sol1();

        // solution 2
         // lapindromes_sol2();

        /** Lapindrone ends here **/



        /** smart phone starts here**/
      //  smartPhones();
        /** smart phone end shere **/


        carvans();
    }

    private static void smartPhones() {
       // long[] arr = new long[]{30,20,50,14};
        List<Long> arr = new ArrayList<>();
       // long temp;
//        for(int i =0 ; i <arr.length; i++) {
//            for (int j = 1; j < arr.length - i; j++) {
//                if (arr[j - 1] > arr[j]) {
//                    temp = arr[j - 1];
//                    arr[j - 1] = arr[j];
//                    arr[j] = temp;
//                }
//            }
//        }

        int total = scanner.nextInt();
        while(total-->0){
            arr.add(scanner.nextLong());
        }

        Collections.sort(arr);
        int currentCount = arr.size();
        long currentRev = arr.get(0)* arr.size();

        for(int k = 1 ;k < arr.size(); k++) {
            long nextRev = 0;
            currentCount = currentCount-1;
            if(currentCount > 0) {
                nextRev = arr.get(k) * currentCount;
            }
            if(nextRev > currentRev) {
                currentRev = nextRev;
            }


        }
        System.out.println(currentRev);

    }

    private static void lapindromes_sol2() {
        String s = "gaga"; //gaga // abcddbca // rotor
        String out = "NO";
        boolean isOdd = s.length() %2 != 0 ? true : false;
        int loopIndex = isOdd ? s.length()/2+1 : s.length()/2;
        String s1 = s.substring(0,s.length()/2);
        String s2 = s.substring(loopIndex);
        Map<Character, Integer> mp1 = new HashMap<>();
        Map<Character, Integer> mp2 = new HashMap<>();
        for(int i = 0;i <s1.length(); i++){

            if(mp1.containsKey(s1.charAt(i))) {
               int count = mp1.get(s1.charAt(i));
               mp1.put(s1.charAt(i), count+1);
            } else {
                mp1.put(s1.charAt(i), 1);
            }
        }

        for(int j = 0; j <s2.length(); j++) {
            if(mp2.containsKey(s2.charAt(j))) {
                int count = mp2.get(s2.charAt(j));
                mp2.put(s2.charAt(j), count+1);
            } else {
                mp2.put(s2.charAt(j), 1);
            }
        }

        if(mp1.equals(mp2)) {
            out = "YES";
        }
        System.out.println(out);
    }

    private static void lapindromes_sol1() {
        String s = "aaaa"; //gaga // abcddbca // rotor
        char[] chars = s.toCharArray();
        boolean isOdd = chars.length % 2 !=0;
        int midIndex = chars.length/2;
        int loopIndex =  isOdd ? midIndex +1 : midIndex;
        int matchFoundCounter = 0;
        String out = "NO";
        for(int i = 0 ; i < midIndex ; i++) {
            for(int j = chars.length-1; j >= loopIndex; j--) {

                if(chars[i] == chars[j]) {
                    matchFoundCounter ++;
                }
            }
        }
        if(matchFoundCounter == s.length() && matchFoundCounter/2 == midIndex) {
            out = "YES";
        }
        else if(midIndex == matchFoundCounter) {
            out = "YES";
        }

        System.out.println(out);
    }

    private static void reverseNumber() {
        int  num = 1234;
        int reverse = 0;

        while(num > 0) {
            int remainder = num % 10; // 3
            reverse = reverse * 10 + remainder; // 0 *4 + 4
            num = num/10;

        }

        System.out.println(reverse);
    }

    private static void findFactors() {
        int n;
        List<Integer> list  = new ArrayList<>();
        List<Integer> list2  = new ArrayList<>();
        n = scanner.nextInt();

        for( int i = 1; i <= Math.sqrt(n) ; i++) {
            if(n % i == 0) {
                if( n/i == i) {
                    list2.add(i);
                } else {
                   // System.out.printf("%d " , i);
                    list2.add(i);
                    list.add(n / i);

                }
                //System.out.printf("%d ",i);
            }
        }
        System.out.println(list.size() + list2.size());
        for(int j = 0; j < list2.size(); j++) {
            System.out.printf("%d ", list2.get(j));
        }
        for(int j = list.size()-1; j >= 0; j--) {
            System.out.printf("%d ", list.get(j));
        }
    }

    private static void findMultiples() {
        int n;
        String result = "";

        n = scanner.nextInt();


        if(n % 5 != 0 && n % 11 != 0) {
            result = "NONE";
        } else if (n % 55 == 0) {
            result = "BOTH";
        } else  {
            result = "ONE";
        }

        System.out.println(result);
    }


    static void palin_modified(String str) {
        char[] chars = str.toCharArray();
        boolean success = true;
        String out = "NO";
        for(int i = 0, j = chars.length - 1; i < j; i++, j-- ) {
            System.out.println("Debug: i = " + chars[i] + ", j =" + chars[j] );
            success = success && chars[i] == chars[j];
        }
        if(success){
            out = "YES";
        }
        System.out.println(out);
    }


    static void carvans() {
       int[] speeds = new int[]{4,5,1,2,3};

        int max_speed = speeds[0];
        int numOfCars = 1;
        for(int i = 1; i < speeds.length;i++) {
            if(max_speed >= speeds[i] ) {
                max_speed = speeds[i];
                numOfCars++;
            }


        }
        System.out.println(numOfCars);
//        int numOfCases = scanner.nextInt();
//
//        while(numOfCases --> 0) {
//            int ipNUmCars = scanner.nextInt();
//            int[] speeds = new int[ipNUmCars];
//            for(int k = 0; k <ipNUmCars;k++) {
//                speeds[k] = scanner.nextInt();
//            }
//            int max_speed = speeds[0];
//            int numOfCars = 1;
//            for(int i = 1; i < speeds.length;i++) {
//                if(max_speed > speeds[i] ) {
//                    numOfCars++;
//                }
//                max_speed = speeds[i];
//
//            }
//            System.out.println(numOfCars);
//
//        }

    }

}

