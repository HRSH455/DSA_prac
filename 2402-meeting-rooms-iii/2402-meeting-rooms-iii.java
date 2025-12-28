class Solution {
    public int mostBooked(int n, int[][] meetings) {
        // Sort meetings by start time
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));
        
        // Min-heap of free room indices
        PriorityQueue<Integer> freeRooms = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            freeRooms.offer(i);
        }
        
        // Min-heap of busy rooms: (endTime, roomIndex)
        PriorityQueue<long[]> busyRooms = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] == b[0]) return Long.compare(a[1], b[1]);
                return Long.compare(a[0], b[0]);
            }
        );
        
        long[] count = new long[n];
        
        for (int[] meeting : meetings) {
            long start = meeting[0];
            long end = meeting[1];
            long duration = end - start;
            
            // Free up rooms whose meetings have finished by 'start'
            while (!busyRooms.isEmpty() && busyRooms.peek()[0] <= start) {
                long[] finished = busyRooms.poll();
                int roomIdx = (int) finished[1];
                freeRooms.offer(roomIdx);
            }
            
            int room;
            long newEnd;
            if (!freeRooms.isEmpty()) {
                // Use the smallest indexed free room
                room = freeRooms.poll();
                newEnd = end;
            } else {
                // Delay the meeting to earliest available room
                long[] earliest = busyRooms.poll();
                long curEnd = earliest[0];
                room = (int) earliest[1];
                newEnd = curEnd + duration;  // delayed end time
            }
            
            count[room]++;
            busyRooms.offer(new long[] { newEnd, room });
        }
        
        // Find room with maximum count; smallest index on tie
        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (count[i] > count[ans]) {
                ans = i;
            }
        }
        return ans;
    }
}