package neu.edu.madcourse.numadfa_zacharysylvane;

public class ItemCard implements ItemClickListener {

    private String name;
    private String url;
    private boolean itemChecked;
    private int image;

    public ItemCard(String name, String url, int image) {
        this.name = name;
        this.url = url;
        this.itemChecked = itemChecked;
        this.image = image;


    }


    public int getImage() {
        return image;
    }

    public String getItemName() {
        return name;
    }

    public String getURL() {
        return url;
    }



    @Override
    public void onClick(int position) {
        itemChecked = !itemChecked;
    }
}