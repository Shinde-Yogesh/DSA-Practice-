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
}


/*[
  "A" = ["B"];
  "B" = ["A", "c"];
  "C" = ["B"];

   ]*/