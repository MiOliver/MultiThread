package com.oliver.algorithm;

/**
 * Created by ning on 9/5/16.
 */
public class SortUtils {

    /**
     * 插入排序
     * @param array
     */
    public static void insertSort(Integer[] array){
        if(array.length==0){
            return;
        }
        for(int i=1;i<array.length;i++){
            int tem=array[i];
            int j=i-1;
            for(;j>=0&&array[j]>tem;j--){
                array[j+1]=array[j];
            }
            array[j+1]=tem;
        }
        for(int item:array){
            System.out.println(item+",");
        }
    }

    /**
     * 希尔排序
     * @param array
     */
    public static void shellSort(Integer[] array){
        if(array.length==0){
            return;
        }
        int d1=array.length;
        while (true){
            d1=(int)Math.ceil(d1/2);
            int d=d1;
            for(int i=1;i<array.length;i=i+d){
                int tem=array[i];
                int j=i-d;
                for(;j>=0&&array[j]>tem;j=j-d){
                    array[j+d]=array[j];
                }
                array[j+d]=tem;
            }
            if(d==1){
                break;
            }
        }

        for(int item:array){
            System.out.println(item+",");
        }
    }

    /**
     * 选择排序
     * @param array
     */
    public static void selectSort(Integer[] array){
        for(int i=0;i<array.length-1;i++){
            int tem=i;
            int exchange;
            for(int j=i;j<array.length-1;j++){
                if(array[tem]>array[j+1]){
                    tem=j+1;
                }
            }
            exchange=array[tem];
            array[tem]=array[i];
            array[i]=exchange;
        }
        for(int item:array){
            System.out.println(item+",");
        }
    }

    /**
     * 快速排序
     */
    public static void quickSort(Integer[] array){
        if(array.length>0){
            _quickSort(array,0,array.length-1);
        }
    }

    public static void _quickSort(Integer[] array,int low ,int high){
        if(low<high){
            int middle=getMiddle(array,low,high);
            _quickSort(array,0,middle-1);
            _quickSort(array,middle+1,high);
        }
    }

    public static int getMiddle(Integer[] array,int low ,int high){
        int tem=array[low];
        while (low<high){
            if(array[low]<tem){
                    low++;
            }else{
                int exchange=array[low];
                array[low]=array[high];
                array[high]=exchange;
                high--;
            }
        }
        array[low]=tem;
        return low;
    }


    /**
     * 归并排序
     */

    public static void mergingSort(int[] array){
        sort(array,0,array.length-1);
        for(int i=0;i<array.length;i++)
            System.out.println(array[i]);
    }

    public static void sort(int[] data, int left, int right) {
        // TODO Auto-generatedmethod stub
        if(left<right){
            //找出中间索引
            int center=(left+right)/2;
            //对左边数组进行递归
            sort(data,left,center);
            //对右边数组进行递归
            sort(data,center+1,right);
            //合并
            merge(data,left,center,right);
        }

    }

    public static void merge(int[] data, int left, int center, int right) {
        // TODO Auto-generatedmethod stub
        int [] tmpArr=new int[data.length];
        int mid=center+1;
        //third记录中间数组的索引
        int third=left;
        int tmp=left;
        while(left<=center&&mid<=right){
            //从两个数组中取出最小的放入中间数组
            if(data[left]<=data[mid]){
                tmpArr[third++]=data[left++];
            }else{
                tmpArr[third++]=data[mid++];
            }
        }

        //剩余部分依次放入中间数组
        while(mid<=right){
            tmpArr[third++]=data[mid++];
        }

        while(left<=center){
            tmpArr[third++]=data[left++];
        }

        //将中间数组中的内容复制回原数组
        while(tmp<=right){
            data[tmp]=tmpArr[tmp++];
        }

    }







}
