package 常用算法与数据结构.排序与搜索;

import java.util.Arrays;

public class Sort {

    public void sort_by_java(int[] nums){
        //升序
        Arrays.sort(nums);

        //指定位置升序
        int start = 0;
        int end = nums.length-1;
        Arrays.sort(nums,start,end);

        //降序
        Integer[] nums1 = new Integer[]{1,2,3};
        Arrays.sort(nums1,(o1,o2)->o2-o1);
        return;
    }

    public void swap(int[] num,int i,int j){
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
        return;
    }
    //归并排序 时间复杂度O(nlog2n) 空间复杂度O(n)
    public int[] 归并(int[] num){
        if(num.length<2) return num;
        int mid = num.length/2;
        int[] left = Arrays.copyOfRange(num,0,mid);
        int[] right = Arrays.copyOfRange(num,mid,num.length);
        int[] temp = new int[num.length];
        return sort_guiBing(归并(left),归并(right),temp);
    }

    public int[] sort_guiBing(int[] a,int[] b,int[] temp){
        int indexa = 0;
        int indexb = 0;
        int indext = 0;
        while(indexa<a.length||indexb<b.length){
            if(indexa>=a.length){
                while (indexb<b.length){
                    temp[indext++] = b[indexb++];
                }
                break;
            }
            if(indexb>=b.length){
                while (indexa<a.length){
                    temp[indext++] = a[indexa++];
                }
                break;
            }
            if(a[indexa]<b[indexb]){
                temp[indext++] = a[indexa++];
            }else {
                temp[indext++] = b[indexb++];
            }

        }
        return temp;
    }
    //插入排序 时间复杂度O(n^2) 空间复杂度O(1)
    public void 插入(int[] num){
        int preIndex = 0;
        for(int i=1;i<num.length;++i){
            preIndex = i-1;
            while(preIndex>=0&&num[preIndex]>num[i]){
                num[preIndex+1] = num[preIndex];
                --preIndex;
            }

            num[preIndex+1] = num[i];
        }
        return;
    }
    //选择排序 时间复杂度O(n^2) 空间复杂度O(1)
    public void 选择(int[] num){
        int minIndex = 0;
        for(int i=0;i<num.length-1;++i){
            minIndex = i;
            for(int j=i+1;j<num.length;++j){
                if(num[j]<num[minIndex]){
                    minIndex = j;
                }
            }
            swap(num,i,minIndex);
        }
    }
    //冒泡排序 时间复杂度O(n^2) 空间复杂度O(1)
    public void 冒泡(int[] num){
        for(int i=0;i<num.length-1;++i){
            for(int j=0;j<num.length-1-i;++j){
                if(num[j]>num[j+1]){
                    swap(num,j,j+1);
                }
            }
        }
        return;
    }
    //快排 时间复杂度O(nlogn) 空间复杂度O(nlogn)
    public void quick_sort(int[] nums,int left,int right){
        int key = nums[left];
        int start = left;
        int end = right;
        while(left<right){
            while(left<right&&nums[right]>=key){
                --right;
            }
            nums[left] = nums[right];
            while(left<right&&nums[left]<=key){
                ++left;
            }
            nums[right] = nums[left];
        }
        nums[left] = key;
        quick_sort(nums,start,left-1);
        quick_sort(nums,left+1,end);
        return;
    }
    //堆排序 时间复杂度O(nlogn) 空间复杂度O(1)
    public void heapBuild(int[] n,int size){
        for(int i=size/2-1;i>=0;--i){
            heapAdjust(n,i,n.length-1);
        }
    }

    public void heapAdjust(int[] n,int pos,int size){
        int lchild = 2*pos+1;
        int rchild = 2*pos+2;
        int larger = pos;
        if(lchild<=size&&n[lchild]>n[larger]){
            larger = lchild;
        }

        if(rchild<=size&&n[rchild]>n[larger]){
            larger = rchild;
        }

        if(larger!=pos){
            swap(n,pos,larger);
            heapAdjust(n,larger,size);
        }


    }

    public void heapSort(int[] n){
        heapBuild(n,n.length);
        for(int i=n.length-1;i>=1;--i){
            int temp = n[0];
            n[0] = n[i];
            n[i] = temp;
            heapAdjust(n,0,i-1);
        }
        return;
    }

    //堆2
    private void 堆排序(int[] nums){
        for (int i = nums.length - 1; i >= 0; i--){
            保持大顶堆(nums, i);
            swap(nums, 0, i);
        }
    }

    private void 保持大顶堆(int[] nums, int l){
        for (int i = nums.length / 2; i >= 0; i--) {
            int lchildIndex = 2 * i + 1;
            int rchildIndex = 2 * i + 2;
            if (lchildIndex <= l && nums[lchildIndex] > nums[i]){
                swap(nums, i, lchildIndex);
            }
            if (rchildIndex <= l && nums[rchildIndex] > nums[i]){
                swap(nums, i, rchildIndex);
            }
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{5,7,2,10,16,1,6};
        Sort sort = new Sort();
//        int[] b = sort.归并(a);
//        for (int i : b) {
//            System.out.println(i);
//        }

        sort.heapSort(a);
        for (int i : a) {
            System.out.println(i);
        }
    }

}
