package algorithms.sorting.merge_sort;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {


    public MergeSort(){

    }

    public List sort(List<Integer> array1, List<Integer> array2){
        if(array1.size() <= 0){
            return array2;
        }
        if(array2.size() <= 0){
            return array1;
        }
        List<Integer> mergedList = new ArrayList<Integer>();
        int largeSize = (array1.size() > array2.size())? array1.size():array2.size();

        for(int i = 0; i < largeSize; i++){
//            if()

        }
        // loop  till a1.size || a2.size
            // if a1.get(i) < a2.get(j)
//                    r.push(a1.get(i))//
//                i++
//            else
//                r.push(a2.get(j))
//                    j++
        return null;
    }


    public static void main(String[] args){


    }

}
