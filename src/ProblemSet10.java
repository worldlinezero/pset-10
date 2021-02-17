import java.util.Arrays;
public class ProblemSet10 {

    public static void main(String[] args) {

    }

    public String[] fizzBuzz(int start, int end) {
        if (start > end) {
            return null;
        }
        String[] arr = new String[end - start];
        int count = 0;
        for (int i = start; i < end; i++) {
            String addOn = "";
            if (i % 3 == 0) {
                addOn += "Fizz";
            }
            if (i % 5 == 0) {
                addOn += "Buzz";
            }
            if (addOn.length() == 0) {
                addOn = Integer.toString(i);
            }
            arr[count] = addOn;
            count++;
        }
        return arr;
    }

    public int maxSpan(int[] numbers) {
        int span;
        int max = 0;
        if (numbers == null) {
            return -1;
        }
        else if (numbers.length == 0) {
            span = 0;
        }
        else if (numbers.length == 1) {
            span = 1;
        }
        else {
            int temp = 0;
            for (int i = 0; i < numbers.length; i++) {
                for (int j = 0; j < numbers.length; j++) {
                    if (numbers[i] == numbers[j]) {
                        temp = j - i + 1;
                    }
                }
                if (temp > max) {
                    max = temp;
                }
            }
            span = max;
        }
        return span;
    }

    public int[] fix34(int[] numbers) {
        int others = 0;
        int threes = 0;
        int fours = 0;
        for (int number : numbers) {
            if (number == 3) {
                threes++;
            }
            if (number == 4) {
                fours++;
            } else {
                others++;
            }
        }
        boolean initFour = false;
        boolean consec = false;
        boolean end = false;
        for (int number : numbers) {
            initFour = number == 4;
        }
        for (int k = 0; k < numbers.length - 1; k++) {
            if (numbers[k] == 3 && numbers[k+1] == 4) {
                consec = true;
                break;
            }
        }
        if (numbers[numbers.length - 1] == 3) {
            end = true;
        }
        if (numbers == null || threes != fours || initFour || consec || end) {
            return null;
        }
        int[] arr = new int[numbers.length];
        int[] otherNumbers = new int[others];
        int otherIndex = 0;
        for (int number : numbers) {
            if (number != 3 && number != 4) {
                otherNumbers[otherIndex] = number;
                otherIndex++;
            }
        }
        for (int m = 0; m < numbers.length; m++) {
            if (numbers[m] == 3) {
                arr[m] = 3;
                arr[m + 1] = 4;
            }
        }
        int tempIndex = 0;
        for(int n = 0; n < numbers.length; n++) {
            if (arr[n] == 0){
                arr[n] = otherNumbers[tempIndex];
                tempIndex ++;
            }
        }
        return arr;
    }
    public int[] fix45(int[] numbers) {
        int others = 0;
        int fours = 0;
        int fives = 0;
        for (int number : numbers) {
            if (number == 4) {
                fours++;
            }
            if (number == 5) {
                fives++;
            } else {
                others++;
            }
        }
        boolean consec = false;
        for (int k = 0; k < numbers.length - 1; k++) {
            if (numbers[k] == 3 && numbers[k+1] == 4) {
                consec = true;
                break;
            }
        }
        if (numbers == null || fours != fives || consec) {
            return null;
        }
        int[] arr = new int[numbers.length];
        int[] otherNumbers = new int[others];
        int otherIndex = 0;
        for (int number : numbers) {
            if (number != 3 && number != 4) {
                otherNumbers[otherIndex] = number;
                otherIndex++;
            }
        }
        for (int m = 0; m < numbers.length; m++) {
            if (numbers[m] == 3) {
                arr[m] = 3;
                arr[m + 1] = 4;
            }
        }
        int tempIndex = 0;
        for(int n = 0; n < numbers.length; n++) {
            if (arr[n] == 0){
                arr[n] = otherNumbers[tempIndex];
                tempIndex ++;
            }
        }
        return arr;
    }

    public boolean canBalance(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return false;
        }
        int[] testArr = new int[numbers.length];
        boolean equal = false;
        int sum = 0;
        int testSum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum = 0;
            testSum = 0;
            testArr[i] = numbers[i];
            numbers[i] = 0;
            for (int number : numbers) {
                sum += number;
            }
            for (int k = 0; k < numbers.length; k++) {
                testSum += testArr[k];
            }
            if (testSum == sum) {
                equal = true;
                break;
            }
        }
        return equal;
    }
    public boolean linearIn(int[] outer, int[] inner) {
        boolean identicalCheck = Arrays.equals(outer, inner);
        if (inner == null || inner.length == 0 || outer == null || outer.length == 0) {
            return false;
        } else if (identicalCheck = true) {
            return true;
        } else {
            for (int i : inner) {
                boolean match = false;
                for (int j : outer) {
                    if (i == j) {
                        match = true;
                        break;
                    }
                }
                if (!match) {
                    return false;
                }
            }
            return true;
        }
    }

    public int[] squareUp(int n) {
        int [] square = new int[n * n];
        if (n < 0) {
            return null;
        }
        else {
            for (int i = n; i > 0; i--) {
                for (int j = 1; j <= i ; j++) {
                    square[n * i - j] = j;
                }
            }
            return square;
        }
    }

    public int[] seriesUp(int n) {
        if (n < 0) {
            return null;
        }
        else {
            int allIndices = 0;
            for (int i = 0; i <= n; i++) {
                allIndices += i;
            }
            int [] testArr = new int[allIndices];
            for (int i = 0; i <= n; i--) {
                for (int j = i; j > 0; j--) {
                    testArr[allIndices - 1] = j;
                    allIndices--;
                }
            }
            return testArr;
        }
    }

    public int maxMirror(int[] numbers) {
        if (numbers == null) {
            return -1;
        }
        int max = 0;
        for (int x = 0; x < numbers.length; ++x)
            for (int y = max + 1; y < numbers.length - x + 1; ++y)
            for (int z = x; z < numbers.length - y + 1; ++z) {
        boolean mirror = true;
        for (int i = 0; mirror && i < y; ++i)
            mirror = numbers[x + i] == numbers[z + y - i - 1];
        if (mirror) max = y;
        }
        return max;
    }

    public int countClumps(int[] numbers) {
        if (numbers == null) {
            return -1;
        }
        boolean clumped = false;
        int clumpNo = 0;
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] == numbers[i + 1]) {
                if (!clumped) {
                    clumpNo++;
                    clumped = true;
                }
            } else {
                clumped = false;
            }
        }
        return clumpNo;
    }
}
