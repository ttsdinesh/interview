import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * @author Dinesh Thangaraj
 *
 *         Created on 12-May-2018
 * 
 *         Find the Kth most frequently occurring char in a string. Return -1 if
 *         nothing is found. If 2 chars have the same freq, return the smallest
 *         char.
 */
public class WhatFix {
	public static void main(String[] args) {
		kFreq("aaabbacccd", 2);
		kFreq("aabcd", 3);
		kFreq("aaabbbcd", 1);
		kFreq("aaabbbcd", 0);
		kFreq("aaabbbcd", 3);
		kFreq("aaabbbcd", 2);
		kFreq("aaa", 1);
		kFreq("aaa", 2);
	}

	private static void kFreq(final String s, final int k) {
		if (s == null || s.length() < 1 || k < 1) {
			System.out.println("-1");
			return;
		}
		Map<Character, Integer> tm = new TreeMap<Character, Integer>();
		for (char c : s.toCharArray())
			tm.put(c, tm.getOrDefault(c, 0) + 1);

		Map<Integer, LinkedList<Character>> countChar = new TreeMap<Integer, LinkedList<Character>>((a, b) -> b - a);
		for (Entry<Character, Integer> entry : tm.entrySet())
			countChar.put(entry.getValue(),
					countChar.getOrDefault(entry.getValue(), new LinkedList<Character>(List.of(entry.getKey()))));

		int count = 0;
		for (Entry<Integer, LinkedList<Character>> entry : countChar.entrySet())
			if (++count == k) {
				System.out.println(entry.getValue().get(0));
				return;
			}

		System.out.println("-1");
	}
}
