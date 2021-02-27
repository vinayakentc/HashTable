package com.hashtable;


import static org.junit.Assert.*;
import org.junit.Test;
import com.hashtable.MyHashMap;
import com.hashtable.MyLinkedHashMap;

public class MyHashMapTest {

	@Test
	public void givenASentenceWhenWordsAreAddedToListShouldReturnWordFrequency() {
		String sentence = "To be or not to be";
		MyHashMap<String, Integer> myHashMap = new MyHashMap<String, Integer>();
		String[] words = sentence.toLowerCase().split(" ");
		for (String word : words) {
			Integer value = myHashMap.get(word);
			if (value == null)
				value = 1;
			else
				value = value + 1;
			myHashMap.add(word, value);
		}
		int frequency = myHashMap.get("to");
		assertEquals(2, frequency);
	}

	@Test
	public void givenASentenceWhenWordsAreAddedShouldReturnWordFrequency() {
		String sentence = "Paranoids are not paranoid because they are paranoid but "
				+ "because they keep putting themselves deliberately into " + "paranoid avoidable situations";
		MyLinkedHashMap<String, Integer> myLinkedHashMap = new MyLinkedHashMap<>();
		String[] words = sentence.toLowerCase().split(" ");
		for (String word : words) {
			Integer value = myLinkedHashMap.get(word);
			if (value == null)
				value = 1;
			else
				value = value + 1;
			myLinkedHashMap.add(word, value);
		}
		int frequency = myLinkedHashMap.get("paranoid");
		assertEquals(3, frequency);
	}

	@Test
	public void givenASentence_WhenWordsAreRemoved_ShouldReturnRemovedWord() {
		String sentence = "Paranoids are not paranoid because they are paranoid but because they keep putting themselves deliberately "
						   + "into paranoid avoidable situations";
		MyLinkedHashMap<String, Integer> myLinkedHashMap = new MyLinkedHashMap<>();
		String[] words = sentence.toLowerCase().split(" ");
		for (String word : words) {
			Integer value = myLinkedHashMap.get(word);
			if (value == null)
				value = 1;
			else
				value = value + 1;
			myLinkedHashMap.add(word, value);
		}
		myLinkedHashMap.remove("avoidable");
		Integer frequency = myLinkedHashMap.get("avoidable");
		assertEquals(null, frequency);
	}
}

