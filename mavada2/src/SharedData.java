import java.util.ArrayList;

/**
 * Shared data object used by two threads to collaboratively search
 * for a subset of the array that sums to b.
 * @author Hadishof
 * @version 1.0
 */
public class SharedData {

    /** The array of integers to search within */
    private ArrayList<Integer> array;

    /** Boolean array indicating which elements are part of the solution */
    private boolean[] winArray;

    /** Flag indicating whether a solution has been found */
    private boolean flag;

    /** The target sum value to find in the array */
    private final int b;

    /**
     * Constructor for SharedData.
     * Initializes the array and target value b.
     * @param array the list of integers to search within
     * @param b the target sum to find
     */
    public SharedData(ArrayList<Integer> array, int b) {
        this.array = array;
        this.b = b;
    }

    /**
     * Returns the win array indicating which elements form the solution.
     * @return boolean array where true means the element is part of the solution
     */
    public boolean[] getWinArray() {
        return winArray;
    }

    /**
     * Sets the win array with the solution elements.
     * @param winArray boolean array representing the solution elements
     */
    public void setWinArray(boolean[] winArray) {
        this.winArray = winArray;
    }

    /**
     * Returns the array of integers.
     * @return the ArrayList of integers
     */
    public ArrayList<Integer> getArray() {
        return array;
    }

    /**
     * Returns the target sum value b.
     * @return the target sum b
     */
    public int getB() {
        return b;
    }

    /**
     * Returns whether a solution has been found.
     * @return true if a solution was found, false otherwise
     */
    public boolean getFlag() {
        return flag;
    }

    /**
     * Sets the flag to indicate whether a solution has been found.
     * @param flag true if solution found, false otherwise
     */
    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}