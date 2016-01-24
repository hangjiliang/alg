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

}
