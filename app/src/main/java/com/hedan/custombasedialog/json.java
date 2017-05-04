package com.hedan.custombasedialog;

import java.util.List;

/**
 * Created by DengXiao on 2017/5/2.
 */

public class json {
    /**
     * ST : 1
     * MM :
     * TL : 一键买药
     * TS : 请通过以下病症选择药品
     * DT : [{"ID":"1","KN":"感冒","CK":"7501","PC":"http://p2.kfyao.com/kn/kn2016102915021241457.png"},{"ID":"12","KN":"消炎","CK":"3545","PC":"http://p2.kfyao.com/kn/kn2016112117025648642.png"},{"ID":"3","KN":"咳嗽","CK":"3351","PC":"http://p2.kfyao.com/kn/kn2016112117022169427.png"},{"ID":"6","KN":"妇科","CK":"2921","PC":"http://p2.kfyao.com/kn/kn2016110116523438112.png"},{"ID":"13","KN":"清热解毒","CK":"2732","PC":"http://p2.kfyao.com/kn/kn2016102914585192397.png"},{"ID":"21","KN":"维生素","CK":"2259","PC":"http://p2.kfyao.com/kn/kn2016102914564130246.png"},{"ID":"15","KN":"滴眼液","CK":"2215","PC":"http://p2.kfyao.com/kn/kn2016102914582675589.png"},{"ID":"31","KN":"口罩","CK":"1980","PC":"http://p2.kfyao.com/kn/kn2016110708530147442.png"},{"ID":"30","KN":"脚气","CK":"1825","PC":"http://p2.kfyao.com/kn/kn2016102914532080534.png"},{"ID":"23","KN":"膏药","CK":"1649","PC":"http://p2.kfyao.com/kn/kn2016102914561988648.png"},{"ID":"22","KN":"胃炎","CK":"1622","PC":"http://p2.kfyao.com/kn/kn2016102914563141334.png"},{"ID":"28","KN":"鼻炎","CK":"1003","PC":"http://p2.kfyao.com/kn/kn2016102914544044938.png"},{"ID":"8","KN":"儿童用药","CK":"876","PC":"http://p2.kfyao.com/kn/kn2016102914595077396.png"},{"ID":"11","KN":"消毒","CK":"744","PC":"http://p2.kfyao.com/kn/kn2016102914592315146.png"},{"ID":"25","KN":"退烧","CK":"704","PC":"http://p2.kfyao.com/kn/kn2016102914560290645.png"},{"ID":"10","KN":"拉肚子","CK":"678","PC":"http://p2.kfyao.com/kn/kn2016102914593219483.png"},{"ID":"20","KN":"皮肤过敏","CK":"671","PC":"http://p2.kfyao.com/kn/kn2016112117024340124.png"},{"ID":"5","KN":"嗓子疼","CK":"615","PC":"http://p2.kfyao.com/kn/kn2016102915004080764.png"},{"ID":"9","KN":"尿路感染","CK":"602","PC":"http://p2.kfyao.com/kn/kn2016110117122482911.png"},{"ID":"19","KN":"皮肤瘙痒","CK":"593","PC":"http://p2.kfyao.com/kn/kn2016102914574031093.png"},{"ID":"2","KN":"便秘","CK":"573","PC":"http://p2.kfyao.com/kn/kn2016102915020041914.png"},{"ID":"16","KN":"止痛","CK":"533","PC":"http://p2.kfyao.com/kn/kn2016102914581735141.png"},{"ID":"26","KN":"阴道炎","CK":"514","PC":"http://p2.kfyao.com/kn/kn2016102914554619180.png"},{"ID":"14","KN":"湿疹","CK":"511","PC":"http://p2.kfyao.com/kn/kn2016102914583686147.png"},{"ID":"27","KN":"鼻塞","CK":"510","PC":"http://p2.kfyao.com/kn/kn2016102914544712565.png"},{"ID":"17","KN":"痛经","CK":"491","PC":"http://p2.kfyao.com/kn/kn2016102914580691812.png"},{"ID":"4","KN":"咽炎","CK":"484","PC":"http://p2.kfyao.com/kn/kn2016102915005978645.png"},{"ID":"29","KN":"牙痛","CK":"477","PC":"http://p2.kfyao.com/kn/kn2016102914533770347.png"},{"ID":"7","KN":"安神","CK":"472","PC":"http://p2.kfyao.com/kn/kn2016102915000124906.png"},{"ID":"24","KN":"解酒","CK":"467","PC":"http://p2.kfyao.com/kn/kn2016102914561098284.png"},{"ID":"18","KN":"痤疮","CK":"461","PC":"http://p2.kfyao.com/kn/kn2016102914574736833.png"}]
     */

    private int ST;
    private String MM;
    private String TL;
    private String TS;
    private List<DTBean> DT;

    public int getST() {
        return ST;
    }

    public void setST(int ST) {
        this.ST = ST;
    }

    public String getMM() {
        return MM;
    }

    public void setMM(String MM) {
        this.MM = MM;
    }

    public String getTL() {
        return TL;
    }

    public void setTL(String TL) {
        this.TL = TL;
    }

    public String getTS() {
        return TS;
    }

    public void setTS(String TS) {
        this.TS = TS;
    }

    public List<DTBean> getDT() {
        return DT;
    }

    public void setDT(List<DTBean> DT) {
        this.DT = DT;
    }

    public static class DTBean {
        /**
         * ID : 1
         * KN : 感冒
         * CK : 7501
         * PC : http://p2.kfyao.com/kn/kn2016102915021241457.png
         */

        private String ID;
        private String KN;
        private String CK;
        private String PC;

        public String getID() {
            return ID;
        }

        public void setID(String ID) {
            this.ID = ID;
        }

        public String getKN() {
            return KN;
        }

        public void setKN(String KN) {
            this.KN = KN;
        }

        public String getCK() {
            return CK;
        }

        public void setCK(String CK) {
            this.CK = CK;
        }

        public String getPC() {
            return PC;
        }

        public void setPC(String PC) {
            this.PC = PC;
        }
    }
}
