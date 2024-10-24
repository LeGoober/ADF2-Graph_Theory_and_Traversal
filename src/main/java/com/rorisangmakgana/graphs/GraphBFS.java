package com.rorisangmakgana.graphs;

import java.util.*;

public class GraphBFS {

    //Setting the BFS method and settiing the Vertex that will be its source node
    public static void breadth_first_search(List<List<Integer>> adj_list, int source_node) {
        //Creating the Queue using a Linked List
        Queue<Integer> queue = new LinkedList<>();

        //Initially, we mark all the vertices as not visited, and when we push a vertex into the queue, we mark it as visited(Boolean)
        //We set a Array to store the Boolean on whether we have visited the node
        boolean[] visited_nodes = new boolean[adj_list.size()];

        //Now is where we are pushing the source node into the Linked List and then we have to mark the value of index in the Boolean array as True, which indicates that we have visited the node
        visited_nodes[source_node] = true;
        queue.add(source_node);

        //We the set the condition to check that while the linked list that is storing our vertices is not empty, we conduct the process of dequeueing the current vertex in the Linked List and adding its adjacent vertices
        while (!queue.isEmpty()) {
            int current_node = queue.poll(); //the poll method removes the vertex
            System.out.println(current_node + " ");

            //We then retrieve all the adjacent vertices to the current node that we are currently on, and since we are keeping track of the position of the values that have been visited using the Array of Booleans, we will mark the adjacent vertices as visited and enqueue the node
            for (int adj_node : adj_list.get(current_node)) {
                if (!visited_nodes[adj_node]) {
                    visited_nodes[adj_node] = true;
                    queue.add(adj_node);
                }
            }
        }
    }

    public static void addEdge(List<List<Integer>> adj_list, int i, int j) {
//        adj_list.add(i).add(j);
//        adj_list.add(j).add(i); //setting up a Undirected Graph

    }
}
