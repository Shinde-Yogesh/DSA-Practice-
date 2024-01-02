package com.Graph_Udemy_Course;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph {
// creating the constructor
	private HashMap<String, ArrayList<String>> adjList = new HashMap<>();
	
	public void printGraph()
	{
		System.out.println(adjList);
	}
	
	// add the vertices
	public boolean addVertex(String vertex)
	{
		if(adjList.get(vertex) == null)
		{
			adjList.put(vertex, new ArrayList<String>());
			return true;
		}
		return false;
	}
	
	// for the Edges
	public boolean addEdges(String vertex1, String vertex2)
	{
		if(vertex1 != null  && vertex2 != null)
		{
			adjList.get(vertex1).add(vertex2);
			adjList.get(vertex2).add(vertex1);
			return true;
		}
		return false;
	}
	// for the remove Edges
	public boolean removeEdges(String vertex1, String vertex2)
	{
		if(vertex1 != null  && vertex2 != null)
		{
			adjList.get(vertex1).remove(vertex2);
			adjList.get(vertex2).remove(vertex1);
			return true;
		}
		return false;
	}
}


/*[
  "A" = ["B"];
  "B" = ["A", "c"];
  "C" = ["B"];

   ]*/