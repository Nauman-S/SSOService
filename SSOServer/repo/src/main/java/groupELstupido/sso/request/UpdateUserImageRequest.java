package groupELstupido.sso.request;

public class UpdateUserImageRequest {
    private String username;

    private byte [] imageData;

    private String imageFormat;

    public UpdateUserImageRequest(String username, byte[] imageData, String imageIdentifier) {
        this.username = username;
        this.imageData = imageData;
        this.imageFormat = imageIdentifier;
    }

    public String getUsername() {
        return username;
    }

    public byte [] getImageData() {
        return imageData;
    }

    public String getImageIdentifier() {
        return imageFormat;
    }
}
