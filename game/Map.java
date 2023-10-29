public class Map {
    String[][] map = new String[31][51];

    public static void main(String[] args) {
        Map instance = new Map();
        instance.draw();
    }

    public Map() {

        for (int i = 0; i < 31; i++) {
            for (int j = 0; j < 51; j++) {
                if (j % 10 == 0 && i % 6 == 0) {
                    map[i][j] = "+";
                } else if (j % 10 == 0) {
                    map[i][j] = "|";
                } else if (i % 6 == 0) {
                    map[i][j] = "-";
                } else {
                    map[i][j] = " ";
                }

            }
        }
    }

    public boolean isEmpty(int Xpos, int Ypos) {

        if (map[1 + 6 * Xpos][1 + 10 * Ypos].equals(" ")) {
            return true;

        } else {
            System.out.println("Dieses Feld ist bereits belegt, bitte wählen Sie ein anderes Feld!");
            return false;

        }
    }

    public boolean isFull() {

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (map[1 + 6 * i][1 + 10 * j].equals(" ")) {
                    return false;

                }
            }
            
        }
        return true;
    }

    public int place(Player currentPlayer, String[][] chosen, int Xpos, int Ypos) {

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 9; j++) {
                map[1 + 6 * Xpos + i][1 + 10 * Ypos + j] = chosen[i][j];
            }
        }
        return  currentPlayer.points;
    }

    public void draw() {

        for (int i = 0; i < 31; i++) {
            for (int j = 0; j < 51; j++) {
                System.out.print(map[i][j]);

            }
            System.out.println();
        }
    }

}
