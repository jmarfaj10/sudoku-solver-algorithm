
package sudoku;


public class Sudoku {
    
    public static void main(String[] args) {
        int [][] tabla={{0,0,6,0,3,0,1,0,0},
                         {0,0,0,4,7,8,0,0,0},
                         {0,0,2,0,0,0,0,9,3},
                         {6,0,0,0,8,9,0,4,2},
                         {0,8,0,1,0,0,9,0,0},
                         {4,0,0,3,2,0,0,6,0},
                         {0,0,0,0,0,0,3,2,9},
                         {9,0,4,7,6,0,0,0,0},
                         {0,3,0,0,0,5,6,7,0}};
        
        int [] posibilidades={1,2,3,4,5,6,7,8,9};
        resolverSudoku(tabla,posibilidades,0,0);
        
    }
    
    
    public static void resolverSudoku(int [][]tabla, int[] posibilidades, int fil, int col){
        if(completo(tabla)){
            System.out.println("Sudoku completado: ");
            pintarSudoku(tabla); 
        }else{
            for(int i=fil;i<tabla.length;i++){
                for(int j=col;j<tabla[0].length;j++){
                    if(esCero(tabla,i,j)){
                    for(int k=0;k<posibilidades.length;k++){
                        int num=posibilidades[k];
                        if(validar(tabla,i,j,num)){
                            resolverSudoku(tabla,posibilidades, i,j);
                            tabla[i][j]=0;
                        }
                    }
                    return;
                        
                    }
                }
                col=0;
            }
        }
        return;
    }
    public static boolean completo(int [][] tabla){
        for(int i=0;i<tabla.length;i++){
            for(int j=0;j<tabla[0].length;j++){
                if(tabla[i][j]==0){
                    return false;
                }
            }
        }
        return true;
    }
    
    public static boolean esCero(int[][] tabla, int fila, int columna){
        
                if(tabla[fila][columna]==0){
                    return true;
                }else{
                    return false; 
                }

    }
    
    public static boolean validar(int tablero[][], int fila, int col, int num){
        if(comprobarColumna(tablero,col,num)&&comprobarFila(tablero,fila,num)&&comprobarCuadrado(tablero,fila,col,num)){
            tablero[fila][col]=num;
            return true;
        }else{
            return false;
        }
    }
    
    public static boolean comprobarColumna(int tablero[][], int col, int num){
        for(int i=0;i<tablero.length;i++){
            if(tablero[i][col]==num){
                return false;
            }
        }
        return true;
    }
    
    public static boolean comprobarFila(int tablero[][], int fil, int num){
        for(int i=0;i<tablero.length;i++){
            if(tablero[fil][i]==num){
                return false;
            }
        }
        return true;
    }
    
    public static boolean comprobarCuadrado(int tablero[][], int fil, int col, int num){
        int filIni=0;
        int colIni=0;
        int filFin=0;
        int colFin=0;
        if(fil==0||fil==1||fil==2){
            filIni=0;
            filFin=3;
        }else if(fil==3||fil==4||fil==5){
            filIni=3;
            filFin=6;
        }else{
            filIni=6;
            filFin=9;
        }
        
        if(col==0||col==1||col==2){
            colIni=0;
            colFin=3;
        }else if(col==3||col==4||col==5){
            colIni=3;
            colFin=6;
        }else{
            colIni=6;
            colFin=9;
        }
        for(int i=filIni;i<filFin;i++){
            for(int j=colIni;j<colFin;j++){
                if(tablero[i][j]==num){
                    return false;
                }
            }
        }
        return true;
    }
    
    public static void pintarSudoku(int [][]tablero){
        for(int i=0;i<tablero.length;i++){
            System.out.print("[");
            for(int j=0;j<tablero[0].length;j++){
                if(j%3==0&&j!=0){
                    System.out.print(" ");
                }
                if(j!=tablero[0].length-1){
                    System.out.print(tablero[i][j]+",");
                }else{
                    System.out.print(tablero[i][j]);
                }
                
            }
            System.out.println("]");
            if((i+1)%3==0&&(i+1)!=1&&(i+1)!=0){
                    System.out.println();
                }
            
        }
    }
}

