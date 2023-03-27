/*
	Autore: Luca Ricatti
	Data: 27/03/2023
	Luogo: Casa
	Oggetto: Algoritmo di Dijkstra
*/

package Dijkstra;

import java.util.TreeMap;

public class Node implements Comparable<Node> {
	private String name;
	public int weight = Integer.MAX_VALUE;
	public Node nodeBefore = null;
	private TreeMap<Node, Integer> connections;

	public Node(String name) {
		this.name = name;
		connections = new TreeMap<>((a, b) -> a.name.compareTo(b.name));
	}

	public void newConnection(Node nodo2, int distance) {
		connections.put(nodo2, distance);
		nodo2.connections.put(this, distance);
	}

	public int weightTo(Node node) {
		return weight + connections.get(node);
	}

	public TreeMap<Node, Integer> getConnections() {
		return connections;
	}

	public String getName() {
		return name;
	}

	@Override
	public int compareTo(Node other) {
		return Integer.compare(weight, other.weight);
	}
}