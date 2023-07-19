package tien.baseproject.orderservice.constant;

import lombok.Getter;

public class MailConstant {

    public static final String SENDER = "ShopTienDepTrai1234";

    public enum SymbolUrl {
        UNKNOWN("-"),
        ADA("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/ADA.png"),
        ATOM("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/ATOM.png"),
        BAND("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/BAND.png"),
        BAT("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/BAT.png"),
        BCH("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/BCH.png"),
        BEL("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/BEL.png"),
        BNB("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/BNB.png"),
        BTC("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/BTC.png"),
        BTCB("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/BTCB.png"),
        BUSD("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/BUSD.png"),
        BUSDT("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/BUSD-T.png"),
        COMP("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/COMP.png"),
        DAI("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/DAI.png"),
        DFY("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/DFY.png"),
        DOT("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/DOT.png"),
        ELF("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/ELF.png"),
        EOS("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/EOS.png"),
        ETC("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/ETC.png"),
        ETH("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/ETH.png"),
        FIL("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/FIL.png"),
        INJ("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/INJ.png"),
        IOTX("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/IOTX.png"),
        LINK("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/LINK.png"),
        LTC("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/LTC.png"),
        MKR("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/MKR.png"),
        NEAR("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/NEAR.png"),
        ONT("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/ONT.png"),
        PAX("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/PAX.png"),
        SNX("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/SNX.png"),
        SXP("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/SXP.png"),
        TCT("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/TCT.png"),
        UNI("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/UNI.png"),
        USDC("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/USDC.png"),
        USDT("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/USDT.png"),
        WBNB("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/WBNB.png"),
        XRP("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/XRP.png"),
        XTZ("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/XTZ.png"),
        YFI("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/YFI.png"),
        YFII("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/YFII.png"),
        ZEC("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/ZEC.png"),
        ALPACA("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/ALPACA.png"),
        AVA("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/AVA.png"),
        BABY("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/BABY.png"),
        BLS("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/BLS.png"),
        BSW("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/BSW.png"),
        CAKE("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/CAKE.png"),
        EFUN("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/EFUN.png"),
        NFTD("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/NFTD.png"),
        TRVL("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/TRVL.png"),
        UNO("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/UNO.png"),
        WST("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/WST.png");

        @Getter
        private final String url;

        SymbolUrl(String url) {
            this.url = url;
        }

    }

    public enum Template {
        REPORT_MANAGEMENT("report-management", "", "Report Management Email"),
        BAN_NFT("ban-nft", "", "Ban NFT Email"),
        CANCEL_EVENT("cancel-event", "", "Ban NFT Email"),
        CREATE_ORDER("create-order","","Create Order Success");

        @Getter
        private final String templateName;

        @Getter
        private final String link1;

        @Getter
        private final String link2 = null;

        @Getter
        private final String subject;

        Template(String templateName, String link, String subjectMail) {
            this.templateName = templateName;
            this.link1 = link;
            this.subject = subjectMail;
        }
    }

}
