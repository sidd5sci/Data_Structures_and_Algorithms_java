package examples;

import java.util.*;
//import com.google.common.collect.Lists;
//import com.google.common.collect.Sets;

public class ListExamples {
    List<String> data = Arrays.asList("ab", "bc", "cd", "ab", "bc", "cd");

    List<String> list = new ArrayList<>(data); // will add data as is
    Set<String> set1 = new HashSet<>(data); // will add data keeping only unique values

    SortedSet<String> set2 = new TreeSet<>(data); // will add data keeping unique values and sorting
    Set<String> set3 = new LinkedHashSet<>(data); // will add data keeping only unique values and preserving the original order

//    Map<String, Object> map1 = new HashMap<>(map);
//    SortedMap<String, Object> map2 = new TreeMap<>(map);


//
//    Apache Commons Collections framework
//
//    Using Apache Commons you can create Map using array in ArrayUtils.toMap as well as MapUtils.toMap:
//
//    Create a Map mapping colors.
//    Map colorMap = MapUtils.toMap(new String[][] {{
//        {"RED", "#FF0000"},
//        {"GREEN", "#00FF00"},
//        {"BLUE", "#0000FF"}});




//
//    Google Guava Collections framework
//
//    List<String> list1 = Lists.newArrayList("ab", "bc", "cd");
//    List<String> list2 = Lists.newArrayList(data);
//    Set<String> set4 = Sets.newHashSet(data);
//    SortedSet<String> set5 = Sets.newTreeSet("bc", "cd", "ab", "bc", "cd");
}






class MyMainClass{

    public static void main(String args[]){

        String data  = "30-Apr-21:Cust_subscription(name=Virat, instance=ad01, subscription=silver package):5&"
                +"25-Apr-21:Cust_subscription(name=Sanju, instance=ad02, subscription=gold package):1&"
                +"30-Apr-21:Cust_subscription(name=Rahul, instance=ad01, subscription=silver package):1&"
                +"26-Apr-21:Cust_subscription(name=Manish, instance=ad03, subscription=silver package):1&";

        String logLines[] = data.split("&",-2);


        List<ReportEntry> reportList = new ArrayList<>();
        for(int i= 0 ;i < logLines.length -1;i++){
            System.out.println(logLines[i]);
            // parssing
            String date = logLines[i].split(":",-2)[0];
            System.out.println(date);
            String subCount = logLines[i].split(":",-2)[2];
            System.out.println(subCount);
            String subscription = logLines[i].split("=",4)[3];
            System.out.println(subscription);

            // storing
//            ReportEntry report = new ReportEntry(date,subscription,subCount);
//            reportList.add(report);
        }
//
//        System.out.println( "| Date | subscription Count| subscription|");
//        for(ReportEntry r : reportList){
//            System.out.println(r.date+" | "+r.subscriptionCount+" | "+r.subscriptionType);
//        }



        Solution s = new Solution();

        int a[] = {5, -2, 3 , 1, 2};
        int b[] = {-533, -666, -500, 169, 724, 478, 358, -38, -536, 705, -855, 281, -173, 961, -509, -5, 942, -173, 436, -609, -396, 902, -847, -708, -618, 421, -284, 718, 895, 447, 726, -229, 538, 869, 912, 667, -701, 35, 894, -297, 811, 322, -667, 673, -336, 141, 711, -747, -132, 547, 644, -338, -243, -963, -141, -277, 741, 529, -222, -684, 35};
        int c[] = {-969, -948, 350, 150, -59, 724, 966, 430, 107, -809, -993, 337, 457, -713, 753, -617, -55, -91, -791, 758, -779, -412, -578, -54, 506, 30, -587, 168, -100, -409, -238, 655, 410, -641, 624, -463, 548, -517, 595, -959, 602, -650, -709, -164, 374, 20, -404, -979, 348, 199, 668, -516, -719, -266, -947, 999, -582, 938, -100, 788, -873, -533, 728, -107, -352, -517, 807, -579, -690, -383, -187, 514, -691, 616, -65, 451, -400, 249, -481, 556, -202, -697, -776, 8, 844, -391, -11, -298, 195, -515, 93, -657, -477, 587};
        System.out.println("SUM >> "+s.solve(c,81));

        Solution1 s = new Solution1();



    }

}



class ReportEntry {

    String date;
    String subscriptionType;
    String subscriptionCount;

    public ReportEntry(String date,String subscriptionType,String subscriptionCount){
        this.date = date;
        this.subscriptionType = subscriptionType;
        this.subscriptionCount = subscriptionCount;
    }

    // setters

    // getters
}




class Solution {
    public int solve(int[] A, int B) {
        if(A.length <0){
            return 0;
        }

        int sum = Integer.MIN_VALUE;
        for(int i =0 ;i<=B;i++){
            int s = pickSum(A,B-i,i);
            if(s > sum )
            {
                sum = s;
            }
        }

        return sum;
    }

    public int pickSum(int[] A,int end,int elementsFromEnd){
        int sum = 0;
        for(int i =0 ;i<end;i++){
            sum += A[i];
        }
        for(int i= A.length-1;i> A.length-elementsFromEnd-1;i--){
            sum += A[i];
        }
        return sum;
    }
}


class Solution1 {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maxSubArray(final List<Integer> A) {
        if(A.size() < 0){
            return 0;
        }
        if(A.size() == 1){
            return A.get(0);
        }

        int sum = Integer.MIN_VALUE;
        for(int i = A.size() ;i>0; i--){
            int s = 0;

            // count possible subarray with length i
            for(int j=0 ; j<= A.size()-i ;j++){
                s =  sumOfInternalArray(A,j,i-j);
            }

            if(s>sum ){
                sum = s;
            }

        }

        return sum;
    }


    public int sumOfInternalArray(List<Integer> A, int start, int end){
        int sum = 0;

        for(int i = start;i < end; i++){
            sum += A.get(i);
        }
        return sum ;
    }

    public int count(List<Integer> A,int n){
        // function to calculate N*(N+1)/2
        return n * (n + 1) / 2;
    }

}

