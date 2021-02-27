package com.hashtable;

public class MyLinkedList<K> {
	public INode<K> head;
	public INode<K> tail;

	public MyLinkedList() {
		this.head = null;
		this.tail = null;
	}

	public void add(INode<K> newNode) {
		if (this.tail == null) {
			this.tail = newNode;
		}
		if (this.head == null) {
			this.head = newNode;
		} else {
			INode<K> tempNode = this.head;
			this.head = newNode;
			this.head.setNext(tempNode);
		}
	}

	public void appendAfter(INode<K> newNode) {
		if (this.tail == null) {
			this.tail = newNode;
		}
		if (this.head == null) {
			this.head = newNode;
		} else {
			this.tail.setNext(newNode);
			this.tail = newNode;
		}
	}

	public void insert(INode<K> myNode, INode<K> newNode) {
		INode tempNode = myNode.getNext();
		myNode.setNext(newNode);
		newNode.setNext(tempNode);
	}

	public INode<K> pop() {
		INode tempNode = this.head;
		this.head = head.getNext();
		return tempNode;

	}

	public INode<K> popLast() {
		INode tempNode = this.head;
		while (!tempNode.getNext().equals(tail)) {
			tempNode = tempNode.getNext();
		}
		this.tail = tempNode;
		tempNode = tempNode.getNext();
		return tempNode;
	}

	public INode<K> searchNode(K key) {
		INode tempNode = head;
		while (tempNode != null && tempNode.getNext() != null) {
			if (tempNode.getKey().equals(key)) {
				return tempNode;
			} else {
				tempNode = tempNode.getNext();
			}
		}
		return null;
	}

	public INode<K> deleteNodeFronTheList(INode<K> targetNode) {
		INode tempNode = this.head;
		INode prev = null;
		if (tempNode != null && tempNode.getKey() == targetNode.getKey()) {
			tempNode.setNext(null);
			return tempNode;
		} else {
			while (tempNode != null && tempNode.getKey() != targetNode.getKey()) {
				prev = tempNode;
				tempNode = tempNode.getNext();
			}
			prev.setNext(tempNode.getNext());
			tempNode.setNext(null);
			return tempNode;
		}
	}

	public int size() {
		int size = 0;
		INode n = head;
		while (n != null) {
			size++;
			n = n.getNext();
		}
		return size;
	}
}