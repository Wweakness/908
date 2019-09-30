//一个网站域名，如"discuss.leetcode.com"，包含了多个子域名。作为顶级域名，常用的有"com"，下一级则有"leetcode.com"，最低的一级为"discuss.leetcode.com"。当我们访问域名"discuss.leetcode.com"时，也同时访问了其父域名"leetcode.com"以及顶级域名 "com"。

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.*;
public class p6 {
    public List<String> subdomainVisits(String[] cpdomains){
            Map<String,Integer> count=new HashMap<>();
            for(String cp:cpdomains){
                String[] t=cp.split(" ");
                int n=Integer.valueOf(t[0]);
                String domain=t[1];

                 String[] u=domain.split("\\.");
                for(int i=0;i<u.length;i++){
                    String[] sub= Arrays.copyOfRange(u,i,u.length);//切割
                    String d=String.join(".",sub);

                      int oldCount=count.getOrDefault(d,0);
                      count.put(d,oldCount+n);
            }
        }
        System.out.println(count);
        List<String> result=new ArrayList<>();
        for(Map.Entry<String,Integer> e:count.entrySet()){
            String d=e.getKey();
            int n=e.getValue();
            result.add(n+""+d);
        }
        return result;
    }
    public static void main(String[] args){
        String[] s={"900 google.mail.com","50 yahoo.com","1 intel.mail.com","5 wiki.org"};
        List<String> r=new p6().subdomainVisits(s);
        System.out.println(r);
    }
}