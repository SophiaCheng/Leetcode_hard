package com.leetcode.hard;
import java.util.*;
public class InsertInterval {
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> list = new ArrayList<>();
        if(intervals == null || intervals.isEmpty()){
        	list.add(newInterval);
        	return list;
        } else if(newInterval.start > intervals.get(intervals.size() - 1).end){
        	intervals.add(intervals.size(), newInterval);
        	return intervals;
        } else if(newInterval.end < intervals.get(0).start){
        	intervals.add(0, newInterval);
        	return intervals;
        }
        // to find the start Interval
        int i = 0;
        while(i < intervals.size()){
        	if(newInterval.start > intervals.get(i).end){
        		list.add(intervals.get(i));
        		i ++;
        	}else{
        		break;
        	}
        }
        
        Interval begin = new Interval();
        if(i < intervals.size()){
        	  begin = intervals.get(i);
        } else{
        	 begin = intervals.get(intervals.size() - 1);
        } // corner case
        
        while(i < intervals.size()){
        	if(newInterval.end >= intervals.get(i).start){
        		i ++;
        	}else{
        		break;
        	}
        }
        
        // create a new Interval 
       int start = Math.min(newInterval.start, begin.start);
       int end = Math.max(newInterval.end, intervals.get(i - 1).end);
       Interval insert = new Interval(start, end);
        list.add(insert);
        
        // to add the remaining Intervals
        while(i < intervals.size()){
        	list.add(intervals.get(i));
        	i ++;
        }
        return list;
    }
}
