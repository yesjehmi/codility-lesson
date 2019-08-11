package ProgrammersTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProgrammersQueue {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int C = Integer.parseInt(inputs[1]);

        Queue queue = new Queue(C);

        String[] command;

        for (int i=0; i<N; i++) {
            command = br.readLine().split(" ");

            switch(command[0]){
                case "SIZE" :
                    System.out.println(queue.size());
                    break;
                case "OFFER" :
                    System.out.println(queue.offer(command[1]));
                    break;
                case "TAKE" :
                    String take = queue.take();
                    if (take != null) {
                        System.out.println(take);
                    }
                    break;
            }
        }
    }
}

class Queue {
    private int capacity;
    private int frontIndex;
    private int tailIndex;
    private int num;
    private String[] queue;

    public Queue(int capacity) {
        this.capacity = capacity;
        this.frontIndex = 0;
        this.tailIndex = 0;
        this.num = 0;
        this.queue = new String[capacity];
    }

    public int size() {
        return this.num;
    }

    public String take() {
        if (size() <= 0) {
            return null;
        }

        String queueResult = this.queue[this.frontIndex++];
        this.frontIndex = this.frontIndex % this.capacity;
        this.num --;
        return queueResult;
    }

    public boolean offer (String input) {
        if (num == capacity) {
            return false;
        }

        this.num ++;
        this.tailIndex = ++this.tailIndex % this.capacity;
        this.queue[this.tailIndex] = input;
        return true;
    }
}
