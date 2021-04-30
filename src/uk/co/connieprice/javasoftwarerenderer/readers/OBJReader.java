package uk.co.connieprice.javasoftwarerenderer.readers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import uk.co.connieprice.javasoftwarerenderer.objects.Model;
import uk.co.connieprice.javasoftwarerenderer.objects.Model.Edge;
import uk.co.connieprice.javasoftwarerenderer.objects.Model.Vertex;

public class OBJReader {
	public static void read(Model model, String filepath) {	
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filepath));

			List<Vertex> vertexes = new ArrayList<Vertex>();
	
			String line;
			while ((line = reader.readLine()) != null) {
			    String[] parts = line.split(" ");

			    if (parts.length > 0) {
			        String command = parts[0];

			        switch(command) {
			        	case "v":
			        		vertexes.add(new Vertex(
			        			Double.parseDouble(parts[1]),
			        			Double.parseDouble(parts[2]),
			        			Double.parseDouble(parts[3])
			        		));
			        		break;
			        	case "f":
			        		int vertexCount = parts.length - 1;
			        		int[] vertexIndices = new int[vertexCount];

			        		for (int i = 0; i < vertexCount; i++) {
			        			vertexIndices[i] = Integer.parseInt(parts[i+1]);
			        		}

			        		for (int i = 0; i < vertexCount; i++) {
			        			int currentVertexIndex = vertexIndices[i];
			        			int nextVertexIndex = vertexIndices[(i+1)%vertexCount];

			        			Vertex currentVertex = vertexes.get(currentVertexIndex - 1);
			        			Vertex nextVertex = vertexes.get(nextVertexIndex - 1);

			        			model.addEdge(new Edge(
			        				currentVertex,
			        				nextVertex
			    		        ));
			        		}
			        		break;
			        }
			    }
			}

		    reader.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}    
	}
}
