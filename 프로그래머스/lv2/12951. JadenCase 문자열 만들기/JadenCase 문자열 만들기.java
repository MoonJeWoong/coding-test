class Solution {
    public String solution(String s) {
        String tmp = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        for(String x : tmp.split("")){
            if(x.equals(" ")){
                sb.append(x);
                flag = true;
                continue;
            }
            if(flag){
                sb.append(x.toUpperCase());
                flag = false;
            } else {
                sb.append(x);
            }
        }
        return sb.toString();
    }
}