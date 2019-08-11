package lessons;

import java.util.Stack;

public class Codility7 {
    public int solution(String S) {
        //Stack 기능으로 괄호가 맞는지를 판단.
        Stack charStack = new Stack<>();
        char lastChar;
        for (char input : S.toCharArray()) {
            //시작하는 부분이면
            if (input == '(' || input == '{' || input == '[') {
                charStack.push(input);
            } else {
                try {
                    lastChar = (char)charStack.peek();
                } catch (Exception ex) {
                    return 0;
                }

                if (input == ')') {
                    if (lastChar == '(') {
                        charStack.pop();
                    } else {
                        charStack.push(input);
                    }
                }

                else if (input == '}') {
                    if (lastChar == '{') {
                        charStack.pop();
                    } else {
                        charStack.push(input);
                    }
                }

                else if (input == ']') {
                    if (lastChar == '[') {
                        charStack.pop();
                    } else {
                        charStack.push(input);
                    }
                }
            }
        }

        return charStack.isEmpty()? 1 : 0;
    }
}
