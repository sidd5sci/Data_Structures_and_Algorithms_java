package algorithms.sorting.merge_sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {


    public MergeSort(){

    }

    public List sort1(List<Integer> array){

        if (array.size() == 1) {
            return array;
        }

        List<Integer> left = array.subList(0, array.size() / 2);
        List<Integer> right = array.subList(array.size() / 2, array.size());

        return sort(sort1(left), sort1(right));
    }

    public List sort(List<Integer> array1, List<Integer> array2){
        if(array1.size() <= 0){
            return array2;
        }
        if(array2.size() <= 0){
            return array1;
        }
        List<Integer> mergedList = new ArrayList<Integer>();
        Integer array1Index  = 0;
        Integer array2Index  = 0;

        while( array1Index < array1.size() && array2Index < array2.size()){
//            System.out.println(array1.get(array1Index) +" ---- "+ array2.get(array2Index));
            if(array1.get(array1Index) < array2.get(array2Index)){
                mergedList.add(array1.get(array1Index));
                array1Index++;
            }else{
                mergedList.add(array2.get(array2Index));
                array2Index++;
            }

        }

        List<Integer> leftRemaining = array1.subList(array1Index, array1.size());
        List<Integer> rightRemaining = array2.subList(array2Index, array2.size());

        mergedList.addAll(leftRemaining);
        mergedList.addAll(rightRemaining);

        return mergedList;
    }


    public static void main(String[] args){

        MergeSort sortService = new MergeSort();
        // two arrays should be sorted
//        ArrayList<Integer> array1 = new ArrayList<>(Arrays.asList(63, 87, 283, 4, 0));
//        ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(99, 2, 1, 5));
//
//        System.out.println(sortService.sort(array1,array2));

        // no pre requirements
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0));
        System.out.println(sortService.sort1(numbers));

    }

}
