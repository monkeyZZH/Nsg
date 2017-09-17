package been;

/**
 * name:周振辉
 * 时间：2017/9/16 9:09
 * 类描述：
 */

public class Data_dl {

    /**
     * code : 200
     * datas : {"username":"monkey","userid":"2","key":"bff8c0ed2f88d898ba0b63a6f6d278ad"}
     */

    private int code;
    private DatasBean datas;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DatasBean getDatas() {
        return datas;
    }

    public void setDatas(DatasBean datas) {
        this.datas = datas;
    }

    public static class DatasBean {
        /**
         * username : monkey
         * userid : 2
         * key : bff8c0ed2f88d898ba0b63a6f6d278ad
         */

        private String username;
        private String userid;
        private String key;
        private String error;

        public String getError() {
            return error;
        }

        public void setError(String error) {
            this.error = error;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getUserid() {
            return userid;
        }

        public void setUserid(String userid) {
            this.userid = userid;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }
    }
}
