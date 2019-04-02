package it.html.swing.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.JViewport;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import it.html.swing.gui.MainWindow;

public class OpenFileAction implements ActionListener {
	private File fileOpened;
	private MainWindow window;
	public OpenFileAction(MainWindow window) {
		this.window = window;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JFileChooser fileChooser = new JFileChooser();
		int returnValue = fileChooser.showOpenDialog(null);
		// in caso di errore visualizziamo un messaggio di errore
		// altrimenti invochiamo il metodo addToListTree() per l'aggiunta di un entry nel JTree per il file selezionato:
		if (returnValue == JFileChooser.ERROR_OPTION) {
			JOptionPane.showMessageDialog(window, "Unexpected error", "Error", JOptionPane.ERROR_MESSAGE);
		} else if (returnValue == JFileChooser.APPROVE_OPTION) {
			// E' stato selezionato un file
			fileOpened = fileChooser.getSelectedFile();
			// La stringa del suo path vienne aggiunta alla JTree
			addToListTree(fileOpened.getAbsolutePath());
		}
	}
	private void addToListTree(String filePath) {
		JPanel jPanel = (JPanel) window.getContentPane().getComponent(0);
		
		JScrollPane jScrollPane = (JScrollPane) jPanel.getComponent(1);
		
		JViewport viewport = jScrollPane.getViewport();
		JTree fileListTree = (JTree) viewport.getView();
		
		DefaultMutableTreeNode child = new DefaultMutableTreeNode(filePath);
		// ...
		DefaultTreeModel dtm = (DefaultTreeModel) fileListTree.getModel();
		DefaultMutableTreeNode root = (DefaultMutableTreeNode)
		dtm.getRoot();
		// ...
		root.add(child);
		// refresh del JTree:
		dtm.reload(root);
		// JTree completamente aperto:
		fileListTree.expandRow(0);
	}
	// ...
}
