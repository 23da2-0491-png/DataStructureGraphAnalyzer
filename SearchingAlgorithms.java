
import java.util.Arrays;

public class SearchingAlgorithms {

    public static class SearchResult {
        public int index;
        public int comparisons;

        public SearchResult(int index, int comparisons) {
            this.index = index;
            this.comparisons = comparisons;
        }
    }

    public static SearchResult linearSearch(
            int[] data, int target) {

        int comparisons = 0;

        for (int i = 0; i < data.length; i++) {
            comparisons++;

            if (data[i] == target) {
                return new SearchResult(i, comparisons);
            }
        }

        return new SearchResult(-1, comparisons);
    }

    public static SearchResult binarySearch(
            int[] data, int target) {

        int[] sorted = Arrays.copyOf(data, data.length);
        Arrays.sort(sorted);

        int low = 0;
        int high = sorted.length - 1;
        int comparisons = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            comparisons++;

            if (sorted[mid] == target) {
                return new SearchResult(mid, comparisons);
            } else if (sorted[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return new SearchResult(-1, comparisons);
    }
}