import java.util.*;

class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] answer = new int[n - k + 1];

        for (int i = 0; i <= n - k; i++) {
            int[] sub = Arrays.copyOfRange(nums, i, i + k);

            // Step 2: Count occurrences
            Map<Integer, Integer> freq = new HashMap<>();
            for (int num : sub) {
                freq.put(num, freq.getOrDefault(num, 0) + 1);
            }

            // Step 3: Sort by freq DESC, value DESC
            List<Integer> sorted = new ArrayList<>(freq.keySet());
            sorted.sort((a, b) -> freq.get(b) != freq.get(a) ? freq.get(b) - freq.get(a) : b - a);

            // Step 4: Pick top x elements
            Set<Integer> keep = new HashSet<>();
            int count = 0;
            for (int num : sorted) {
                keep.add(num);
                count++;
                if (count == x) break;
            }

            // Step 5: Sum elements in sub that are in 'keep'
            int sum = 0;
            for (int num : sub) {
                if (keep.contains(num)) {
                    sum += num;
                }
            }
            answer[i] = sum;
        }
        return answer;
    }
}
