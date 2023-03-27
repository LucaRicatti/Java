/*
	Autore: Luca Ricatti
	Data: 27/03/2023
	Luogo: Casa
	Oggetto: Algoritmo di Dijkstra
*/

package Dijkstra;

import java.util.Vector;

public class Main {
	public static void main(String[] args) {
		Graph graph = new Graph(5);
		graph.connectNodes();

		graph.computePaths();

		Vector<Node> shortestPath = graph.getShortestPath();

		for (int i = shortestPath.size() - 1; i >= 0; i--) {
			System.out.println(shortestPath.get(i).getName() + " ");
		}
	}
}