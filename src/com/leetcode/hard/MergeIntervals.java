package com.leetcode.hard;
import java.util.*;

 

public class MergeIntervals {
	public static void main(String[] args){
		List<Interval> intervals = new ArrayList<>();
		intervals.add(new Interval(1,4));
		intervals.add(new Interval(1,4));
//		intervals.add(new Interval(15,18));
//		intervals.add(new Interval(8,10));
		List<Interval> result = merge(intervals);
		for(int i = 0; i < result.size(); i ++){
			System.out.print(result.get(i).start + " "+ result.get(i).end);
			System.out.println();
		}
	}
	 public static List<Interval> merge(List<Interval> intervals) {
	      List<Interval> list = new ArrayList<>();
	      if(intervals == null || intervals.isEmpty()){
	    	  return list;
	      }
	       
	      
	      Collections.sort(intervals,new Comparator<Interval>(){
	    	  public int compare(Interval i1, Interval i2){
	    		  if(i1.start == i2.start){
	    			  return 0;
	    		  } else{
	    			  return (i1.start < i2.start ? -1 : 1);
	    		  }
	    	  }
	      } );
	      
	     list.add(intervals.get(0));
	     for(int i = 1; i < intervals.size(); i ++){
	    	 Interval last = list.get(list.size() - 1);
	    	 if(intervals.get(i).start <= last.end){
	    		 last.end = Math.max(last.end, intervals.get(i).end);
	    	 } else{
	    		 list.add(intervals.get(i));
	    	 }
	     }
		 return list;
	 }
}

class Interval{
	int start;
	int end;
	Interval(){
		start = 0;
		end = 0;
	}
	Interval(int start, int end){
		this.start = start;
		this.end = end;
	}
}