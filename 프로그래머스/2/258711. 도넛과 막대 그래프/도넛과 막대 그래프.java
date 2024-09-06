import java.util.*;

class Solution {
    private static List<List<Integer>> graph = new ArrayList<>();
    private static Set<Integer> vertexes = new HashSet<>();
    private static int centerVertex;
    private static int allGraphsCount;
    
    private static int[] incommingCounts;
    
    public int[] solution(int[][] edges) {
        initGraph(edges);
        
        int[] answer = new int[4];
        answer[0] = centerVertex;
        allGraphsCount = graph.get(centerVertex).size();
        
        removeCenterVertex();
        
        answer[2] = countStickGraph();
        answer[3] = countEightGraph();
        answer[1] = allGraphsCount - answer[2] - answer[3];
        
        return answer;
    }
    
    private void initGraph(int[][] edges) {
        int maxVertex = 0;
        for (int[] edge : edges) {
            vertexes.add(edge[0]);
            vertexes.add(edge[1]);
            maxVertex = Math.max(maxVertex, Math.max(edge[0], edge[1]));
        }
        
        for (int vertex = 0; vertex <= maxVertex; vertex++) {
            graph.add(new ArrayList<>());
        }
        
        incommingCounts = new int[maxVertex + 1];
        
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            incommingCounts[edge[1]] += 1;
        }
        
        for (int vertex : vertexes) {
            if (incommingCounts[vertex] == 0 && graph.get(vertex).size() >= 2) {
                centerVertex = vertex;
            }
        }
    }
    
    private void removeCenterVertex() {
        for (int vertex : graph.get(centerVertex)) {
            incommingCounts[vertex] -= 1;
        }
        graph.set(centerVertex, new ArrayList<>());
        
    }

    private int countStickGraph() {
        int count = 0;
        for (int vertex : vertexes) {
            if (vertex == centerVertex) continue;
            if (graph.get(vertex).size() == 0) {
                count++;
            }
        }
        return count;
    }
    
    private int countEightGraph() {
        int count = 0;
        for (int vertex : vertexes) {
            if (vertex == centerVertex) continue;
            if (incommingCounts[vertex] == 2 && graph.get(vertex).size() == 2) {
                count++;
            }
        }
        return count;
    }
}