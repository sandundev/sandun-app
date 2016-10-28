package com.sandun.personal.project.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;

public class ArrayListUtils {

	public static List<Long> getCollectionIds(Collection<?> coll) {
		List<Long> idList = new ArrayList<Long>();
		try {
			for (Iterator<?> iterator = coll.iterator() ; iterator.hasNext() ; ) {
				Object obj = iterator.next();
				idList.add((Long)PropertyUtils.getProperty(obj, "id"));
			}
			return idList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}	
}
