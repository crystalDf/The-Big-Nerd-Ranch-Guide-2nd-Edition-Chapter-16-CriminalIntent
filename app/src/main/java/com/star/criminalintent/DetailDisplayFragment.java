package com.star.criminalintent;


import android.app.Dialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

public class DetailDisplayFragment extends DialogFragment {

    public static final String ARG_PATH = "path";

    public static DetailDisplayFragment newInstance(String path) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_PATH, path);

        DetailDisplayFragment detailDisplayFragment = new DetailDisplayFragment();
        detailDisplayFragment.setArguments(args);

        return detailDisplayFragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        View view = LayoutInflater.from(getContext()).inflate(
                R.layout.fragment_detail_display, null);

        ImageView imageView = (ImageView) view.findViewById(R.id.detail_photo);

        String path = (String) getArguments().getSerializable(ARG_PATH);
        Bitmap bitmap = PictureUtils.getScaledBitmap(
                path, getActivity());

        imageView.setImageBitmap(bitmap);

        return new AlertDialog.Builder(getContext())
                    .setView(view)
                    .setTitle(R.string.detail_display_title)
                    .setPositiveButton(android.R.string.ok, null)
                    .create();
    }
}