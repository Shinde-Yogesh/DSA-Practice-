package com.Graph_Udemy_Course;

public class Main {
	public static void main(String[] args) {
		Graph graph = new Graph();
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");

		graph.addEdges("A", "B");
		graph.addEdges("A", "C");
		graph.addEdges("A", "D");
		graph.addEdges("B", "D");
		graph.addEdges("C", "D");
//		System.out.println("Before remove the Edges");
//
//		graph.printGraph();
//		System.out.println();
//		System.out.println("After remove the Edges");
//		graph.removeEdges("A", "B");
		System.out.println("Before remove the Vertex");
		graph.printGraph();
		
		System.out.println("After remove the Vertex");
		graph.removeVertex("D");
		graph.printGraph();

	}
}
