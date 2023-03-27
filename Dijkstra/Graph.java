/*
	Autore: Luca Ricatti
	Data: 27/03/2023
	Luogo: Casa
	Oggetto: Algoritmo di Dijkstra
*/

package Dijkstra;

import java.util.PriorityQueue;
import java.util.Vector;

public class Graph {
	Node nodes[];
	Node startNode, endNode;

	public Graph(int numberOfNodes) {
		nodes = new Node[numberOfNodes];

		startNode = new Node("Casa");
		startNode.weight = 0;

		for (int i = 0; i < numberOfNodes; i++) {
			nodes[i] = new Node(String.valueOf((char) ('a' + i)));
		}

		endNode = new Node("Ufficio");
	}

	public void connectNodes() {
		// Start
		startNode.newConnection(nodes[0], 2); // A
		startNode.newConnection(nodes[3], 8); // D

		// A
		nodes[0].newConnection(nodes[2], 2); // B
		nodes[0].newConnection(nodes[1], 6); // C

		// B
		nodes[1].newConnection(endNode, 5); // Ufficio
		
		// C
		nodes[2].newConnection(nodes[3], 2); // D
		nodes[2].newConnection(nodes[4], 9); // E
		
		// D
		nodes[3].newConnection(nodes[4], 3); // E

		// E
		nodes[4].newConnection(endNode, 1); // Ufficio
	}

	public void computePaths() {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(startNode);

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();

            for (Node neighbor : currentNode.getConnections().keySet()) {
                int tentativeWeight = currentNode.weightTo(neighbor);

                if (tentativeWeight < neighbor.weight) {
                    neighbor.weight = tentativeWeight;
                    neighbor.nodeBefore = currentNode;
                    queue.add(neighbor);
                }
            }
        }
    }

	public Vector<Node> getShortestPath() {
        Vector<Node> path = new Vector<>();

        for (Node node = endNode; node != null; node = node.nodeBefore) {
            path.add(node);
        }

        return path;
    }
}