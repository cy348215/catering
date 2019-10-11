package utils;

//java代码：
class StringUtil {
    private static int count = 0;
    private static long lastTimeStamp = 1L;

    /** 生成13位纯数字订单号 */
    public static String generateOrderNo() {
        synchronized (StringUtil.class) {
            //每300ms可以产生999个，超出需要等待
            long nowTimeStamp = System.currentTimeMillis() / 300L;
            if (nowTimeStamp > lastTimeStamp) {
                count = 0;
                lastTimeStamp = nowTimeStamp;
            }
            if (count >= 999) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return generateOrderNo();
            }
            count++;
            if (count >= 1000) {
                count = 0;
            }
            StringBuilder orderNo = new StringBuilder(13);
            orderNo.append(nowTimeStamp);
            String countStr = String.valueOf(count);
            for (int i = 3; i > countStr.length(); i--) {
                orderNo.append("0");
            }
            orderNo.append(count);
            return orderNo.toString();
        }
    }
}
