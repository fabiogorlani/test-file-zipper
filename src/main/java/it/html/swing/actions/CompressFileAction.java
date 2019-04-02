package it.html.swing.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.JViewport;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import it.html.swing.gui.MainWindow;
import it.html.swing.gui.Zipper;

public class CompressFileAction implements ActionListener {
	private MainWindow window;
	public CompressFileAction(MainWindow window) {
		this.window = window;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JPanel header = (JPanel) window.getContentPane().getComponent(0);
		JScrollPane jScrollPane = (JScrollPane) header.getComponent(1);
		JViewport viewport = jScrollPane.getViewport();
		JTree fileListTree = (JTree) viewport.getView();
		

		DefaultTreeModel dtm = (DefaultTreeModel) fileListTree.getModel();
		DefaultMutableTreeNode root = (DefaultMutableTreeNode) dtm.getRoot();
		
		
		File[] files = new File[root.getChildCount()];
		Enumeration filesSelected = root.children();
		int i = 0;
		while (filesSelected.hasMoreElements()) {
			DefaultMutableTreeNode fl = (DefaultMutableTreeNode) filesSelected.nextElement();
			files[i] = new File(fl.toString());
			i++;
		}
		
		File jarFile = null;
		JFileChooser fileChooser = new JFileChooser();
		int returnValue = fileChooser.showSaveDialog(window);
		if (returnValue == JFileChooser.ERROR_OPTION) {
			JOptionPane.showMessageDialog(window, "Unexpected error", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		} else if (returnValue == JFileChooser.APPROVE_OPTION) {
			jarFile = fileChooser.getSelectedFile();
		}
		
		
		if ( (jarFile != null) && files != null) {
			String path = jarFile.getAbsolutePath();
			if(!path.endsWith(".jar")){
				JOptionPane.showMessageDialog(window,
					"File extension must be jar", "Error",
					JOptionPane.ERROR_MESSAGE);
				return;
			}
			Zipper.makeJarFile(jarFile, files);
		} else {
			return;
		}
				JOptionPane.showMessageDialog(window,
					"Archive created with successful", "Info",
					JOptionPane.INFORMATION_MESSAGE);
			}
		}		
	
		
		
