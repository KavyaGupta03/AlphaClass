import java.util.*;
public class HeapAlpha{
    static class heap{ 
        ArrayList<Integer> list=new ArrayList<>();
        public void insert(int n){// Tc= O(logn)
            // step 1: put the no on the last index
            list.add(n);
            // step 2 : modify the heap
            int child = list.size()-1;
            int parent = (child-1)/2; 
            while(list.get(child) > list.get(parent) && parent >= 0){
                int temp=list.get(child);
                list.set(child,list.get(parent));
                list.set(parent,temp);
                child=parent;
                parent=(child-1)/2;
            }
        }
        public boolean isEmpty(){// Tc=O(1)
            return list.isEmpty();
        }
        public int peek(){// Tc=O(1)
            if(!list.isEmpty()){
                return list.get(0);
            }
            return -1;
        }
        public int delete(){// Tc= O(logn)
            // 3 step process 
            if(!isEmpty()){
                int data=peek();
                // step 1: swap
                int temp=list.get(0);
                list.set(0,list.get(list.size()-1));
                list.set(list.size()-1,temp);
                // step 2: delete the last node
                list.remove(list.size()-1);
                // step 3: heapify
                heapify(0);
                return data;
            }
            return -1;
        }
        private void heapify(int idx){
            int lc=2*idx+1;
            int rc=2*idx+2;
            int maxIdx=idx;

            if(lc < list.size() && list.get(lc) > list.get(maxIdx)){
                maxIdx=lc;
            }else if( lc < list.size() && list.get(rc) > list.get(maxIdx)){
                maxIdx=rc;
            }
            if(maxIdx != idx){
                // swap
                int temp=list.get(idx);
                list.set(idx,list.get(maxIdx));
                list.set(maxIdx,temp);

                heapify(maxIdx);
            }
        }
    }
    public static void heapSort(int arr[]){
        // step 1 : convert the given mean heap to my max heap
        int n=arr.length;
        for(int i=(n/2)-1;i>=0;i--){
            heapify(arr,i,n);
        }

        for(int i:arr){
            System.out.print(i+" ");
        }

        // step 2: call the heapify for the arr by decreasing its size
        for(int i=arr.length-1;i>0;i--){
            // swap
            int temp=arr[i];
            arr[i]=arr[0];
            arr[0]=temp;
            heapify(arr,0,i);
        }
    }
    private static void heapify(int arr[],int i,int size){
        int lc=2*i+1;
        int rc=2*i+2;
        int maxIdx=i;
        if(lc < size && arr[lc] > arr[maxIdx]){
            maxIdx=lc;
        }
        if( rc < size && arr[rc] > arr[maxIdx]){
            maxIdx=rc;
        }
        if(maxIdx != i){
            int temp=arr[i];
            arr[i]=arr[maxIdx];
            arr[maxIdx]=temp;
            heapify(arr, maxIdx, size);
        }
    }
    public static void main(String[] args) {
        // heap h1=new heap();
        // h1.insert(1);
        // h1.insert(5);
        // h1.insert(10);
        // h1.insert(17);
        // h1.insert(21);
        // h1.insert(2);
        // System.out.println(h1.delete());
        // System.out.println(h1.list);
        // System.out.println(h1.peek());
        int arr[]={1,2,4,5,3};
        heapSort(arr);
        for(int i:arr){
            System.out.print(i+" ");
        }
    }
}