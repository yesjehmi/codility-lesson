package ProgrammersTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ProgramersTest {
    //Window Size 내 MaxSize의 int 를return
    public static void main (String[] args) throws java.lang.Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input;
        input = br.readLine();
        int W = Integer.parseInt(input);

        List<Integer> inputs = new ArrayList<>();

        while (true) {
            String test = br.readLine();

            if(test == null)
                break;

            inputs.add(Integer.parseInt(br.readLine()));

            if(inputs.size() >= W) {
                int maxValue = inputs.stream().max(Integer::compareTo).get();
                System.out.println(maxValue);
                inputs.remove(0);
            }
        }
    }
}
