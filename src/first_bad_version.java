public class first_bad_version {

    /*
    *       You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.

            Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

            You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.

            Example:

            Given n = 5, and version = 4 is the first bad version.

            call isBadVersion(3) -> false
            call isBadVersion(5) -> true
            call isBadVersion(4) -> true

            Then 4 is the first bad version.


    * */
    int first_bad=0;

    public int firstBadVersion(int n) {

        int left=1;
        int right=n;

        if(n == 0 ){
            return 0;
        }
        if( n == 1 ){
            if(isBadVersion(n)){
                return n;
            }
        }
        while(left < right)   {
            int middle = left + (right - left)/2;

            if(isBadVersion(middle)){
                right=middle;

            }
            else{
                left = middle +1;
            }
        }
        return left;

    }

    public boolean isBadVersion(int version){

        if (version >= first_bad){
            return true;
        }
        else {
            return false;
        }
    }

    public void setFirst_bad(int first_bad){
        this.first_bad=first_bad;
    }



    public static void main(String [] args){

            first_bad_version f=new first_bad_version();

            //when the first bad version exceeded the number of total number version released
        //it should be error but the program return the max version released as the first bad option
        //TODO fix

            f.setFirst_bad(7); //7th version is the first bad version

            int version_size=10; //how many version that have been released in total

        System.out.println(f.firstBadVersion(version_size));

    }
}
