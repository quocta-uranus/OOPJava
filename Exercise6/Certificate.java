package OOPJava.Exercise6;

public class Certificate {
    private String CertificatedID;
    private String CertificateName;
    private String CertificateRank;
    private String CertificatedDate;

    public Certificate(String certificatedID, String certificateName, String certificateRank, String certificatedDate) {
        CertificatedID = certificatedID;
        CertificateName = certificateName;
        CertificateRank = certificateRank;
        CertificatedDate = certificatedDate;
    }

    public void ShowCertificateInfo() {
        System.out.println("Certificate ID: " + CertificatedID);
        System.out.println("Certificate Name: " + CertificateName);
        System.out.println("Certificate Rank: " + CertificateRank);
        System.out.println("Certificate Date: " + CertificatedDate);
    }
}
