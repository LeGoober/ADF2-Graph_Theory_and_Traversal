package com.rorisangmakganaiv.gui;

import com.rorisangmakgana.graphs.GraphAdjacencyMatrix;
import com.rorisangmakgana.graphs.GraphDijkstraAlgorithm;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class GraphsGUI extends JFrame {
    private JPanel pnl_main, pnl_graphs_container, pnl_input_panel;
    private JLabel lbl_algorithm_select;
    private JButton btn_run_algorithm;
    private JComboBox<String> jcb_algorithm_select;
    private JLabel[][] graph_adj_cells;
    private int grid_size = 30;
    private GraphDijkstraAlgorithm graphShortestPath = new GraphDijkstraAlgorithm();
    private int[][] adjMatrix;
    private Random random = new Random();

    public GraphsGUI() {
        setTitle("Graph Algorithm Visualizer");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pnl_main = new JPanel();
        pnl_graphs_container = new JPanel();
        pnl_input_panel = new JPanel();

        btn_run_algorithm = new JButton("Run Algorithm/Graph");
        String[] jcb_inputs = {"Select Graph Operation", "Create Graph Adj.Matrix", "Dijkstra's Shortest Path"};
        jcb_algorithm_select = new JComboBox<>(jcb_inputs);

        lbl_algorithm_select = new JLabel("Select Algorithm:");
        
        graph_adj_cells = new JLabel[grid_size][grid_size];
        btn_run_algorithm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                runGraphOperation();
            }
        });
        
        setGUI();
        setVisible(true);
    }

    public void setGUI() {
        pnl_graphs_container.setLayout(new GridLayout(grid_size, grid_size));

        for (int i = 0; i < grid_size; i++) {
            for (int j = 0; j < grid_size; j++) {
                graph_adj_cells[i][j] = new JLabel("", SwingConstants.CENTER);
                graph_adj_cells[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                graph_adj_cells[i][j].setOpaque(true);
                graph_adj_cells[i][j].setBackground(Color.WHITE);
                pnl_graphs_container.add(graph_adj_cells[i][j]);
            }
        }

        pnl_input_panel.setLayout(new FlowLayout());
        pnl_input_panel.add(lbl_algorithm_select);
        pnl_input_panel.add(jcb_algorithm_select);
        pnl_input_panel.add(btn_run_algorithm);

        pnl_main.setLayout(new BorderLayout());
        pnl_main.add(pnl_graphs_container, BorderLayout.CENTER);
        pnl_main.add(pnl_input_panel, BorderLayout.EAST);

        this.add(pnl_main);
    }

    public void highlightPath(int[][] adjMatrix, int[][] pathEdges) {
        // Reset the graph to default color
        for (int i = 0; i < adjMatrix.length; i++) {
            for (int j = 0; j < adjMatrix[i].length; j++) {
                if (adjMatrix[i][j] == 1) {
                    graph_adj_cells[i][j].setBackground(Color.CYAN);
                    graph_adj_cells[j][i].setBackground(Color.CYAN);
                } else {
                    graph_adj_cells[i][j].setBackground(Color.WHITE);
                }
            }
        }

        // Highlight the shortest path in yellow
        for (int[] edge : pathEdges) {
            if (edge[0] == 0 && edge[1] == 0) break; // Ignore empty edges
            int u = edge[0], v = edge[1];
            graph_adj_cells[u][v].setBackground(Color.YELLOW);
            graph_adj_cells[v][u].setBackground(Color.YELLOW);
        }
    }

    public void runGraphOperation() {
        String selectedAlgorithm = (String) jcb_algorithm_select.getSelectedItem();
        if ("Create Graph Adj.Matrix".equals(selectedAlgorithm)) {
            int vertices = 20;
            adjMatrix = new int[vertices][vertices];
            GraphAdjacencyMatrix.addRandomEdges(adjMatrix, 50);
            highlightPath(adjMatrix, new int[0][5]); // Display graph structure only
        } else if ("Dijkstra's Shortest Path".equals(selectedAlgorithm)) {
            int source = 0;
            int destination = 8;
            int[] parent = graphShortestPath.dijkstra(adjMatrix, source);
            int[][] pathEdges = graphShortestPath.getShortestPathEdges(source, destination, parent);
            highlightPath(adjMatrix, pathEdges);
        }
    }
}
