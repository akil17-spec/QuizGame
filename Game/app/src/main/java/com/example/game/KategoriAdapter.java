package com.example.game;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.List;
import java.util.Locale;
import java.util.Set;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import de.hdodenhof.circleimageview.CircleImageView;

public class KategoriAdapter extends RecyclerView.Adapter<KategoriAdapter.ViewHolder> {

    private List<KategoriModel> kategoriModelList;

    public KategoriAdapter(List<KategoriModel> kategoriModelList) {
        this.kategoriModelList = kategoriModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int ViewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.kategori_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setData(kategoriModelList.get(position).getUrl(), kategoriModelList.get(position).getName(),kategoriModelList.get(position).getSets());
    }

    @Override
    public int getItemCount() {
        return kategoriModelList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private CircleImageView imageView;
        private TextView title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.image_view);
            title = itemView.findViewById(R.id.title);
        }

        private void setData(String url, final String title, final int sets) {
            Glide.with(itemView.getContext()).load(url).into(imageView);
            this.title.setText(title);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent setIntent = new Intent(itemView.getContext(), SetActivity.class);
                    setIntent.putExtra("title", title);
                    setIntent.putExtra("sets", sets);
                    itemView.getContext().startActivity(setIntent);
                }
            });
        }
    }
}

