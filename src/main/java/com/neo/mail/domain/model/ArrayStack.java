package com.neo.mail.domain.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author EDZ
 * 栈   先进后出，只能访问栈顶的数据
 */
public class ArrayStack {
	private Logger logger = LoggerFactory.getLogger(ArrayStack.class);
	private long[] arr;
	private int size;
	private int top;
	
	public ArrayStack() {
	}
	
	public ArrayStack(long[] arr, int size, int top) {
		this.arr = arr;
		this.size = size;
		this.top = top;
	}
	
	public ArrayStack(int maxSize) {
		this.size = maxSize;
		this.arr = new long[maxSize];
		// 空栈
		this.top = -1;
	}
	
	/**
	 * 入栈
	 * @return
	 */
	public void push(long value) {
		if (isFull()) {
			logger.info("栈已满!");
			return;
		}
		arr[++top] = value;
	}
	/**
	 * 返回栈顶内容, 不删除
	 */
	public long peek() {
		if (isEmpty()) {
			logger.info("栈中没有数据!");
			return 0;
		}
		return arr[top];
	}
	/**
	 * 弹出栈顶内容, 删除
	 */
	public long pop() {
		if (isEmpty()) {
			logger.info("栈中没有数据!");
			return 0;
		}
		return arr[top--];
	}
	
	/**
	 * 遍历数据
	 */
	public void display() {
		for (int i = top; i>=0;i--) {
			logger.info("ArrayStack: " + arr[i] + " ");
		}
		logger.info("");
	}
	
	/**
	 * 是否已满
	 * @return
	 */
	public boolean isFull() {
		return (top == size - 1);
	}
	
	/**
	 * 是否空栈
	 * @return
	 */
	public boolean isEmpty() {
		return (top == -1);
	}
	
	/**
	 * 获取size
	 * @return
	 */
	public int size() {
		return top + 1;
	}
	
	public long[] getArr() {
		return arr;
	}
	
	public void setArr(long[] arr) {
		this.arr = arr;
	}
	
	public int getSize() {
		return size;
	}
	
	public void setSize(int size) {
		this.size = size;
	}
	
	public int getTop() {
		return top;
	}
	
	public void setTop(int top) {
		this.top = top;
	}
}
