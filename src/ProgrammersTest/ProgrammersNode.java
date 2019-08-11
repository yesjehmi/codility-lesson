package ProgrammersTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class ProgrammersNode {
    //DFS Algorithm을 recursive하게 풀이
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nodeCount = Integer.parseInt(br.readLine());
        String[] nodes = new String[nodeCount];
        for (int i = 0; i < nodeCount; i++) {
            nodes[i] = br.readLine();
        }

        String ret = solution(nodes);
        System.out.println(ret);
    }

    static class Node {
        public int start;
        public int end;
        public int visitedNum;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    private static final Map<Integer, List<Node>> nodes = new HashMap<>();
    private static boolean isExist = false;

    private static String solution(String[] args) {

        for (int i = 0; i < args.length; i++) {
            String[] points = args[i].split(" ");
            int start = Integer.parseInt(points[0]);
            int end = Integer.parseInt(points[1]);

            if (nodes.containsKey(start)) {
                List<Node> nodeList = nodes.get(start);
                nodeList.add(new Node(start, end));
                nodes.put(start, nodeList);
            } else {
                List<Node> nodeList = new ArrayList<>();
                nodeList.add(new Node(start, end));
                nodes.put(start, nodeList);
            }

            dfs(start, end, i);
            if (isExist) return "true";
        }

        return "false";
    }

    private static void dfs(int start, int end, int index) {
        if (isExist) return ;

        if (nodes.containsKey(end)) {
            List<Node> nodeList = nodes.get(end);
            for (Node node: nodeList) {
                if (node.visitedNum == index) return ;
                node.visitedNum = index;
                if (start == end) {
                    isExist = true;
                } else dfs(start, node.end, index);
            }
        }
    }


}
