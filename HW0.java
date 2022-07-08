//Exercise 1

public class Triangle {
	/** Draws a triangle with five lines of *
	 */
    public static void main(String[] args) {
       int n = 1;
       String star = "*";
       while (n < 6) {
          System.out.println(star);
          n = n + 1;
          star = star + "*";
        }
    }
}


public class Triangle {
	/** Generalizes previous triangle class
	 * allows for drawing of N sized triangle
	 */
    public static void main(String[] args) {
       drawTriangle(10);
    }
     
   public static void drawTriangle (int N) {
       int n = 1;
       String star = "*";
       while (n <= N) {
          System.out.println(star);
          n = n + 1;
          star = star + "*";
        }    
   }
}

//Excercise 2

public class max {
    /** Returns the maximum value from m by executing a brute force search assuming all ints
     * greater than or equals to zero using while loop
     */
    public static int max(int[] m) {
    	int pos = 0;
    	int var = 0;
    	while (pos < m.length) {
    		if (m[pos] > var) {
    			var = m[pos];
    		}
    		pos = pos + 1;
    	}
    	return var;
    }
    public static void main(String[] args) {
       int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};
       System.out.println(max(numbers));
   }
}

//Excercise 3

public class max {
    /** Returns the maximum value from m by executing a brute force search assuming all ints
     * greater than or equals to zero using for loop
     */
    public static int max(int[] m) {
    	int var = 0;
    	for (int pos = 0; pos < m.length; pos = pos + 1) {
    		if (m[pos] > var) {
    			var = m[pos];
    		}
    	}
    	return var;
    }

    public static void main(String[] args) {
       int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};
       System.out.println(max(numbers));
   }
}

//Excercise 4

public class BreakContinue {
  public static void windowPosSum(int[] a, int n) {
    /** your code here */
    for (int i = 0; i < a.length; i ++) {
    	if (a[i] < 0)
    		continue;
    	for (int j = i + 1; j <= i + n; j ++) {
    		if (j == a.length)
    			break;
    		a[i] += a[j];
    	}
    } 
  }

  public static void main(String[] args) {
    int[] a = {1, 2, -3, 4, 5, 4};
    int n = 3;
    windowPosSum(a, n);

    // Should print 4, 8, -3, 13, 9, 4
    System.out.println(java.util.Arrays.toString(a));
  }
}


