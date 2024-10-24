package com.rorisangmakgana.graphs;
import java.util.*;

public class GraphAdjacencyList {
    //Adding each of the edges to the ArrayList of Integers
    public static void addEdge(List<List<Integer>> adjList, int i, int j){
        adjList.get(i).add(j);
        adjList.get(j).add(i);
    }
    
    public static void displayAdjList(List<List<Integer>> adjList){
        for(int i = 0; i < adjList.size(); i++){
            System.out.print(i+ ": ");
            for(int j: adjList.get(i)){
                System.out.print(j+ " ");
            }
            System.out.println();
        }
    }
    public static void main(String [] args){
		int vertices = 10;
		List <List<Integer>> adj_list = new ArrayList<>(vertices);
		for(int i = 0; i < vertices; i++){
			adj_list.add(new ArrayList<>());
		}
		addEdge(adj_list, 0, 1);
		addEdge(adj_list, 0, 2);
		addEdge(adj_list, 1, 2);
		addEdge(adj_list, 2, 3);

		System.out.println("Displaying the Values in an Adjacency List:");
		displayAdjList(adj_list);
	}
}
