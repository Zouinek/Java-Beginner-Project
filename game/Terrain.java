import java.util.Random; 
public class Terrain {
    char[] symbols = {'*','o','-'};
    char[][] map =
     {{'\\','0','0','0','/'},
       {'3','\\','0','/','1'},
       {'3','3','X','1','1'},
       {'3','/','2','\\','1'},
       {'/','2','2','2','\\'}};

    private void chooseChunk (char[]type){
        Random random = new Random();
        for ( int i = 0; i < type.length ; i++ ){
            int randomsymbol = random.nextInt(3);
            type[i] = symbols[randomsymbol];
        }
    }
    private void replace (char[] type){
         for(int i=0; i < map.length ;i++){
            for (int j=0 ; j < map[0].length; j++){

            
            
                switch (map[i][j]){
                    case '0':
                    map[i][j] = type[0];
                    break;
                    case '1':
                    map[i][j] = type[1];
                    break;
                    case '2':
                    map[i][j] = type[2];
                    break;
                    case '3':
                    map[i][j] = type[3];
                    break;

                }
            }
        }
    }
    private  void checkNeighbourhood (char[] type){
        if(type[0] == type[1]){
            map[0][4] = type[0];
            map[1][3] = type[0];
        }
        if(type[1] == type[2]){
            map[3][3] = type[1];
            map[4][4] = type[1];
        }
        if(type[2] == type[3]){
            map[3][1] = type[2];
            map[4][0] = type[2];
        }
        if(type[3] == type[0]){
            map[0][0] = type[3];
            map[1][1] = type[3];
        }
        if (type[0] == type[1] && type[1] == type[2] && type[2]==type[3] ){
            map[2][2] = 0;
        }
    }
    public void generate () {
        char [] type = new char[4];
        chooseChunk(type);
        replace(type);
        checkNeighbourhood(type);

    }
    public void print() {
        for(int i=0; i < map.length ;i++){
            for (int j=0 ; j < map[0].length; j++){
             System.out.print(map[i][j]+ " ");
            }
            System.out.println();
            
        }
    }
    public static void main (String[] args){
        Terrain terrain = new Terrain();
        terrain.generate();
        terrain.print();
    }
            

    

}