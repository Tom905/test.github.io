package queue; 
/** 
* @author ���� E-mail: 
* @version ����ʱ�䣺2019��3��31�� ����9:08:12 
* ��˵�� ѭ������
*/
public class Queue {
	int arr[];
    int front=0;
    int rear=0;
	Queue(int maxSize)
	{
		arr=new int[maxSize+1];
	}
	//�ж϶����Ƿ�Ϊ��
    boolean isFull() {
    	if((rear+1)%arr.length==front) {
    		System.out.println("���������޷�����");
    		return true;
    	}
    	else return false;
    }
    //�ж϶����Ƿ�Ϊ��
    boolean isEmpty() {
    	if(front==rear) {
    		System.out.println("�ö���Ϊ��");    		
    		return true;
    	}
    	else return false;
    }
	//�����������
    void showQueue() {
    	if(isEmpty()) return ;
    	else {
     		for(int i=front;i<front+(rear+arr.length-front)%arr.length;i++)//���Խfront+(rear+arr.length-front)%arr.length
    			System.out.println(arr[i%arr.length]);
    	}
    }
  //���
    public void addQueue(int value) {
    	if(isFull()) return;
    	else {
    		arr[rear]=value;
    		rear=(rear+1)%(arr.length);
    	}
    }
	//����
    int getQueue() {
    	if(isEmpty())
				throw new IllegalArgumentException("�ö���Ϊ��");
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
			System.out.println("��ӳɹ�");
		}
		queue.showQueue();
	}


}
 