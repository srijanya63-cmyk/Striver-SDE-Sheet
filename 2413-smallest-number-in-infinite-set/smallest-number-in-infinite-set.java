class SmallestInfiniteSet {

    private int current;
    private PriorityQueue<Integer> minHeap;
    private HashSet<Integer> set;

    public SmallestInfiniteSet() {
        current = 1;
        minHeap = new PriorityQueue<>();
        set = new HashSet<>();
    }

    public int popSmallest() {

        if (!minHeap.isEmpty()) {
            int num = minHeap.poll();
            set.remove(num);
            return num;
        }

        return current++;
    }

    public void addBack(int num) {

        if (num < current && !set.contains(num)) {
            minHeap.offer(num);
            set.add(num);
        }
    }
}