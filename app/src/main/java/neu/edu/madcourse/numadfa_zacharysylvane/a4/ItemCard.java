package neu.edu.madcourse.numadfa_zacharysylvane.a4;

public class ItemCard implements ItemClickListener {

    private String itemName;
    private String itemDescription;
    private boolean itemChecked;
    private int image;

    public ItemCard(String itemName, String itemDescription, boolean itemChecked, int image) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemChecked = itemChecked;
        this.image = image;

    }


    public int getImage() {
        return image;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public boolean isItemChecked() {
        return itemChecked;
    }


    @Override
    public void onCheckBoxClick(int position) {
        itemChecked = !itemChecked;
    }
}