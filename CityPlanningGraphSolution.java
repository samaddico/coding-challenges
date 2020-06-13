package com.example.demo;

import java.util.*;

/**
 * Problem Statment here 
 * https://www.chegg.com/homework-help/questions-and-answers/network-consisting-m-cities-m-1-roads-connecting-given-cities-labeled-distinct-integers-wi-q37619409
 *
 */

 public class CityPlanningGraphSolution {



    public static int[] solution(int[] network) {
        int networkSize = network.length;
        Vector<Integer> graph[] = new Vector[networkSize];
        boolean[] solVisited = new boolean[networkSize];
        int[] depth = new int[networkSize];
        int[] prod = new int[networkSize - 1];
        Queue<Integer> queue=new LinkedList<>();
        int capital = 1;

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new Vector<>();
        }

        for(int i = 0; i < network.length; i++) {
            if(network[i] != i) {
                graph[i].add(network[i]);
                graph[network[i]].add(i);
            } else {
                capital = i;
            }
        }

        solVisited[capital] = true;
        depth[capital] = 0;
        queue.add(capital);
        while(!queue.isEmpty()) {
            int currentCity = queue.peek();
            queue.poll();
            for (Integer adjCity : graph[currentCity]) {
                if(solVisited[adjCity]) continue;
                solVisited[adjCity] = true;
                depth[adjCity] = depth[currentCity] + 1;
                prod[depth[adjCity]-1]++;
                queue.add(adjCity);
            }
        }
        return prod;
    }

    public static void main(String[] agr) {
        int[] networkCity = {9,1,4,9,0,4,8,9,0,1};
        int[] result = solution(networkCity);
        System.out.println(Arrays.toString(result));

    }

}
