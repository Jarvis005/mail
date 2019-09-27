package com.neo.mail.service.impl;

import com.neo.mail.domain.model.ArrayStack;
import com.neo.mail.domain.model.PriortyQueue;
import com.neo.mail.domain.model.RoundQueue;
import com.neo.mail.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author EDZ
 */
@Service
public class TestServiceImpl implements TestService {
	
	private Logger logger = LoggerFactory.getLogger(TestServiceImpl.class);
	@Override
	public void testArrayStack() {
		ArrayStack arrayStack = new ArrayStack(3);
		arrayStack.push(1L);
		arrayStack.push(2L);
		arrayStack.push(3L);
		arrayStack.push(4L);
		boolean full = arrayStack.isFull();
		boolean empty = arrayStack.isEmpty();
		long peek = arrayStack.peek();
		arrayStack.display();
		long pop = arrayStack.pop();
		arrayStack.display();
		arrayStack.push(4L);
		arrayStack.display();
	}
	
	@Override
	public void testRoundQueue() {
		RoundQueue queue = new RoundQueue(2);
		queue.insert(1L);
		queue.insert(2L);
		queue.insert(3L);
		queue.display();
		queue.remove();
		queue.display();
		queue.insert(3L);
		queue.display();
	}
	
	@Override
	public void testPriortyQueue() {
		PriortyQueue queue = new PriortyQueue(5);
		queue.insert(20L);
		queue.insert(5L);
		queue.insert(3L);
		queue.insert(10L);
		queue.insert(2L);
		queue.insert(4L);
		queue.diaplay();
		logger.info("remove:{}" , queue.remove());
		queue.diaplay();
	}
}
