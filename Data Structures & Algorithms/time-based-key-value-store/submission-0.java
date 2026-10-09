class TimeMap {

    private class Node {
        String val;
        int ts;

        Node(String val, int timestamp) {
            this.val = val;
            this.ts = timestamp;
        }

        public String getVal(){ return val;}

        public int getTs(){ return ts;}
    }

    private Map<String,List<Node>> timeMap;

    public TimeMap() {
        timeMap = new HashMap();
    }
    
    public void set(String key, String value, int timestamp) {
        Node node = new Node(value,timestamp);
        List<Node> valList;
        List<Node> entryVal = timeMap.get(key);
        if(entryVal != null) {
            valList = entryVal;
        } else {
            valList = new ArrayList<Node>();
        }
        valList.add(new Node(value,timestamp));
        timeMap.put(key,valList);
    }
    
    public String get(String key, int timestamp) {
        List<Node> entryVal = timeMap.get(key);
        if(entryVal == null) return "";
        return findVal(entryVal, timestamp);

    }

    private String findVal(List<Node> valList, int timestamp) {
        int l=0;
        int r=valList.size()-1;
        String desiredVal="";
        while(l<=r) {
            int mid=l+(r-l)/2;
            Node midNode = valList.get(mid);
            if(midNode.getTs() == timestamp) return midNode.getVal();
            if(midNode.getTs() < timestamp) {
                desiredVal = midNode.getVal();
                l=mid+1;
            } else {
                r=mid-1;
            }
        }
        return desiredVal;
    }
}
