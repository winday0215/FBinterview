class Solution {
  public static List<String> subsequenceOfString(String s) {
    if (s == null || s.length() == 0) {
      return new ArrayList<String>();
    }
    
    Set<String> hash = new HashSet<>();
    dfs(s, hash, 0, new StringBuilder());
    
    List<String> res = new ArrayList<>();
    res.addAll(hash);
    return res;
  }
  
  private static void dfs(String s, Set<String> hash, int index, StringBuilder seq) {
    if (!hash.contains(seq)) {
      hash.add(seq.toString());
    }
    
    for (int i = index; i < s.length(); i++) {
      if (i != index && s.charAt(i) == s.charAt(i - 1)) {
        continue;
      }
      
      seq.append(s.charAt(i));
      dfs(s, hash, i + 1, seq);
      seq.deleteCharAt(seq.length() - 1);
    }
  }
  
  public static void main(String[] args) {
    String s = "aaaa";
    List<String> res = subsequenceOfString(s);
    
    for (String x : res) {
      System.out.println(x);
    }
    
  }
}

