import java.util.ArrayList;

public class Image implements Cloneable {
    public ArrayList<String> images = new ArrayList<>();

    public void loadImages(){
        images.add("Panda.jpg");
        images.add("Penguin.jpg");
        images.add("Monkey.jpg");
        images.add("Lion.jpg");
    }

    public ArrayList<String> getImages(){
        return images;
    }

    public void setImage(String imageName){
        images.add(imageName);
    }

    @Override
    protected Image clone() throws CloneNotSupportedException {
        Image imageObject = new Image();
        for(String image : this.getImages()){
            imageObject.getImages().add(image);
        }
        return imageObject;
    }
}
