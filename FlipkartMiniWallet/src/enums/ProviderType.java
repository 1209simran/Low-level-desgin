package enums;

public enum ProviderType {
    CC("Credit Card"), DC("Debit Card"), UPI("UPI");

    private String type;
    ProviderType(String type) {
        this.type = type;
    }
}
