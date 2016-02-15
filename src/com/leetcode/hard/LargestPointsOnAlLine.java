package com.leetcode.hard;
import java.util.*;
public class LargestPointsOnAlLine {
	public static void main(String[] args){
		Point p1 = new Point(2,3);
		Point p2 = new Point(3,3);
		Point p3 = new Point(-5,3);
		Point[] points = {p1,p2,p3};
		System.out.println(maxPoints(points));
	}
	public static int maxPoints(Point[] points) {
        int result = 0;
    for(int i = 0; i < points.length; i ++){
        Point p1 = points[i];
	    int same = 0;
        int sameX = 0;
        int most = 0;
        Map<Double, Integer> map = new HashMap<>();
        for(int j = i; j < points.length; j ++){
           Point p2 = points[j];
           if(p1.x == p2.x && p1.y == p2.y){
	       same ++;
           }else if(p1.x == p2.x){
	       sameX ++;
           } else {
              double slope = Math.abs((p2.y - p1.y + 0.0) / (p2.x - p1.x));
              System.out.println(slope);
              if(!map.containsKey(slope)){
	           map.put(slope, 1);
              } else {
	           map.put(slope, map.get(slope) + 1);
              }
              most = Math.max(most, map.get(slope));
           }
        }
        most = Math.max(most, sameX) + same;
        result = Math.max(result, most);
    }
    return result;
    }
}

class Point{
	int x;
	int y;
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}