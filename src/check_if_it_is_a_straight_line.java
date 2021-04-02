public class check_if_it_is_a_straight_line {
    /*
    *       You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point.
    *       Check if these points make a straight line in the XY plane.

            //detailed explanation in folder named explanation
     *
    *
    * */

    public boolean checkStraightLine(int[][] coordinates) {
        int x0 = coordinates[0][0], y0 = coordinates[0][1], x1 = coordinates[1][0], y1 = coordinates[1][1];
        int dx = x1 - x0, dy = y1 - y0;
        for (int[] co : coordinates) {
            int x = co[0], y = co[1];
            if (dx * (y - y1) != dy * (x - x1))
                return false;
        }
        return true;
    }

    public static void main(String [] args){

        check_if_it_is_a_straight_line c=new check_if_it_is_a_straight_line();

        int [][]coord={{1,2},{2,3},{3,4}};

        System.out.println(c.checkStraightLine(coord));
    }
}
