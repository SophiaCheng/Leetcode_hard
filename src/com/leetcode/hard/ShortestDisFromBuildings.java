package com.leetcode.hard;
import java.util.*;
public class ShortestDisFromBuildings {
    public int shortestDistance(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
	     return -1;
	 }
	 int[][] distance = new int[grid.length][grid[0].length];
	 int[][] count = new int[grid.length][grid[0].length];
	 int num = 0;
	 int res = Integer.MAX_VALUE;
	 for(int i = 0; i < grid.length; i ++){
		for(int j = 0; j < grid[0].length; j ++){
			if(grid[i][j] == 1){
				num ++;
				addDistance(grid, i, j, distance, count);
			}
		}
	 }
	 for(int i = 0 ; i < grid.length; i ++){
	    for(int j = 0; j < grid[0].length; j ++){
		if(grid[i][j] == 0 && count[i][j] == num){
		   res = Math.min(res, distance[i][j]);
		}
	    }
	 }
	 return res == Integer.MAX_VALUE ? -1 : res;
    }

    private void addDistance(int[][] grid, int i, int j, int[][] distance, int[][] count){
	int M = grid.length;
	int N = grid[0].length;
Queue<Cell> queue = new LinkedList<>();
boolean[][] visited = new boolean[M][N];
queue.offer(new Cell(i, j));
visited[i][j] = true;
int cost = 0;
while(!queue.isEmpty()){
	int size = queue.size();
	for(int k = 0; k < size; k ++){
		Cell cur = queue.poll();
		distance[cur.x][cur.y] += cost;
		if(cur.x + 1 < M && grid[cur.x + 1][cur.y] == 0 && !visited[cur.x + 1][cur.y]){
			queue.offer(new Cell(cur.x + 1, cur.y));
			count[cur.x + 1][cur.y] ++;
			visited[cur.x + 1][cur.y] = true;
		}
		if(cur.x - 1 >= 0 && grid[cur.x - 1][cur.y] == 0 && !visited[cur.x - 1][cur.y]){
			queue.offer(new Cell(cur.x - 1, cur.y));
			count[cur.x - 1][cur.y] ++;
			visited[cur.x - 1][cur.y] = true;
		}
		if(cur.y + 1 < N && grid[cur.x][cur.y + 1] == 0 && !visited[cur.x][cur.y + 1]){
			queue.offer(new Cell(cur.x, cur.y + 1));
			count[cur.x][cur.y + 1] ++;
			visited[cur.x][cur.y + 1] = true;
		}
		if(cur.y - 1 >= 0 && grid[cur.x][cur.y - 1] == 0 && !visited[cur.x][cur.y - 1]){
			queue.offer(new Cell(cur.x, cur.y - 1));
			count[cur.x][cur.y - 1] ++;
			visited[cur.x][cur.y - 1] = true;
		}
	}
	cost ++;
} 
    }
}

class Cell{
    int x;
    int y;
    public Cell(int x, int y){
	this.x = x;
	this.y = y;
    }
}