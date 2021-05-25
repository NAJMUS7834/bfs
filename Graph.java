package com.getwayssolution.www;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Graph 
{
	private LinkedList<Integer> adj[];
	
	public Graph(int v) 
	{
		adj = new LinkedList[v];
		for(int i = 0; i < v; i++)
		{
			adj[i] = new LinkedList<Integer>();
		}
	}

	public void addEdge(int source, int destination)
	{
		adj[source].add(destination);
		adj[destination].add(source);
		
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter no of vertex and edges");
		int v = sc.nextInt();
		int e = sc.nextInt();
		
		Graph graph = new Graph(v);
		
		System.out.println("Enter "+e+" edges");
		for(int i = 0; i < e; i++)
		{
			int source = sc.nextInt();
			int destination = sc.nextInt();
			graph.addEdge(source, destination);
		}
		
		System.out.println("Enter Source and destination to calculate bfs: ");
		
		int source = sc.nextInt();
		int destination = sc.nextInt();
		
		System.out.println(" distance between source and destination "+graph.bfs(source, destination));

	}

	public int bfs(int source, int destination)
	{
		int[] par = new int[adj.length];
		boolean[] vis = new boolean[adj.length];
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(source);
		
		par[source] = -1;
		vis[source] = true;
		
		while(!q.isEmpty())
		{
			int cur = q.poll();
			
			if(cur == destination) break;
			
			for(int neighbour: adj[cur])
			{
				if(!vis[neighbour])
				{
					vis[neighbour] = true;
					q.add(neighbour);
					par[neighbour] = cur;
				}
			}
		}
		int cur = destination;
		int distance = 0;
		while(par[cur] != -1)
		{
			System.out.print(cur+" <= ");
			cur = par[cur];
			distance++;
		}
		System.out.print(source);
		
		
		
		return distance;
	}

}
