package com.coderschool.booketplace.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.coderschool.booketplace.R;
import com.coderschool.booketplace.api.FirebaseApi;
import com.coderschool.booketplace.models.Book;
import com.firebase.ui.storage.images.FirebaseImageLoader;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by dattran on 11/16/16.
 */

public class BookVH extends RecyclerView.ViewHolder {
    @BindView(R.id.ivBook)
    ImageView ivBook;
    @BindView(R.id.tvName)
    TextView tvName;
    @BindView(R.id.tvPrice)
    TextView tvPrice;

    public BookVH(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(Book book) {
        tvName.setText(book.getName());
        tvPrice.setText(book.getPrice());
        Glide.with(itemView.getContext())
                .using(new FirebaseImageLoader())
                .load(FirebaseApi.getInstance().getImageStorageRef(book.getKey()))
                .into(ivBook);
//        Picasso.with(itemView.getContext()).load(book.getImages().get(0).getUrl()).into(ivBook);
    }

}