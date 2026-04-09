class MyHashSet {
    private static final int SIZE = 1000;
    private List<List<Integer>> set;

    public MyHashSet() {
        set = new ArrayList<>();
        for (int i = 0; i < SIZE; i++) {
            set.add(new ArrayList<Integer>());
        }
    }
    
    public void add(int key) {
        // check if bucket already contains this key

        // get key location (index) using hash method
        int idx = key % SIZE;

        List<Integer> bucket = set.get(idx);

        if (!bucket.contains(key)) {
            bucket.add(key);
        }
    }
    
    public void remove(int key) {
        int idx = key % SIZE;

        List<Integer> bucket = set.get(idx);

        if (bucket.contains(key)) {
            bucket.remove((Integer) key);
        }
    }
    
    public boolean contains(int key) {
        int idx = key % SIZE;

        List<Integer> bucket = set.get(idx);

        return bucket.contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */