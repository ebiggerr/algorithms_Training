public class flood_fill {

    /*
    *    An image is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 to 65535).

        Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor, "flood fill" the image.

        To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), and so on. Replace the color of all of the aforementioned pixels with the newColor.

        At the end, return the modified image.

    *
    * */

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        if (color != newColor) dfs(image, sr, sc, color, newColor);
        return image;
    }
    public void dfs(int[][] image, int r, int c, int color, int newColor) {
        if (image[r][c] == color) {
            image[r][c] = newColor;
            if (r >= 1) dfs(image, r-1, c, color, newColor);
            if (c >= 1) dfs(image, r, c-1, color, newColor);
            if (r+1 < image.length) dfs(image, r+1, c, color, newColor);
            if (c+1 < image[0].length) dfs(image, r, c+1, color, newColor);
        }
    }

    public static void main(String [] args){

        flood_fill f=new flood_fill();

        int [][]image={ {1,1,1},
                        {1,1,0},
                        {1,0,1}

                        //{7,1,3,5,4},
                        //{4,2,3,1,6}}
                        };

        int sr=1;
        int sc=1;

        int newColour=2;


        for(int i=0;i<image.length;i++){
            for(int j=0;j<image[0].length;j++){
                System.out.print(image[i][j]+ " ");
            }
            System.out.println("");
        }

        int [][]newImage=f.floodFill(image,sr,sc,newColour);
        System.out.println("");

        for(int i=0;i<newImage.length;i++){
            for(int j=0;j<newImage[0].length;j++){
                System.out.print(newImage[i][j]+ " ");
            }
            System.out.println("");
        }
    }

}
