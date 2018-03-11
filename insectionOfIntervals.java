public static List<Interval> findBothOnline(List<Interval> a, List<Interval> b){
                List<Interval> res = new ArrayList<>();
                int i = 0, j = 0;
                while(i < a.size() && j < b.size()) { 鏉ユ簮涓€浜�.涓夊垎鍦拌鍧�. 
                        Interval i1 = a.get(i);
                        Interval i2 = b.get(j);.1point3acres缃�
                        if(i1.end < i2.start) {
                                i++;
                        }else if(i2.end < i1.start) {. 1point 3acres 璁哄潧
                                j++;
                        }else {
                                res.add(new Interval(Math.max(i1.start, i2.start), Math.min(i1.end, i2.end)));
                                if(i1.end < i2.end) {
                                        i++;
                                }else {
                                        j++;
                                }
                        }
                }
                return res;
        }
