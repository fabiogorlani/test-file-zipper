package it.html.swing.gui;


import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
public class MainWindow extends JFrame {
	// ...
	public MainWindow(String title, int width, int height) {
		super(title);
		setSize(width, height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public MainWindow(String title, int width, int height, LayoutManager layout) {
		this(title,width,height);
		getContentPane().setLayout(layout);
	}
	public void addComponent(Component component) {
		getContentPane().add(component);
	}
	
	
	
}