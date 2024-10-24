package com.rorisangmakgana.graphs;
import java.util.*;

public class GraphDFS {

    //Setting the function that recursively calls the traversal of the Graph, DFS
    public static void depth_first_search_recursion(List<List<Integer>> adj_list, int source_vertex, boolean[] visited_vertex) {

//We mark the current position of the source node as already visited once we start the function
        visited_vertex[source_vertex] = true;
        //Print the Current Vertex
        System.out.println(source_vertex + " ");

//We then construct a for loop that then checks for each of the vertices that we currently have stored within our martix
        for (int vertex : adj_list.get(source_vertex)) {
            //Checking whether we have visited the node
            if (!visited_vertex[vertex]) {
                depth_first_search_recursion(adj_list, vertex, visited_vertex);
            }
        }
    }

    //Creating the Main function that initializes the visited arrays
    public static void depth_first_search(List<List<Integer>> adj_list, int source_vertex) {
        boolean[] visited_vertex = new boolean[adj_list.size()];
        //We then call the recursive function within the method 
        depth_first_search_recursion(adj_list, source_vertex, visited_vertex);
    }

//This method ensures to add edges to the adjaenct list 
//    public static void addEdge(List<List<Integer>> adj_list, int i, int j) {
//        adj_list.add(i).add(i);
//        adj_list.add(i).add(j);
//    }
}
