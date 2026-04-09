class MyHashMap {
    private static final int SIZE = 1000;
    static class Node {
        int key;
        int value;
    } 

    private List<List<Node>> map;

    public MyHashMap() {
        map = new ArrayList<>();
        for (int i = 0; i < SIZE; i++) {
            map.add(new ArrayList<Node>());
        }
    }
    
    public void put(int key, int value) {
        int idx = key % SIZE;
        List<Node> bucket = map.get(idx);
        boolean exists = false;

        // find node inside bucket
        for (Node n : bucket) {
            if (n.key == key) {
                n.value = value;
                exists = true;
                break;
            }
        }
    
        if (!exists) {
            Node n = new Node();
            n.key = key;
            n.value = value;

            bucket.add(n);
        }
    }
    
    public int get(int key) {
        int idx = key % SIZE;

        List<Node> bucket = map.get(idx);

        for (Node n : bucket) {
            if (n.key == key) return n.value;
        }

        return -1;
    }
    
    public void remove(int key) {
        int idx = key % SIZE;

        List<Node> bucket = map.get(idx);
        
        Iterator<Node> itr = bucket.iterator();

        while (itr.hasNext()) {
            Node n = itr.next();
            if (n.key == key){
                itr.remove();
                return;
            }
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */