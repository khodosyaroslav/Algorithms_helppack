package com.graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {
	public double matrix[][];
	public int n;
	
	public Graph(int n) {
		matrix = new double[n][n];
		this.n = n;		
	}
	public Graph(double matrix[][]) {
		this.matrix = matrix;
		n = matrix.length;
	}	
	public int degreeOfVertex(int vertex) {
		int degree = 0;
		for(int i = 0; i < n; i++) {
			if(matrix[vertex][i] != 0)
				degree++;
		}
		return degree;
	}
	
	public void bfs(int from) {
		boolean visited[] = new boolean[n];
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(from);
		visited[from] = true;
		while(q.size() != 0) {
			from = q.poll();
			System.out.print(from + " ");
			
			for(int i = 0; i < n; i++) {
				if(matrix[from][i] != 0 && !visited[i]) {
					visited[i] = true;
					q.add(i);
				}
			}
		}
	}
	
	public void dfs(int from) {
		dfs(from, new boolean[n]);
	}
	private void dfs(int from, boolean visited[]) {
		visited[from] = true;
		System.out.print(from + " ");
		for(int i = 0; i < n; i++) {
			if(matrix[from][i] != 0 && !visited[i])
				dfs(i, visited);
		}
	}
	
	public void dfsNonRecursive(int from) {
		boolean visited[] = new boolean[n];
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(from);
		visited[from] = true;
		while(stack.size() != 0) {
			from = stack.pop();
			System.out.print(from + " ");
			
			for(int i = 0; i < n; i++) {
				if(matrix[from][i] != 0 && !visited[i]) {
					stack.push(i);
					visited[i] = true;
				}
			}
		}
	}
	
	public double[] dijkstra(int start) {
		double distance[] = new double[n];
		boolean visited[] = new boolean[n];
		for(int i = 0; i < n; i++) {
			distance[i] = Double.MAX_VALUE;
			visited[i] = false;
		}
		
		distance[start] = 0;
		int index = -1;
		for(int i = 0; i < n; i++) {
			double min = Double.MAX_VALUE;
			
			for(int j = 0; j < n; j++) {
				if(!visited[j] && distance[j] <= min) {
					min = distance[j];
					index = j;
				}
			}
			
			visited[index] = true;
			for(int j = 0; j < n; j++) {
				if( (!visited[j] && matrix[index][j] > -1) && distance[index] != Double.MAX_VALUE
					&& distance[index] + matrix[index][j] < distance[j])
					distance[j] = distance[index] + matrix[index][j];
			}
		}
		
		return distance;
	}
	
	public double[][] getAllShortestPath(){ // Floyd-Warshall algo
		double distances[][] = new double[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				distances[i][j] = matrix[i][j];
			}
		}
		
		for(int k = 0; k < n; k++) {
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {					
					if(distances[i][k] != 0 && distances[k][j] != 0 && i != j) {
						if(distances[i][k] + distances[k][j] < distances[i][j] || distances[i][j] == 0)
							distances[i][j] = distances[i][k] + distances[k][j];
					}					
				}
			}
		}
		
		return distances;
	}
	
	public static void main(String[] args) {
		/*double arr[][] = new double[][] {
			{0, 1, 1, 0},
			{0, 0, 1, 1},
			{1, 0, 0, 1},
			{0, 1, 0, 0}
		};
		
		Graph g = new Graph(arr);
		g.bfs(1);
		g.dfs(1);
		g.dfsNonRecursive(1);*/
		
		double[][] g = new double[][] {
			{0, 5, -1, 6, -1, 50},
			{5, 0, 7, -1, -1, -1},
			{-1, 7, 0, 4, -1, 10},
			{6, -1, 4, 0, 10, -1},
			{-1, -1, -1, 10, 0, 8},
			{50, -1, 10, -1, 8, 0}
		};
		
		Graph graph = new Graph(g);
		int start = 0;
		double[] dist = graph.dijkstra(start);
		for(int i = 0; i < dist.length; i++) {
			System.out.println("From " + (start+1) + " to " + (i+1) + " -> " + dist[i]);
		}
		
		/*double[][] g = new double[][] {
			{0, 5, 0, 6, 0, 50},
			{5, 0, 7, 0, 0, 0},
			{0, 7, 0, 4, 0, 10},
			{6, 0, 4, 0, 10, 0},
			{0, 0, 0, 10, 0, 8},
			{50, 0, 10, 0, 8, 0}
		};
		
		Graph graph = new Graph(g);
		double dist[][] = graph.getAllShortestPath();
		System.out.println(dist[0][5]); //20
		*/
	}

}
