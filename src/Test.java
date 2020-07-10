import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Test {
    public static void main(String[] args) throws InterruptedException {
     new Worker().main();
    }
}

class Worker{
    private List<Integer> list1=new ArrayList<>();
    private List<Integer> list2=new ArrayList<>();
    Random random=new Random();

    public void main() throws InterruptedException {
        long before=System.currentTimeMillis();
        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                work();
            }
        });
        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                work();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        long after=System.currentTimeMillis();
        System.out.println(after-before);
        System.out.println("List1 "+list1.size());
        System.out.println("List2 "+list2.size());

    }

    public  void addToList1(){
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        list1.add(random.nextInt(100));
    }
    public  void addToList2(){
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        list2.add(random.nextInt(100));
    }

    public void work(){
        for(int i=0; i<10;i++){
          addToList1();
          addToList2();
        }
    }
}