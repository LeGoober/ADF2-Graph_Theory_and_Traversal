package com.rorisangmakgana.graphs;

import java.util.*;

public class GraphAdjacencyMatrix {

    //Setting up the method that will add the positions of our edges within a Graph
    public static void addEdge(int[][] adjMatrix, int i, int j) {
        adjMatrix[i][j] = 1;
        adjMatrix[j][i] = 1;
    }

    //Setting up the method that iterates through each of the values that are stored in our Adjacency Matrix
    public static void displayMatrix(int[][] adjMatrix) {
        //the condition of this for loop is that we are then checking the amount of rows that are present within the adjacency matrix 
        //then we check the values within each of the rows and then we print out those values present
        for (int[] row : adjMatrix) {
            for (int values : row) {
                System.out.print(values + " ");
            }
            System.out.println();
        }
    }

    //A method for adding ranadom edges to our graph
    public static void addRandomEdges(int[][] adj_matrix, int num_of_edges) {
        //We first construct an instance of the Random class within the method,
        //then we set the vertices according to the length of the adjacency matrix as a means of ensuring that we have the right number of
        //vertices and don't cause a stack overflow
        Random random = new Random();
        int vertices = adj_matrix.length;

        
        //Adding the number of random edges, we add the number of random edges according to the length of the edges we've set in the method declaration
        for (int i = 0; i < num_of_edges; i++) {
            //this is where we randomly assign the values of the vertex according to the length of the vertex
            int vertex_1 = random.nextInt(vertices);
            int vertex_2 = random.nextInt(vertices);

            //ensuring that while we are adding the edges there arent any self loops,we first set the condition that both vertices are equal or the
            //values within the matrix itself are equal to one(if not one since a self loop is indicated that there's only one common vertex) and we continue to randomize 
            //the values within the vertices
            while (vertex_1 == vertex_2 || adj_matrix[vertex_1][vertex_2] == 1) {
                vertex_1 = random.nextInt(vertices);
                vertex_2 = random.nextInt(vertices);
            }
            //we then add the edges of the matrix according to the vertices that we have randomized, since adjacency is the concept of understanding that 
            //the edges that are on incident with a vertex create the adjacency between the two
            addEdge(adj_matrix, vertex_1, vertex_2);
        }

    }

    public static int[][] initializeMatrix(int vertices) {
        int[][] adjMatrix = new int[vertices][vertices];

        addEdge(adjMatrix, 0, 1);
        addEdge(adjMatrix, 0, 2);
        addEdge(adjMatrix, 2, 1);
        addEdge(adjMatrix, 3, 1);
        addEdge(adjMatrix, 2, 2);

        return adjMatrix;
    }
}
