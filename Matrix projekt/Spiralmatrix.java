import java.util.List;
  class  Spiralmatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> arr = new ArrayList();
        if ( matrix.length == 0 ) return arr ; 
         int brows = 0;
         int bcols = 0;
         int rows = matrix.length -1; 
         int cols = matrix[0].length -1 ;  
         
         while ( brows <= rows && bcols <= cols) {
          for (int i = bcols ; i <= cols; i++){
           arr.add(matrix[brows][i]);
          } 
             brows++;
             for (int i = brows; i <= rows; i ++){
                 arr.add(matrix[i][cols]);
             }
             cols--; 
             if (brows <= rows){
                 for (int i = cols ; i >= bcols; i--){
                     arr.add(matrix[rows][i]);
                 }
                
             }
             rows--;
             if (bcols <= cols) {
                 for (int i = rows ; i >= brows ; i--){
                     arr.add(matrix[i][bcols]);
                 }
             }
             bcols++;
         
             
                 } 
        return arr; 
    }
    
}