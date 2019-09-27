package com.neo.mail.domain.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 队列也可以用数组来实现，不过这里有个问题，当数组下标满了后就不能再添加了，
 * 但是数组前面由于已经删除队列头的数据了，导致空。所以队列我们可以用循环数组来实现，见下面的代码：
 * @author EDZ
 */
public class RoundQueue {
	private Logger logger = LoggerFactory.getLogger(RoundQueue.class);
	private long[] a;
	/**
	 * 实际存储量
	 */
	private int nItems;
	/**
	 * 数组大小
	 */
	private int size;
	/**
	 * 头
	 */
	private int front;
	/**
	 * 尾
	 */
	private int rear;
	
	public RoundQueue() {
	}
	
	public RoundQueue(int maxSize) {
		this.a = new long[maxSize];
		this.size = maxSize;
		this.nItems = 0;
		this.front = 0;
		this.rear = -1;
	}
	
	public void display () {
		if (isEmpty()) {
			logger.info("队列为空!");
			return;
		}
		int item = front;
		for (int i = 0; i < nItems; i++) {
			logger.info("RoundQueue: {}, {}", a[item++ % size], " ");
		}
		logger.info(" ");
	}
	
	public void insert (long value) {
		if (isFull()) {
			logger.info("队列已满!");
			return;
		}
		rear = ++rear % size;
		a[rear] = value;
		nItems++;
	}
	
	public long remove () {
		if (isEmpty()) {
			logger.info("队列为空!");
			return 0;
		}
		nItems--;
		front = front%size;
		return a[front++];
	}
	
	public long peek() {
		if (isEmpty()) {
			logger.info("队列为空!");
			return 0;
		}
		return a[front];
	}
	
	public boolean isFull () {
		return (nItems == size);
	}
	
	public boolean isEmpty () {
		return (nItems == 0);
	}
	
	public int size() {
		return nItems;
	}
}
