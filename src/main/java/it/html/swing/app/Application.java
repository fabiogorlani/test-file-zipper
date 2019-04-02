package it.html.swing.app;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import it.html.swing.actions.CompressFileAction;
import it.html.swing.actions.OpenFileAction;
import it.html.swing.gui.MainWindow;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainWindow mainWindow = new MainWindow("File Zipper", 600, 400,	new GridLayout(2, 1));
	
	
		
		JPanel headerPnl = new JPanel();
		headerPnl.setLayout(new GridLayout(2, 1));
		// ...
		JLabel banner = new JLabel();
		ImageIcon ii = new ImageIcon("banner.png");
		banner.setIcon(ii);
		// ...
		headerPnl.add(banner);
		
		
		DefaultMutableTreeNode rootFileTree = new DefaultMutableTreeNode("Files");
		DefaultTreeModel dtm = new DefaultTreeModel(rootFileTree, false);
		JTree fileListTree = new JTree(dtm);
		JScrollPane qPane = new JScrollPane(fileListTree,
			JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		headerPnl.add(qPane);
		mainWindow.addComponent(headerPnl);
		
		
		JPanel footerPnl = new JPanel();
		footerPnl.setBackground(Color.white);
		// Definiamo il JButton per aprire i file:
		JButton openBtn = new JButton("Open a file");
		// Definiamo il JButton per comprimere i file selezionati:
		JButton compressionBtn = new JButton("Make archive");
		
		OpenFileAction openFileAction = new OpenFileAction(mainWindow);
		openBtn.addActionListener(openFileAction);
		CompressFileAction compressFileAction = new CompressFileAction(mainWindow);
		compressionBtn.addActionListener(compressFileAction);
		
		
		
		footerPnl.add(openBtn);
		footerPnl.add(compressionBtn);
		// ...
		mainWindow.addComponent(footerPnl);
		mainWindow.setVisible(true);
		

	
	
	}	
	
	
	
}
