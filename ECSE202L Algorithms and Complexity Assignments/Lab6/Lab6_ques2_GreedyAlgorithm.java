import java.util.Arrays;
import java.util.Comparator;

/* I have done this assignment on my own. I have not copied any code from
another student or any online source. I understand if my code is found
similar to somebody else's code, my case can be sent to the Disciplinary
committee of the institute for appropriate action." */

public class FractionalKnapsack {

    static class Item {
	int value, weight;

	
	public Item(int value, int weight) {
	    this.value = value;
	    this.weight = weight;
	}
    }

    
    static double fractionalKnapsack(int W, Item[] arr, int n) {
	
	Arrays.sort(arr, new Comparator<Item>() {

	    @Override
	
	    public int compare(Item o1, Item o2) {
			return (int) ((o2.value / o2.weight) - (o1.value / o1.weight));
	    }
	});

	
	for (int i = 0; i < n; i++) {
	    System.out.println(arr[i].value + "  " + arr[i].weight);
	}

	int curWeight = 0; 
	double finalvalue = 0.0;

	
	for (int i = 0; i < n; i++) {
	
	    if (curWeight + arr[i].weight <= W) {
		curWeight += arr[i].weight;
		finalvalue += arr[i].value;
	    }

	
	    else {
		int remain = W - curWeight;
		finalvalue += arr[i].value * ((double) remain / arr[i].weight);
		break;//
	    }
	}

	
	return finalvalue;
    }

    public static void main(String[] args) {

	Item[] arr = { new Item(100, 20), new Item(60, 10), new Item(120, 30) };
	System.out.println(fractionalKnapsack(50, arr, arr.length));
    }
}