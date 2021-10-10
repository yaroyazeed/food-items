package com.yaroyazeed.foodapplication;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

public class MainAdapter extends FirebaseRecyclerAdapter <MainModel, MainAdapter.myViewHolder> {



    Context context;

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public MainAdapter(@NonNull @NotNull FirebaseRecyclerOptions<MainModel> options, Context context) {
        super(options);
        this.context = context;
    }

    @Override
    protected void onBindViewHolder(@NonNull @NotNull myViewHolder holder, int position, @NonNull @NotNull MainModel model) {

        holder.productName.setText(model.getProductName());
        holder.quantity.setText(model.getQuantity());
        holder.price.setText(model.getPrice());
        holder.itemImage.setText(model.getImage());

        //Set onclick listener for each item in the recyclerview
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Initialize and bind Dialog view
                Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.layout_dialog);

                //Initialize and bind Image views for food items
                ImageView image1 = dialog.findViewById(R.id.imageView);
                ImageView image2 = dialog.findViewById(R.id.imageView2);

                //Initialize and bind Text Views for food item details
                TextView name = dialog.findViewById(R.id.itemName);
                TextView description = dialog.findViewById(R.id.itemDescription);
                TextView from = dialog.findViewById(R.id.itemFrom);
                TextView nutrients = dialog.findViewById(R.id.itemNutrient);
                TextView organic = dialog.findViewById(R.id.itemOrganic);
                TextView price = dialog.findViewById(R.id.itemPrice);
                TextView quantity = dialog.findViewById(R.id.itemQuantity);

                //Initialize and bind image and button to close dialog view
                ImageView close = dialog.findViewById(R.id.cancel);
                Button done = dialog.findViewById(R.id.done);


                //Set views to values from myView model
                name.setText(model.getProductName());
                description.setText(model.getDescription());
                from.setText(context.getString(R.string.country, model.getFrom()));
                nutrients.setText(context.getString(R.string.nutrients, model.getNutrients()));

                if (model.getOrganic()){
                    organic.setText(context.getString(R.string.is));
                }else{
                    organic.setText(context.getString(R.string.is_not));
                }

                price.setText(context.getString(R.string.dollar, model.getPrice()));
                quantity.setText(context.getString(R.string.quantity, model.getQuantity()));

                //Set Image views using Picasso
                Picasso.get().load(model.getImage1()).into(image1);
                Picasso.get().load(model.getImage2()).into(image2);


                //Close dialog view on click
                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                done.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });


    }

    @NonNull
    @NotNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_item, parent, false);
        return new myViewHolder(view);
    }

    static class myViewHolder extends RecyclerView.ViewHolder {

        TextView itemImage;
        TextView productName, price, quantity;

        public myViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            //View binding
            itemImage = itemView.findViewById(R.id.itemImage);
            productName = itemView.findViewById(R.id.itemName);
            price = itemView.findViewById(R.id.itemPrice);
            quantity = itemView.findViewById(R.id.itemQuantity);
        }
    }

    @Override
    public int getItemCount() {
        return super.getItemCount();
    }
}
