import com.helperService.Reader;

import java.io.IOException;


class Solution {

    public static Reader reader;

    public static void main(String [] args) throws IOException {

        Reader.init(System.in);
        int caseNum=Reader.nextInt();

        for (int caseNo = 1; caseNo <= caseNum; caseNo++) {
            System.out.println(String.format("Case #%d: %s", caseNo, solve(reader)));
        }
    }

    static String solve(Reader reader) throws IOException {

        int r=Reader.nextInt();
        int c=Reader.nextInt();



        int ans=0;


        return String.valueOf(ans);

    }

}
