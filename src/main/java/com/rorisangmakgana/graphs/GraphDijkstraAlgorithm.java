package com.rorisangmakgana.graphs;

import java.util.*;
import java.util.Arrays;

public class GraphDijkstraAlgorithm {

    static final int Vertices = 9;

    // Utility function to find the vertex with the minimum distance
    public int minimumDistance(int[] distance, boolean[] sptSet) {
        int min = Integer.MAX_VALUE, minIndex = -1;
        for (int v = 0; v < Vertices; v++) {
            if (!sptSet[v] && distance[v] <= min) {
                min = distance[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    // Dijkstra's algorithm implementation
    public int[] dijkstra(int[][] graph, int source) {
        int[] distance = new int[Vertices];
        boolean[] sptSet = new boolean[Vertices];
        int[] parent = new int[Vertices]; // Array to store the shortest path tree

        Arrays.fill(distance, Integer.MAX_VALUE);
        Arrays.fill(parent, -1); // Initialize parent to track paths
        distance[source] = 0;

        for (int count = 0; count < Vertices - 1; count++) {
            int u = minimumDistance(distance, sptSet);
            sptSet[u] = true;

            for (int v = 0; v < Vertices; v++) {
                if (!sptSet[v] && graph[u][v] != 0
                        && distance[u] != Integer.MAX_VALUE
                        && distance[u] + graph[u][v] < distance[v]) {
                    distance[v] = distance[u] + graph[u][v];
                    parent[v] = u; // Track parent for path highlighting
                }
            }
        }
        return parent;
    }

    // Helper function to get the shortest path as an array of edges
    public int[][] getShortestPathEdges(int source, int destination, int[] parent) {
        int[][] edges = new int[Vertices][2];
        int count = 0;
        for (int v = destination; v != source; v = parent[v]) {
            int u = parent[v];
            edges[count][0] = u;
            edges[count][1] = v;
            count++;
        }
        return Arrays.copyOf(edges, count);
    }
}
