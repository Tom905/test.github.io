package queue; 
/** 
* @author 作者 E-mail: 
* @version 创建时间：2019年3月31日 上午9:08:12 
* 类说明 循环队列
*/
public class Queue {
	int arr[];
    int front=0;
    int rear=0;
	Queue(int maxSize)
	{
		arr=new int[maxSize+1];
	}
	//判断队列是否为满
    boolean isFull() {
    	if((rear+1)%arr.length==front) {
    		System.out.println("队列已满无法加入");
    		return true;
    	}
    	else return false;
    }
    //判断队列是否为空
    boolean isEmpty() {
    	if(front==rear) {
    		System.out.println("该队列为空");    		
    		return true;
    	}
    	else return false;
    }
	//输出所有数据
    void showQueue() {
    	if(isEmpty()) return ;
    	else {
     		for(int i=front;i<front+(rear+arr.length-front)%arr.length;i++)//动脑筋：front+(rear+arr.length-front)%arr.length
    			System.out.println(arr[i%arr.length]);
    	}
    }
  //入队
    public void addQueue(int value) {
    	if(isFull()) return;
    	else {
    		arr[rear]=value;
    		rear=(rear+1)%(arr.length);
    	}
    }
	//出队
    int getQueue() {
    	if(isEmpty())
				throw new IllegalArgumentException("该队列为空");
    	int e=arr[front];
    	front=(front+1)%arr.length;
    	return e;
    }
	
	public static void main(String[] args) {
	Queue queue=new Queue(4);
	int i=9;
		queue.showQueue();
		while(!queue.isFull()) {
			queue.addQueue(i++);
			System.out.println("添加成功");
		}
		queue.showQueue();
	}


}
 