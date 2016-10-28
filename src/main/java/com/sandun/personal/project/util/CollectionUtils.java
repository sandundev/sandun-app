package com.sandun.personal.project.util;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.google.common.collect.Sets;

public class CollectionUtils {

	public static <T> boolean containsDuplicates(Collection<T> colllection) {
		Set<T> set = new HashSet<T>(colllection);
		return (set.size() < colllection.size()) ? true : false;
	}

	public static <T> boolean isNotEmptyAndDoesNotContainDuplicates(Collection<T> colllection) {
		return !colllection.isEmpty() && !CollectionUtils.containsDuplicates(colllection);
	}

	public static <T> boolean isNotEmptyAndContainsDuplicates(Collection<T> colllection) {
		return !colllection.isEmpty() && CollectionUtils.containsDuplicates(colllection);
	}

	public static <T> boolean isNotEmptyAndElementsInCollectionTheSame(Collection<T> colllection) {
		return !colllection.isEmpty() && (Sets.newHashSet(colllection).size() == 1);
	}

	public static <T> boolean collectionIsNotNullOrEmpty(Collection<T> colllection) {
		return colllection != null && !colllection.isEmpty();
	}

	public static <T> boolean collectionIsNullOrEmpty(Collection<T> colllection) {
		return !CollectionUtils.collectionIsNotNullOrEmpty(colllection);
	}

	public static <K, V> boolean mapIsNotNullOrEmpty(Map<K, V> map) {
		return map != null && !map.isEmpty();
	}

	public static <K, V> boolean mapIsNullOrEmpty(Map<K, V> map) {
		return !mapIsNotNullOrEmpty(map);
	}

	public static <T> List<T> removeDuplicates(List<T> list) {
		return list.stream().collect(Collectors.toSet()).stream().collect(Collectors.toList());
	}
}
