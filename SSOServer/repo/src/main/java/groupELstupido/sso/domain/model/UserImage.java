package groupELstupido.sso.domain.model;

public class UserImage {
    private int userId;

    private byte [] imageData;

    private String imageFileName;

    public UserImage (int userId, byte [] imageData, String imageFileName) {
        this.userId = userId;
        this.imageData = imageData;
        this.imageFileName = imageFileName;
    }

    public int getUserId () {
        return userId;
    }

    public byte [] getImageData () {
        return imageData;
    }

    public String getImageFileName() {
        return imageFileName;
    }
}
