package practice;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class SortingTest {
	
	int[] a1 = new int[10];
	int[] a2 = new int[100];
	int[] a3 = new int[1000];
	int[] a4 = new int[10000];
	int[][] m = new int[4][];
	
	
	@Before
	public void buildArrays(){
		buildArray(a1);
		buildArray(a2);
		buildArray(a3);
		buildArray(a4);
		m[0] = a1;
		m[1] = a2;
		m[2] = a3;
		m[3] = a4;
	}
	
	private void buildArray(int[] a){
		Random ran = new Random();
		for(int i = 0; i < a.length; i++){
			a[i] = ran.nextInt();
		}
	}
	
	@Test
	public void testSorting(){
		Sorting s = new Sorting();
		for(int i = 0; i < m.length; i++){
			int[] mm = m[i];
			int[] a = mm.clone();
			int[] b = a.clone();
			Arrays.sort(a);
			b = s.heapSortMinHeap(b);
			for(int j = 0; j < a.length; j++){
				assertEquals(a[j], b[j]);
			}
			System.err.println("heap sort verified");
			
			a = mm.clone();
			b = mm.clone();
			Arrays.sort(a);
			s.selectionSort(b);
			for(int j = 0; j < a.length; j++){
				assertEquals(a[j], b[j]);
			}
			System.err.println("selection sort verified");
			
			
			
		}
	}

}
