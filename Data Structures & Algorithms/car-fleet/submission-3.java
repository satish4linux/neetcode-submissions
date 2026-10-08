class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Integer[] indices = new Integer[position.length];
        for(int i=0;i<indices.length;i++) indices[i] = i;
        Arrays.sort(indices, (a,b) -> Integer.compare(position[b],position[a]));

        int[] sortedSpeed = new int[indices.length];
        int[] sortedPosition = new int[indices.length];
        for(int i=0;i<indices.length;i++) {
            sortedSpeed[i] = speed[indices[i]];
            sortedPosition[i] = position[indices[i]];
        }

        double[] time = new double[indices.length];
        for(int i=0;i<indices.length;i++) {
            time[i] = (double)((double)target - (double)sortedPosition[i])/(double)sortedSpeed[i];
        }

        Deque<Double> ms = new ArrayDeque();
        for(int i=0;i<time.length;i++) {
            if(ms.isEmpty()) ms.push(time[i]);
            else {
                if(ms.peek() < time[i]) ms.push(time[i]);
            }
        }
        return ms.size();
    }
}
