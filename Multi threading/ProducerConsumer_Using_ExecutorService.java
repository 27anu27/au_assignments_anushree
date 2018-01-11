package co. au.executors;

import java.util.ArrayList;
import java.util.Iterator;

public class ProducerConsumer_Using_ExecutorService {
	
	ExecutorServiceThreadPool executorServiceThreadPool;
    static ArrayList consumerdata = new ArrayList(); 
    
    public static void main(String[] args) {
        ProducerConsumer_Using_ExecutorService prodconsumer = new ProducerConsumer_Using_ExecutorService();
        prodconsumer.init();
                Iterator itr = consumerdata.iterator(); 
                    while(itr.hasNext()) {
                        Object element = itr.next(); 
                        System.out.print(element + " ");    
                    } 
    }
    private void init() {
        executorServiceThreadPool = new ExecutorServiceThreadPool();
        for(int i = 0; i < 10; i++){
            executorServiceThreadPool.addThread(new Producer(i));   
            executorServiceThreadPool.addThread(new Consumer(i));
        }
                executorServiceThreadPool.finish();
    }
    private class Producer implements Runnable {
            int data;
            public Producer(int datatoput) {
               data = datatoput;
             }
        @Override
        public void run() {         
            System.out.println("Inserting Element " + data);
            try {
                executorServiceThreadPool.queue.put(data);
                    Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        }
    }
    private class Consumer implements Runnable {
                int datatake,data; 
                public Consumer(int datatoput) {
                    data = datatoput;
                  }
        @Override
        public void run() {                                 
                try 
                {
                	System.out.println("Consuming Element " + data);
                    datatake = executorServiceThreadPool.queue.take();
                    consumerdata.add(datatake);
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
        }
    }
}