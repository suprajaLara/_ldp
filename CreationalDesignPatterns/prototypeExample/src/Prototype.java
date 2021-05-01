public class Prototype {
    public static void main(String[] args) throws CloneNotSupportedException {
        Image image = new Image();
        image.loadImages();
        Image imageCopy1 = image.clone();
        Image imageCopy2 = image.clone();

        imageCopy1.setImage("Tiger.jpg");
        imageCopy2.setImage("Bear.jpg");

        System.out.println(image.getImages());
        System.out.println(imageCopy1.getImages());
        System.out.println(imageCopy2.getImages());
    }
}
