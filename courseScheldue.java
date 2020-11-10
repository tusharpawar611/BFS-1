class Solution {
    
    private int numOfNodes;
    private boolean directed;
    private float[][] matrix;

   
    private boolean[][] isSetMatrix;
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        HashMap<Integer,List<Integer>> adj = new HashMap<>();
        int[] indegrees = new int[numCourses];
        
        for(int[] n : prerequisites){
            indegrees[n[0]]++;
            if(!adj.containsKey(n[1])){
                adj.put(n[1],new ArrayList<Integer>());
            }
            adj.get(n[1]).add(n[0]);
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<indegrees.length;i++){
            if(indegrees[i]==0){
                q.offer(i);
            }
        }
        int count =0;
        while(!q.isEmpty()){
            int temp = q.poll();
            count++;
            if(adj.containsKey(temp)){
                for(int k : adj.get(temp)){
                    if(--indegrees[k]==0){
                        q.offer(k);
                    }
                }
            }
        }
        return count == numCourses;
    } 
}