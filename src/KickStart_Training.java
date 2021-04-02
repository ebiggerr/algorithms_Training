

import java.io.IOException;
import java.util.Arrays;
import com.helperService.*;


public class KickStart_Training {

    public static Reader reader;

    public static void main(String [] args) throws IOException {

        Reader.init(System.in);
        int caseNum=Reader.nextInt();

        for (int caseNo = 1; caseNo <= caseNum; caseNo++) {
            System.out.println(String.format("Case #%d: %s", caseNo, solve(reader)));
            System.out.flush();
        }
    }

    static String solve(Reader reader) throws IOException {

        int n=Reader.nextInt();
        int p=Reader.nextInt();
        int []arr = new int[n];
        for(int i=0;i<n;i++)
            arr[i]=Reader.nextInt();
        Arrays.sort(arr);
        int []prefixArray = new int[n+1];
        for(int j=0;j<n;j++){
            prefixArray[j+1] = prefixArray[j]+arr[j];
        }
        long result  = Long.MAX_VALUE;
        for(int j=p-1;j<n;j++)
        {
            long currentSum = prefixArray[j]-prefixArray[j-(p-1)];
            long finalHours = arr[j]*(p-1) - currentSum;
            result = Math.min(result,finalHours);
        }

        return String.valueOf(result);

    }

}

