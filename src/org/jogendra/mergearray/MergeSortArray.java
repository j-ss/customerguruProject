package org.jogendra.mergearray;

public class MergeSortArray {

  public static void main(String[] args){

    int array1[]={2,5,6,8,9,78};
    int array2[]={3,7,10,89};
    int k=0;
    int i=0;
    int j=0;
    int newArray[]=new int[array1.length+array2.length];
    for(;i<array1.length&&j<array2.length;){
      if(array1[i]<=array2[j]){
        newArray[k]=array1[i];
        i++;
        k++;
      }
      else if(array1[i]>array2[j]){
        newArray[k]=array2[j];
        j++;
        k++;
      }
    }
    if(i!=array1.length){
      while(i<array1.length){
        newArray[k++]=array1[i++];
      }
    }
    if(j!=array2.length){
      while(j<array2.length){
        newArray[k++]=array2[j++];
      }
    }
    System.out.print("Array 1 -");
    for(int element:array1){
      System.out.print(element+" ");
    }
    System.out.print("\nArray 2 -");
    for(int element:array2){
      System.out.print(element+" ");
    }
    System.out.print("\nNew Array -");
    for(int element:newArray){
      System.out.print(element+" ");
    }
  }
}
