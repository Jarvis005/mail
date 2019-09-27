package com.neo.mail.domain.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 优先级队列是比栈和队列更专用的数据结构。优先级队列与上面普通的队列相比，
 * 主要区别在于队列中的元素是有序的，关键字最小（或者最大）的数据项总在队头。
 * 数据项插入的时候会按照顺序插入到合适的位置以确保队列的顺序。
 * 优先级队列的内部实现可以用数组或者一种特别的树——堆来实现
 * @author EDZ
 */
public class PriortyQueue {
	private Logger logger = LoggerFactory.getLogger(PriortyQueue.class);
	
	private long[] a;
	private int size;
	private int nitem;
	
	public PriortyQueue (int maxSize) {
		this.a = new long[maxSize];
		this.size = maxSize;
		nitem = 0;
	}
	
	public void insert(long value) {
		if (isFull()) {
			logger.info("队列已满");
			return;
		}
		int j;
		if (nitem == 0) {
			a[nitem++] = value;
		} else {
			for (j = nitem-1; j>=0; j--) {
				if (value > a[j]) {
					a[j+1] = a[j];
				} else {
					break;
				}
			}
			a[j+1] = value;
			nitem++;
		}
	}
	
	public long remove() {
		if (isEmpty()) {
			logger.info("队列为空!");
			return 0L;
		}
		return a[--nitem];
	}
	
	public boolean isFull () {
		return (nitem == size);
	}
	
	public boolean isEmpty() {
		return (nitem == 0);
	}
	
	public int size () {
		return nitem;
	}
	
	public void diaplay () {
		for (int i = nitem - 1; i>=0; i--) {
			logger.info("PriortyQueue：{}", a[i]);
		}
		logger.info(" ");
	}
}
