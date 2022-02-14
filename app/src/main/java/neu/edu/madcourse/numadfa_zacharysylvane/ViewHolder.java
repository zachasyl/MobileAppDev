package neu.edu.madcourse.numadfa_zacharysylvane;



import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


public class ViewHolder extends RecyclerView.ViewHolder {
    public ImageView itemIcon;
    public TextView itemName;
    public TextView itemDesc;

    public ViewHolder(View itemView, final ItemClickListener listener) {
        super(itemView);
        itemIcon = itemView.findViewById(R.id.icon);
        itemName = itemView.findViewById(R.id.name);
        itemDesc = itemView.findViewById(R.id.description);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    int position = getLayoutPosition();
                    if (position != RecyclerView.NO_POSITION) {

                        listener.onClick(position);
                    }
                }
            }
        });

    }
}