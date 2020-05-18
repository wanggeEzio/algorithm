//最大堆
public class MaxHeap {

    private static final int DEFAULT_SIZE = 100;

    private int[] values;

    private int num;

    public MaxHeap(){
        this(DEFAULT_SIZE);
    }

    public MaxHeap(int size){
        values = new int[size];
        num = 0;
    }

    public void push(int value){
        values[++num] = value;
        adjustDownToTop();
    }

    public int pop(){
        int result = values[1];
        values[1] = values[--num];
        adjustTopToDown();
        return result;
    }

    public boolean isEmpty(){
        return num == 0;
    }

    //从上到下调整
    private void adjustTopToDown(){
        int index = 1;
        while(true){
            int left = index * 2;
            int right = index * 2 + 1;

            //如果右孩子最大
            if(right <= num && values[right] >= values[index] && values[right] >= values[left]){
                swap(right, index);
                index = right;
            }else{
                //如果左孩子最大
                if(left <= num && values[left] >= values[index] && (right > num || values[left] >= values[right])){
                    swap(left, index);
                    index = left;
                }else{
                    //当前节点最大
                    return;
                }
            }
        }
    }

    //从下到上调整
    private void adjustDownToTop(){
        int index = num;
        while(true){
            if(index == 1){
                return;
            }
            int parent = index / 2;
            if(values[index] >= values[parent]){
                swap(index, parent);
                index = parent;
            }else{
                return;
            }
        }
    }

    private void swap(int indexi, int indexj){
        int temp = values[indexi];
        values[indexi] = values[indexj];
        values[indexj] = temp;
    }

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(100);
        for(int i = 1; i <= 10; i++){
            maxHeap.push(i);
            maxHeap.push(i);
        }

        while(!maxHeap.isEmpty()){
            System.out.println(maxHeap.pop());
        }
    }
}