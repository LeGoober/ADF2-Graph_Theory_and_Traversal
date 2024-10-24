package com.rorisangmakganaiv.gui;
import com.rorisangmakgana.graphs.GraphAdjacencyMatrix;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class GraphsGUI extends JFrame{
    private JPanel pnl_main, pnl_graphs_container, pnl_input_panel;
    private JLabel lbl_algorithm_select;
    private JButton btn_run_algorithm;
    private JComboBox<String> jcb_algorithm_select;
    private JLabel [][] graph_adj_cells;
    private int grid_size = 10;
    Random random = new Random();
    public GraphsGUI(){
        // Setting the Title of the Graphical Panel
        setTitle("Graph Algorithm Visualizer");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Initializing the Panels
        pnl_main = new JPanel();
        pnl_graphs_container = new JPanel();
        pnl_input_panel = new JPanel();

        // Initializing the Labels and the Buttons that will capture the input events
        btn_run_algorithm = new JButton("Run Algorithm/Graph");
        String[] jcb_inputs = {
            "Select Graph Operation", "Create Graph Adj.List", 
            "Create Graph Adj.Matrix", "Graph Depth First Search", 
            "Graph Breadth First Search"
        };
        jcb_algorithm_select = new JComboBox<>(jcb_inputs);
        jcb_algorithm_select.setBounds(100, 100, 100, 150);
        lbl_algorithm_select = new JLabel("Select Algorithm:");
        lbl_algorithm_select.setBounds(100, 100, 100, 150);
        
        // Initializing the 2-D Array of Labels
        graph_adj_cells = new JLabel[grid_size][grid_size];
        
        btn_run_algorithm = new JButton("Run Algorithm");
        btn_run_algorithm.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                runGraphOperation();
            }
        });
        
        
        // Setting up the GUI layout
        setGUI();
        
        setVisible(true);
    }
    
    public void setGUI(){
        pnl_graphs_container.setLayout(new GridLayout(grid_size, grid_size));

        // Populating the Grid Container with labels, we do that by first iterating
        //according to the grid size that we have set as a variable to create the size of the 2D matrix, then we iterate through the rows and 
        //columns of each of the rows and columns to ensure that we are polpulating the frame according to the 2D 
        for (int i = 0; i < grid_size; i++) {
            for (int j = 0; j < grid_size; j++) {
                graph_adj_cells[i][j] = new JLabel("", SwingConstants.CENTER);
                graph_adj_cells[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                graph_adj_cells[i][j].setOpaque(true);
                graph_adj_cells[i][j].setBackground(Color.WHITE); // Default background color
                pnl_graphs_container.add(graph_adj_cells[i][j]);
            }
        }

        // Adding input components to the input panel
        pnl_input_panel.setLayout(new FlowLayout());
        pnl_input_panel.add(lbl_algorithm_select);
        pnl_input_panel.add(jcb_algorithm_select);
        pnl_input_panel.add(btn_run_algorithm);

        // Setting up the main panel
        pnl_main.setLayout(new BorderLayout());
        pnl_main.add(pnl_graphs_container, BorderLayout.CENTER);
        pnl_main.add(pnl_input_panel, BorderLayout.EAST);

        this.add(pnl_main); // Adding the main panel to the frame
    }
    
    public void highlightPath(int [][] adjMatrix){
        for(int i = 0; i< adjMatrix.length; i++){
            for(int j = 0; j < adjMatrix.length; j++){
                if(adjMatrix[i][j] == 1){
                    graph_adj_cells[i][j].setBackground(Color.CYAN);
                    graph_adj_cells[j][i].setBackground(Color.CYAN);
                }
                else{
                    graph_adj_cells[i][j].setBackground(Color.WHITE);
                }
            }
        }
    }
    
    public void runGraphOperation(){
        //We created a method that ensures that we are running the program according to the parameters of the amount of 
        //vertices and edges that we have set for the graph that we have constructed
        
        //This is an interesting way of capturing the inputs from a JComboBox, as we are then checking for the selected text and are 
        //parsing that within a string that we ddo comparision operation on whether if the value if equal to the option that we have selected, we then run that operation
        //this would be like setting a 'ghost' action listener 
        String selectedAlgorithm = (String) jcb_algorithm_select.getSelectedItem();
        if("Create Graph Adj.Matrix".equals(selectedAlgorithm)){
            int vertices = 5; 
            int max_edges = 6;
         
            
            int adjMatrix [][] = new int[vertices][vertices];
            int random_edges = random.nextInt(max_edges + 1);
            GraphAdjacencyMatrix.addRandomEdges(adjMatrix, random_edges);
            highlightPath(adjMatrix);
        }
    }
}
