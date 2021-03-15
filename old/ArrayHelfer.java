public class ArrayHelfer {

    public static int arrayGet(int[] array, int i) throws IndexOutOfBoundsException {
        return array[i];
    }

    public static int sum(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }

    public static double mean(int[] array) {
        double sum = 0.0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum / array.length;
    }

    public static void square(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] *= array[i];
        }
    }

    public static int max(int[] array) {
        int high = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > high) {
                high = array[i];
            }
        }
        return high;
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[index]) {
                    index = j;
                }
            }
            int smallerNumber = array[index];
            array[index] = array[i];
            array[i] = smallerNumber;
        }
    }

    public static int median(int[] array) {
        return array[array.length / 2];
    }

    public static int[] resize(int[] array, int length) {
        int[] new_array = new int[length];
        try {
            for (int i = 0; i < length; i++) {
                new_array[i] = array[i];
            }
        } catch (IndexOutOfBoundsException e) {
            return new_array;
        }
        return new_array;
    }

    public static String show(int[] array) {
        String temp = "[ ";
        for (int i = 0; i < array.length; i++) {
            temp += array[i] + " ";
        }
        return temp += "]";
    }
}