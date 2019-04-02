package it.html.swing.gui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;
import java.util.jar.Manifest;

public class Zipper {
	public static void makeJarFile(File destinationPathFile, File[] files) {
		
		
		
		if ((files == null || destinationPathFile == null)) {
			throw new IllegalArgumentException("Arguments null");
		}
		
		try {
			destinationPathFile.createNewFile();
		
			byte buffer[] = new byte[1024];
			FileOutputStream fileStream = new FileOutputStream(destinationPathFile);
			JarOutputStream jarStream = new JarOutputStream(fileStream, new Manifest());
			// TODO: aggiunta dei file nell'archivio
			jarStream.close();
			fileStream.close();	
			
			
			
			for (File sFile : files) {
				// Se il file non è una directory lo aggiungiamo
				if (!sFile.isDirectory()) {
					// Creaimo un entry con il suo nome
					JarEntry file = new JarEntry(sFile.getName());
					file.setTime(sFile.lastModified());
					// La inseriamo nello stream
					jarStream.putNextEntry(file);
					// Apertura di uno stream di lettura sul file corrente
					FileInputStream in = new FileInputStream(sFile);
					int bytes = 0;
					// Scriviamo nello stream relativo a questa entry i byte del file corrente
					while ((bytes = in.read(buffer, 0, buffer.length)) != -1) {
						jarStream.write(buffer, 0, bytes);
					}
				}
			}
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}