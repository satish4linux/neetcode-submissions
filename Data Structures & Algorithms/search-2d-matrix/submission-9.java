class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length==1) return searchRow(matrix[0],target);
        int il=0;
        int n= matrix.length-1;
        int ir=n;

        while(il<=ir) {
            int imid= il + (ir-il)/2;
            if(matrix[imid][0] == target) return true;
            else if(matrix[imid][0] < target) {
                System.out.println("checkpnt 1");
                if(imid+1 <= n) { 
                    if(matrix[imid+1][0] > target) return searchRow(matrix[imid], target);
                    else {System.out.println("checkpnt 3");il=imid+1;}
                    }
                else return searchRow(matrix[imid], target);
            }
            else {
                System.out.println("checkpnt 2");
                if(imid-1 >= 0) {
                    if(matrix[imid-1][0] <= target) return searchRow(matrix[imid-1],target);
                    else ir=imid-1;
                }
                else return searchRow(matrix[imid],target);
            }
        }
        return false;
    }

    private boolean searchRow(int[] row, int target) {
        System.out.println("row - " + row[0]);
        int l = 0;
        int r = row.length-1;
        while(l<=r) {
            int mid =l + (r-l)/2;
            if(row[mid] == target) return true;
            else if(row[mid] < target) l++;
            else r--;
        }
        return false;
    }
}
