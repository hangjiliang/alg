package practice;

public class Sorting {
	
	public void heapSortMaxHeap(int[] a){
		for(int i = a.length-1; i >= 1; i--){
			maxHeapify(a, i);
			// swap
			int temp = a[0];
			a[0] = a[i];
			a[i] = temp;
		}
	}
	
	public int[] heapSortMinHeap(int[] a){
		int[] r = new int[a.length];
		for(int i = a.length - 1; i >= 1; i--){
			minHeapify(a, i);
			r[a.length-1-i] = a[0];
			// swap
			int temp = a[0];
			a[0] = a[i];
			a[i] = temp;
		}
		r[a.length-1] = a[0];
		return r;
	}
	
	private void maxHeapify(int[] a, int endIndex){
		for(int i = (endIndex-1)>>1; i >= 0; i--){
			int v = a[i];
			int k = i;
			boolean heap = false;
			while(!heap && 2*k+1 <= endIndex){
				int j = 2*k+1;
				if(j < endIndex){
					if(a[j+1] > a[j]){
						j++;
					}
 				}
				if(v >= a[j]){
					heap = true;
				}else{
					a[k] = a[j];
					k = j;
				}
			}
			a[k] = v;
		}
	}
	
	private void minHeapify(int[] a, int endIndex){
		for(int i = (endIndex-1)>>1; i >= 0; i--){
			int v = a[i];
			int k = i;
			boolean heap = false;
			while(!heap && 2*k+1 <= endIndex){
				int j = 2*k+1;
				if(j < endIndex){
					if(a[j] > a[j+1]){
						j++;
					}
				}
				if(v <= a[j]){
					heap = true;
				}else{
					a[k] = a[j];
					k = j;
				}
			}
			a[k] = v;
		}
	}
	
	public void selectionSort(int[] a){
		for(int i = 0; i < a.length-1; i++){
			int min = i;
			for(int j = i+1; j < a.length; j++){
				if(a[j] < a[min]){
					min = j;
				}
			}
			// swap
			int temp = a[i];
			a[i] = a[min];
			a[min] = temp;
		}
	}
	
	public void bubbleSort(int[] a){
		for(int i = 0; i < a.length-1; i++){
			for(int j  = 0; j < a.length-1-i; j++){
				if(a[j] > a[j+1]){
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
	}
	
	public void insertionSort(int[] a){
		for(int i = 0 ; i < a.length; i++){
			int v = a[i];
			int j = i-1;
			while(j >= 0 && a[j] > v){
				a[j+1] = a[j];
				j--;
			}
			a[j+1] = v;
		}
	}
	
	public void mergeSort(int[] a){
		int n = a.length;
		if(n > 1){
			int[] b = new int[n/2];
			int[] c = new int[n-n/2];
			for(int i = 0; i < n/2; i++){
				b[i] = a[i];
			}
			for(int i = n/2; i < n; i++){
				c[i-n/2] = a[i];
			}
			mergeSort(b);
			mergeSort(c);
			merge(b, c, a);
		}
	}
	
	private void merge(int[] a, int[] b, int[] c){
		int p = a.length;
		int q = b.length;
		int i = 0;
		int j = 0;
		int k = 0;
		while(i<p && j<q){
			if(a[i] <= b[j]){
				c[k] = a[i];
				i++;
			}else{
				c[k] = b[j];
				j++;
			}
			k++;
		}
		if(i == p){
			// copy b
			while(j<q){
				c[k] = b[j];
				j++;
				k++;
			}
		}else{
			// copy a
			while(i<p){
				c[k] = a[i];
				i++;
				k++;
			}
		}
	}
	
	public void quickSort(int[] a){
		quickSort(a, 0, a.length-1);
	}
	
	public void quickSort(int[] a, int left, int right){
		if(left < right){
			int s = partition(a, left, right);
			quickSort(a, left, s-1);
			quickSort(a, s+1, right);
		}
	}
	
	private int partition(int[] a, int left, int right){
		int pivot = a[left];
		int l = left;
		int r = right;
		while(l < r){
			while(l < right && a[l] <= pivot){
				l++;
			}
			while(r > left && a[r] > pivot){
				r--;
			}
			// swap
			int temp = a[l];
			a[l] = a[r];
			a[r] = temp;
		}
		// swap the last round
		int temp = a[l];
		a[l] = a[r];
		a[r] = temp;
		
		a[left] = a[r];
		a[r] = pivot;
		return r;
	}
	
	public static void main(String[] args){
		int[] a = {6, 1, 2, 3, 4};
		Sorting s = new Sorting();
		s.partition(a, 0, a.length-1);
	}

}
