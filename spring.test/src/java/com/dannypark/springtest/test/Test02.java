package com.dannypark.springtest.test;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import org.junit.Test;

public class Test02 {

	@Test
	public void test() {
//		List list = new ArrayList();
//		list.add("가나다라마바사asdasasd");
//		list.add("C");
//		list.add(10);
//		
//		func01(list);
//		func02();
		TestVO[] polArr = new TestVO[4];
		polArr[0] = new TestVO();
		polArr[0].setPolYmd("20200101");
		polArr[1] = new TestVO();
		polArr[1].setPolYmd("19800101");
		polArr[2] = new TestVO();
		polArr[2].setPolYmd("19900101");
		polArr[3] = new TestVO();
		polArr[3].setPolYmd("20100801");		
		
		TreeMap<String, TestVO> tm = new TreeMap<String, TestVO>();
		for(int i = 0; i < polArr.length ; i++) {
			tm.put(polArr[i].getPolYmd(), polArr[i]);
		}
		
		SortedMap<String, TestVO> hm = tm.descendingMap();
		Set<String> kset = hm.keySet();
		Iterator<String> itKey = kset.iterator();
		for(int i = 0 ; itKey.hasNext() ; i++){
			String key = itKey.next();
			System.out.println(hm.get(key).getPolYmd());
		}
	}
	
	@Test
	public void test01(){
		String[][] polArr = new String[4][];
		polArr[0] = new String [] {"20200101", "1"};
		polArr[1] = new String [] {"19800101", "2"};
		polArr[2] = new String [] {"19900101", "3"};
		polArr[3] = new String [] {"20100801", "4"};
		
		String[][] sortedArr = new String[4][];
		
		TreeMap<String, Integer> tm = new TreeMap<String, Integer>();
		for(int i = 0; i < polArr.length ; i++) {
			tm.put(polArr[i][0], i);
		}
		
		//SortedMap<String, Integer> hm = tm.descendingMap();
		Set<String> kset = tm.keySet();
		Iterator<String> itKey = kset.iterator();
		for(int i = 0 ; itKey.hasNext() ; i++){
			String key = itKey.next();
			Integer idx = tm.get(key);
//			System.out.println(key + "/"+ polArr[idx][0] + "/"+ polArr[idx][1]);
			sortedArr[i] = polArr[idx];
		}
		
	}
	
	@Test
	public void test02(){
		String[][] polArr = new String[4][];
		polArr[0] = new String [] {"20200101", "1"};
		polArr[1] = new String [] {"19800101", "2"};
		polArr[2] = new String [] {"19900101", "3"};
		polArr[3] = new String [] {"20100801", "4"};
		
//		String[] polArr = new String[4];
//		polArr[0] = "20200101";
//		polArr[1] = "19800101";
//		polArr[2] = "19900101";
//		polArr[3] = "20100801";
//		
//		Arrays.sort(polArr);
		
//		Arrays.srot(polArr, (test1, test2) -> {return Integer.compare(test1[0], test2[1])})
//		Arrays.sort(polArr, new Comparator<int[]>(){ 
//				@Override
//				public int compare(int[] o1, int[] o2){
//					return o1[0] - o2[0];
//				}
//				
//		});
//
//		sortArray(polArr, new Comparator<int[]>(){ 
//			@Override
//			public int compare(int[] o1, int[] o2){
//				return o1[0] - o2[0];
//			}
//		
//		});
		sortArray(polArr);
		
		for(int i=0; i<4; i++){
			System.out.println(polArr[i][0]);
			System.out.println(polArr[i][1]);
		}
	}
	
	public void sortArray(String[][] arr){
		Comparator<String[]> tor = new Comparator<String[]>(){
			public int compare(String[] arr1, String[] arr2){
				if(Integer.parseInt(arr1[0])> Integer.parseInt(arr2[0]))
						return 1;
				else if(Integer.parseInt(arr1[0]) == Integer.parseInt(arr2[0]))
						return 0;
				else	return -1;
			}
		};
		Arrays.sort(arr, tor);
	}
	
	
	private void func01(List list) {
		if("C".equalsIgnoreCase((String)list.get(1))){
			String res1 = String.format("%%-%ds", list.get(2));
			//res1 = "%%-" + list.get(2) + "s";
			//String res2 = list.get(0).substring(0, Integer.parseInt(list.get(2)));
			System.out.println(res1);
			//System.out.println(res2);
			System.out.println(String.format(res1, list.get(0)));
		}		
	}
	
	private void func01(Map map) {
		System.out.println("@222");
	}
	
//	private void func02() {
//		TestVO vo = new TestVO();
//		vo.setLimit_V1("1000");
//		vo.setLimit_V2("2000");
//		vo.setLimit_V3("3000");
//		
//		Method[] methods = vo.getClass().getMethods();
//		for(int i = 0 ; i < methods.length ; i++) {
//			Method row = methods[i];
//			
//			//System.out.println(row.getName());
//			if(("getLimit_V"+"2").equals(row.getName())) {
//				try {
//					System.out.println(row.invoke(vo, new Object[0]));					
//				} catch (Exception e) {
//					// TODO: handle exception
//				}
//			}
//			
//		}
//	}
}
