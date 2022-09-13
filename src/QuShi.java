public class QuShi {
    public static void main(String[] args) {
        System.out.println(method("abcde1abcd23456"));
    }

    private static String method(String str) {
        int left = 0, right = 0;
        int max = -1;
        int start = 0;
        int end = 0;

        while(left < str.length()){

            while(left < str.length() && (str.charAt(left) < 'A' || str.charAt(left) > 'z')){
                left ++;
            }
            right = left + 1;
            while(right < str.length() && str.charAt(right) >= 'A' && str.charAt(left) <= 'z'){
                right ++;
            }

            if(right - left > max){
                max = right - left;
                start = left;
                end = right;
            }

            left = right;
        }
        return str.substring(start,end);
    }
}
