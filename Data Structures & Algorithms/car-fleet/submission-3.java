class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        // 1. build (position, time) pairs as a double[][]
        // 2. sort pairs by position descending
        // 3. for each pair in sorted order:
        //      if stack is empty OR current time > stack.peek(), push current time (new fleet leader)
        //      else do nothing (joins the fleet ahead)
        // 4. return stack.size()

        int n = position.length;
        double[][] cars = new double[n][2];

        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = (double) (target - position[i]) / speed[i]; // calculating time to reach target for this position
        }

        // sort in descending order based on position
        Arrays.sort(cars, (a,b) -> Double.compare(b[0], a[0])); // descending sort based on position

        // use stack to store leaders of fleet which will be equivalent to total fleets as no car can pass the car in front of it
        Deque<Double> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (stack.isEmpty() || cars[i][1] > stack.peek()) {
                stack.push(cars[i][1]);
            }
        }
        
        return stack.size();
    }
}
