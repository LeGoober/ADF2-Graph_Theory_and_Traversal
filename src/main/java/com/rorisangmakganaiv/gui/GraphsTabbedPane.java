package com.rorisangmakganaiv.gui;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GraphsTabbedPane extends JFrame {

    private JTabbedPane jtp_tabbed_pane;
    GraphsGUI graphs_gui;
    GraphsGUI_2 graph_gui;
    
    public GraphsTabbedPane() {
        super("Graphs GUI");
        graphs_gui = new GraphsGUI();
        graph_gui = new GraphsGUI_2();
        jtp_tabbed_pane.addTab("Graphs Adjacency Matrix", graphs_gui);
        jtp_tabbed_pane.addTab("Graphs Text Area", graph_gui);
        add(jtp_tabbed_pane);
        setGUI();
    }

    public void setGUI() {
        this.add(jtp_tabbed_pane);
        setSize(800, 1200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
