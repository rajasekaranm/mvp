package ocs.com.mvp.ui.home.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import ocs.com.mvp.R;
import ocs.com.mvp.databinding.RowImageItemBinding;


public class AdapterHomeImages extends RecyclerView.Adapter<AdapterHomeImages.ImageHolder> {
    private ArrayList<String> listImages = new ArrayList<>();
    private LayoutInflater inflater;
    private Context context;

    public AdapterHomeImages(Context context) {
        this.context = context;
    }

    public void addImages(ArrayList<String> listImages) {
        this.listImages.addAll(listImages);
        notifyDataSetChanged();
    }

    @Override
    public ImageHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (inflater == null)
            inflater = LayoutInflater.from(parent.getContext());
        return new ImageHolder(DataBindingUtil.inflate(inflater, R.layout.row_image_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ImageHolder holder, int position) {
        Glide.with(context).load(listImages.get(position)).into(holder.binding.ivImageListItem);
    }

    @Override
    public int getItemCount() {
        return listImages.size();
    }

    public class ImageHolder extends RecyclerView.ViewHolder {
        RowImageItemBinding binding;

        public ImageHolder(RowImageItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
